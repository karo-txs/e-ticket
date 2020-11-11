package br.unicap.eticket.view.jDialogs;

import javax.swing.JLabel;

public class TelaPopupMissoes extends javax.swing.JDialog {
    
    JLabel[] regras;
    JLabel[] condicoes;
    
    public TelaPopupMissoes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setBackground(new java.awt.Color(0, 0, 0, 0));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMissao3 = new javax.swing.JLabel();
        lblMissao2 = new javax.swing.JLabel();
        lblMissao1 = new javax.swing.JLabel();
        jbtFinalizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblTier3 = new javax.swing.JLabel();
        lblTier2 = new javax.swing.JLabel();
        lblTier1 = new javax.swing.JLabel();
        lblMissoes = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMissao3.setFont(new java.awt.Font("Gulim", 0, 12)); // NOI18N
        lblMissao3.setForeground(new java.awt.Color(255, 255, 255));
        lblMissao3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMissao3.setText("<html><center>A partir de 20 tickets comprados ganhe 20% de desconto nas proximas compras!");
        getContentPane().add(lblMissao3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 330, 50));

        lblMissao2.setFont(new java.awt.Font("Gulim", 0, 12)); // NOI18N
        lblMissao2.setForeground(new java.awt.Color(255, 255, 255));
        lblMissao2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMissao2.setText("<html><center>A partir de 10 tickets comprados ganhe 15% de desconto nas proximas compras!");
        getContentPane().add(lblMissao2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 330, 50));

        lblMissao1.setFont(new java.awt.Font("Gulim", 0, 12)); // NOI18N
        lblMissao1.setForeground(new java.awt.Color(255, 255, 255));
        lblMissao1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMissao1.setText("<html><center>A partir de 5 tickets comprados ganhe 10% de desconto nas proximas compras!");
        getContentPane().add(lblMissao1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 330, 60));

        jbtFinalizar.setBackground(new java.awt.Color(227, 0, 0));
        jbtFinalizar.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jbtFinalizar.setForeground(new java.awt.Color(255, 255, 255));
        jbtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoRetorno.png"))); // NOI18N
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
        getContentPane().add(jbtFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, 40, 40));

        jLabel2.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Missões");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 360, 40));

        lblTier3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/icones/Tier1.png"))); // NOI18N
        getContentPane().add(lblTier3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 60, 40));

        lblTier2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/icones/Tier2.png"))); // NOI18N
        getContentPane().add(lblTier2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 60, 40));

        lblTier1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/icones/Tier3.png"))); // NOI18N
        getContentPane().add(lblTier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 60, 50));

        lblMissoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/icones/IconeMissao.png"))); // NOI18N
        getContentPane().add(lblMissoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 60, 40));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/fundos/FundoPopupSenhaInvalida.png"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 450, 520));

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbtFinalizar;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblMissao1;
    private javax.swing.JLabel lblMissao2;
    private javax.swing.JLabel lblMissao3;
    private javax.swing.JLabel lblMissoes;
    private javax.swing.JLabel lblTier1;
    private javax.swing.JLabel lblTier2;
    private javax.swing.JLabel lblTier3;
    // End of variables declaration//GEN-END:variables
}
