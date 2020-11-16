package br.unicap.eticket.excecoes;
public class AtualizacaoMalSucedidaException extends RuntimeException{

    public AtualizacaoMalSucedidaException(String message) {
        super(message+" não Atualizado(a)!");
    }

    public AtualizacaoMalSucedidaException(Throwable cause) {
        super("Atualização não concluida por: "+cause.getMessage());
    }
}
