package br.unicap.eticket.view.jDialogs;

import br.unicap.eticket.view.FrameInicio;
import javax.swing.JPanel;

public class TelaPopupConfirmar extends javax.swing.JDialog {

    private boolean confirmarAcao;

    public TelaPopupConfirmar(java.awt.Frame parent, boolean modal, String frase) {
        super(parent, modal);
        initComponents();
        lblConfirmar.setText("<html><center>" + frase);
        confirmarAcao = false;
        this.setBackground(new java.awt.Color(0,0,0,0));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblConfirmar = new javax.swing.JLabel();
        jbtSim = new javax.swing.JButton();
        jbtNao = new javax.swing.JButton();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblConfirmar.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        lblConfirmar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConfirmar.setText("<html><center>Confirmar Ação?");
        getContentPane().add(lblConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 270, 60));

        jbtSim.setBackground(new java.awt.Color(227, 0, 0));
        jbtSim.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jbtSim.setForeground(new java.awt.Color(255, 255, 255));
        jbtSim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/Confirma0.png"))); // NOI18N
        jbtSim.setBorder(null);
        jbtSim.setContentAreaFilled(false);
        jbtSim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtSim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtSimMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtSimMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtSimMouseExited(evt);
            }
        });
        getContentPane().add(jbtSim, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, 40));

        jbtNao.setBackground(new java.awt.Color(227, 0, 0));
        jbtNao.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jbtNao.setForeground(new java.awt.Color(255, 255, 255));
        jbtNao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/Cancela0.png"))); // NOI18N
        jbtNao.setBorder(null);
        jbtNao.setContentAreaFilled(false);
        jbtNao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtNao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtNaoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtNaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtNaoMouseExited(evt);
            }
        });
        getContentPane().add(jbtNao, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 40, 40));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/fundoPopupComum.png"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 330, 130));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean getConfirmarAcao() {
        return this.confirmarAcao;
    }


    private void jbtNaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtNaoMouseClicked
        this.dispose();
    }//GEN-LAST:event_jbtNaoMouseClicked

    private void jbtNaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtNaoMouseEntered
        jbtNao.setBackground(new java.awt.Color(204, 0, 0));
        jbtNao.setForeground(new java.awt.Color(204, 204, 204));
    }//GEN-LAST:event_jbtNaoMouseEntered

    private void jbtNaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtNaoMouseExited
        jbtNao.setBackground(new java.awt.Color(204, 0, 0));
        jbtNao.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jbtNaoMouseExited

    private void jbtSimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSimMouseClicked
        this.confirmarAcao = true;
        this.dispose();
    }//GEN-LAST:event_jbtSimMouseClicked

    private void jbtSimMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSimMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtSimMouseEntered

    private void jbtSimMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSimMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtSimMouseExited

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtNao;
    private javax.swing.JButton jbtSim;
    private javax.swing.JLabel lblConfirmar;
    private javax.swing.JLabel lblFundo;
    // End of variables declaration//GEN-END:variables
}
