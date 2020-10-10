package br.unicap.eticket.dao;

import br.unicap.eticket.model.locais.Cinema;
import br.unicap.eticket.model.locais.LocalGenerico;

public class CinemaDAO extends LocalDAO{
    public CinemaDAO(){ }
    public Cinema buscarCinema(Cinema c){
        LocalGenerico busca = this.buscarLocal(c);
        if(busca instanceof Cinema) return (Cinema)busca;
        else return null;
    }
}
