package br.unicap.eticket.model.factoryMethod;

import java.util.LinkedHashMap;
import java.util.Map;

public class GerenciadorMap<T, R> {

    public Map<T, R> criaMap() {
        return new LinkedHashMap<>();
    }

}
