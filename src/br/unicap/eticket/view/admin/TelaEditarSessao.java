package br.unicap.eticket.view.admin;

import br.unicap.eticket.control.auxiliares.EntretenimentoControl;
import br.unicap.eticket.control.auxiliares.SessaoControl;
import br.unicap.eticket.excecoes.AtualizacaoMalSucedidaException;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.model.locais.Cinema;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.locaisAuxiliares.Entretenimento;
import br.unicap.eticket.model.locaisAuxiliares.Sala;
import br.unicap.eticket.model.locaisAuxiliares.Sessao;
import br.unicap.eticket.view.FrameInicio;
import br.unicap.eticket.view.TelaInicio;
import br.unicap.eticket.view.jDialogs.JDialogsControl;
import br.unicap.eticket.view.jDialogs.TelaPopupConfirmar;
import java.util.Calendar;
import java.util.List;
import javax.swing.JLabel;

public class TelaEditarSessao extends javax.swing.JPanel {

    private LocalGenerico local;
    private Sessao sessao;
    private Sessao busca;

    public TelaEditarSessao(LocalGenerico local, Sessao sessao) {
        initComponents();
        this.local = local;
        //this.nomeSessao = nomeSessao;
        this.sessao = sessao;
        initEntretenimentos();
        initSalas();
        this.initSessao();
    }

    private void initEntretenimentos() {
        String[] ents = null;
        EntretenimentoControl entC = new EntretenimentoControl();
        List<Entretenimento> entreterimentos;
        if (local instanceof Cinema) {
            entreterimentos = entC.todosFilmes();
        } else {
            entreterimentos = entC.todasPecas();
        }
        int tam = entreterimentos.size();

        ents = new String[tam];
        for (int i = 0; i < tam; i++) {
            ents[i] = entreterimentos.get(i).getNome();
        }

        jcbEntretenimento.setModel(new javax.swing.DefaultComboBoxModel<>(ents));
    }

    private void initSalas() {

        List<Sala> s = local.getSalas();
        String[] salas = new String[s.size()];
        int i = 0;
        for (Sala a : s) {
            salas[i] = a.getNome();
            i++;
        }
        jcbSalas.setModel(new javax.swing.DefaultComboBoxModel<>(salas));
    }

    private void initSessao() {
        SessaoControl sessaoC = new SessaoControl();
        //Sessao sala = new Sessao(local,nomeSessao);
        try {
            busca = sessaoC.buscar(sessao);
            fldNome.setText(busca.getNome());
            Calendar data = busca.getDataInicial();
            jcbDia.setSelectedItem(String.valueOf(data.get(Calendar.DAY_OF_MONTH)));
            jcbMes.setSelectedIndex(data.get(Calendar.MONTH)+ 1);
            jcbAno.setSelectedItem(String.valueOf(data.get(Calendar.YEAR)));
            jfldHora.setText(String.valueOf(data.get(Calendar.HOUR_OF_DAY)));
            jfldMinutos.setText(String.valueOf(data.get(Calendar.MINUTE)));

            jcbSalas.setSelectedItem(busca.getSala().getNome());
            jcbEntretenimento.setSelectedItem(busca.getEntretenimento().getNome());

        } catch (CadastroInexistenteException ex) {
            JDialogsControl.mostrarPopUp(ex.getMessage(), true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCadastrarSala = new javax.swing.JLabel();
        lblNomeSala = new javax.swing.JLabel();
        lblQtdCadx = new javax.swing.JLabel();
        jcbSalas = new javax.swing.JComboBox<String>();
        lblTipoSala = new javax.swing.JLabel();
        jcbDia = new javax.swing.JComboBox<String>();
        jcbMes = new javax.swing.JComboBox<String>();
        jcbAno = new javax.swing.JComboBox<String>();
        jfldHora = new javax.swing.JFormattedTextField();
        jfldMinutos = new javax.swing.JFormattedTextField();
        lblHora = new javax.swing.JLabel();
        lblHora1 = new javax.swing.JLabel();
        jcbEntretenimento = new javax.swing.JComboBox<String>();
        jbtEditarSessao = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblDeslogar = new javax.swing.JLabel();
        fldNome = new javax.swing.JTextField();
        lblLinhinha = new javax.swing.JLabel();
        lblHomePage = new javax.swing.JLabel();
        lblSalas = new javax.swing.JLabel();
        lblSessoes = new javax.swing.JLabel();
        lblControleOrcamento = new javax.swing.JLabel();
        lblPerfil = new javax.swing.JLabel();
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
        lblCadastrarSala.setText("Editar Sessão ");
        add(lblCadastrarSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 360, 50));

        lblNomeSala.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblNomeSala.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeSala.setText("Entretenimento");
        add(lblNomeSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 190, 130, 30));

        lblQtdCadx.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblQtdCadx.setForeground(new java.awt.Color(255, 255, 255));
        lblQtdCadx.setText("Data Inicial");
        add(lblQtdCadx, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, 100, 30));

