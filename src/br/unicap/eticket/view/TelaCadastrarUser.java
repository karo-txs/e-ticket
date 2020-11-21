package br.unicap.eticket.view;

import br.unicap.eticket.view.admin.TelaCadastrarLocal;
import br.unicap.eticket.controller.usuarios.FachadaUsuarios;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosInvalidosException;
import br.unicap.eticket.excecoes.DadosRepetidosException;
import br.unicap.eticket.excecoes.SenhaInvalidaException;
import br.unicap.eticket.model.usuarios.Admin;
import br.unicap.eticket.model.usuarios.Cliente;
import br.unicap.eticket.model.usuarios.Usuario;
import br.unicap.eticket.view.jDialogs.JDialogsControl;
import br.unicap.eticket.view.jDialogs.TelaPopupNickname;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaCadastrarUser extends javax.swing.JPanel {

    private boolean isAdmin;

    public TelaCadastrarUser(boolean isAdmin) {
        initComponents();
        this.isAdmin = isAdmin;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEntrar = new javax.swing.JLabel();
        jbtCriarConta = new javax.swing.JButton();
        fldNome = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        lblSenhaC = new javax.swing.JLabel();
        fldEmail = new javax.swing.JTextField();
        fldSenha = new javax.swing.JPasswordField();
        fldSenhaConf = new javax.swing.JPasswordField();
        lblBackCine = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEntrar.setBackground(new java.awt.Color(255, 255, 255));
        lblEntrar.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        lblEntrar.setForeground(new java.awt.Color(255, 255, 255));
        lblEntrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEntrar.setText("Cadastro");
        add(lblEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 490, 90));

        jbtCriarConta.setBackground(new java.awt.Color(227, 0, 0));
        jbtCriarConta.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jbtCriarConta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoComprido (1).png"))); // NOI18N
        jbtCriarConta.setText("Criar conta");
        jbtCriarConta.setBorder(null);
        jbtCriarConta.setContentAreaFilled(false);
        jbtCriarConta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtCriarConta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtCriarConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtCriarContaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtCriarContaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtCriarContaMouseExited(evt);
            }
        });
        add(jbtCriarConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 600, 210, 60));

        fldNome.setBackground(new java.awt.Color(204, 204, 204));
        fldNome.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        fldNome.setForeground(new java.awt.Color(102, 102, 102));
        fldNome.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 350, 40));

        lblNome.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("Digite seu nome de usuário");
        add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 200, 30));

        lblEmail.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Digite seu endereço de email");
        add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, 220, 30));

        lblSenha.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(255, 255, 255));
        lblSenha.setText("Digite uma senha");
        add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 390, 200, 30));

        lblSenhaC.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblSenhaC.setForeground(new java.awt.Color(255, 255, 255));
        lblSenhaC.setText("Confirme a senha");
        add(lblSenhaC, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 480, 200, 30));

        fldEmail.setBackground(new java.awt.Color(204, 204, 204));
        fldEmail.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        fldEmail.setForeground(new java.awt.Color(102, 102, 102));
        fldEmail.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 350, 40));

        fldSenha.setBackground(new java.awt.Color(204, 204, 204));
        fldSenha.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        fldSenha.setForeground(new java.awt.Color(102, 102, 102));
        add(fldSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, 350, 40));

        fldSenhaConf.setBackground(new java.awt.Color(204, 204, 204));
        fldSenhaConf.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        fldSenhaConf.setForeground(new java.awt.Color(102, 102, 102));
        add(fldSenhaConf, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 510, 350, 40));

        lblBackCine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/telas/TelaInicial.png"))); // NOI18N
        add(lblBackCine, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));
    }// </editor-fold>//GEN-END:initComponents

    private void jbtCriarContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtCriarContaMouseClicked

        
        Usuario user;
        if (senhaIgual(String.valueOf(fldSenha.getPassword()), String.valueOf(fldSenhaConf.getPassword()))) {
            try {
                if (!this.isAdmin) {
                    FachadaUsuarios.getInstance().cadastrar(fldNome.getText(), fldEmail.getText(), String.valueOf(fldSenha.getPassword()));
                    Cliente busca = FachadaUsuarios.getInstance().buscar(new Cliente(fldEmail.getText(), String.valueOf(fldSenha.getPassword())));
                    TelaPopupNickname telaConf = JDialogsControl.mostrarNick(busca);
                    if (telaConf.getConfirmarAcao()) {
                        FrameInicio.getFrame().setContentPane(new TelaInicio());
                        FrameInicio.getFrame().revalidate();
                    }
                } else {
                    FachadaUsuarios.getInstance().validarDadosAdmin(fldNome.getText(), fldEmail.getText(), String.valueOf(fldSenha.getPassword()));
                    user = new Admin(fldNome.getText(), fldEmail.getText(), String.valueOf(fldSenha.getPassword()));
                    FrameInicio.getFrame().setContentPane(new TelaCadastrarLocal((Admin) user));
                    FrameInicio.getFrame().revalidate();
                }
            } catch (DadosInvalidosException | DadosRepetidosException | CadastroInexistenteException ex) {
                JDialogsControl.mostrarPopUp(ex.getMessage(), true);
            } catch (SenhaInvalidaException ex) {
                JDialogsControl.mostrarSenhaInvalida(ex.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TelaCadastrarUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JDialogsControl.mostrarPopUp("Senhas não conferem!", true);
        }
    }//GEN-LAST:event_jbtCriarContaMouseClicked

    private void jbtCriarContaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtCriarContaMouseEntered
        jbtCriarConta.setForeground(new java.awt.Color(191, 30, 30));
    }//GEN-LAST:event_jbtCriarContaMouseEntered

    private void jbtCriarContaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtCriarContaMouseExited
        jbtCriarConta.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jbtCriarContaMouseExited

    private boolean senhaIgual(String senhaA, String senhaB) {
        return senhaA.equals(senhaB);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fldEmail;
    private javax.swing.JTextField fldNome;
    private javax.swing.JPasswordField fldSenha;
    private javax.swing.JPasswordField fldSenhaConf;
    private javax.swing.JButton jbtCriarConta;
    private javax.swing.JLabel lblBackCine;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEntrar;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSenhaC;
    // End of variables declaration//GEN-END:variables
}
