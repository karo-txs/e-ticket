package br.unicap.eticket.view.jDialogs;

import br.unicap.eticket.excecoes.DadosInvalidosException;
import br.unicap.eticket.model.usuarios.Cliente;

public class TelaPopupNickname extends javax.swing.JDialog {
    
    private Cliente cliente;
    private boolean confirmarAcao;
    
    public TelaPopupNickname(java.awt.Frame parent, boolean modal, Cliente cliente) {
        super(parent, modal);
        initComponents();
        this.cliente = cliente;
        confirmarAcao = false;
        this.setBackground(new java.awt.Color(0, 0, 0, 0));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fldNick = new javax.swing.JTextField();
        lblCampo = new javax.swing.JLabel();
        lblMensagem = new javax.swing.JLabel();
        jbtFinalizar = new javax.swing.JButton();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fldNick.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        fldNick.setBorder(null);
        fldNick.setOpaque(false);
        fldNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fldNickActionPerformed(evt);
            }
        });
        getContentPane().add(fldNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 150, -1));

        lblCampo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/CampoDeNick.png"))); // NOI18N
        getContentPane().add(lblCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 180, 30));

        lblMensagem.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        lblMensagem.setForeground(new java.awt.Color(181, 0, 0));
        lblMensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMensagem.setText("<html><center>Crie seu NickName!");
        getContentPane().add(lblMensagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 270, 60));

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
        getContentPane().add(jbtFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 60, 40));

        lblFundo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/fundos/FundoDuasCores.png"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents
 public boolean getConfirmarAcao() {
        return this.confirmarAcao;
    }
    private void jbtFinalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFinalizarMouseClicked
        
        try {
            cliente.atualizarNickName(fldNick.getText());//sair
            this.confirmarAcao = true;
            this.dispose();
        } catch (DadosInvalidosException ex) {
            JDialogsControl.mostrarPopUp(ex.getMessage(),true);
        }
        
    }//GEN-LAST:event_jbtFinalizarMouseClicked

    private void jbtFinalizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFinalizarMouseEntered
        jbtFinalizar.setBackground(new java.awt.Color(204, 0, 0));
        jbtFinalizar.setForeground(new java.awt.Color(204, 204, 204));
    }//GEN-LAST:event_jbtFinalizarMouseEntered

    private void jbtFinalizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFinalizarMouseExited
        jbtFinalizar.setBackground(new java.awt.Color(204, 0, 0));
        jbtFinalizar.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jbtFinalizarMouseExited

    private void fldNickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fldNickActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fldNickActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fldNick;
    private javax.swing.JButton jbtFinalizar;
    private javax.swing.JLabel lblCampo;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblMensagem;
    // End of variables declaration//GEN-END:variables
}
