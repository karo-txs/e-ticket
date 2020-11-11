
package br.unicap.eticket.excecoes;

public class SubiuDeTierException extends Exception{
    public SubiuDeTierException(String tier) {
        super(tier+" Alcançado!");
    }
}
