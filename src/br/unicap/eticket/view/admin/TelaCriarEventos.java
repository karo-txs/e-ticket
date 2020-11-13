package br.unicap.eticket.view.admin;

import br.unicap.eticket.controller.localAuxiliares.EventoController;
import br.unicap.eticket.controller.localAuxiliares.SessaoController;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosRepetidosException;
import br.unicap.eticket.model.auxiliares.Evento;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.locaisAuxiliares.Sessao;
import br.unicap.eticket.model.locaisAuxiliares.TipoEvento;
import br.unicap.eticket.view.FrameInicio;
import br.unicap.eticket.view.TelaInicio;
import br.unicap.eticket.view.jDialogs.JDialogsControl;
import br.unicap.eticket.view.jDialogs.TelaPopupConfirmar;
import javax.swing.JLabel;

public class TelaCriarEventos extends javax.swing.JPanel {

    private LocalGenerico local;
    private Sessao[] sessoesAux;

    public TelaCriarEventos(LocalGenerico local) {
        initComponents();
        this.local = local;
        initSessoes(local);
    }

    private void initSessoes(LocalGenerico local) {
        SessaoController sc = new SessaoController();
        String[] dados = sc.formataDados(local.getSessoes());
        sessoesAux = sc.converterListEmArray(local.getSessoes());
        
        lstSessoes.setModel(new javax.swing.DefaultComboBoxModel<>(dados));
        lstEventos.setModel(new javax.swing.DefaultComboBoxModel<>(TipoEvento.eventos()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEventos = new javax.swing.JLabel();
        lblPerfil = new javax.swing.JLabel();
        lblControleOrcamento = new javax.swing.JLabel();
        lblSessoes = new javax.swing.JLabel();
        lblSalas = new javax.swing.JLabel();
        lblHomePage = new javax.swing.JLabel();
        lblLinhinha = new javax.swing.JLabel();
        lblDeslogar = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstEventos = new javax.swing.JList<>();
        lblBordaEsquerda = new javax.swing.JLabel();
        lblEventosDisp = new javax.swing.JLabel();
        lblEscolherEvento = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jbtDesativarEvento = new javax.swing.JButton();
        jbtAtivarEvento = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstSessoes = new javax.swing.JList<>();
        lblBackground = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEventos.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        lblEventos.setForeground(new java.awt.Color(255, 255, 255));
        lblEventos.setText("Eventos");
        lblEventos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEventos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEventosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblEventosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblEventosMouseExited(evt);
            }
        });
        add(lblEventos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 90, 40));

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

        lblLinhinha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/linhinha.png"))); // NOI18N
        add(lblLinhinha, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 150, 360, 20));

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

        lblUsername.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("@Admin");
        lblUsername.setToolTipText("");
        add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 140, 40));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/logoSemNome.png"))); // NOI18N
        add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 110, 110));

        lstEventos.setBackground(new java.awt.Color(21, 17, 17));
        lstEventos.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        lstEventos.setForeground(new java.awt.Color(255, 255, 255));
        lstEventos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "10 Tickets Gratuitos", "20 Tickets Gratuitos", "30 Tickets Gratuitos" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstEventos.setFixedCellHeight(60);
        lstEventos.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane2.setViewportView(lstEventos);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 210, 390, 340));

        lblBordaEsquerda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/BordaEsquerda.png"))); // NOI18N
        lblBordaEsquerda.setText("jLabel3");
        add(lblBordaEsquerda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 770));

        lblEventosDisp.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        lblEventosDisp.setForeground(new java.awt.Color(255, 255, 255));
        lblEventosDisp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEventosDisp.setText("Eventos Disponíveis");
        add(lblEventosDisp, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 390, 80));

        lblEscolherEvento.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblEscolherEvento.setForeground(new java.awt.Color(255, 255, 255));
        lblEscolherEvento.setText("Escolha o evento:");
        add(lblEscolherEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 160, 390, 40));

        jLabel1.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Escolha a sessão:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 390, 40));

        jbtDesativarEvento.setBackground(new java.awt.Color(227, 0, 0));
        jbtDesativarEvento.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jbtDesativarEvento.setForeground(new java.awt.Color(255, 0, 0));
        jbtDesativarEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoComprido2 (1)_1.png"))); // NOI18N
        jbtDesativarEvento.setText("<html><center>Desativar Evento");
        jbtDesativarEvento.setBorder(null);
        jbtDesativarEvento.setContentAreaFilled(false);
        jbtDesativarEvento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtDesativarEvento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtDesativarEvento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtDesativarEventoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtDesativarEventoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtDesativarEventoMouseExited(evt);
            }
        });
        add(jbtDesativarEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 560, 250, 70));

        jbtAtivarEvento.setBackground(new java.awt.Color(227, 0, 0));
        jbtAtivarEvento.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jbtAtivarEvento.setForeground(new java.awt.Color(0, 51, 255));
        jbtAtivarEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoComprido2 (1)_1.png"))); // NOI18N
        jbtAtivarEvento.setText("<html><center>Ativar Evento");
        jbtAtivarEvento.setBorder(null);
        jbtAtivarEvento.setContentAreaFilled(false);
        jbtAtivarEvento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtAtivarEvento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtAtivarEvento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtAtivarEventoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtAtivarEventoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtAtivarEventoMouseExited(evt);
            }
        });
        add(jbtAtivarEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 560, 250, 70));

        lstSessoes.setBackground(new java.awt.Color(21, 17, 17));
        lstSessoes.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        lstSessoes.setForeground(new java.awt.Color(255, 255, 255));
        lstSessoes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "SALA3D | Sala-2 | 400 Assentos | R$14.50", "BISTRÔ | Sala-2 | 400 Assentos | R$14.50", "IMAX | Sala-2 | 400 Assentos | R$14.50", "SALA3D | Sala-2 | 400 Assentos | R$14.50", "BISTRÔ | Sala-2 | 400 Assentos | R$14.50", "IMAX | Sala-2 | 400 Assentos | R$14.50", "SALA3D | Sala-2 | 400 Assentos | R$14.50", "BISTRÔ | Sala-2 | 400 Assentos | R$14.50", "IMAX | Sala-2 | 400 Assentos | R$14.50" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstSessoes.setFixedCellHeight(60);
        lstSessoes.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(lstSessoes);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 580, 340));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/fundoGigante.png"))); // NOI18N
        lblBackground.setText("jLabel1");
        add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));
    }// </editor-fold>//GEN-END:initComponents

    private void lblEventosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEventosMouseClicked

    }//GEN-LAST:event_lblEventosMouseClicked

    private void lblEventosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEventosMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblEventosMouseEntered

    private void lblEventosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEventosMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lblEventosMouseExited

    private void lblPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPerfilMouseClicked
        FrameInicio.getFrame().setContentPane(new TelaMeuPerfilAdmin(local.getAdmin()));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblPerfilMouseClicked

    private void lblPerfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPerfilMouseEntered
        acenderBotao(lblPerfil);
    }//GEN-LAST:event_lblPerfilMouseEntered

    private void lblPerfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPerfilMouseExited
        apagarBotao(lblPerfil);
    }//GEN-LAST:event_lblPerfilMouseExited

    private void lblControleOrcamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblControleOrcamentoMouseClicked
        //FrameInicio.getFrame().setContentPane(new TelaControleOrcamento(local));
        //FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblControleOrcamentoMouseClicked

    private void lblControleOrcamentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblControleOrcamentoMouseEntered
        acenderBotao(lblControleOrcamento);
    }//GEN-LAST:event_lblControleOrcamentoMouseEntered

    private void lblControleOrcamentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblControleOrcamentoMouseExited
        apagarBotao(lblControleOrcamento);
    }//GEN-LAST:event_lblControleOrcamentoMouseExited

    private void lblSessoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSessoesMouseClicked

        FrameInicio.getFrame().setContentPane(new TelaListaDeSessoes(local));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblSessoesMouseClicked

    private void lblSessoesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSessoesMouseEntered
        acenderBotao(lblSessoes);
    }//GEN-LAST:event_lblSessoesMouseEntered

    private void lblSessoesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSessoesMouseExited
        apagarBotao(lblSessoes);
    }//GEN-LAST:event_lblSessoesMouseExited

    private void lblSalasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalasMouseClicked
        FrameInicio.getFrame().setContentPane(new TelaListaDeSalas(local));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblSalasMouseClicked

    private void lblSalasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalasMouseEntered
        acenderBotao(lblSalas);
    }//GEN-LAST:event_lblSalasMouseEntered

    private void lblSalasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalasMouseExited
        apagarBotao(lblSalas);
    }//GEN-LAST:event_lblSalasMouseExited

    private void lblHomePageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomePageMouseClicked

        FrameInicio.getFrame().setContentPane(new TelaHomepageAdmin(local.getAdmin()));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblHomePageMouseClicked

    private void lblHomePageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomePageMouseEntered
        acenderBotao(lblHomePage);
    }//GEN-LAST:event_lblHomePageMouseEntered

    private void lblHomePageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomePageMouseExited
        apagarBotao(lblHomePage);
    }//GEN-LAST:event_lblHomePageMouseExited

    private void jbtAtivarEventoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAtivarEventoMouseClicked
        EventoController evtC = new EventoController();
        if (lstSessoes.getSelectedIndex() == -1) {
            JDialogsControl.mostrarPopUp("Selecione a sessão!", true);
        } else if (lstEventos.getSelectedIndex() == -1) {
            JDialogsControl.mostrarPopUp("Selecione o evento!", true);
        } else {

            Sessao selecionada = sessoesAux[lstSessoes.getSelectedIndex()];

            try {
                evtC.cadastrar(new Evento(selecionada, TipoEvento.eventoSelecionado(lstEventos.getSelectedValue())));
                JDialogsControl.mostrarPopUp("Evento Ativado!", false);
            } catch (CadastroInexistenteException | DadosRepetidosException ex) {
                JDialogsControl.mostrarPopUp(ex.getMessage(), true);
            }
        }

    }//GEN-LAST:event_jbtAtivarEventoMouseClicked

    private void jbtAtivarEventoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAtivarEventoMouseEntered
        jbtAtivarEvento.setForeground(new java.awt.Color(191, 30, 30));
    }//GEN-LAST:event_jbtAtivarEventoMouseEntered

    private void jbtAtivarEventoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAtivarEventoMouseExited
        jbtAtivarEvento.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jbtAtivarEventoMouseExited

    private void jbtDesativarEventoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDesativarEventoMouseClicked
        EventoController evtC = new EventoController();
        if (lstSessoes.getSelectedIndex() == -1) {
            JDialogsControl.mostrarPopUp("Selecione a sessão!", true);
        } else {
            Sessao selecionada = sessoesAux[lstSessoes.getSelectedIndex()];
            try {
                
                evtC.remover(new Evento(selecionada));
                JDialogsControl.mostrarPopUp("Evento Desativado!", false);
            } catch (CadastroInexistenteException ex) {
                 JDialogsControl.mostrarPopUp(ex.getMessage(), true);
            }
        }
    }//GEN-LAST:event_jbtDesativarEventoMouseClicked

    private void jbtDesativarEventoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDesativarEventoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtDesativarEventoMouseEntered

    private void jbtDesativarEventoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDesativarEventoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtDesativarEventoMouseExited

    private void lblDeslogarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeslogarMouseClicked
        TelaPopupConfirmar telaConf = JDialogsControl.mostrarConfirmacao("Deseja sair?");
        if (telaConf.getConfirmarAcao()) {
            FrameInicio.getFrame().setContentPane(new TelaInicio());
            FrameInicio.getFrame().revalidate();
        }
    }//GEN-LAST:event_lblDeslogarMouseClicked

    private void lblDeslogarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeslogarMouseEntered
        acenderBotao(lblDeslogar);
    }//GEN-LAST:event_lblDeslogarMouseEntered

    private void lblDeslogarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeslogarMouseExited
        apagarBotao(lblDeslogar);
    }//GEN-LAST:event_lblDeslogarMouseExited

    private void acenderBotao(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(204, 204, 204));
    }

    private void apagarBotao(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(255, 255, 255));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtAtivarEvento;
    private javax.swing.JButton jbtDesativarEvento;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblBordaEsquerda;
    private javax.swing.JLabel lblControleOrcamento;
    private javax.swing.JLabel lblDeslogar;
    private javax.swing.JLabel lblEscolherEvento;
    private javax.swing.JLabel lblEventos;
    private javax.swing.JLabel lblEventosDisp;
    private javax.swing.JLabel lblHomePage;
    private javax.swing.JLabel lblLinhinha;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JLabel lblSalas;
    private javax.swing.JLabel lblSessoes;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JList<String> lstEventos;
    private javax.swing.JList<String> lstSessoes;
    // End of variables declaration//GEN-END:variables
}
