package br.unicap.eticket.dao;

import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.locais.Teatro;


public class TeatroDAO extends LocalDAO{
     public TeatroDAO(){ super(); }
     
   public Teatro buscarTeatro(Teatro c){
        LocalGenerico busca = this.buscarLocal(c);
        if(busca instanceof Teatro) return (Teatro)busca;
        else return null;
    }
}
