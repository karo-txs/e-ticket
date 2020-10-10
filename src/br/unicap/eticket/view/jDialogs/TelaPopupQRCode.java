package br.unicap.eticket.view.jDialogs;

import br.unicap.eticket.model.usuarios.Cliente;
import br.unicap.eticket.view.FrameInicio;
import br.unicap.eticket.view.cliente.TelaListaDeReservas;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class TelaPopupQRCode extends javax.swing.JDialog {

    private Cliente cliente;

    public TelaPopupQRCode(java.awt.Frame parent, boolean modal, byte[] img, Cliente c) {
        super(parent, modal);
        initComponents();
        this.cliente = c;
        Image im = new ImageIcon(img).getImage();
        Icon ic = new ImageIcon(im);
        lblQRCode.setIcon(ic);
        this.setBackground(new java.awt.Color(0, 0, 0, 0));
    }

    public TelaPopupQRCode(byte[] img) {
        initComponents();
        Image im = new ImageIcon(img).getImage();
        Icon ic = new ImageIcon(im);
        lblQRCode.setIcon(ic);
        this.setBackground(new java.awt.Color(0, 0, 0, 0));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblQRCode = new javax.swing.JLabel();
        jbtOk = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblQRCode.setOpaque(true);
        lblQRCode.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(lblQRCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 150, 150));

        jbtOk.setBackground(new java.awt.Color(227, 0, 0));
        jbtOk.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jbtOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoComprido (1).png"))); // NOI18N
        jbtOk.setText("Lista de Reservas");
        jbtOk.setBorder(null);
        jbtOk.setContentAreaFilled(false);
        jbtOk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtOk.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtOkMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtOkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtOkMouseExited(evt);
            }
        });
        getContentPane().add(jbtOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, 40));

        jLabel2.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("<html><Center> Sua Reserva foi concluída com sucesso!");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 410, 60));

        jLabel1.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("<html> <Center>Utilize este QR Code para identificação no local.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 240, 60));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/FundoPopupGrande.png"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 560, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtOkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtOkMouseClicked
        FrameInicio.getFrame().setContentPane(new TelaListaDeReservas(cliente));
        this.dispose();
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_jbtOkMouseClicked

    private void jbtOkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtOkMouseEntered
        jbtOk.setBackground(new java.awt.Color(204, 0, 0));
        jbtOk.setForeground(new java.awt.Color(204, 204, 204));
    }//GEN-LAST:event_jbtOkMouseEntered

    private void jbtOkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtOkMouseExited
        jbtOk.setBackground(new java.awt.Color(204, 0, 0));
        jbtOk.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jbtOkMouseExited

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbtOk;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblQRCode;
    // End of variables declaration//GEN-END:variables
}
