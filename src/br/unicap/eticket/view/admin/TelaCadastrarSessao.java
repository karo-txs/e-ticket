package br.unicap.eticket.view.admin;

import br.unicap.eticket.controller.localAuxiliares.EntretenimentoController;
import br.unicap.eticket.controller.localAuxiliares.SalaController;
import br.unicap.eticket.controller.localAuxiliares.SessaoController;
import br.unicap.eticket.controller.auxiliares.Conversor;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosRepetidosException;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.locais.Auditorio;
import br.unicap.eticket.model.locaisAuxiliares.Sala;
import br.unicap.eticket.view.FrameInicio;
import br.unicap.eticket.view.TelaInicio;
import br.unicap.eticket.view.jDialogs.JDialogsControl;
import br.unicap.eticket.view.jDialogs.TelaPopupCadPalestra;
import br.unicap.eticket.view.jDialogs.TelaPopupConfirmar;
import java.util.Calendar;
import javax.swing.JLabel;

public class TelaCadastrarSessao extends javax.swing.JPanel {

    private LocalGenerico local;

    public TelaCadastrarSessao(LocalGenerico local) {
        initComponents();
        this.local = local;
        initEntretenimentos();
        initSalas();
    }

    private void initEntretenimentos() {
        EntretenimentoController entC = new EntretenimentoController();

        if (local instanceof Auditorio) {
            jbtCadPalestra.setVisible(true);
        } else {
            jbtCadPalestra.setVisible(false);
        }
        jcbEntretenimento.setModel(new javax.swing.DefaultComboBoxModel<>(entC.todosEntretenimentosDoLocal(local)));
    }

    private void initSalas() {
        SalaController salaC = new SalaController();
        jcbSalas.setModel(new javax.swing.DefaultComboBoxModel<>(salaC.salasDoLocal(local,false)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCadastrarSala = new javax.swing.JLabel();
        lblNomeSala = new javax.swing.JLabel();
        lblQtdCadx = new javax.swing.JLabel();
        fldNomeSessao = new javax.swing.JTextField();
        lblQtdCady = new javax.swing.JLabel();
        jcbSalas = new javax.swing.JComboBox<>();
        lblTipoSala = new javax.swing.JLabel();
        jcbDia = new javax.swing.JComboBox<>();
        jcbMes = new javax.swing.JComboBox<>();
        jcbAno = new javax.swing.JComboBox<>();
        jfldHora = new javax.swing.JFormattedTextField();
        jfldMinutos = new javax.swing.JFormattedTextField();
        lblHora = new javax.swing.JLabel();
        lblHora1 = new javax.swing.JLabel();
        jbtCadPalestra = new javax.swing.JButton();
        jcbEntretenimento = new javax.swing.JComboBox<>();
        jbtCadastrarSessao = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
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
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCadastrarSala.setFont(new java.awt.Font("Impact", 0, 38)); // NOI18N
        lblCadastrarSala.setForeground(new java.awt.Color(255, 255, 255));
        lblCadastrarSala.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCadastrarSala.setText("Cadastrar Sessão");
        add(lblCadastrarSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 360, 50));

        lblNomeSala.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblNomeSala.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeSala.setText("Entretenimento");
        add(lblNomeSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 130, 30));

        lblQtdCadx.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblQtdCadx.setForeground(new java.awt.Color(255, 255, 255));
        lblQtdCadx.setText("Data Inicial");
        add(lblQtdCadx, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, 100, 30));

