package br.unicap.eticket.model.factoryMethod;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorLista<T> {

    public List<T> criaLista() {
        return new ArrayList<>();
    }
    
}
