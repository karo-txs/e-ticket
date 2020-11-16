package br.unicap.eticket.excecoes;

public class CadastroInexistenteException extends RuntimeException {

    public CadastroInexistenteException(String obj) {
        super(obj+" com Cadastro Inexistente!");
    }
}
