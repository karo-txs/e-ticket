package br.unicap.eticket.model.usuarios;

import br.unicap.eticket.dao.AdminDAO;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.usuarios.financeiro.DadosFinanceirosLocal;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin extends Usuario {

    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(unique = true)
    private LocalGenerico localAdministrado;
    
    @Embedded
    private DadosFinanceirosLocal dadosFinanceiros = new DadosFinanceirosLocal();

    public Admin() {
    }
    
    public Admin(String nome, String email, String senha){
        super(nome,email,senha);
    }
    
    public Admin(String nome, String email, String senha, LocalGenerico localAdm) {
        super(nome, email, senha);
        this.localAdministrado=localAdm;
    }

    public Admin(String nome, String email, String senha,int idade, String cpf,String telefone,LocalGenerico localAdm) {
        super(nome, email, senha, idade, cpf, telefone);
        this.localAdministrado=localAdm;
    }
   
    /**
     * Preenche os dados financeiros do admin de um local
     *
     * @param titular
     * @param numBanco
     * @param numeracaoConta
     * @param agencia
     */
    public void preencherDadosFinanceiros(String titular, String numBanco, String numeracaoConta, String agencia) {
        AdminDAO admD = new AdminDAO();
        admD.abrirTransacao();
        this.dadosFinanceiros.cadastrarConta(titular, numBanco, numeracaoConta, agencia);
        admD.atualizar(this);
        admD.fecharTransacao();
    }

       
    public LocalGenerico getLocalAdministrado() {
        return localAdministrado;
    }

    public void setLocalAdministrado(LocalGenerico localAdministrado) {
        this.localAdministrado = localAdministrado;
    }
}
