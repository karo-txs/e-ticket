package br.unicap.eticket.model.locaisAuxiliares;

import br.unicap.eticket.control.auxiliares.SessaoControl;
import br.unicap.eticket.dao.ReservaDAO;
import br.unicap.eticket.dao.SessaoDAO;
import br.unicap.eticket.excecoes.AtualizacaoMalSucedidaException;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.model.auxiliares.Reserva;
import br.unicap.eticket.model.locais.LocalGenerico;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "sessoes")
public class Sessao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column
    private String nome;

    @ManyToOne
    @JoinColumn(name = "local")
    private LocalGenerico local;

    @ManyToOne
    @JoinColumn(name = "sala")
    private Sala sala;

    @ManyToOne
    @JoinColumn(name = "entreterimento")
    private Entretenimento entretenimento;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataInicial;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataFinal;

    private String data;

    @Column
    private boolean ativa = true;

    public Sessao() {
    }

    public Sessao(LocalGenerico local, Sala sala, String nome) {
        this.local = local;
        this.sala = sala;
        this.nome = nome;
        this.ativa = true;
    }

    public Sessao(LocalGenerico local, Sala sala, String nome, Calendar dataInicial, Entretenimento entreterimento) {
        this(local, sala, nome);
        this.dataInicial = dataInicial;
        this.dataFinal = (Calendar) this.dataInicial.clone();
        this.dataFinal.add(Calendar.MINUTE, entreterimento.getDuracao());
        this.entretenimento = entreterimento;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        data = df.format(this.getDataFinal().getTime());

    }

    /**
     * Atualização do nome da sessão (sua chave)
     * @param novoNome
     * @throws CadastroInexistenteException
     * @throws AtualizacaoMalSucedidaException
     */
    public void atualizarNome(String novoNome) throws CadastroInexistenteException, AtualizacaoMalSucedidaException {
        SessaoDAO sd = new SessaoDAO();
        SessaoControl sc = new SessaoControl();
        Sessao busca = this.getId() == null ? sc.buscar(this) : this;
        String nomeSessao = busca.getLocal().getId()+"-"+busca.getSala().getNome() + ":" + novoNome;
        //Se uma sessao com mesmo nome não existe, logo é possivel modificar seu nome
        try {
            Sessao buscaNovoNome = sc.buscar(nomeSessao);
            throw new AtualizacaoMalSucedidaException("Nome da Sessao");
        } catch (CadastroInexistenteException ex) {
            busca.setNome(novoNome);
            sd.atualizarAtomico(busca);
        }
    }

    /**
     * Retorna a ocupação de assentos da sessão
     *
     * @return HashMap
     * @throws CadastroInexistenteException
     */
    public HashMap<String, Boolean> ocupacaoDeAssentosDaSessao() throws CadastroInexistenteException {
        ReservaDAO reservaD = new ReservaDAO();
        SessaoControl sc = new SessaoControl();
        Sessao busca = this.getId() == null ? sc.buscar(this) : this;

        Sala sala = busca.getSala();
        List<Reserva> reservas = reservaD.consultar("reservasDaSessao", "sessao", busca);

        int x = sala.getFileirasX();
        int y = sala.getFileirasY();
        String nomeCadeira;
        char numLinha = 'A';
        int numColuna = 1;

        LinkedHashMap<String, Boolean> assentos = new LinkedHashMap<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                nomeCadeira = numLinha + "" + numColuna;
                assentos.put(nomeCadeira, Boolean.FALSE);
                numColuna++;
            }
            numColuna = 1;
            numLinha++;
        }

        for (Reserva r : reservas) {
            assentos.replace(r.getAssento(), Boolean.FALSE, Boolean.TRUE);
        }
        return assentos;
    }

    /**
     * Desativa uma Sessao, impossibilitando novas reservas
     *
     * @throws CadastroInexistenteException
     */
    public void desativarSessao() throws CadastroInexistenteException {
        SessaoControl sc = new SessaoControl();
        SessaoDAO sd = new SessaoDAO();
        Sessao busca = this.getId() == null ? sc.buscar(this) : this;

        busca.setAtiva(false);
        sd.atualizarAtomico(busca);
        System.out.println("Sessao " + this.getNome() + " DESATIVADA");
    }

    /**
     * Permite a avaliação, a aqueles que tem reserva marcada, do local da
     * sessão e de seu entreterimento
     *
     * @return boolean
     * @throws CadastroInexistenteException
     */
    public boolean permitirAvaliacao() throws CadastroInexistenteException {
        SessaoControl sc = new SessaoControl();
        Sessao busca = this.getId() == null ? sc.buscar(this) : this;
        if (!busca.isAtiva()) {
            return true;
        } else {
            return false;
        }
    }

    //Gets e Sets
    public String getNome() {
        if (this.nome.contains(":")) {
            String[] nome = this.nome.split(":");
            return nome[1];
        } else {
            return this.nome;
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Entretenimento getEntretenimento() {
        return entretenimento;
    }

    public void setEntretenimento(Entretenimento entretenimento) {
        this.entretenimento = entretenimento;
    }

    public LocalGenerico getLocal() {
        return local;
    }

    public void setLocal(LocalGenerico local) {
        this.local = local;
    }

    public Calendar getDataInicial() {
        Calendar dateAux = (Calendar) this.dataInicial.clone();
        dateAux.add(Calendar.HOUR, 3);
        return dateAux;
    }

    public void setDataInicial(Calendar dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Calendar getDataFinal() {
        Calendar dateAux = (Calendar) this.dataFinal.clone();
        dateAux.add(Calendar.HOUR, 3);
        return dateAux;
    }

    public void setDataFinal(Calendar dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String dataI = df.format(this.getDataInicial().getTime());
        String dataF = df.format(this.getDataFinal().getTime());

        return this.getNome() + " | " + sala.getNome() + " | " + this.getEntretenimento().getNome() + " | " + dataI + " | " + dataF;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.local);
        hash = 89 * hash + Objects.hashCode(this.nome);
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
        final Sessao other = (Sessao) obj;
        if (!Objects.equals(this.local, other.local)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

}
