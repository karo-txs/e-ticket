package br.unicap.eticket.model.usuarios.financeiro;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class Conta implements Serializable {
    private String titular;
    private String numBanco;
    private String numeracaoConta;
    private String agencia;
    private double saldo;

    public Conta(){
        
    }
    
    public Conta(String titular, String numBanco, String numeracaoConta, String agencia) {
        this.titular = titular;
        this.numBanco = numBanco;
        this.numeracaoConta = numeracaoConta;
        this.agencia = agencia;
        this.saldo = 0;
    }
    
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumBanco() {
        return numBanco;
    }

    public void setNumBanco(String numBanco) {
        this.numBanco = numBanco;
    }

    public String getNumeracaoConta() {
        return numeracaoConta;
    }

    public void setNumeracaoConta(String numeracaoConta) {
        this.numeracaoConta = numeracaoConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
}
