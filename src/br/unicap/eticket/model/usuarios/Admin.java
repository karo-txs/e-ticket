package br.unicap.eticket.model.usuarios;

import br.unicap.eticket.model.locais.LocalGenerico;
import java.util.Calendar;
import javax.persistence.CascadeType;
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
    
     /*
    @Embedded
    private DadosFinanceirosLocal dadosFinanceiros;
    */

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
    
    //CUPOM
    public void criarCupom(LocalGenerico local,String codigo, double valor, Calendar dataExpiracao){
        //Cupom cupom = new Cupom(local,codigo,valor,dataExpiracao);
        //adiciona cupom ao banco
    }
       
    public LocalGenerico getLocalAdministrado() {
        return localAdministrado;
    }

    public void setLocalAdministrado(LocalGenerico localAdministrado) {
        this.localAdministrado = localAdministrado;
    }
}
