package br.unicap.eticket.view.cliente;

import br.unicap.eticket.control.auxiliares.ReservaControl;
import br.unicap.eticket.control.usuarios.ClienteControl;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.model.auxiliares.Reserva;
import br.unicap.eticket.model.usuarios.Cliente;
import br.unicap.eticket.view.FrameInicio;
import br.unicap.eticket.view.TelaInicio;
import br.unicap.eticket.view.jDialogs.TelaAvaliacao;
import br.unicap.eticket.view.jDialogs.TelaPopupConfirmar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class TelaListaDeReservas extends javax.swing.JPanel {

    private Cliente cliente;
    private Long[] idReservas;

    public TelaListaDeReservas(Cliente cliente) {
        initComponents();
        this.cliente = cliente;
        initReservas(cliente);
        if (cliente.getNickName() != null) {
            this.lblUsername.setText("@" + cliente.getNickName());
        }
    }

    private void initReservas(Cliente cliente)  {
        String[] dados;
        ClienteControl clienteC = new ClienteControl();
        try {
            cliente = clienteC.buscar(cliente);
        } catch (CadastroInexistenteException ex) {
           FrameInicio.mostrarPopUp(ex.getMessage(), true);
        }
        List<Reserva> reservas = cliente.getReservas();
        dados = new String[reservas.size()];
        int i = 0;
        this.idReservas = new Long[reservas.size()];
        if (reservas != null) {
            for (Reserva r : reservas) {
                if (!r.getSessao().isAtiva() && r.isAvaliacaoDisp()) {
                    dados[i] = r.toString() + " - Avaliação Disponível!";
                } else {
                    dados[i] = r.toString();
                }
                idReservas[i] = r.getId();
                i++;
            }

            lstReservas.setModel(new javax.swing.DefaultComboBoxModel<>(dados));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jbtRemoverSala = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstReservas = new javax.swing.JList<>();
        jbtFazerAvaliacao = new javax.swing.JButton();
        lblDeslogar = new javax.swing.JLabel();
        lblMeuPerfil = new javax.swing.JLabel();
        lblMinhasReservas = new javax.swing.JLabel();
        lblHomepage = new javax.swing.JLabel();
        lblLinhinha = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblBordaEsquerda = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setBackground(new java.awt.Color(21, 17, 17));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista de Reservas");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 1070, 50));

        jbtRemoverSala.setBackground(new java.awt.Color(255, 0, 0));
        jbtRemoverSala.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jbtRemoverSala.setForeground(new java.awt.Color(255, 255, 255));
        jbtRemoverSala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/Remove.png"))); // NOI18N
        jbtRemoverSala.setBorder(null);
        jbtRemoverSala.setContentAreaFilled(false);
        jbtRemoverSala.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtRemoverSala.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtRemoverSala.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtRemoverSalaMouseClicked(evt);
            }
        });
        add(jbtRemoverSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 500, 50, 50));

        lstReservas.setBackground(new java.awt.Color(21, 17, 17));
        lstReservas.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        lstReservas.setForeground(new java.awt.Color(255, 255, 255));
        lstReservas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "SALA3D | Sala-2 | 400 Assentos | R$14.50", "BISTRÔ | Sala-2 | 400 Assentos | R$14.50", "IMAX | Sala-2 | 400 Assentos | R$14.50", "SALA3D | Sala-2 | 400 Assentos | R$14.50", "BISTRÔ | Sala-2 | 400 Assentos | R$14.50", "IMAX | Sala-2 | 400 Assentos | R$14.50", "SALA3D | Sala-2 | 400 Assentos | R$14.50", "BISTRÔ | Sala-2 | 400 Assentos | R$14.50", "IMAX | Sala-2 | 400 Assentos | R$14.50" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstReservas.setFixedCellHeight(60);
        lstReservas.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(lstReservas);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 830, 340));

        jbtFazerAvaliacao.setBackground(new java.awt.Color(51, 51, 255));
        jbtFazerAvaliacao.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jbtFazerAvaliacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoComprido (1).png"))); // NOI18N
        jbtFazerAvaliacao.setText("Fazer Avaliação");
        jbtFazerAvaliacao.setBorder(null);
        jbtFazerAvaliacao.setContentAreaFilled(false);
        jbtFazerAvaliacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtFazerAvaliacao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtFazerAvaliacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtFazerAvaliacaoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtFazerAvaliacaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtFazerAvaliacaoMouseExited(evt);
            }
        });
        add(jbtFazerAvaliacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 500, 220, 40));

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

        lblMeuPerfil.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        lblMeuPerfil.setForeground(new java.awt.Color(255, 255, 255));
        lblMeuPerfil.setText("Meu Perfil");
        lblMeuPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMeuPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMeuPerfilMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMeuPerfilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMeuPerfilMouseExited(evt);
            }
        });
        add(lblMeuPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 110, 40));

        lblMinhasReservas.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        lblMinhasReservas.setForeground(new java.awt.Color(255, 255, 255));
        lblMinhasReservas.setText("Minhas Reservas");
        lblMinhasReservas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMinhasReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinhasReservasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMinhasReservasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMinhasReservasMouseExited(evt);
            }
        });
        add(lblMinhasReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 170, 40));

        lblHomepage.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        lblHomepage.setForeground(new java.awt.Color(255, 255, 255));
        lblHomepage.setText("HomePage");
        lblHomepage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblHomepage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomepageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHomepageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHomepageMouseExited(evt);
            }
        });
        add(lblHomepage, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 110, 40));

        lblLinhinha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/linhinha.png"))); // NOI18N
        add(lblLinhinha, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 150, 360, 20));

        lblUsername.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("@Admin");
        lblUsername.setToolTipText("");
        add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 140, 40));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/logoSemNome.png"))); // NOI18N
        add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 110, 110));

        lblBordaEsquerda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/BordaEsquerda.png"))); // NOI18N
        lblBordaEsquerda.setText("jLabel3");
        add(lblBordaEsquerda, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 320, 770));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/fundoGigante.png"))); // NOI18N
        add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 0, 1360, 770));
    }// </editor-fold>//GEN-END:initComponents

    private void jbtRemoverSalaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtRemoverSalaMouseClicked
        ReservaControl reservaC = new ReservaControl();
        int valSelecionado = lstReservas.getSelectedIndex();

        if (valSelecionado != -1) {
            Long idSelecionado = this.idReservas[valSelecionado];
            Reserva reserva = reservaC.buscaPorId(idSelecionado);
            TelaPopupConfirmar telaConf = FrameInicio.mostrarConfirmacao("Confirmar Exclusão?");
            if (telaConf.getConfirmarAcao()) {
                try {
                    cliente.cancelarReserva(reserva);
                    Thread.sleep(1L);
                    FrameInicio.getFrame().setContentPane(new TelaListaDeReservas(cliente));
                    FrameInicio.getFrame().revalidate();
                } catch (CadastroInexistenteException ex) {
                    FrameInicio.mostrarPopUp(ex.getMessage(), true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TelaListaDeReservas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jbtRemoverSalaMouseClicked

    private void lblDeslogarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeslogarMouseClicked
        TelaPopupConfirmar telaConf = FrameInicio.mostrarConfirmacao("Deseja sair?");
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

    private void lblMeuPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMeuPerfilMouseClicked
        FrameInicio.getFrame().setContentPane(new TelaMeuPerfilCliente(this.cliente));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblMeuPerfilMouseClicked

    private void lblMeuPerfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMeuPerfilMouseEntered
        acenderBotao(lblMeuPerfil);
    }//GEN-LAST:event_lblMeuPerfilMouseEntered

    private void lblMeuPerfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMeuPerfilMouseExited
        apagarBotao(lblMeuPerfil);
    }//GEN-LAST:event_lblMeuPerfilMouseExited

    private void lblMinhasReservasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinhasReservasMouseClicked

        FrameInicio.getFrame().setContentPane(new TelaListaDeReservas(cliente));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblMinhasReservasMouseClicked

    private void lblMinhasReservasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinhasReservasMouseEntered
        acenderBotao(lblMinhasReservas);
    }//GEN-LAST:event_lblMinhasReservasMouseEntered

    private void lblMinhasReservasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinhasReservasMouseExited
        apagarBotao(lblMinhasReservas);
    }//GEN-LAST:event_lblMinhasReservasMouseExited

    private void lblHomepageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomepageMouseClicked
        FrameInicio.getFrame().setContentPane(new TelaHomepageCliente(cliente));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblHomepageMouseClicked

    private void lblHomepageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomepageMouseEntered
        acenderBotao(lblHomepage);
    }//GEN-LAST:event_lblHomepageMouseEntered

    private void lblHomepageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomepageMouseExited
        apagarBotao(lblHomepage);
    }//GEN-LAST:event_lblHomepageMouseExited

    private void jbtFazerAvaliacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFazerAvaliacaoMouseClicked

        if (lstReservas.getSelectedIndex() != -1 && lstReservas.getSelectedValue().contains("Avaliação Disponível")) {
            TelaAvaliacao tela = new TelaAvaliacao(idReservas[lstReservas.getSelectedIndex()], cliente);
            tela.setLocationRelativeTo(null);
            tela.setVisible(true);
        } else {
            FrameInicio.mostrarPopUp("Avaliação não disponível!", true);
        }
    }//GEN-LAST:event_jbtFazerAvaliacaoMouseClicked

    private void jbtFazerAvaliacaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFazerAvaliacaoMouseEntered

        jbtFazerAvaliacao.setForeground(new java.awt.Color(191, 30, 30));
    }//GEN-LAST:event_jbtFazerAvaliacaoMouseEntered

    private void jbtFazerAvaliacaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFazerAvaliacaoMouseExited

        jbtFazerAvaliacao.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jbtFazerAvaliacaoMouseExited

    private void acenderBotao(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(204, 204, 204));
    }

    private void apagarBotao(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(255, 255, 255));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtFazerAvaliacao;
    private javax.swing.JButton jbtRemoverSala;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblBordaEsquerda;
    private javax.swing.JLabel lblDeslogar;
    private javax.swing.JLabel lblHomepage;
    private javax.swing.JLabel lblLinhinha;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMeuPerfil;
    private javax.swing.JLabel lblMinhasReservas;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JList<String> lstReservas;
    // End of variables declaration//GEN-END:variables
}
