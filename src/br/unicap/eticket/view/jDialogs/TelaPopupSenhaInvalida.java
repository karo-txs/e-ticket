package br.unicap.eticket.view.jDialogs;

import javax.swing.JLabel;

public class TelaPopupSenhaInvalida extends javax.swing.JDialog {
    
    JLabel[] regras;
    JLabel[] condicoes;
    
    public TelaPopupSenhaInvalida(java.awt.Frame parent, boolean modal, String frase) {
        super(parent, modal);
        initComponents();
        initRegras();
        initRegrasErradas(frase);
        this.setBackground(new java.awt.Color(0, 0, 0, 0));
    }
    
    private void initRegras() {
        regras = new JLabel[8];
        regras[0] = lblMensagem;
        regras[1] = lblMensagem1;
        regras[2] = lblMensagem2;
        regras[3] = lblMensagem3;
        regras[4] = lblMensagem4;
        regras[5] = lblMensagem5;
        regras[6] = lblMensagem6;
        regras[7] = lblMensagem7;
        
        condicoes = new JLabel[8];
        condicoes[0] = lblCondicao;
        setarImagV(condicoes[0]);
        condicoes[1] = lblCondicao1;
        setarImagV(condicoes[1]);
        condicoes[2] = lblCondicao2;
        setarImagV(condicoes[2]);
        condicoes[3] = lblCondicao3;
        setarImagV(condicoes[3]);
        condicoes[4] = lblCondicao4;
        setarImagV(condicoes[4]);
        condicoes[5] = lblCondicao5;
        setarImagV(condicoes[5]);
        condicoes[6] = lblCondicao6;
        setarImagV(condicoes[6]);
        condicoes[7] = lblCondicao7;
        setarImagV(condicoes[7]);
    }
    
    private void setarImagV(JLabel j) {
        j.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/IconeV.png")));
    }

    private void setarImagX(JLabel j) {
        j.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/IconeX.png")));
    }
    
    private void initRegrasErradas(String frase) {
        String[] regrasErradas = frase.split("--");
        for (int i = 0; i < regrasErradas.length; i++) {
            for (int l = 0; l < regras.length; l++) {
                if (regrasErradas[i].equalsIgnoreCase(regras[l].getText())) {
                    setarImagX(condicoes[l]);
                }
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblCondicao7 = new javax.swing.JLabel();
        lblCondicao6 = new javax.swing.JLabel();
        lblCondicao4 = new javax.swing.JLabel();
        lblCondicao5 = new javax.swing.JLabel();
        lblCondicao3 = new javax.swing.JLabel();
        lblCondicao2 = new javax.swing.JLabel();
        lblCondicao1 = new javax.swing.JLabel();
        lblCondicao = new javax.swing.JLabel();
        lblMensagem7 = new javax.swing.JLabel();
        lblMensagem6 = new javax.swing.JLabel();
        lblMensagem5 = new javax.swing.JLabel();
        lblMensagem4 = new javax.swing.JLabel();
        lblMensagem3 = new javax.swing.JLabel();
        lblMensagem2 = new javax.swing.JLabel();
        lblMensagem1 = new javax.swing.JLabel();
        lblMensagem = new javax.swing.JLabel();
        jbtFinalizar = new javax.swing.JButton();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Senha Incorreta!");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 360, 40));
        getContentPane().add(lblCondicao7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 30, 30));
        getContentPane().add(lblCondicao6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 30, 30));
        getContentPane().add(lblCondicao4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 30, 30));
        getContentPane().add(lblCondicao5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 30, 30));
        getContentPane().add(lblCondicao3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 30, 30));
        getContentPane().add(lblCondicao2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 30, 30));
        getContentPane().add(lblCondicao1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 30, 30));
        getContentPane().add(lblCondicao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 30, 30));

        lblMensagem7.setFont(new java.awt.Font("Impact", 0, 16)); // NOI18N
        lblMensagem7.setForeground(new java.awt.Color(255, 255, 255));
        lblMensagem7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMensagem7.setText("Deve ter no mínimo 4 caracter(es).");
        getContentPane().add(lblMensagem7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 370, 20));

        lblMensagem6.setFont(new java.awt.Font("Impact", 0, 16)); // NOI18N
        lblMensagem6.setForeground(new java.awt.Color(255, 255, 255));
        lblMensagem6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMensagem6.setText("Não deve conter mais de 14 caracter(es).");
        getContentPane().add(lblMensagem6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 370, 20));

        lblMensagem5.setFont(new java.awt.Font("Impact", 0, 16)); // NOI18N
        lblMensagem5.setForeground(new java.awt.Color(255, 255, 255));
        lblMensagem5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMensagem5.setText("Deve ter pelo menos 1 caracter(es) especiais.");
        getContentPane().add(lblMensagem5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 370, 20));

        lblMensagem4.setFont(new java.awt.Font("Impact", 0, 16)); // NOI18N
        lblMensagem4.setForeground(new java.awt.Color(255, 255, 255));
        lblMensagem4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMensagem4.setText("Deve conter pelo menos 2 dígito(s).");
        getContentPane().add(lblMensagem4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 360, 20));

        lblMensagem3.setFont(new java.awt.Font("Impact", 0, 16)); // NOI18N
        lblMensagem3.setForeground(new java.awt.Color(255, 255, 255));
        lblMensagem3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMensagem3.setText("Deve conter pelo menos 2 caracter(es) alfabético(s).");
        getContentPane().add(lblMensagem3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 370, 20));

        lblMensagem2.setFont(new java.awt.Font("Impact", 0, 16)); // NOI18N
        lblMensagem2.setForeground(new java.awt.Color(255, 255, 255));
        lblMensagem2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMensagem2.setText("Deve conter pelo menos 1 caracter(es) minúsculo(s).");
        getContentPane().add(lblMensagem2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 370, -1));

        lblMensagem1.setFont(new java.awt.Font("Impact", 0, 16)); // NOI18N
        lblMensagem1.setForeground(new java.awt.Color(255, 255, 255));
        lblMensagem1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMensagem1.setText("Deve conter pelo menos 1 caracter(es) maiúsculo(s).");
        getContentPane().add(lblMensagem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 370, -1));

        lblMensagem.setFont(new java.awt.Font("Impact", 0, 16)); // NOI18N
        lblMensagem.setForeground(new java.awt.Color(255, 255, 255));
        lblMensagem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMensagem.setText("Não pode conter espaços em branco.");
        getContentPane().add(lblMensagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 370, -1));

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

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/FundoSenhaInv.png"))); // NOI18N
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

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbtFinalizar;
    private javax.swing.JLabel lblCondicao;
    private javax.swing.JLabel lblCondicao1;
    private javax.swing.JLabel lblCondicao2;
    private javax.swing.JLabel lblCondicao3;
    private javax.swing.JLabel lblCondicao4;
    private javax.swing.JLabel lblCondicao5;
    private javax.swing.JLabel lblCondicao6;
    private javax.swing.JLabel lblCondicao7;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JLabel lblMensagem1;
    private javax.swing.JLabel lblMensagem2;
    private javax.swing.JLabel lblMensagem3;
    private javax.swing.JLabel lblMensagem4;
    private javax.swing.JLabel lblMensagem5;
    private javax.swing.JLabel lblMensagem6;
    private javax.swing.JLabel lblMensagem7;
    // End of variables declaration//GEN-END:variables
}
