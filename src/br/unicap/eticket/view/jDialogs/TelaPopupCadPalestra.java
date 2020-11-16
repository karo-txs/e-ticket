package br.unicap.eticket.view.jDialogs;

import br.unicap.eticket.controller.localAuxiliares.EntretenimentoController;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosInvalidosException;
import br.unicap.eticket.model.entretenimentos.Classificacao;
import br.unicap.eticket.model.entretenimentos.Entretenimento;
import br.unicap.eticket.model.entretenimentos.Palestra;
import br.unicap.eticket.model.locais.Auditorio;
import br.unicap.eticket.model.locais.LocalGenerico;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaPopupCadPalestra extends javax.swing.JDialog {

    private CapturarCapa captura = new CapturarCapa();
    private Auditorio local;

    public TelaPopupCadPalestra(java.awt.Frame parent, boolean modal, LocalGenerico l) {
        super(parent, modal);
        initComponents();
        this.local = (Auditorio) l;
        this.setBackground(new java.awt.Color(0, 0, 0, 0));
    }
    
    public TelaPopupCadPalestra(LocalGenerico local) {
        initComponents();
        this.local = (Auditorio)local;
        this.setBackground(new java.awt.Color(0, 0, 0, 0));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcbClassif = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextSinopse = new javax.swing.JTextArea();
        fldDuracao = new javax.swing.JTextField();
        fldPalestrante = new javax.swing.JTextField();
        fldNome = new javax.swing.JTextField();
        lblClassificacao = new javax.swing.JLabel();
        lblSinopse = new javax.swing.JLabel();
        lblPalestrante = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblDuracao1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbtSelecionarImg = new javax.swing.JButton();
        jbtConfirma = new javax.swing.JButton();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jcbClassif.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        jcbClassif.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Selecione -", "Livre", "10 anos", "12 anos", "14 anos", "16 anos", "18 anos" }));
        getContentPane().add(jcbClassif, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 170, -1));

        jTextSinopse.setBackground(new java.awt.Color(240, 240, 240));
        jTextSinopse.setColumns(20);
        jTextSinopse.setRows(5);
        jScrollPane1.setViewportView(jTextSinopse);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 310, 150));

        fldDuracao.setBackground(new java.awt.Color(240, 240, 240));
        getContentPane().add(fldDuracao, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 90, -1));

        fldPalestrante.setBackground(new java.awt.Color(240, 240, 240));
        getContentPane().add(fldPalestrante, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 310, -1));

        fldNome.setBackground(new java.awt.Color(240, 240, 240));
        getContentPane().add(fldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 310, -1));

        lblClassificacao.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblClassificacao.setForeground(new java.awt.Color(255, 255, 255));
        lblClassificacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClassificacao.setText("Classificação");
        getContentPane().add(lblClassificacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 80, 20));

        lblSinopse.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblSinopse.setForeground(new java.awt.Color(255, 255, 255));
        lblSinopse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSinopse.setText("Sinopse");
        getContentPane().add(lblSinopse, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 70, 20));

        lblPalestrante.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblPalestrante.setForeground(new java.awt.Color(255, 255, 255));
        lblPalestrante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPalestrante.setText("Palestrante");
        getContentPane().add(lblPalestrante, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 190, 80, 20));

        lblNome.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNome.setText("Nome");
        getContentPane().add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 50, 20));

        lblDuracao1.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblDuracao1.setForeground(new java.awt.Color(255, 255, 255));
        lblDuracao1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDuracao1.setText("Duração");
        getContentPane().add(lblDuracao1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 70, 20));

        jLabel2.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cadastro Palestra");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 360, 40));

        jbtSelecionarImg.setBackground(new java.awt.Color(227, 0, 0));
        jbtSelecionarImg.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jbtSelecionarImg.setForeground(new java.awt.Color(255, 255, 255));
        jbtSelecionarImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoCompridoEdicao.png"))); // NOI18N
        jbtSelecionarImg.setText("Selecionar Capa");
        jbtSelecionarImg.setBorder(null);
        jbtSelecionarImg.setContentAreaFilled(false);
        jbtSelecionarImg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtSelecionarImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtSelecionarImgMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtSelecionarImgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtSelecionarImgMouseExited(evt);
            }
        });
        jbtSelecionarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSelecionarImgActionPerformed(evt);
            }
        });
        getContentPane().add(jbtSelecionarImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, 200, -1));

        jbtConfirma.setText("OK");
        jbtConfirma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtConfirmaMouseClicked(evt);
            }
        });
        getContentPane().add(jbtConfirma, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 490, -1, -1));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/fundos/FundoPopupSenhaInvalida.png"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 450, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtSelecionarImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSelecionarImgMouseClicked
        captura.setLocationRelativeTo(null);
        captura.setVisible(true);
       
//        
//        
//        EntretenimentoController entC = new EntretenimentoController();
//        try {
//
//            entC.cadastrar(new Palestra(fldNome.getText(), fldPalestrante.getText(), Integer.parseInt(fldDuracao.getText()),
//                    Classificacao.getClassificacao(this.jcbClassif.getSelectedItem().toString()),
//                    jTextSinopse.getText(),this.local), this.local, null);
//            p = new Palestra(fldNome.getText(), this.local);
//            this.dispose();
//
//        } catch (DadosInvalidosException ex) {
//            JDialogsControl.mostrarPopUp(ex.getMessage(), true);
//        }
    }//GEN-LAST:event_jbtSelecionarImgMouseClicked

    private void jbtSelecionarImgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSelecionarImgMouseEntered
        jbtSelecionarImg.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_jbtSelecionarImgMouseEntered

    private void jbtSelecionarImgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSelecionarImgMouseExited
        jbtSelecionarImg.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_jbtSelecionarImgMouseExited

    private void jbtSelecionarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSelecionarImgActionPerformed
        
    }//GEN-LAST:event_jbtSelecionarImgActionPerformed

    private void jbtConfirmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtConfirmaMouseClicked
        EntretenimentoController entC = new EntretenimentoController();
        Entretenimento ent =  new Palestra(fldNome.getText(), fldPalestrante.getText(),
                Integer.parseInt(fldDuracao.getText()), Classificacao.getClassificacao(this.jcbClassif.getSelectedItem().toString()),
                jTextSinopse.getText(),local);
        
        try {
            entC.cadastrar(ent);
        } catch (DadosInvalidosException ex) {
            Logger.getLogger(TelaPopupCadPalestra.class.getName()).log(Level.SEVERE, null, ex);
        }
        
             if (captura.getImagemSelecionada() != null) {
                try {
                    entC.modificarCapa(ent,captura.getImagemSelecionada());
                } catch (CadastroInexistenteException ex) {
                    Logger.getLogger(TelaPopupCadPalestra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            this.dispose();
    }//GEN-LAST:event_jbtConfirmaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fldDuracao;
    private javax.swing.JTextField fldNome;
    private javax.swing.JTextField fldPalestrante;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextSinopse;
    private javax.swing.JButton jbtConfirma;
    private javax.swing.JButton jbtSelecionarImg;
    private javax.swing.JComboBox<String> jcbClassif;
    private javax.swing.JLabel lblClassificacao;
    private javax.swing.JLabel lblDuracao1;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPalestrante;
    private javax.swing.JLabel lblSinopse;
    // End of variables declaration//GEN-END:variables
}
