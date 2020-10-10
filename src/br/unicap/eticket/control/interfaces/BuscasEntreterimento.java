package br.unicap.eticket.control.interfaces;

import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.locaisAuxiliares.Entretenimento;
import java.util.List;

public interface BuscasEntreterimento {

    public abstract List<? extends Entretenimento> entreterimentosEmCartaz();
    public abstract List<? extends Entretenimento> entreterimentosEmCartaz(LocalGenerico l);
    public abstract List<? extends Entretenimento> entreterimentosNotaMaiorQue(double nota);
}
