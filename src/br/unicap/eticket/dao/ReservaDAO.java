package br.unicap.eticket.dao;

import br.unicap.eticket.model.auxiliares.Reserva;
import java.util.List;

public class ReservaDAO extends BaseDAO<Reserva>{
    public ReservaDAO(){ super(Reserva.class); }
    
    public Reserva buscarReserva(Reserva r){
        List<Reserva> aux = this.consultar("reservaPorSessaoEAssento", "sessao",r.getSessao(),
                                           "assento",r.getAssento());
        if(aux.isEmpty()) return null;
        else return aux.get(0);
    }
    
}
