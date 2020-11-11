package br.unicap.eticket.model.locais;

import br.unicap.eticket.controller.locais.LocalController;
import br.unicap.eticket.controller.auxiliares.Conversor;
import br.unicap.eticket.controller.auxiliares.ValidaDados;
import br.unicap.eticket.dao.LocalDAO;
import br.unicap.eticket.excecoes.AtualizacaoMalSucedidaException;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosInvalidosException;
import br.unicap.eticket.model.auxiliares.Endereco;
import br.unicap.eticket.model.locaisAuxiliares.Sala;
import br.unicap.eticket.model.locaisAuxiliares.Sessao;
import br.unicap.eticket.model.usuarios.Admin;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "CATEGORIA", discriminatorType = DiscriminatorType.INTEGER)
@Table(name = "locais")
public abstract class LocalGenerico implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @OneToOne
    private Admin admin;

    @Column(nullable = false)
    private String nome;

    @Embedded
    private Endereco endereco;

    @Column
    private String email;

    @Column
    private String telefone;

    @Column
    private String redeSocial_facebook;

    @Column
    private String redeSocial_instragam;

    @Column(columnDefinition = "TEXT")
    private String sobre;

    @Column(nullable = false)
    private double nota;

    private int qtdeClientes;

    @Lob
    @Column(name = "local_capa", nullable = false, columnDefinition = "mediumblob")
    private byte[] capa;

    @Lob
    @Column(name = "local_banner", columnDefinition = "mediumblob")
    private byte[] banner;

    public LocalGenerico() {
    }

    public LocalGenerico(Admin admin, String nome, Endereco endereco, String email, String telefone, String redeSocial_facebook, String redeSocial_instragam) {
        this(admin, nome, endereco);
        this.email = email;
        this.telefone = telefone;
        this.redeSocial_facebook = redeSocial_facebook;
        this.redeSocial_instragam = redeSocial_instragam;
    }

    public LocalGenerico(Admin admin, String nome, Endereco endereco, byte[] capa) {
        this(admin, nome, endereco);
        this.capa = capa;
    }

    public LocalGenerico(Admin admin, String nome, Endereco endereco) {
        this(nome, endereco);
        this.admin = admin;
    }

    public LocalGenerico(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.nota=-1;
    }

    /**
     * Atualiza o endereço do local (sua chave)
     *
     *
     * @param end
     * @throws CadastroInexistenteException
     * @throws AtualizacaoMalSucedidaException
     */
    public void atualizarEnd(Endereco end) throws CadastroInexistenteException, AtualizacaoMalSucedidaException {
        LocalController localC = new LocalController();
        LocalDAO localD = new LocalDAO();
        LocalGenerico busca = this.getId() == null ? localC.buscar(this) : this;

        if (!busca.getEndereco().equals(end)) {
            if (ValidaDados.validaEndereco(end)) {
                LocalGenerico localExiste = localD.buscarLocal(end);
                if (localExiste == null) {
                    busca.setEndereco(end);
                    localD.atualizarAtomico(busca);
                } else {
                    throw new AtualizacaoMalSucedidaException("Endereço");
                }
            } else {
                throw new AtualizacaoMalSucedidaException(new DadosInvalidosException("Endereço"));
            }
        }
    }

    /**
     * Recebe uma nota
     *
     * @param nota
     */
    public void receberNota(double nota) {
        LocalDAO dao = new LocalDAO();
        dao.abrirTransacao();

        LocalGenerico local = this.getId() == null ? dao.buscarLocal(this) : this;
        local.somarCliente();
        if (local.getNota() == -1) {
            local.adicaoDeNota(nota+1);
        } else {
            local.adicaoDeNota(nota);
        }
        dao.atualizar(local);

        dao.fecharTransacao();
    }

    /**
     * Adição de nota a sua nota geral
     *
     * @param nota
     */
    public void adicaoDeNota(double nota) {
        this.nota = (this.nota + nota) / this.qtdeClientes;
    }

    public void somarCliente() {
        this.qtdeClientes++;
    }

    public void inserirCapa(String urlCapa) {
        this.setCapa(Conversor.converterImagemEmByte(urlCapa));
    }

    public void inserirBanner(String urlCapa) {
        this.setBanner(Conversor.converterImagemEmByte(urlCapa));
    }

    public void atualizarSobre(String sobre) throws CadastroInexistenteException {
        LocalDAO localD = new LocalDAO();
        LocalController localC = new LocalController();

        LocalGenerico busca = this.getId() == null ? localC.buscar(this) : this;

        busca.setSobre(sobre);
        localD.atualizarAtomico(busca);
    }

    public abstract void inserirCapaESalvar(String urlCapa);

    public abstract void inserirBannerESalvar(String urlCapa);

    public abstract void setImagemPadrao();

    public abstract List<Sala> getSalas();

    public abstract List<Sessao> getSessoes();

    //Gets e Sets
    public Long getId() {
        return this.id;
    }

    public double getNota() {
        return nota;
    }

    public String getNome() {
        return this.nome;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public Admin getAdmin() {
        return this.admin;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public byte[] getCapa() {
        return capa;
    }

    public void setCapa(byte[] capa) {
        this.capa = capa;
    }

    public int getQtdeClientes() {
        return qtdeClientes;
    }

    public byte[] getBanner() {
        return banner;
    }

    public void setBanner(byte[] banner) {
        this.banner = banner;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRedeSocial_facebook() {
        return redeSocial_facebook;
    }

    public void setRedeSocial_facebook(String redeSocial_facebook) {
        this.redeSocial_facebook = redeSocial_facebook;
    }

    public String getRedeSocial_instragam() {
        return redeSocial_instragam;
    }

    public void setRedeSocial_instragam(String redeSocial_instragam) {
        this.redeSocial_instragam = redeSocial_instragam;
    }

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }

    @Override
    public String toString() {
        return "Local{" + "id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", admin=" + admin + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.endereco);
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
        final LocalGenerico other = (LocalGenerico) obj;
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        return true;
    }

    @Override
    public LocalGenerico clone() throws CloneNotSupportedException {
        return (LocalGenerico) super.clone();
    }

}
