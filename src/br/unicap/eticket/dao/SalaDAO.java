package br.unicap.eticket.dao;

import br.unicap.eticket.model.locaisAuxiliares.Sala;
import java.util.List;

public class SalaDAO extends BaseDAO<Sala> {
    public SalaDAO(){ super(Sala.class); }

    public Sala buscarSala(String nome){
        List<Sala> sala = this.consultar("salaPorNome", "nome",nome);
        if(sala.isEmpty()) return null;
        else return sala.get(0);
    }
}
