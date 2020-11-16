package br.unicap.eticket.model.usuarios;

import br.unicap.eticket.controller.auxiliares.ValidaDados;
import br.unicap.eticket.controller.localAuxiliares.ReservaController;
import br.unicap.eticket.controller.usuarios.ClienteController;
import br.unicap.eticket.dao.ClienteDAO;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosInvalidosException;
import br.unicap.eticket.excecoes.DadosRepetidosException;
import br.unicap.eticket.model.locaisAuxiliares.Assento;
import br.unicap.eticket.model.auxiliares.Endereco;
import br.unicap.eticket.model.auxiliares.Reserva;
import br.unicap.eticket.model.locaisAuxiliares.Sala;
import br.unicap.eticket.model.locaisAuxiliares.Sessao;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.entretenimentos.Entretenimento;
import br.unicap.eticket.model.usuarios.financeiro.DadosFinanceirosCliente;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "cliente_tipo", discriminatorType = DiscriminatorType.INTEGER)
public class Cliente extends Usuario {

    @Column
    private String nickName;

    @ElementCollection
    @CollectionTable
    @OneToMany
    private List<Reserva> reservas;

    @Embedded
    private DadosFinanceirosCliente dadosFinanceiros = new DadosFinanceirosCliente();

    public Cliente() {
    }

    public Cliente(String email, String senha) {
        super(email, senha);
        this.reservas = new ArrayList<>();
    }

    public Cliente(String nome, String nick, String email, String senha) {
        super(nome, email, senha);
        this.nickName = nick;
        this.reservas = new ArrayList<>();
    }

    public Cliente(String nome, String email, String senha, int idade, String cpf, String telefone) {
        super(nome, email, senha, idade, cpf, telefone);
        this.reservas = new ArrayList<>();
    }

    public Cliente(String nome, String nick, String email, String senha, int idade, String cpf, String telefone, Endereco endereco) {
        super(nome, email, senha, idade, cpf, telefone, endereco);
        this.nickName = nick;
        this.reservas = new ArrayList<>();
    }

    /**
     * Da nota a um estabelecimento
     *
     * @param local
     * @param nota
     */
    public void darNota(LocalGenerico local, double nota) {
        local.receberNota(nota);
    }

    /**
     * Da nota a um entretenimento
     *
     * @param ent
     * @param nota
     */
    public void darNota(Entretenimento ent, double nota) {
        ent.receberNota(nota);
    }

    /**
     * Preenche os dados financeiros do cliente e salva
     *
     * @param numero
     * @param nomeNoCartao
     * @param dataExpiracao
     * @param codigoSeguranca
     * @throws CadastroInexistenteException
     */
    public void preencherDadosFinanceiros(String numero, String nomeNoCartao, Calendar dataExpiracao, int codigoSeguranca) {
        ClienteDAO clienteD = new ClienteDAO();
        clienteD.abrirTransacao();
        this.dadosFinanceiros.cadastrarCartao(numero, nomeNoCartao, dataExpiracao, codigoSeguranca);
        clienteD.atualizar(this);
        clienteD.fecharTransacao();
    }

    /**
     * Faz o pagamento da reserva, retornando o valor total. Se o cliente passar
     * de 5 reservas no mesmo local ele se tranforma em um cliente especial, que
     * possui níveis de desconto.
     *
     * @param reserva
     * @return double
     * @throws CadastroInexistenteException
     */
    public double pagarReserva(Reserva reserva) throws CadastroInexistenteException {
        ClienteController clienteC = new ClienteController();
        ReservaController reservaC = new ReservaController();
        Cliente busca = this.getId() == null ? clienteC.buscar(this) : this;
        Reserva buscaR = reservaC.buscar(reserva);

        busca.trasformarEmClienteEspecial(buscaR.getSessao().getLocal());
        return buscaR.getValorIngresso();
    }

    /**
     * Retorna a quantidade de reservas feitas pelo cliente por local
     * especificado
     *
     * @param local
     * @return qtdeTickets
     */
    public int qtdeTickets(LocalGenerico local) {
        int qtdeReservas = 0;
        for (Reserva r : this.getReservas()) {
            LocalGenerico buscaLocal = r.getSessao().getLocal();
            if (buscaLocal.equals(local)) {
                qtdeReservas++;
            }
        }
        return qtdeReservas;
    }

