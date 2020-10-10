package br.unicap.eticket.dao;

import br.unicap.eticket.model.locaisAuxiliares.Entretenimento;
import java.util.List;

public class EntreterimentoDAO extends BaseDAO<Entretenimento>{
   public EntreterimentoDAO(){ super(Entretenimento.class); }
    
    public Entretenimento buscarEntreterimento(String nome) {
        List<Entretenimento> ents = this.consultar("entreterimentosPorNome", "nome", nome);
        if(!ents.isEmpty()) return ents.get(0);
        return null;
    } 
}
