package br.unicap.eticket.view.jDialogs;

import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.usuarios.ClienteEspecial;

public class TelaPopupSubiuTier extends javax.swing.JDialog {
    
    public TelaPopupSubiuTier(java.awt.Frame parent, boolean modal, ClienteEspecial clienteE, LocalGenerico local) {
        super(parent, modal);
        initComponents();
        String caminho = clienteE.getTierImg(local);
        lblTier.setIcon(new javax.swing.ImageIcon(getClass().getResource(caminho)));
        this.setBackground(new java.awt.Color(0, 0, 0, 0));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtFinalizar = new javax.swing.JButton();
        lblTier = new javax.swing.JLabel();
        lblMensagem1 = new javax.swing.JLabel();
        lblMensagem = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtFinalizar.setBackground(new java.awt.Color(227, 0, 0));
        jbtFinalizar.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jbtFinalizar.setForeground(new java.awt.Color(255, 255, 255));
        jbtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/Confirma0.png"))); // NOI18N
        jbtFinalizar.setBorder(null);
        jbtFinalizar.setContentAreaFilled(false);
        jbtFinalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtFinalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtFinalizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtFinalizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtFinalizarMouseExited(evt);
            }
        });
        getContentPane().add(jbtFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 50, 40));

        lblTier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/icones/Tier1.png"))); // NOI18N
        getContentPane().add(lblTier, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 60, 40));

        lblMensagem1.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        lblMensagem1.setForeground(new java.awt.Color(255, 255, 255));
        lblMensagem1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMensagem1.setText("<html><center>Veja as missões para conferir seu bônus! Válido apenas neste estabelecimento.");
        getContentPane().add(lblMensagem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 430, 40));

        lblMensagem.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblMensagem.setForeground(new java.awt.Color(255, 255, 255));
        lblMensagem.setText("<html><center>Parabéns! Você acaba de subir de Tier.");
        getContentPane().add(lblMensagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 220, 40));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/fundos/FundoPopupSubiuDeNivel.png"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 490, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtFinalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFinalizarMouseClicked
        this.dispose();
    }//GEN-LAST:event_jbtFinalizarMouseClicked

    private void jbtFinalizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFinalizarMouseEntered
        jbtFinalizar.setBackground(new java.awt.Color(204, 0, 0));
        jbtFinalizar.setForeground(new java.awt.Color(204, 204, 204));
    }//GEN-LAST:event_jbtFinalizarMouseEntered

    private void jbtFinalizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFinalizarMouseExited
        jbtFinalizar.setBackground(new java.awt.Color(204, 0, 0));
        jbtFinalizar.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jbtFinalizarMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtFinalizar;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JLabel lblMensagem1;
    private javax.swing.JLabel lblTier;
    // End of variables declaration//GEN-END:variables
}
