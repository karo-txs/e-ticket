package br.unicap.eticket.dao;
import br.unicap.eticket.model.auxiliares.Evento;
import java.util.List;

public class EventoDAO extends BaseDAO<Evento> {

    public EventoDAO() {
        super(Evento.class);
    }

    public Evento buscarEvento(Evento e) {
        List<Evento> evento = this.consultar("eventoPorSessao", "sessao", e.getSessao());
        if (evento.isEmpty()) {
            return null;
        } else {
            return evento.get(0);
        }
    }
}