    /**
     * Se o cliente utrapassou 5 tickets em um mesmo local, ele se tranforma em
     * um cliente especial. O qual possibilita o alcance de novos descontos no
     * estabelecimento
     *
     * @param local
     */
    private void trasformarEmClienteEspecial(LocalGenerico local) throws CadastroInexistenteException {
        if (this.qtdeTickets(local) == TierCliente.TIER3.getQtdeTickets()) {
            ClienteDAO clienteD = new ClienteDAO();
            ClienteController clienteC = new ClienteController();

            ClienteEspecial e = new ClienteEspecial(this.getNome(), this.nickName, this.getEmail(),
                    this.getSenha(), this.getIdade(), this.getCpf(), this.getTelefone(), this.getEndereco());
            e.setDadosFinanceiros(this.getDadosFinanceiros());
            e.criarFidelidade(local);

            clienteD.abrirTransacao();
            clienteD.removerDetached(this);
            clienteD.fecharTransacao();

            clienteD.incluirAtomico(e);

            ClienteEspecial buscaE = (ClienteEspecial) clienteC.buscar(e);
            for (Reserva r : this.reservas) {
                buscaE.getReservas().add(r);
            }
            clienteD.atualizarAtomico(buscaE);
        }
    }

    //GRUPO
    public void fazerReservaGrupo(Sessao s, Grupo g, String... params) {

    }

    /**
     * Fazer uma Reserva em uma Sessao escolhendo a cadeira
     *
     * @param sessao
     * @param numCadeira
     * @return Reserva
     * @throws CadastroInexistenteException
     * @throws DadosRepetidosException
     * @throws DadosInvalidosException
     */
    public Reserva fazerReserva(Sessao sessao, String numCadeira) throws CadastroInexistenteException, DadosRepetidosException, DadosInvalidosException {
        ClienteDAO dao = new ClienteDAO();
        Sala sala = sessao.getSala();
        Reserva reservaFeita = sala.reservarAssento(numCadeira, sessao, this);
        if (reservaFeita != null) {
            this.reservas.add(reservaFeita);
            dao.atualizarAtomico(this);
            return reservaFeita;
        } else {
            throw new DadosInvalidosException("Reserva");
        }
    }

    /**
     * Cancelar uma reserva que tenha sido feita anteriormente
     *
     * @param r
     * @throws CadastroInexistenteException
     */
    public void cancelarReserva(Reserva r) throws CadastroInexistenteException {
        ReservaController rc = new ReservaController();
        ClienteDAO dao = new ClienteDAO();
        Reserva reserva = rc.buscar(r);

        dao.abrirTransacao();
        Cliente c = this.getId() == null ? dao.buscarCliente(this) : this;

        int size = c.getReservas().size();

        List<Reserva> aux = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (reserva.compareTo(c.getReservas().get(i)) != 0) {
                aux.add(c.getReservas().get(i));
            }
        }
        c.setReservas(aux);

        dao.atualizar(c);
        dao.fecharTransacao();

        Sessao s1 = reserva.getSessao();
        Sala sala = s1.getSala();
        sala.esvaziarAssentoDaSessao(new Assento(reserva.getAssento()), s1);
    }

    /**
     * Lista de Reservas Feitas (Histórico)
     *
     * @return List
     * @throws CadastroInexistenteException
     */
    public List<Reserva> listaReservas() throws CadastroInexistenteException {
        ClienteController cc = new ClienteController();
        Cliente c = this.getId() == null ? cc.buscar(this) : this;
        return c.getReservas();
    }

    /**
     * Atualiza o nickname verificando se o mesmo ja está sendo utilizado ou não
     *
     * @param nick
     * @throws br.unicap.eticket.excecoes.DadosInvalidosException
     */
    public void atualizarNickName(String nick) throws DadosInvalidosException {
        ClienteDAO cd = new ClienteDAO();
        //Cliente busca = cd.buscarCliente(nick);
        Cliente busca = this.getId() == null ? cd.buscarCliente(this) : this;
        if (ValidaDados.validaNickName(nick) && !nick.equals(this.getNickName())) {
            busca.setNickName(nick);
            cd.atualizarAtomico(busca);
        } else {
            throw new DadosInvalidosException("NickName");
        }
    }

    //gets e sets
    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public boolean isEspecial() {
        return false;
    }

    public DadosFinanceirosCliente getDadosFinanceiros() {
        return dadosFinanceiros;
    }

    public void setDadosFinanceiros(DadosFinanceirosCliente dadosFinanceiros) {
        this.dadosFinanceiros = dadosFinanceiros;
    }

}
