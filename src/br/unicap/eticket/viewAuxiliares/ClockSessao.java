package br.unicap.eticket.viewAuxiliares;
import br.unicap.eticket.controller.localAuxiliares.SessaoController;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.model.locaisAuxiliares.Sessao;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.Timer;

public class ClockSessao extends JLabel{
    public ClockSessao() {
        Timer t = new Timer(1000, e -> {
            try {
                desativarSessao();
            } catch (CadastroInexistenteException ex) {
                Logger.getLogger(ClockSessao.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        t.setInitialDelay(0);
        t.start();
    }
    
    private Calendar getDateTimeC(){
        return Calendar.getInstance();
    }
    
    private boolean desativarSessao() throws CadastroInexistenteException{
        SessaoController sc = new SessaoController();
        List<Sessao> sessoes = sc.sessoesPassadas(getDateTimeC());
        for(Sessao s: sessoes){
            if(s.isAtiva()){
                s.desativarSessao();
            }
        }
        return true;
    }
}
