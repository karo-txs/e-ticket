package br.unicap.eticket.model.usuarios;

import br.unicap.eticket.controller.auxiliares.ValidaDados;
import br.unicap.eticket.controller.usuarios.UsuarioController;
import br.unicap.eticket.dao.UsuarioDAO;
import br.unicap.eticket.excecoes.AtualizacaoMalSucedidaException;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosInvalidosException;
import br.unicap.eticket.model.auxiliares.Endereco;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Usuario implements Serializable, Comparable<Usuario> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column
    private int idade;

    @Column(length = 14)
    private String cpf;

    @Column
    private String telefone;

    @Embedded
    private Endereco endereco;

    public Usuario() {

    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String nome, String email, String senha) {
        this(email, senha);
        this.nome = nome;
    }

    public Usuario(String nome, String email, String senha, String cpf) {
        this(nome, email, senha);
        this.cpf = cpf;
    }

    public Usuario(String nome, String email, String senha, int idade, String cpf, String telefone) {
        this(nome, email, senha, cpf);
        this.idade = idade;
        this.telefone = telefone;
    }

    public Usuario(String nome, String email, String senha, int idade, String cpf, String telefone, Endereco endereco) {
        this(nome, email, senha, idade, cpf, telefone);
        this.endereco = endereco;
    }

    public void atualizarEmail(String novoEmail) throws AtualizacaoMalSucedidaException, CadastroInexistenteException {
        UsuarioDAO ud = new UsuarioDAO();
        UsuarioController ac = new UsuarioController();
        Usuario busca = this.getId() == null ? ac.buscarUser(this) : this;
        if (!busca.getEmail().equalsIgnoreCase(novoEmail)) {
            if (ValidaDados.validaEmail(novoEmail)) {
                Usuario novo = new Admin();
                novo.setEmail(novoEmail);
                Usuario buscaComNovoEmail = ac.buscarUser(novo);
                if (buscaComNovoEmail == null) {
                    busca.setEmail(novoEmail);
                    ud.atualizarAtomico(busca);
                } else {
                    throw new AtualizacaoMalSucedidaException("Email");
                }
            } else {
                throw new AtualizacaoMalSucedidaException(new DadosInvalidosException("Email"));
            }
        }
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return (this.cpf == null) ? "" : this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return this.endereco == null ? new Endereco() : this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return this.telefone == null ? "" : this.telefone;

    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int compareTo(Usuario u) {
        return this.email.compareToIgnoreCase(u.getEmail());
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", endereco=" + endereco + ", email=" + email + ", senha=" + senha + '}';
    }

}
