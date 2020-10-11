package br.unicap.eticket.view.admin;

import br.unicap.eticket.control.auxiliares.SalaControl;
import br.unicap.eticket.excecoes.AtualizacaoMalSucedidaException;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.locaisAuxiliares.Sala;
import br.unicap.eticket.model.locaisAuxiliares.TiposDeSala;
import br.unicap.eticket.view.FrameInicio;
import br.unicap.eticket.view.TelaInicio;
import br.unicap.eticket.view.jDialogs.TelaPopupConfirmar;
import javax.swing.JLabel;

public class TelaEditarSala extends javax.swing.JPanel {

    private LocalGenerico local;
    private String nomeSala;
    private Sala busca;

    public TelaEditarSala(LocalGenerico local, String nomeSala) {
        initComponents();
        this.local = local;
        this.nomeSala = nomeSala;
        jcbTipoSala.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"- Selecione -", TiposDeSala.NORMAL.name(), TiposDeSala.IMAX.name(),
            TiposDeSala.BISTRO.name(), TiposDeSala.DMAX.name(), TiposDeSala.SALA3D.name()}));
        this.initSala();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCadastrarSala = new javax.swing.JLabel();
        lblQtdCadx = new javax.swing.JLabel();
        lblQtdCady = new javax.swing.JLabel();
        lblTipoSala = new javax.swing.JLabel();
        lblValorIngresso = new javax.swing.JLabel();
        fldQtdCadx = new javax.swing.JTextField();
        fldQtdCady = new javax.swing.JTextField();
        jfldValIngresso = new javax.swing.JFormattedTextField();
        jbtEditar = new javax.swing.JButton();
        jcbTipoSala = new javax.swing.JComboBox<>();
        lblUsername = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblLinhinha = new javax.swing.JLabel();
        lblHomePage = new javax.swing.JLabel();
        lblSalas = new javax.swing.JLabel();
        lblSessoes = new javax.swing.JLabel();
        lblControleOrcamento = new javax.swing.JLabel();
        lblPerfil = new javax.swing.JLabel();
        lblDeslogar = new javax.swing.JLabel();
        fldNome = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        lblBordaEsquerda = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(21, 17, 17));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCadastrarSala.setFont(new java.awt.Font("Impact", 0, 38)); // NOI18N
        lblCadastrarSala.setForeground(new java.awt.Color(255, 255, 255));
        lblCadastrarSala.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCadastrarSala.setText("Editar Sala");
        add(lblCadastrarSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 350, 50));

        lblQtdCadx.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblQtdCadx.setForeground(new java.awt.Color(255, 255, 255));
        lblQtdCadx.setText("QTD Cadeiras X");
        add(lblQtdCadx, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 260, 190, 30));

        lblQtdCady.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblQtdCady.setForeground(new java.awt.Color(255, 255, 255));
        lblQtdCady.setText("QTD Cadeiras Y");
        add(lblQtdCady, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 260, 130, 30));

        lblTipoSala.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblTipoSala.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoSala.setText("Tipo da sala");
        add(lblTipoSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 370, 100, 30));

        lblValorIngresso.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblValorIngresso.setForeground(new java.awt.Color(255, 255, 255));
        lblValorIngresso.setText("Valor do ingresso");
        add(lblValorIngresso, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 470, 140, 30));

        fldQtdCadx.setBackground(new java.awt.Color(204, 204, 204));
        fldQtdCadx.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        fldQtdCadx.setForeground(new java.awt.Color(102, 102, 102));
        fldQtdCadx.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldQtdCadx, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 290, 160, 40));

        fldQtdCady.setBackground(new java.awt.Color(204, 204, 204));
        fldQtdCady.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        fldQtdCady.setForeground(new java.awt.Color(102, 102, 102));
        fldQtdCady.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldQtdCady, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 290, 160, 40));

        jfldValIngresso.setBackground(new java.awt.Color(204, 204, 204));
        jfldValIngresso.setForeground(new java.awt.Color(102, 102, 102));
        jfldValIngresso.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(""))));
        jfldValIngresso.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        add(jfldValIngresso, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 500, 350, -1));

        jbtEditar.setBackground(new java.awt.Color(227, 0, 0));
        jbtEditar.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jbtEditar.setForeground(new java.awt.Color(255, 255, 255));
        jbtEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoCompridoEdicao.png"))); // NOI18N
        jbtEditar.setText("EDITAR");
        jbtEditar.setBorder(null);
        jbtEditar.setContentAreaFilled(false);
        jbtEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtEditarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtEditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtEditarMouseExited(evt);
            }
        });
        add(jbtEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 580, 210, 60));

        jcbTipoSala.setBackground(new java.awt.Color(204, 204, 204));
        jcbTipoSala.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        jcbTipoSala.setForeground(new java.awt.Color(102, 102, 102));
        jcbTipoSala.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Selecione -", "NORMAL", "3D", "IMAX", "DMAX", "BISTRÔ" }));
        add(jcbTipoSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 400, 350, 40));

        lblUsername.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("@Admin");
        lblUsername.setToolTipText("");
        add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 140, 40));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/logoSemNome.png"))); // NOI18N
        add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 110, 110));

        lblLinhinha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/linhinha.png"))); // NOI18N
        add(lblLinhinha, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 150, 360, 20));

        lblHomePage.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        lblHomePage.setForeground(new java.awt.Color(255, 255, 255));
        lblHomePage.setText("HomePage");
        lblHomePage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblHomePage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomePageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHomePageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHomePageMouseExited(evt);
            }
        });
        add(lblHomePage, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 110, 40));

        lblSalas.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        lblSalas.setForeground(new java.awt.Color(255, 255, 255));
        lblSalas.setText("Salas");
        lblSalas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSalas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSalasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSalasMouseExited(evt);
            }
        });
        add(lblSalas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 110, 40));

        lblSessoes.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        lblSessoes.setForeground(new java.awt.Color(255, 255, 255));
        lblSessoes.setText("Sessões");
        lblSessoes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSessoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSessoesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSessoesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSessoesMouseExited(evt);
            }
        });
        add(lblSessoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 110, 40));

        lblControleOrcamento.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        lblControleOrcamento.setForeground(new java.awt.Color(255, 255, 255));
        lblControleOrcamento.setText("Controle de Orçamento");
        lblControleOrcamento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblControleOrcamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblControleOrcamentoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblControleOrcamentoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblControleOrcamentoMouseExited(evt);
            }
        });
        add(lblControleOrcamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 230, 40));

        lblPerfil.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        lblPerfil.setForeground(new java.awt.Color(255, 255, 255));
        lblPerfil.setText("Perfil");
        lblPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPerfilMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPerfilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPerfilMouseExited(evt);
            }
        });
        add(lblPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 150, 40));

        lblDeslogar.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        lblDeslogar.setForeground(new java.awt.Color(255, 255, 255));
        lblDeslogar.setText("Deslogar");
        lblDeslogar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDeslogar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDeslogarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDeslogarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDeslogarMouseExited(evt);
            }
        });
        add(lblDeslogar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 650, 150, 40));

        fldNome.setBackground(new java.awt.Color(204, 204, 204));
        fldNome.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        fldNome.setForeground(new java.awt.Color(102, 102, 102));
        add(fldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, 350, 40));

        lblNome.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("Nome");
        add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, 50, 20));

        lblBordaEsquerda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/BordaEsquerda.png"))); // NOI18N
        lblBordaEsquerda.setText("jLabel3");
        add(lblBordaEsquerda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 770));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/fundoGigante.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));
    }// </editor-fold>//GEN-END:initComponents

    private void initSala() {
        SalaControl salaC = new SalaControl();
        Sala sala = new Sala(local, nomeSala);
        try {
            busca = salaC.buscar(sala);
            fldNome.setText(busca.getNome());
            fldQtdCadx.setText(String.valueOf(busca.getFileirasX()));
            fldQtdCady.setText(String.valueOf(busca.getFileirasY()));
            jfldValIngresso.setText(String.valueOf(busca.getValorIngresso()));
            jcbTipoSala.setSelectedItem(busca.getTipoSala().getTipo());
        } catch (CadastroInexistenteException ex) {
            FrameInicio.mostrarPopUp(ex.getMessage(), true);
        }
    }
    private void jbtEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtEditarMouseClicked
        SalaControl salaC = new SalaControl();
        TiposDeSala tipo = TiposDeSala.valueOf(String.valueOf(jcbTipoSala.getSelectedItem()));

        Sala sala = new Sala(local, tipo, this.nomeSala, Integer.parseInt(fldQtdCadx.getText()),
                Integer.parseInt(fldQtdCady.getText()), Double.parseDouble(jfldValIngresso.getText()));
        try {
            salaC.atualizar(sala);
            if (!fldNome.getText().equalsIgnoreCase(this.nomeSala)) {
                busca.alterarNome(fldNome.getText());
            }

            FrameInicio.getFrame().setContentPane(new TelaListaDeSalas(local));
            FrameInicio.getFrame().revalidate();
        } catch (CadastroInexistenteException | AtualizacaoMalSucedidaException ex) {
            FrameInicio.mostrarPopUp(ex.getMessage(), true);
        }
    }//GEN-LAST:event_jbtEditarMouseClicked

    private void jbtEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtEditarMouseEntered
        jbtEditar.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jbtEditarMouseEntered

    private void jbtEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtEditarMouseExited
        jbtEditar.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jbtEditarMouseExited

    private void lblHomePageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomePageMouseClicked

        FrameInicio.getFrame().setContentPane(new TelaHomepageAdmin(local.getAdmin()));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblHomePageMouseClicked

    private void lblHomePageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomePageMouseEntered
        ascenderBotao(lblHomePage);
    }//GEN-LAST:event_lblHomePageMouseEntered

    private void lblHomePageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomePageMouseExited
        apagarBotao(lblHomePage);
    }//GEN-LAST:event_lblHomePageMouseExited

    private void lblSalasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalasMouseClicked

        FrameInicio.getFrame().setContentPane(new TelaListaDeSalas(local));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblSalasMouseClicked

    private void lblSalasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalasMouseEntered
        ascenderBotao(lblSalas);
    }//GEN-LAST:event_lblSalasMouseEntered

    private void lblSalasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalasMouseExited
        apagarBotao(lblSalas);
    }//GEN-LAST:event_lblSalasMouseExited

    private void lblSessoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSessoesMouseClicked

        FrameInicio.getFrame().setContentPane(new TelaListaDeSessoes(local));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblSessoesMouseClicked

    private void lblSessoesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSessoesMouseEntered
        ascenderBotao(lblSessoes);
    }//GEN-LAST:event_lblSessoesMouseEntered

    private void lblSessoesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSessoesMouseExited
        apagarBotao(lblSessoes);
    }//GEN-LAST:event_lblSessoesMouseExited

    private void lblControleOrcamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblControleOrcamentoMouseClicked
        //FrameInicio.getFrame().setContentPane(new TelaControleOrcamento(local));
        //FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblControleOrcamentoMouseClicked

    private void lblControleOrcamentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblControleOrcamentoMouseEntered
        ascenderBotao(lblControleOrcamento);
    }//GEN-LAST:event_lblControleOrcamentoMouseEntered

    private void lblControleOrcamentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblControleOrcamentoMouseExited
        apagarBotao(lblControleOrcamento);
    }//GEN-LAST:event_lblControleOrcamentoMouseExited

    private void lblPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPerfilMouseClicked
        FrameInicio.getFrame().setContentPane(new TelaMeuPerfilAdmin(local.getAdmin()));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblPerfilMouseClicked

    private void lblPerfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPerfilMouseEntered
        ascenderBotao(lblPerfil);
    }//GEN-LAST:event_lblPerfilMouseEntered

    private void lblPerfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPerfilMouseExited
        apagarBotao(lblPerfil);
    }//GEN-LAST:event_lblPerfilMouseExited

    private void lblDeslogarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeslogarMouseClicked
        TelaPopupConfirmar telaConf = FrameInicio.mostrarConfirmacao("Deseja sair?");
        if (telaConf.getConfirmarAcao()) {
            FrameInicio.getFrame().setContentPane(new TelaInicio());
            FrameInicio.getFrame().revalidate();
        }
    }//GEN-LAST:event_lblDeslogarMouseClicked

    private void lblDeslogarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeslogarMouseEntered
        ascenderBotao(lblDeslogar);
    }//GEN-LAST:event_lblDeslogarMouseEntered

    private void lblDeslogarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeslogarMouseExited
        apagarBotao(lblDeslogar);
    }//GEN-LAST:event_lblDeslogarMouseExited

    private void ascenderBotao(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(204, 204, 204));
    }

    private void apagarBotao(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(255, 255, 255));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fldNome;
    private javax.swing.JTextField fldQtdCadx;
    private javax.swing.JTextField fldQtdCady;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbtEditar;
    private javax.swing.JComboBox<String> jcbTipoSala;
    private javax.swing.JFormattedTextField jfldValIngresso;
    private javax.swing.JLabel lblBordaEsquerda;
    private javax.swing.JLabel lblCadastrarSala;
    private javax.swing.JLabel lblControleOrcamento;
    private javax.swing.JLabel lblDeslogar;
    private javax.swing.JLabel lblHomePage;
    private javax.swing.JLabel lblLinhinha;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JLabel lblQtdCadx;
    private javax.swing.JLabel lblQtdCady;
    private javax.swing.JLabel lblSalas;
    private javax.swing.JLabel lblSessoes;
    private javax.swing.JLabel lblTipoSala;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblValorIngresso;
    // End of variables declaration//GEN-END:variables
}
