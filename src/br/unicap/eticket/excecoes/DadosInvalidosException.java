package br.unicap.eticket.excecoes;
public class DadosInvalidosException extends RuntimeException{
    public DadosInvalidosException(String obj) {
        super(obj+" Inválido(a)!");
    }
}
