package br.unicap.eticket.view.admin;

import br.unicap.eticket.controller.auxiliares.Formatador;
import br.unicap.eticket.controller.localAuxiliares.FachadaLocais;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.locaisAuxiliares.Sessao;
import br.unicap.eticket.view.FrameInicio;
import br.unicap.eticket.view.TelaInicio;
import br.unicap.eticket.view.jDialogs.JDialogsControl;
import br.unicap.eticket.view.jDialogs.TelaPopupConfirmar;
import javax.swing.JLabel;

public class TelaListaDeSessoes extends javax.swing.JPanel {

    private LocalGenerico local;
    private Sessao[] sessoesAux;

    public TelaListaDeSessoes(LocalGenerico local) {
        initComponents();
        this.local = local;
        initSessoes(local);
    }

    private void initSessoes(LocalGenerico local) {
        String[] dados = Formatador.formataDadosSessao(local.getSessoes());
        sessoesAux = Formatador.converterListEmArray(local.getSessoes());
        lstSessoes.setModel(new javax.swing.DefaultComboBoxModel<>(dados));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jbtAdicionarSessao = new javax.swing.JButton();
        jbtRemoverSessao = new javax.swing.JButton();
        jbtEditarSessao = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstSessoes = new javax.swing.JList<>();
        lblLogo = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblLinhinha = new javax.swing.JLabel();
        lblHomePage = new javax.swing.JLabel();
        lblSalas = new javax.swing.JLabel();
        lblSessoes = new javax.swing.JLabel();
        lblControleOrcamento = new javax.swing.JLabel();
        lblPerfil = new javax.swing.JLabel();
        lblDeslogar = new javax.swing.JLabel();
        lblEventos = new javax.swing.JLabel();
        lblBordaEsquerda = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(21, 17, 17));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista de Sessões");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 1070, 50));