        jcbSalas.setBackground(new java.awt.Color(204, 204, 204));
        jcbSalas.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        jcbSalas.setForeground(new java.awt.Color(102, 102, 102));
        jcbSalas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Selecione -" }));
        add(jcbSalas, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 490, 360, 40));

        lblTipoSala.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblTipoSala.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoSala.setText("Salas");
        add(lblTipoSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 450, 60, 30));

        jcbDia.setBackground(new java.awt.Color(204, 204, 204));
        jcbDia.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jcbDia.setForeground(new java.awt.Color(102, 102, 102));
        jcbDia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-     Dia    -", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        add(jcbDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 360, 120, 40));

        jcbMes.setBackground(new java.awt.Color(204, 204, 204));
        jcbMes.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jcbMes.setForeground(new java.awt.Color(102, 102, 102));
        jcbMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-    Mês   -", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        add(jcbMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 360, 120, 40));

        jcbAno.setBackground(new java.awt.Color(204, 204, 204));
        jcbAno.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jcbAno.setForeground(new java.awt.Color(102, 102, 102));
        jcbAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-    Ano   -", "2020", "2021", "2022" }));
        add(jcbAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 360, 120, 40));

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
        add(jfldHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 360, 350, -1));

        jfldMinutos.setBackground(new java.awt.Color(204, 204, 204));
        jfldMinutos.setForeground(new java.awt.Color(102, 102, 102));
        try {
            jfldMinutos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jfldMinutos.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        add(jfldMinutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 490, 350, -1));

        lblHora.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblHora.setForeground(new java.awt.Color(255, 255, 255));
        lblHora.setText("Hora");
        add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 320, 100, 30));

        lblHora1.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblHora1.setForeground(new java.awt.Color(255, 255, 255));
        lblHora1.setText("Minutos");
        add(lblHora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 450, 100, 30));

        jcbEntretenimento.setBackground(new java.awt.Color(204, 204, 204));
        jcbEntretenimento.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        jcbEntretenimento.setForeground(new java.awt.Color(102, 102, 102));
        jcbEntretenimento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Selecione -" }));
        add(jcbEntretenimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 230, 360, 40));

        jbtEditarSessao.setBackground(new java.awt.Color(227, 0, 0));
        jbtEditarSessao.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jbtEditarSessao.setForeground(new java.awt.Color(255, 255, 255));
        jbtEditarSessao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoCompridoEdicao.png"))); // NOI18N
        jbtEditarSessao.setText("<html><center>Editar");
        jbtEditarSessao.setBorder(null);
        jbtEditarSessao.setContentAreaFilled(false);
        jbtEditarSessao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtEditarSessao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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
        add(jbtEditarSessao, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 600, 230, 40));

        lblUsername.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("@Admin");
        lblUsername.setToolTipText("");
        add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 140, 40));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/logoSemNome.png"))); // NOI18N
        add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 110, 110));

        lblNome.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("Nome");
        add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 50, 20));

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
        add(fldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 360, 40));

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

    private void jbtEditarSessaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtEditarSessaoMouseClicked
        SessaoControl sessaoC = new SessaoControl();
        Calendar dataInicial = Calendar.getInstance();

        dataInicial.set(Calendar.YEAR, Integer.parseInt(String.valueOf(jcbAno.getSelectedItem())));
        dataInicial.set(Calendar.MONTH, Integer.parseInt(String.valueOf(jcbMes.getSelectedIndex() - 1)));
        dataInicial.set(Calendar.DAY_OF_MONTH, Integer.parseInt(String.valueOf(jcbDia.getSelectedIndex())));
        dataInicial.set(Calendar.HOUR_OF_DAY, Integer.parseInt(jfldHora.getText()));
        dataInicial.set(Calendar.MINUTE, Integer.parseInt(jfldMinutos.getText()));
        dataInicial.set(Calendar.SECOND, 0);

        String nomeEnt = String.valueOf(jcbEntretenimento.getSelectedItem());
        EntretenimentoControl entC = new EntretenimentoControl();

        try {
            Entretenimento ent = entC.buscar(nomeEnt);
            Sessao sessao = new Sessao(this.local, new Sala(this.local, String.valueOf(jcbSalas.getSelectedItem())), this.sessao.getNome(),
                    dataInicial, ent);
            sessaoC.atualizar(sessao);

            busca.atualizarNome(fldNome.getText());

            FrameInicio.getFrame().setContentPane(new TelaListaDeSessoes(local));
            FrameInicio.getFrame().revalidate();
        } catch (CadastroInexistenteException | AtualizacaoMalSucedidaException ex) {
            JDialogsControl.mostrarPopUp(ex.getMessage(), true);
        }
    }//GEN-LAST:event_jbtEditarSessaoMouseClicked

    private void jbtEditarSessaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtEditarSessaoMouseEntered
        jbtEditarSessao.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jbtEditarSessaoMouseEntered

    private void jbtEditarSessaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtEditarSessaoMouseExited
        jbtEditarSessao.setForeground(new java.awt.Color(255, 255, 255));
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

    private void ascenderBotao(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(204, 204, 204));
    }

    private void apagarBotao(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(255, 255, 255));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fldNome;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbtEditarSessao;
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
    private javax.swing.JLabel lblHomePage;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblHora1;
    private javax.swing.JLabel lblLinhinha;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeSala;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JLabel lblQtdCadx;
    private javax.swing.JLabel lblSalas;
    private javax.swing.JLabel lblSessoes;
    private javax.swing.JLabel lblTipoSala;
    private javax.swing.JLabel lblUsername;
    // End of variables declaration//GEN-END:variables
}
