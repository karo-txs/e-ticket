package br.unicap.eticket.dao;

import br.unicap.eticket.model.locais.Auditorio;
import br.unicap.eticket.model.locais.LocalGenerico;

public class AuditorioDAO extends LocalDAO {

    public AuditorioDAO() {}

    public Auditorio buscarAuditorio(Auditorio c) {
        LocalGenerico busca = this.buscarLocal(c);
        if (busca instanceof Auditorio) {
            return (Auditorio) busca;
        } else {
            return null;
        }
    }
}
