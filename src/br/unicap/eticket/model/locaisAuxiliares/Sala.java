package br.unicap.eticket.model.locaisAuxiliares;

import br.unicap.eticket.control.auxiliares.ReservaControl;
import br.unicap.eticket.control.auxiliares.SalaControl;
import br.unicap.eticket.control.auxiliares.SessaoControl;
import br.unicap.eticket.dao.SalaDAO;
import br.unicap.eticket.dao.SessaoDAO;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosRepetidosException;
import br.unicap.eticket.model.auxiliares.Reserva;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.usuarios.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "salas")
public class Sala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column
    private TiposDeSala tipoSala;

    @Column
    private String nome;

    @Column
    private int capacidade;

    @ManyToOne
    private LocalGenerico local;

    @Column
    private double valorIngresso;

    @ElementCollection
    @CollectionTable
    private List<Assento> assentos;

    private int fileirasX, fileirasY;

    public Sala() {
    }

    public Sala(String nome) {
        this.nome = nome;
        this.assentos = new ArrayList<>();
    }

    public Sala(LocalGenerico local, String nome) {
        this(nome);
        this.local = local;
    }

    public Sala(LocalGenerico local, TiposDeSala tipo, String nome) {
        this(local, nome);
        this.tipoSala = tipo;
    }

    public Sala(TiposDeSala tipo, String nome, int linhas, int colunas, double valorIngresso) {
        this(nome);
        this.tipoSala = tipo;
        this.fileirasX = linhas;
        this.fileirasY = colunas;
        this.capacidade = linhas * colunas;
        initAssentos(linhas, colunas, capacidade);
        this.valorIngresso = valorIngresso;
    }

    public Sala(LocalGenerico local, TiposDeSala tipo, String nome, int linhas, int colunas, double valorIngresso) {
        this(tipo, nome, linhas, colunas, valorIngresso);
        this.local = local;
    }

    /**
     * Inicializa os assentos da sala os nomeando de acordo com o tamanho da
     * sala
     *
     * @param linha
     * @param coluna
     * @param capacidade
     */
    public void initAssentos(int linha, int coluna, int capacidade) {
        String numCadeira;
        char numLinha = 'A';
        int numColuna = 1;

        for (int i = 0; i < linha; i++) {

            for (int j = 0; j < coluna; j++) {
                numCadeira = numLinha + "" + numColuna;
                this.assentos.add(new Assento(numCadeira));
                numColuna++;
            }
            numColuna = 1;
            numLinha++;
        }
    }

    /**
     * Aletaração do nome da Sala(sua chave)
     *
     * @param nome
     * @throws br.unicap.eticket.excecoes.CadastroInexistenteException
     */
    public void alterarNome(String nome) throws CadastroInexistenteException {
        SalaDAO salaD = new SalaDAO();
        SessaoDAO sessaoD = new SessaoDAO();
        SalaControl salaC = new SalaControl();
        SessaoControl sessaoC = new SessaoControl();

        Sala busca = this.getId() == null ? salaC.buscar(this) : this;

        Sala nova = salaD.buscarSala(busca.getLocal().getId() + "-" + nome);
        if (nova == null) {
            List<Sessao> sessoesDaSala = sessaoC.sessoesDaSala(busca);
            for (Sessao s : sessoesDaSala) {
                String nomeSessao = s.getNome();
                s.setNome(busca.getLocal().getId() + "-" + nome + ":" + nomeSessao);
                sessaoD.atualizarAtomico(s);
            }

            busca.setNome(busca.getLocal().getId() + "-" + nome);
            salaD.atualizarAtomico(busca);
        }
    }

    /**
     * Reserva um assento
     *
     * @param numCadeira
     * @param sessao
     * @param cliente
     * @return
     * @throws DadosRepetidosException
     * @throws CadastroInexistenteException
     */
    public Reserva reservarAssento(String numCadeira, Sessao sessao, Cliente cliente) throws DadosRepetidosException, CadastroInexistenteException {
        Assento assento = this.buscaAssentoPorNum(numCadeira);
        if (assento != null) {
            ReservaControl rc = new ReservaControl();
            Reserva reserva = new Reserva(sessao, numCadeira);

            String urlCodigo = "src\\br\\unicap\\eticket\\imagens\\qrcodes\\" + cliente.getNome() + "-QrCode.png";
            reserva.gerarCodigo(cliente.getEmail() + "\\" + sessao.getNome() + "\\" + numCadeira, urlCodigo);
            rc.cadastrar(reserva);

            Reserva reservaCriada = rc.buscar(reserva);
            assento.preencherAssento(reservaCriada);
            return reservaCriada;
        } else {
            return null;
        }
    }

    /**
     * Busca um assento da sala que tenha a numeração pedida
     *
     * @param numeracao
     * @return
     */
    public Assento buscaAssentoPorNum(String numeracao) {

        for (Assento a : this.assentos) {
            if (a.getNumeracao().equalsIgnoreCase(numeracao)) {
                return a;
            }
        }
        return null;
    }

    /**
     * Esvazia um assento da sessao, caso a reserva tenha sido cancelada
     *
     * @param a
     * @param sessao
     * @throws CadastroInexistenteException
     */
    public void esvaziarAssentoDaSessao(Assento a, Sessao sessao) throws CadastroInexistenteException {
        SalaDAO sdao = new SalaDAO();
        SalaControl sd = new SalaControl();
        SessaoControl sc = new SessaoControl();
        ReservaControl rc = new ReservaControl();

        Sala s = sd.buscar(new Sala(this.getNome()));
        Sessao ses = sc.buscar(sessao);

        Assento assento = s.buscaAssentoPorNum(a.getNumeracao());
        if (ses != null && assento != null) {
            Reserva reserva = new Reserva(ses, assento.getNumeracao());

            if (rc.buscar(reserva) != null) {
                sdao.abrirTransacao();
                assento.getReservas().remove(reserva);
                rc.remover(reserva);
                sdao.atualizar(s);
                sdao.fecharTransacao();
            }

        }
    }

    //GETS E SETS
    public int getCapacidade() {
        return this.capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getNome() {
        if (this.nome.contains("-")) {
            String[] nome = this.nome.split("-");
            return nome[1];
        } else {
            return this.nome;
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Assento> getListaAssentos() {
        return assentos;
    }

    public void setListaAssentos(List<Assento> listaAssentos) {
        this.assentos = listaAssentos;
    }

    public Long getId() {
        return id;
    }

    public LocalGenerico getLocal() {
        return local;
    }

    public void setLocal(LocalGenerico local) {
        this.local = local;
    }

    public List<Assento> getAssentos() {
        return assentos;
    }

    public void setAssentos(List<Assento> assentos) {
        this.assentos = assentos;
    }

    public double getValorIngresso() {
        return valorIngresso;
    }

    public void setValorIngresso(double valorIngresso) {
        this.valorIngresso = valorIngresso;
    }

    public TiposDeSala getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(TiposDeSala tipoSala) {
        this.tipoSala = tipoSala;
    }

    public int getFileirasX() {
        return fileirasX;
    }

    public void setFileirasX(int fileirasX) {
        this.fileirasX = fileirasX;
    }

    public int getFileirasY() {
        return fileirasY;
    }

    public void setFileirasY(int fileirasY) {
        this.fileirasY = fileirasY;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.local);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sala other = (Sala) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.local, other.local)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getNome() + " | " + tipoSala.toString() + " | " + capacidade + " | R$" + this.valorIngresso;
    }

}
