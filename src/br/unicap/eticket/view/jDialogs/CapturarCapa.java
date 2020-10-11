package br.unicap.eticket.view.jDialogs;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class CapturarCapa extends javax.swing.JDialog {
    
    private String urlImagem;
    
    public CapturarCapa() {
        initComponents();
        this.setBackground(new java.awt.Color(0, 0, 0, 0));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtConcluir = new javax.swing.JButton();
        jbtSelecionarImagem1 = new javax.swing.JButton();
        flCaminho = new javax.swing.JTextField();
        jlbImagem = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(21, 17, 17));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtConcluir.setBackground(new java.awt.Color(227, 0, 0));
        jbtConcluir.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jbtConcluir.setForeground(new java.awt.Color(255, 255, 255));
        jbtConcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/Confirma0.png"))); // NOI18N
        jbtConcluir.setToolTipText("");
        jbtConcluir.setBorder(null);
        jbtConcluir.setContentAreaFilled(false);
        jbtConcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtConcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtConcluirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtConcluirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtConcluirMouseExited(evt);
            }
        });
        jbtConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jbtConcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, -1, -1));

        jbtSelecionarImagem1.setBackground(new java.awt.Color(227, 0, 0));
        jbtSelecionarImagem1.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jbtSelecionarImagem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoComprido (1).png"))); // NOI18N
        jbtSelecionarImagem1.setText("<html><center>Selecionar Imagem");
        jbtSelecionarImagem1.setBorder(null);
        jbtSelecionarImagem1.setContentAreaFilled(false);
        jbtSelecionarImagem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtSelecionarImagem1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtSelecionarImagem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtSelecionarImagem1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtSelecionarImagem1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtSelecionarImagem1MouseExited(evt);
            }
        });
        jbtSelecionarImagem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSelecionarImagem1ActionPerformed(evt);
            }
        });
        getContentPane().add(jbtSelecionarImagem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 200, 50));

        flCaminho.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        flCaminho.setForeground(new java.awt.Color(102, 102, 102));
        flCaminho.setPreferredSize(new java.awt.Dimension(302, 38));
        getContentPane().add(flCaminho, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 260, 30));

        jlbImagem.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(jlbImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 213, 145));

        jLabel1.setFont(new java.awt.Font("Impact", 0, 27)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(188, 0, 0));
        jLabel1.setText("<html><center>Escolha a Capa");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 140, -1));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/fundos/FundoPopupQuadrado.png"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 340));

        setBounds(0, 0, 543, 336);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtConcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtConcluirActionPerformed

    private void jbtConcluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtConcluirMouseExited
        jbtConcluir.setBackground(new java.awt.Color(227, 0, 0));
        jbtConcluir.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jbtConcluirMouseExited

    private void jbtConcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtConcluirMouseEntered
        jbtConcluir.setBackground(new java.awt.Color(204, 0, 0));
        jbtConcluir.setForeground(new java.awt.Color(204, 204, 204));
    }//GEN-LAST:event_jbtConcluirMouseEntered

    private void jbtConcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtConcluirMouseClicked
        this.dispose();
    }//GEN-LAST:event_jbtConcluirMouseClicked

    private void jbtSelecionarImagem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSelecionarImagem1MouseClicked
        JFileChooser arquivo = new JFileChooser();
        arquivo.setDialogTitle("Selecione uma Capa:");
        arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int opc = arquivo.showOpenDialog(this);
        if (opc == JFileChooser.APPROVE_OPTION) {
            File file = new File("Caminho");
            file = arquivo.getSelectedFile();
            String fileName = file.getAbsolutePath();
            flCaminho.setText(fileName);
            
            ImageIcon img = new ImageIcon(arquivo.getSelectedFile().getPath());
            jlbImagem.setIcon(new ImageIcon(img.getImage().getScaledInstance(
                    jlbImagem.getWidth(), jlbImagem.getHeight(), Image.SCALE_DEFAULT)));
            
            String caminhoCompleto = this.caminhoCompleto(fileName);
            
            this.urlImagem = caminhoCompleto;
        }
    }//GEN-LAST:event_jbtSelecionarImagem1MouseClicked
    
    private String caminhoCompleto(String caminho) {
        char[] chars = caminho.toCharArray();
        String aux = "";
        
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '\\') {
                aux = aux.concat(Character.toString(chars[i]));
            } else {
                aux = aux.concat(Character.toString(chars[i])).concat(Character.toString(chars[i]));
            }
        }
        
        return aux;
    }
    private void jbtSelecionarImagem1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSelecionarImagem1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtSelecionarImagem1MouseEntered

    private void jbtSelecionarImagem1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSelecionarImagem1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtSelecionarImagem1MouseExited

    private void jbtSelecionarImagem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSelecionarImagem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtSelecionarImagem1ActionPerformed
    
    public String getImagemSelecionada() {
        return this.urlImagem;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField flCaminho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbtConcluir;
    private javax.swing.JButton jbtSelecionarImagem1;
    private javax.swing.JLabel jlbImagem;
    private javax.swing.JLabel lblFundo;
    // End of variables declaration//GEN-END:variables
}
