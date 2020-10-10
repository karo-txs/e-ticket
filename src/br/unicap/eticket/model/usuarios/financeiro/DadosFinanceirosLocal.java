package br.unicap.eticket.model.usuarios.financeiro;

public class DadosFinanceirosLocal {
     /* NÃO IMPLEMENTADO */
    private Conta conta;
    
    public DadosFinanceirosLocal(Conta conta){
        this.conta=conta;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
    
    private class Conta {
        private String titular;
        private String numBanco;
        private String numeracaoConta;
        private String agencia;
        private double saldo;

        public Conta(String titular, String numBanco, String numeracaoConta, String agencia) {
            this.titular = titular;
            this.numBanco = numBanco;
            this.numeracaoConta = numeracaoConta;
            this.agencia = agencia;
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
    }
}
