package br.unicap.eticket.excecoes;
public class DadosFinanceirosInvalidosException extends Exception{
     public DadosFinanceirosInvalidosException(String dado) {
        super(dado+" Inválido!");
    }
}
