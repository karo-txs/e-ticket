package br.unicap.eticket.view;

import br.unicap.eticket.view.admin.TelaHomepageAdmin;
import br.unicap.eticket.view.cliente.TelaHomepageCliente;
import br.unicap.eticket.controller.usuarios.UsuarioController;
import br.unicap.eticket.excecoes.DadosInvalidosException;
import br.unicap.eticket.model.usuarios.Admin;
import br.unicap.eticket.model.usuarios.Cliente;
import br.unicap.eticket.model.usuarios.Usuario;
import br.unicap.eticket.view.jDialogs.JDialogsControl;
import java.awt.Color;

public class TelaInicio extends javax.swing.JPanel {

    public TelaInicio() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBemVindo = new javax.swing.JLabel();
        fldLogin = new javax.swing.JTextField();
        fldSenha = new javax.swing.JPasswordField();
        jbtEntrar = new javax.swing.JButton();
        lblLinha = new javax.swing.JLabel();
        lblCriarConta = new javax.swing.JLabel();
        lblProprietario = new javax.swing.JLabel();
        lblRodape = new javax.swing.JLabel();
        lblDigSenha = new javax.swing.JLabel();
        lblDigEmail = new javax.swing.JLabel();
        lblBackCine = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBemVindo.setBackground(new java.awt.Color(255, 255, 255));
        lblBemVindo.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        lblBemVindo.setForeground(new java.awt.Color(255, 255, 255));
        lblBemVindo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBemVindo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/LogoComNome.png"))); // NOI18N
        add(lblBemVindo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 160, 140));

        fldLogin.setBackground(new java.awt.Color(204, 204, 204));
        fldLogin.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        fldLogin.setForeground(new java.awt.Color(102, 102, 102));
        fldLogin.setBorder(null);
        add(fldLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 410, 40));

        fldSenha.setBackground(new java.awt.Color(204, 204, 204));
        fldSenha.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        fldSenha.setForeground(new java.awt.Color(102, 102, 102));
        add(fldSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 410, 40));

        jbtEntrar.setBackground(new java.awt.Color(0, 0, 153));
        jbtEntrar.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jbtEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoCompridoVermelho.png"))); // NOI18N
        jbtEntrar.setText("Entrar");
        jbtEntrar.setBorder(null);
        jbtEntrar.setContentAreaFilled(false);
        jbtEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtEntrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtEntrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtEntrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtEntrarMouseExited(evt);
            }
        });
        add(jbtEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 410, 260, 60));

        lblLinha.setBackground(new java.awt.Color(153, 153, 153));
        lblLinha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLinha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/linhaVermelha.png"))); // NOI18N
        add(lblLinha, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 490, 420, -1));

        lblCriarConta.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        lblCriarConta.setForeground(new java.awt.Color(204, 204, 204));
        lblCriarConta.setText("Não possui cadastro? Crie uma conta agora. ");
        lblCriarConta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCriarConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCriarContaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCriarContaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCriarContaMouseExited(evt);
            }
        });
        add(lblCriarConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 530, -1, -1));

        lblProprietario.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        lblProprietario.setForeground(new java.awt.Color(204, 204, 204));
        lblProprietario.setText("Você é um proprietário de auditório, cinema ou teatro?");
        lblProprietario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProprietario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblProprietarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblProprietarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblProprietarioMouseExited(evt);
            }
        });
        add(lblProprietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 560, -1, -1));

        lblRodape.setFont(new java.awt.Font("Segoe UI Symbol", 0, 10)); // NOI18N
        lblRodape.setForeground(new java.awt.Color(204, 204, 204));
        lblRodape.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRodape.setText("Sistema e-ticket © 2020. Todos os direitos reservados.");
        add(lblRodape, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 675, 490, -1));

        lblDigSenha.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblDigSenha.setForeground(new java.awt.Color(255, 255, 255));
        lblDigSenha.setText("Digite sua senha");
        add(lblDigSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, 130, 30));

        lblDigEmail.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblDigEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblDigEmail.setText("Digite seu email");
        add(lblDigEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 130, 30));

        lblBackCine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/telas/TelaInicial.png"))); // NOI18N
        add(lblBackCine, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jbtEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtEntrarMouseClicked

        UsuarioController userC = new UsuarioController();
        String email = fldLogin.getText();
        String senha = String.valueOf(fldSenha.getPassword());

        Usuario u;
        try {
            u = userC.login(email, senha);

            if (u instanceof Cliente) {
                FrameInicio.getFrame().setContentPane(new TelaHomepageCliente((Cliente) u));
            } else {
                FrameInicio.getFrame().setContentPane(new TelaHomepageAdmin((Admin) u));
            }
            
            FrameInicio.getFrame().revalidate();
        } catch (DadosInvalidosException ex) {
            JDialogsControl.mostrarPopUp(ex.getMessage(),true);
        }

    }//GEN-LAST:event_jbtEntrarMouseClicked

    private void jbtEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtEntrarMouseEntered
        jbtEntrar.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_jbtEntrarMouseEntered

    private void jbtEntrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtEntrarMouseExited
        jbtEntrar.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_jbtEntrarMouseExited

    private void lblProprietarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProprietarioMouseEntered
        lblProprietario.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_lblProprietarioMouseEntered

    private void lblProprietarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProprietarioMouseExited
        lblProprietario.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_lblProprietarioMouseExited

    private void lblCriarContaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCriarContaMouseEntered
        lblCriarConta.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_lblCriarContaMouseEntered

    private void lblCriarContaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCriarContaMouseExited
        lblCriarConta.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_lblCriarContaMouseExited

    private void lblCriarContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCriarContaMouseClicked

        FrameInicio.getFrame().setContentPane(new TelaCadastrarUser(false));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblCriarContaMouseClicked

    private void lblProprietarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProprietarioMouseClicked

        FrameInicio.getFrame().setContentPane(new TelaCadastrarUser(true));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblProprietarioMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fldLogin;
    private javax.swing.JPasswordField fldSenha;
    private javax.swing.JButton jbtEntrar;
    private javax.swing.JLabel lblBackCine;
    private javax.swing.JLabel lblBemVindo;
    private javax.swing.JLabel lblCriarConta;
    private javax.swing.JLabel lblDigEmail;
    private javax.swing.JLabel lblDigSenha;
    private javax.swing.JLabel lblLinha;
    private javax.swing.JLabel lblProprietario;
    private javax.swing.JLabel lblRodape;
    // End of variables declaration//GEN-END:variables
}
