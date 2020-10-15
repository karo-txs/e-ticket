package br.unicap.eticket.model.usuarios.financeiro;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Embeddable;

@Embeddable
public class DadosFinanceirosCliente implements Serializable {

    private Cartao cartaoCredito;

    public DadosFinanceirosCliente() {
        cartaoCredito = new Cartao();
    }

    public void cadastrarCartao(String numero, String nomeNoCartao, Calendar dataExpiracao, int codigoSeguranca) {
        this.cartaoCredito.setNumero(numero);
        this.cartaoCredito.setNomeNoCartao(nomeNoCartao);
        this.cartaoCredito.setDataExpiracao(dataExpiracao);
        this.cartaoCredito.setCodigoSeguranca(codigoSeguranca);
    }

    public String getNumero() {
        return this.cartaoCredito.getNumero();
    }

    public String getNomeNoCartao() {
        return this.cartaoCredito.getNomeNoCartao();
    }

    public Calendar getDataExpiracao() {
        return this.cartaoCredito.getDataExpiracao();
    }

    public int getCodigoSeguranca() {
        return this.cartaoCredito.getCodigoSeguranca();
    }
}
