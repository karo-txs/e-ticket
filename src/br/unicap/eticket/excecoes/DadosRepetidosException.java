package br.unicap.eticket.excecoes;
public class DadosRepetidosException extends Exception{
    public DadosRepetidosException(String dado) {
        super(dado+" Já Cadastrado!");
    }
}
