package br.unicap.eticket.dao;

import br.unicap.eticket.model.entretenimentos.Entretenimento;
import java.util.List;

public class EntretenimentoDAO extends BaseDAO<Entretenimento>{
   public EntretenimentoDAO(){ super(Entretenimento.class); }
    
    public Entretenimento buscarEntreterimento(String nome) {
        List<Entretenimento> ents = this.consultar("entreterimentosPorNome", "nome", nome);
        if(!ents.isEmpty()) return ents.get(0);
        return null;
    } 
}
