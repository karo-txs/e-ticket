package br.unicap.eticket.view.jDialogs;

public class TelaPopupComum extends javax.swing.JDialog {
    
    public TelaPopupComum(java.awt.Frame parent, boolean modal, String frase,boolean isErro) {
        super(parent, modal);
        initComponents();
        lblMensagem.setText("<html><center>" + frase);
        if(isErro){
            Exclamacao.setVisible(true);
            ok.setVisible(false);
        }else{
            Exclamacao.setVisible(false);
            ok.setVisible(true);
        }
        this.setBackground(new java.awt.Color(0, 0, 0, 0));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtFinalizar = new javax.swing.JButton();
        ok = new javax.swing.JLabel();
        Exclamacao = new javax.swing.JLabel();
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
        getContentPane().add(jbtFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 50, 40));

        ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/IconeV.png"))); // NOI18N
        getContentPane().add(ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 40, 40));

        Exclamacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/Exclamacao.png"))); // NOI18N
        getContentPane().add(Exclamacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 40, 40));

        lblMensagem.setFont(new java.awt.Font("Impact", 0, 16)); // NOI18N
        lblMensagem.setForeground(new java.awt.Color(255, 255, 255));
        lblMensagem.setText("<html><center>Login inválido!");
        getContentPane().add(lblMensagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 220, 40));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/fundos/FundoPopupComumPequeno.png"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 350, 150));

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
    private javax.swing.JLabel Exclamacao;
    private javax.swing.JButton jbtFinalizar;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JLabel ok;
    // End of variables declaration//GEN-END:variables
}
