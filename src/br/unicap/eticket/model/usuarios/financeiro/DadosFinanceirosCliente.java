package br.unicap.eticket.model.usuarios.financeiro;

import java.util.Calendar;

public class DadosFinanceirosCliente {
     /* NÃO IMPLEMENTADO */
    private Cartao cartaoCredito;
    
    public DadosFinanceirosCliente(Cartao cartaoCredito){
        this.cartaoCredito = cartaoCredito;
    }

    Cartao getCartaoCredito() {
        return cartaoCredito;
    }

    void setCartaoCredito(Cartao cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }
    
    private class Cartao{
        private String numero;
        private String nomeNoCartao;
        private Calendar dataExpiracao;
        private int codigoSeguranca;

        Cartao(String numero, String nomeNoCartao, Calendar dataExpiracao, int codigoSeguranca) {
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
}
