package br.unicap.eticket.view.jDialogs;

import br.unicap.eticket.control.auxiliares.ReservaControl;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.model.auxiliares.Reserva;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.locaisAuxiliares.Entretenimento;

import br.unicap.eticket.model.usuarios.Cliente;
import br.unicap.eticket.view.FrameInicio;
import br.unicap.eticket.view.cliente.TelaListaDeReservas;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class TelaAvaliacao extends javax.swing.JDialog {

    private Reserva reserva;
    private Cliente cliente;
    private boolean avaliacaoFeita;

    public TelaAvaliacao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setBackground(new java.awt.Color(0, 0, 0, 0));
    }

    public TelaAvaliacao(Long idReserva, Cliente cliente) {
        initComponents();
        ReservaControl reservaC = new ReservaControl();
        Reserva busca = reservaC.buscaPorId(idReserva);
        this.reserva = busca;
        this.cliente = cliente;
        initReserva();
        this.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.avaliacaoFeita = false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        lblCarinhasLocal1 = new javax.swing.JLabel();
        lblCarinhasLocal = new javax.swing.JLabel();
        jbtAvaliar = new javax.swing.JButton();
        lblEntretenimento = new javax.swing.JLabel();
        lblFotoEntretenimento = new javax.swing.JLabel();
        lblNomeLocal = new javax.swing.JLabel();
        lblFotoLocal = new javax.swing.JLabel();
        jrb11 = new javax.swing.JRadioButton();
        jrb12 = new javax.swing.JRadioButton();
        jrb13 = new javax.swing.JRadioButton();
        jrb14 = new javax.swing.JRadioButton();
        jrb15 = new javax.swing.JRadioButton();
        jrb1 = new javax.swing.JRadioButton();
        jrb2 = new javax.swing.JRadioButton();
        jrb3 = new javax.swing.JRadioButton();
        jrb4 = new javax.swing.JRadioButton();
        jrb5 = new javax.swing.JRadioButton();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCarinhasLocal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/Carinhas.png"))); // NOI18N
        getContentPane().add(lblCarinhasLocal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 200, 50));

        lblCarinhasLocal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/Carinhas.png"))); // NOI18N
        getContentPane().add(lblCarinhasLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 200, 50));

        jbtAvaliar.setBackground(new java.awt.Color(102, 102, 0));
        jbtAvaliar.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jbtAvaliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoComprido (1).png"))); // NOI18N
        jbtAvaliar.setText("Avaliar");
        jbtAvaliar.setContentAreaFilled(false);
        jbtAvaliar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtAvaliar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtAvaliarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtAvaliarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtAvaliarMouseExited(evt);
            }
        });
        getContentPane().add(jbtAvaliar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 200, 40));

        lblEntretenimento.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblEntretenimento.setForeground(new java.awt.Color(255, 255, 255));
        lblEntretenimento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEntretenimento.setText("<html>Entreterimento");
        getContentPane().add(lblEntretenimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 240, 40));

        lblFotoEntretenimento.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(lblFotoEntretenimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 145, 213));

        lblNomeLocal.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblNomeLocal.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeLocal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomeLocal.setText("<html>CineTal");
        getContentPane().add(lblNomeLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 210, 30));

        lblFotoLocal.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(lblFotoLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 213, 145));

        buttonGroup2.add(jrb11);
        jrb11.setOpaque(false);
        getContentPane().add(jrb11, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 310, -1, -1));

        buttonGroup2.add(jrb12);
        jrb12.setOpaque(false);
        getContentPane().add(jrb12, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 310, -1, -1));

        buttonGroup2.add(jrb13);
        jrb13.setOpaque(false);
        getContentPane().add(jrb13, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 310, -1, -1));

        buttonGroup2.add(jrb14);
        jrb14.setOpaque(false);
        getContentPane().add(jrb14, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 310, -1, -1));

        buttonGroup2.add(jrb15);
        jrb15.setOpaque(false);
        getContentPane().add(jrb15, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 310, -1, -1));

        buttonGroup1.add(jrb1);
        jrb1.setOpaque(false);
        getContentPane().add(jrb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 100, -1, -1));

        buttonGroup1.add(jrb2);
        jrb2.setOpaque(false);
        getContentPane().add(jrb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 100, -1, -1));

        buttonGroup1.add(jrb3);
        jrb3.setOpaque(false);
        getContentPane().add(jrb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 100, -1, -1));

        buttonGroup1.add(jrb4);
        jrb4.setOpaque(false);
        getContentPane().add(jrb4, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 100, -1, -1));

        buttonGroup1.add(jrb5);
        jrb5.setOpaque(false);
        getContentPane().add(jrb5, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 100, -1, -1));

        lblFundo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/FundoPopupAvaliacao.png"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initReserva() {
        LocalGenerico local = reserva.getSessao().getLocal();
        Entretenimento ent = reserva.getSessao().getEntretenimento();
        lblNomeLocal.setText(local.getNome());
        lblEntretenimento.setText(ent.getNome());

        lblFotoLocal.setIcon(new ImageIcon(new ImageIcon(local.getCapa()).getImage()));
        lblFotoEntretenimento.setIcon(new ImageIcon(new ImageIcon(ent.getCapa()).getImage()));

    }
    private void jbtAvaliarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAvaliarMouseEntered
        jbtAvaliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoComprido (2).png")));
    }//GEN-LAST:event_jbtAvaliarMouseEntered

    private void jbtAvaliarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAvaliarMouseExited
        jbtAvaliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoComprido (1).png")));
    }//GEN-LAST:event_jbtAvaliarMouseExited

    private void jbtAvaliarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAvaliarMouseClicked
       /* TelaPopupConfirmar telaConf = FrameInicio.mostrarConfirmacao("Deseja Concluir a sua avalião? Ao concuir não poderá repetir esse processo!");
        if (telaConf.getConfirmarAcao()) {*/
            int nota = 0;
            if (jrb1.isSelected()) {
                nota = 1;
            } else if (jrb2.isSelected()) {
                nota = 2;
            } else if (jrb3.isSelected()) {
                nota = 3;
            } else if (jrb4.isSelected()) {
                nota = 4;
            } else if (jrb5.isSelected()) {
                nota = 5;
            }
            if (buttonGroup1.isSelected(null)) {
                //sem nota
            } else {
                cliente.darNota(reserva.getSessao().getLocal(), nota);
            }

            nota = 0;
            if (jrb11.isSelected()) {
                nota = 1;
            } else if (jrb12.isSelected()) {
                nota = 2;
            } else if (jrb13.isSelected()) {
                nota = 3;
            } else if (jrb14.isSelected()) {
                nota = 4;
            } else if (jrb15.isSelected()) {
                nota = 5;
            }
            if (buttonGroup2.isSelected(null)) {
                //sem nota
            } else {
                cliente.darNota(reserva.getSessao().getEntretenimento(), nota);
            }
            
            try {
                reserva.finalizarReserva();
                this.avaliacaoFeita = true;
                this.dispose();
                
            } catch (CadastroInexistenteException ex) {
                FrameInicio.mostrarPopUp(ex.getMessage());
            } 
            
       /* } else {
            FrameInicio.mostrarPopUp("Avaliação cancelada!");
            this.dispose();
        }*/
    }//GEN-LAST:event_jbtAvaliarMouseClicked
    public boolean getAvaliacaoFeita() {
        return this.avaliacaoFeita;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jbtAvaliar;
    private javax.swing.JRadioButton jrb1;
    private javax.swing.JRadioButton jrb11;
    private javax.swing.JRadioButton jrb12;
    private javax.swing.JRadioButton jrb13;
    private javax.swing.JRadioButton jrb14;
    private javax.swing.JRadioButton jrb15;
    private javax.swing.JRadioButton jrb2;
    private javax.swing.JRadioButton jrb3;
    private javax.swing.JRadioButton jrb4;
    private javax.swing.JRadioButton jrb5;
    private javax.swing.JLabel lblCarinhasLocal;
    private javax.swing.JLabel lblCarinhasLocal1;
    private javax.swing.JLabel lblEntretenimento;
    private javax.swing.JLabel lblFotoEntretenimento;
    private javax.swing.JLabel lblFotoLocal;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblNomeLocal;
    // End of variables declaration//GEN-END:variables
}
