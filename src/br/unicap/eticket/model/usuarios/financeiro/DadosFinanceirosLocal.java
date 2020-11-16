package br.unicap.eticket.model.usuarios.financeiro;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class DadosFinanceirosLocal implements Serializable {
    private Conta conta;
    
    public DadosFinanceirosLocal(){
        this.conta = new Conta();
    }
     public void cadastrarConta(String titular, String numBanco, String numeracaoConta, String agencia) {
        this.conta.setTitular(titular);
        this.conta.setNumBanco(numBanco);
        this.conta.setNumeracaoConta(numeracaoConta);
        this.conta.setAgencia(agencia);
    }
     
    public void receberDinheiro(double val){
        this.conta.setSaldo(this.conta.getSaldo()+val);
    }
    
    public void retirarDinheiro(double val){
         this.conta.setSaldo(this.conta.getSaldo()-val);
    }

    public double getSaldo() {
        return this.conta.getSaldo();
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