        fldNomeSessao.setBackground(new java.awt.Color(204, 204, 204));
        fldNomeSessao.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        fldNomeSessao.setForeground(new java.awt.Color(102, 102, 102));
        fldNomeSessao.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldNomeSessao, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 230, 350, 40));

        lblQtdCady.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblQtdCady.setForeground(new java.awt.Color(255, 255, 255));
        lblQtdCady.setText("Nome");
        add(lblQtdCady, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 190, 50, 30));

        jcbSalas.setBackground(new java.awt.Color(204, 204, 204));
        jcbSalas.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        jcbSalas.setForeground(new java.awt.Color(102, 102, 102));
        jcbSalas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Selecione -" }));
        add(jcbSalas, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 490, 360, 40));

        lblTipoSala.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblTipoSala.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoSala.setText("Salas");
        add(lblTipoSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 450, 60, 30));

        jcbDia.setBackground(new java.awt.Color(204, 204, 204));
        jcbDia.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jcbDia.setForeground(new java.awt.Color(102, 102, 102));
        jcbDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-     Dia    -", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        add(jcbDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, 120, 40));

        jcbMes.setBackground(new java.awt.Color(204, 204, 204));
        jcbMes.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jcbMes.setForeground(new java.awt.Color(102, 102, 102));
        jcbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-    Mês   -", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        add(jcbMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 360, 120, 40));

        jcbAno.setBackground(new java.awt.Color(204, 204, 204));
        jcbAno.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jcbAno.setForeground(new java.awt.Color(102, 102, 102));
        jcbAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-    Ano   -", "2020", "2021", "2022" }));
        add(jcbAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 360, 120, 40));

        jfldHora.setBackground(new java.awt.Color(204, 204, 204));
        jfldHora.setForeground(new java.awt.Color(102, 102, 102));
        try {
            jfldHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jfldHora.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        jfldHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jfldHoraActionPerformed(evt);
            }
        });
        add(jfldHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 360, 350, -1));

        jfldMinutos.setBackground(new java.awt.Color(204, 204, 204));
        jfldMinutos.setForeground(new java.awt.Color(102, 102, 102));
        try {
            jfldMinutos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jfldMinutos.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        add(jfldMinutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 490, 350, -1));

        lblHora.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblHora.setForeground(new java.awt.Color(255, 255, 255));
        lblHora.setText("Hora");
        add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 320, 100, 30));

        lblHora1.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblHora1.setForeground(new java.awt.Color(255, 255, 255));
        lblHora1.setText("Minutos");
        add(lblHora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 450, 100, 30));

        jbtCadPalestra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/Adiciona.png"))); // NOI18N
        jbtCadPalestra.setBorder(null);
        jbtCadPalestra.setContentAreaFilled(false);
        jbtCadPalestra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtCadPalestraMouseClicked(evt);
            }
        });
        add(jbtCadPalestra, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 270, 50, 50));

        jcbEntretenimento.setBackground(new java.awt.Color(204, 204, 204));
        jcbEntretenimento.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        jcbEntretenimento.setForeground(new java.awt.Color(102, 102, 102));
        jcbEntretenimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Selecione -" }));
        add(jcbEntretenimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 360, 40));

        jbtCadastrarSessao.setBackground(new java.awt.Color(227, 0, 0));
        jbtCadastrarSessao.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jbtCadastrarSessao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoComprido2 (1)_1.png"))); // NOI18N
        jbtCadastrarSessao.setText("<html><center>Cadastrar Sessão");
        jbtCadastrarSessao.setBorder(null);
        jbtCadastrarSessao.setContentAreaFilled(false);
        jbtCadastrarSessao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtCadastrarSessao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtCadastrarSessao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtCadastrarSessaoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtCadastrarSessaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtCadastrarSessaoMouseExited(evt);
            }
        });
        add(jbtCadastrarSessao, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 590, 260, 70));

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

    private void jfldHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jfldHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jfldHoraActionPerformed

    private void jbtCadastrarSessaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtCadastrarSessaoMouseClicked
        EntretenimentoController entC = new EntretenimentoController();
        SessaoController sessaoC = new SessaoController();

        if (jcbDia.getSelectedIndex() == 0 || jcbMes.getSelectedIndex() == 0 || jcbAno.getSelectedIndex() == 0) {
            JDialogsControl.mostrarPopUp("Data inicial inválida!", true);
        } else {
            Calendar dataInicial
                    = Conversor.converterParaData(Integer.parseInt(String.valueOf(jcbAno.getSelectedItem())),
                            jcbMes.getSelectedIndex(),
                            jcbDia.getSelectedIndex(),
                            Integer.parseInt(jfldHora.getText()),
                            Integer.parseInt(jfldMinutos.getText()));

            try {
                sessaoC.cadastrar(this.local, new Sala(this.local, String.valueOf(jcbSalas.getSelectedItem())), fldNomeSessao.getText(),
                        dataInicial, entC.buscar(String.valueOf(jcbEntretenimento.getSelectedItem())));
            } catch (DadosRepetidosException | CadastroInexistenteException ex) {
                JDialogsControl.mostrarPopUp(ex.getMessage(), true);
            }

            FrameInicio.getFrame().setContentPane(new TelaListaDeSessoes(local));
            FrameInicio.getFrame().revalidate();

        }
    }//GEN-LAST:event_jbtCadastrarSessaoMouseClicked

    private void jbtCadastrarSessaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtCadastrarSessaoMouseEntered
        jbtCadastrarSessao.setForeground(new java.awt.Color(191, 30, 30));
    }//GEN-LAST:event_jbtCadastrarSessaoMouseEntered

    private void jbtCadastrarSessaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtCadastrarSessaoMouseExited
        jbtCadastrarSessao.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jbtCadastrarSessaoMouseExited

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

    private void jbtCadPalestraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtCadPalestraMouseClicked
        TelaPopupCadPalestra telaConf = new TelaPopupCadPalestra(this.local);
        telaConf.setLocationRelativeTo(null);
        telaConf.setVisible(true);
        this.initEntretenimentos();
    }//GEN-LAST:event_jbtCadPalestraMouseClicked

    private void ascenderBotao(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(204, 204, 204));
    }

    private void apagarBotao(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(255, 255, 255));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fldNomeSessao;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbtCadPalestra;
    private javax.swing.JButton jbtCadastrarSessao;
    private javax.swing.JComboBox<String> jcbAno;
    private javax.swing.JComboBox<String> jcbDia;
    private javax.swing.JComboBox<String> jcbEntretenimento;
    private javax.swing.JComboBox<String> jcbMes;
    private javax.swing.JComboBox<String> jcbSalas;
    private javax.swing.JFormattedTextField jfldHora;
    private javax.swing.JFormattedTextField jfldMinutos;
    private javax.swing.JLabel lblBordaEsquerda;
    private javax.swing.JLabel lblCadastrarSala;
    private javax.swing.JLabel lblControleOrcamento;
    private javax.swing.JLabel lblDeslogar;
    private javax.swing.JLabel lblEventos;
    private javax.swing.JLabel lblHomePage;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblHora1;
    private javax.swing.JLabel lblLinhinha;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNomeSala;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JLabel lblQtdCadx;
    private javax.swing.JLabel lblQtdCady;
    private javax.swing.JLabel lblSalas;
    private javax.swing.JLabel lblSessoes;
    private javax.swing.JLabel lblTipoSala;
    private javax.swing.JLabel lblUsername;
    // End of variables declaration//GEN-END:variables
}
