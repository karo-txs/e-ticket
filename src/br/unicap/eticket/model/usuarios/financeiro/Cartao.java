package br.unicap.eticket.model.usuarios.financeiro;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Embeddable;

@Embeddable
class Cartao implements Serializable {

    private String numero;
    private String nomeNoCartao;
    private Calendar dataExpiracao;
    private int codigoSeguranca;

    public Cartao() {

    }

    public Cartao(String numero, String nomeNoCartao, Calendar dataExpiracao, int codigoSeguranca) {
        this.numero = numero;
        this.nomeNoCartao = nomeNoCartao;
        this.dataExpiracao = dataExpiracao;
        this.codigoSeguranca = codigoSeguranca;
    }

    public String getNumero() {
        return numero;
    }

    void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNomeNoCartao() {
        return nomeNoCartao;
    }

    void setNomeNoCartao(String nomeNoCartao) {
        this.nomeNoCartao = nomeNoCartao;
    }

    public Calendar getDataExpiracao() {
        return dataExpiracao;
    }

    void setDataExpiracao(Calendar dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public int getCodigoSeguranca() {
        return codigoSeguranca;
    }

    void setCodigoSeguranca(int codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }
}

