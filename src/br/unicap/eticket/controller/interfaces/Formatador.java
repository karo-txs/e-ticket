package br.unicap.eticket.controller.interfaces;
import java.util.List;
public interface Formatador<T> {
    public String[] formataDados(List<T> objts);
    public Long[] listarIDs(List<T> objts);
}
