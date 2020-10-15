package br.unicap.eticket.view.jDialogs;

import br.unicap.eticket.model.usuarios.Cliente;
import br.unicap.eticket.view.FrameInicio;
import javax.swing.JDialog;

public class JDialogsControl {
     public static void mostrarPopUp(String msg, boolean isErro) {
        TelaPopupComum telaErro = new TelaPopupComum(FrameInicio.getFrame(), true, msg, isErro);
        telaErro.setLocationRelativeTo(null);
        telaErro.setVisible(true);
    }
    
    public static void mostrarPopUp(JDialog tela){
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
    }

    public static TelaPopupConfirmar mostrarConfirmacao(String msg) {
        TelaPopupConfirmar telaConf = new TelaPopupConfirmar(FrameInicio.getFrame(), true, msg);
        telaConf.setLocationRelativeTo(null);
        telaConf.setVisible(true);
        return telaConf;
    }

    public static TelaPopupNickname mostrarNick(Cliente c) {
        TelaPopupNickname telaConf = new TelaPopupNickname(FrameInicio.getFrame(), true, c);
        telaConf.setLocationRelativeTo(null);
        telaConf.setVisible(true);
        return telaConf;
    }

    public static void mostrarSenhaInvalida(String erros) {
        TelaPopupSenhaInvalida telaErro = new TelaPopupSenhaInvalida(FrameInicio.getFrame(), true, erros);
        telaErro.setLocationRelativeTo(null);
        telaErro.setVisible(true);
    }
}