        jbtAdicionarSessao.setBackground(new java.awt.Color(255, 0, 0));
        jbtAdicionarSessao.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jbtAdicionarSessao.setForeground(new java.awt.Color(255, 255, 255));
        jbtAdicionarSessao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/Adiciona.png"))); // NOI18N
        jbtAdicionarSessao.setBorder(null);
        jbtAdicionarSessao.setContentAreaFilled(false);
        jbtAdicionarSessao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtAdicionarSessao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtAdicionarSessaoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtAdicionarSessaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtAdicionarSessaoMouseExited(evt);
            }
        });
        add(jbtAdicionarSessao, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 510, 50, 50));

        jbtRemoverSessao.setBackground(new java.awt.Color(255, 0, 0));
        jbtRemoverSessao.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jbtRemoverSessao.setForeground(new java.awt.Color(255, 255, 255));
        jbtRemoverSessao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/Remove.png"))); // NOI18N
        jbtRemoverSessao.setBorder(null);
        jbtRemoverSessao.setContentAreaFilled(false);
        jbtRemoverSessao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtRemoverSessao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtRemoverSessao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtRemoverSessaoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtRemoverSessaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtRemoverSessaoMouseExited(evt);
            }
        });
        add(jbtRemoverSessao, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 510, 50, 50));

        jbtEditarSessao.setBackground(new java.awt.Color(255, 0, 0));
        jbtEditarSessao.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jbtEditarSessao.setForeground(new java.awt.Color(255, 255, 255));
        jbtEditarSessao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/Editar.png"))); // NOI18N
        jbtEditarSessao.setBorder(null);
        jbtEditarSessao.setContentAreaFilled(false);
        jbtEditarSessao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtEditarSessao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtEditarSessaoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtEditarSessaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtEditarSessaoMouseExited(evt);
            }
        });
        add(jbtEditarSessao, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 510, 50, 50));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 870, 340));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/logoSemNome.png"))); // NOI18N
        add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 110, 110));

        lblUsername.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("@Admin");
        lblUsername.setToolTipText("");
        add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 140, 40));

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

        lblBordaEsquerda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/BordaEsquerda.png"))); // NOI18N
        lblBordaEsquerda.setText("jLabel3");
        add(lblBordaEsquerda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 770));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/fundoGigante.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));
    }// </editor-fold>//GEN-END:initComponents

    private void jbtAdicionarSessaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAdicionarSessaoMouseClicked
        FrameInicio.getFrame().setContentPane(new TelaCadastrarSessao(local));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_jbtAdicionarSessaoMouseClicked

    private void jbtAdicionarSessaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAdicionarSessaoMouseEntered
        jbtAdicionarSessao.setBackground(new java.awt.Color(204, 0, 0));
        jbtAdicionarSessao.setForeground(new java.awt.Color(204, 204, 204));
    }//GEN-LAST:event_jbtAdicionarSessaoMouseEntered

    private void jbtAdicionarSessaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAdicionarSessaoMouseExited
        jbtAdicionarSessao.setBackground(new java.awt.Color(227, 0, 0));
        jbtAdicionarSessao.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jbtAdicionarSessaoMouseExited

    private void jbtRemoverSessaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtRemoverSessaoMouseClicked
        if (lstSessoes.getSelectedIndex() != -1) {
            TelaPopupConfirmar telaConf = JDialogsControl.mostrarConfirmacao("Deseja Desativar?");
            if (telaConf.getConfirmarAcao()) {
                Sessao selecionada = sessoesAux[lstSessoes.getSelectedIndex()];
                try {
                    FachadaLocais.getInstance().desativarSessao(FachadaLocais.getInstance().buscar(selecionada));
                    Thread.sleep(1L);
                    FrameInicio.getFrame().setContentPane(new TelaListaDeSessoes(local));
                    FrameInicio.getFrame().revalidate();
                } catch (CadastroInexistenteException | InterruptedException ex) {
                    JDialogsControl.mostrarPopUp(ex.getMessage(), true);
                }
            }
        }
    }//GEN-LAST:event_jbtRemoverSessaoMouseClicked

    private void jbtRemoverSessaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtRemoverSessaoMouseEntered
        jbtAdicionarSessao.setBackground(new java.awt.Color(204, 0, 0));
        jbtAdicionarSessao.setForeground(new java.awt.Color(204, 204, 204));
    }//GEN-LAST:event_jbtRemoverSessaoMouseEntered

    private void jbtRemoverSessaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtRemoverSessaoMouseExited
        jbtAdicionarSessao.setBackground(new java.awt.Color(227, 0, 0));
        jbtAdicionarSessao.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jbtRemoverSessaoMouseExited

    private void jbtEditarSessaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtEditarSessaoMouseClicked
        if (lstSessoes.getSelectedIndex() != -1) {
            Sessao selecionada = sessoesAux[lstSessoes.getSelectedIndex()];
            FrameInicio.getFrame().setContentPane(new TelaEditarSessao(local, selecionada));
            FrameInicio.getFrame().revalidate();
        }
    }//GEN-LAST:event_jbtEditarSessaoMouseClicked

    private void jbtEditarSessaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtEditarSessaoMouseEntered
        jbtAdicionarSessao.setBackground(new java.awt.Color(204, 0, 0));
        jbtAdicionarSessao.setForeground(new java.awt.Color(204, 204, 204));
    }//GEN-LAST:event_jbtEditarSessaoMouseEntered

    private void jbtEditarSessaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtEditarSessaoMouseExited
        jbtAdicionarSessao.setBackground(new java.awt.Color(227, 0, 0));
        jbtAdicionarSessao.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jbtEditarSessaoMouseExited

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
        TelaPopupConfirmar telaConf = JDialogsControl.mostrarConfirmacao("Deseja sair?");
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

    private void lblEventosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEventosMouseClicked
        FrameInicio.getFrame().setContentPane(new TelaCriarEventos(this.local));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblEventosMouseClicked

    private void lblEventosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEventosMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblEventosMouseEntered

    private void lblEventosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEventosMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lblEventosMouseExited

    private void ascenderBotao(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(204, 204, 204));
    }

    private void apagarBotao(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(255, 255, 255));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtAdicionarSessao;
    private javax.swing.JButton jbtEditarSessao;
    private javax.swing.JButton jbtRemoverSessao;
    private javax.swing.JLabel lblBordaEsquerda;
    private javax.swing.JLabel lblControleOrcamento;
    private javax.swing.JLabel lblDeslogar;
    private javax.swing.JLabel lblEventos;
    private javax.swing.JLabel lblHomePage;
    private javax.swing.JLabel lblLinhinha;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JLabel lblSalas;
    private javax.swing.JLabel lblSessoes;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JList<String> lstSessoes;
    // End of variables declaration//GEN-END:variables
}
