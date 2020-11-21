package br.unicap.eticket.viewAuxiliares;

import br.unicap.eticket.controller.localAuxiliares.FachadaLocais;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.model.locaisAuxiliares.Sessao;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

public class ClockSessao {

    public ClockSessao() {
        Timer t = new Timer(1000, e -> {
            new Thread() {
                @Override
                public void run() {
                    List<Sessao> sessoes = FachadaLocais.getInstance().sessoesPassadas(getDateTimeC());
                    sessoes.stream().filter((s) -> (s.isAtiva())).forEachOrdered((s) -> {
                        try {
                            s.desativarSessao();
                        } catch (CadastroInexistenteException ex) {
                            Logger.getLogger(ClockSessao.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                }
            }.start();
        });
        t.setInitialDelay(0);
        t.start();
    }

    private Calendar getDateTimeC() {
        return Calendar.getInstance();
    }
}
