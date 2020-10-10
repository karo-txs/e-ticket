package br.unicap.eticket.model.usuarios;

import br.unicap.eticket.control.auxiliares.ReservaControl;
import br.unicap.eticket.control.auxiliares.SessaoControl;
import br.unicap.eticket.control.usuarios.ClienteControl;
import br.unicap.eticket.control.validacoes.ValidaDados;
import br.unicap.eticket.dao.ClienteDAO;
import br.unicap.eticket.dao.ReservaDAO;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosInvalidosException;
import br.unicap.eticket.excecoes.DadosRepetidosException;
import br.unicap.eticket.model.locaisAuxiliares.Assento;
import br.unicap.eticket.model.auxiliares.Endereco;
import br.unicap.eticket.model.auxiliares.Reserva;
import br.unicap.eticket.model.locaisAuxiliares.Sala;
import br.unicap.eticket.model.locaisAuxiliares.Sessao;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.locaisAuxiliares.Entretenimento;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente extends Usuario {

    @Column
    private String nickName;

    @ElementCollection
    @CollectionTable
    @OneToMany
    private List<Reserva> reservas;

    /*
     @Embedded
     private DadosFinanceirosCliente dadosFinanceiros;
     */
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

    //PAGAR RESERVA
    /*
     public void pagarReserva(Reserva reserva){
     if(dadosFinanceiros.verificar()){//dados financeiros corretos
     System.out.println("Reserva Paga!");
     }else{
     this.cancelarReserva(reserva);
     System.out.println("Reserva não feita!");
     }
     }
     */
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
        ReservaDAO reservaC = new ReservaDAO();
        ClienteDAO dao = new ClienteDAO();
        SessaoControl sc = new SessaoControl();
        Sessao buscaS = sessao.getId() == null ? sc.buscar(sessao) : sessao;

        Reserva busca = reservaC.buscarReserva(new Reserva(buscaS, numCadeira));
        Cliente c = this.getId() == null ? dao.buscarCliente(this) : this;
        if (busca == null) {
            Sala sala = sessao.getSala();

            Reserva reservaFeita = sala.reservarAssento(numCadeira, sessao, c);
            if (reservaFeita != null) {
                c.reservas.add(reservaFeita);
                dao.atualizarAtomico(c);
                return reservaFeita;
            } else {
                throw new DadosInvalidosException("Reserva");
            }
        } else {
            throw new DadosRepetidosException("Reserva");
        }
    }

    /**
     * Cancelar uma reserva que tenha sido feita anteriormente
     *
     * @param r
     * @throws CadastroInexistenteException
     */
    public void cancelarReserva(Reserva r) throws CadastroInexistenteException {
        ReservaControl rc = new ReservaControl();
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
        ClienteControl cc = new ClienteControl();
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

}
