package br.unicap.eticket.excecoes;
public class DadosInvalidosException extends Exception{
    public DadosInvalidosException(String obj) {
        super(obj+" Inválido(a)!");
    }
}
