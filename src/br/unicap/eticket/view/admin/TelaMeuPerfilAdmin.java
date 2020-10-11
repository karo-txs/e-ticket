package br.unicap.eticket.view.admin;

import br.unicap.eticket.control.usuarios.AdminControl;
import br.unicap.eticket.excecoes.AtualizacaoMalSucedidaException;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosInvalidosException;
import br.unicap.eticket.model.usuarios.Admin;
import br.unicap.eticket.view.FrameInicio;
import br.unicap.eticket.view.TelaInicio;
import br.unicap.eticket.view.jDialogs.TelaPopupConfirmar;
import java.awt.Color;
import javax.swing.JLabel;

public class TelaMeuPerfilAdmin extends javax.swing.JPanel {

    private Admin adm;

    public TelaMeuPerfilAdmin(Admin adm) {
        initComponents();
        this.adm = adm;
        this.initDados(adm);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRealizarCad = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblIdade = new javax.swing.JLabel();
        fldNome = new javax.swing.JTextField();
        fldSenhaAntiga = new javax.swing.JPasswordField();
        fldSenhaNova = new javax.swing.JPasswordField();
        fldCPF = new javax.swing.JFormattedTextField();
        lblCPF = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        lblSenhaConf = new javax.swing.JLabel();
        fldEmail = new javax.swing.JTextField();
        lblLinhaAltSenha = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        fldIdade = new javax.swing.JTextField();
        jfldTelefone = new javax.swing.JTextField();
        lblLinhaDadP = new javax.swing.JLabel();
        lblPerfil = new javax.swing.JLabel();
        lblControleOrcamento = new javax.swing.JLabel();
        lblSessoes = new javax.swing.JLabel();
        lblSalas = new javax.swing.JLabel();
        lblHomePage = new javax.swing.JLabel();
        lblLinhinha = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblDeslogar = new javax.swing.JLabel();
        jbtEditar = new javax.swing.JButton();
        lblBordaEsquerda = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(21, 17, 17));
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRealizarCad.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        lblRealizarCad.setForeground(new java.awt.Color(255, 255, 255));
        lblRealizarCad.setText("Atualizar Cadastro");
        add(lblRealizarCad, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, 370, 70));

        lblNome.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("nome completo");
        add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 190, -1, -1));

        lblEmail.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("e-mail");
        add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 400, -1, -1));

        lblIdade.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblIdade.setForeground(new java.awt.Color(255, 255, 255));
        lblIdade.setText("idade");
        add(lblIdade, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 260, -1, -1));

        fldNome.setBackground(new java.awt.Color(204, 204, 204));
        fldNome.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldNome.setForeground(new java.awt.Color(102, 102, 102));
        fldNome.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 210, 250, 20));

        fldSenhaAntiga.setBackground(new java.awt.Color(204, 204, 204));
        fldSenhaAntiga.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldSenhaAntiga.setForeground(new java.awt.Color(102, 102, 102));
        add(fldSenhaAntiga, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 540, 250, 20));

        fldSenhaNova.setBackground(new java.awt.Color(204, 204, 204));
        fldSenhaNova.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldSenhaNova.setForeground(new java.awt.Color(102, 102, 102));
        add(fldSenhaNova, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 590, 250, 20));

        fldCPF.setBackground(new java.awt.Color(204, 204, 204));
        fldCPF.setForeground(new java.awt.Color(102, 102, 102));
        try {
            fldCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fldCPF.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        add(fldCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 350, 250, 20));

        lblCPF.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblCPF.setForeground(new java.awt.Color(255, 255, 255));
        lblCPF.setText("CPF");
        add(lblCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 330, -1, -1));

        lblSenha.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(255, 255, 255));
        lblSenha.setText("senha antiga");
        add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 520, 90, -1));

        lblSenhaConf.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblSenhaConf.setForeground(new java.awt.Color(255, 255, 255));
        lblSenhaConf.setText("nova senha");
        add(lblSenhaConf, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 570, -1, -1));

        fldEmail.setBackground(new java.awt.Color(204, 204, 204));
        fldEmail.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldEmail.setForeground(new java.awt.Color(102, 102, 102));
        fldEmail.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 420, 250, 20));

        lblLinhaAltSenha.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alterar senha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Impact", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        add(lblLinhaAltSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 480, 310, 150));

        lblTelefone.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblTelefone.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefone.setText("telefone");
        add(lblTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 260, -1, -1));

        fldIdade.setBackground(new java.awt.Color(204, 204, 204));
        fldIdade.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldIdade.setForeground(new java.awt.Color(102, 102, 102));
        fldIdade.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldIdade, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 280, 50, 20));

        jfldTelefone.setBackground(new java.awt.Color(204, 204, 204));
        jfldTelefone.setForeground(new java.awt.Color(102, 102, 102));
        add(jfldTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 280, 160, -1));

        lblLinhaDadP.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados pessoais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Impact", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        add(lblLinhaDadP, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 150, 310, 310));

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

        lblUsername.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("@Admin");
        lblUsername.setToolTipText("");
        add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 140, 40));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/logoSemNome.png"))); // NOI18N
        add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 110, 110));

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

        jbtEditar.setBackground(new java.awt.Color(255, 255, 255));
        jbtEditar.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jbtEditar.setForeground(new java.awt.Color(255, 255, 255));
        jbtEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoCompridoEdicao.png"))); // NOI18N
        jbtEditar.setText("Editar");
        jbtEditar.setBorder(null);
        jbtEditar.setContentAreaFilled(false);
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
        jbtEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtEditarActionPerformed(evt);
            }
        });
        add(jbtEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 650, 190, 40));

        lblBordaEsquerda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/BordaEsquerda.png"))); // NOI18N
        lblBordaEsquerda.setText("jLabel3");
        add(lblBordaEsquerda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 770));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/fundoGigante.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));
    }// </editor-fold>//GEN-END:initComponents

    private void initDados(Admin adm) {
        fldNome.setText(adm.getNome());
        fldIdade.setText(String.valueOf(adm.getIdade()));
        fldCPF.setText(adm.getCpf());
        fldEmail.setText(adm.getEmail());
        jfldTelefone.setText(adm.getTelefone());
        this.trocarEditable();
    }

    private void lblPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPerfilMouseClicked
        FrameInicio.getFrame().setContentPane(new TelaMeuPerfilAdmin(adm));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblPerfilMouseClicked

    private void lblPerfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPerfilMouseEntered
        ascenderBotao(lblPerfil);
    }//GEN-LAST:event_lblPerfilMouseEntered

    private void lblPerfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPerfilMouseExited
        apagarBotao(lblPerfil);
    }//GEN-LAST:event_lblPerfilMouseExited

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

    private void lblSessoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSessoesMouseClicked

        FrameInicio.getFrame().setContentPane(new TelaListaDeSessoes(adm.getLocalAdministrado()));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblSessoesMouseClicked

    private void lblSessoesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSessoesMouseEntered
        ascenderBotao(lblSessoes);
    }//GEN-LAST:event_lblSessoesMouseEntered

    private void lblSessoesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSessoesMouseExited
        apagarBotao(lblSessoes);
    }//GEN-LAST:event_lblSessoesMouseExited

    private void lblSalasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalasMouseClicked

        FrameInicio.getFrame().setContentPane(new TelaListaDeSalas(adm.getLocalAdministrado()));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblSalasMouseClicked

    private void lblSalasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalasMouseEntered
        ascenderBotao(lblSalas);
    }//GEN-LAST:event_lblSalasMouseEntered

    private void lblSalasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalasMouseExited
        apagarBotao(lblSalas);
    }//GEN-LAST:event_lblSalasMouseExited

    private void lblHomePageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomePageMouseClicked

        FrameInicio.getFrame().setContentPane(new TelaHomepageAdmin(adm));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblHomePageMouseClicked

    private void lblHomePageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomePageMouseEntered
        ascenderBotao(lblHomePage);
    }//GEN-LAST:event_lblHomePageMouseEntered

    private void lblHomePageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomePageMouseExited
        apagarBotao(lblHomePage);
    }//GEN-LAST:event_lblHomePageMouseExited

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

    private void jbtEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtEditarMouseClicked

        if (jbtEditar.getText().equalsIgnoreCase("Salvar")) {
            AdminControl cc = new AdminControl();
            //tirar mascara de cpf 

            Admin novo = new Admin(fldNome.getText(), fldEmail.getText(), adm.getSenha(), Integer.parseInt(fldIdade.getText()),
                    fldCPF.getText(), jfldTelefone.getText(), this.adm.getLocalAdministrado());

            try {
                if (fldEmail.getText() != null && !fldEmail.getText().equalsIgnoreCase(adm.getEmail())) {
                    adm.atualizarEmail(fldEmail.getText());
                }
                cc.atualizar(novo); //retornar obj
                FrameInicio.mostrarPopUp("Atualizado Com Sucesso!",false);
                this.adm = cc.buscar(adm);
            } catch (CadastroInexistenteException | AtualizacaoMalSucedidaException | DadosInvalidosException ex) {
                FrameInicio.mostrarPopUp(ex.getMessage(),true);
            }
        }
        trocarNome();
        trocarEditable();
    }//GEN-LAST:event_jbtEditarMouseClicked

    private void jbtEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtEditarMouseEntered
       jbtEditar.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_jbtEditarMouseEntered

    private void jbtEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtEditarMouseExited
        jbtEditar.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_jbtEditarMouseExited

    private void jbtEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtEditarActionPerformed

    private void ascenderBotao(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(204, 204, 204));
    }

    private void apagarBotao(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(255, 255, 255));
    }

    private void trocarNome() {
        jbtEditar.setText(jbtEditar.getText().equalsIgnoreCase("Editar") ? "Salvar" : "Editar");
    }

    private void trocarEditable() {
       fldNome.setEditable(!fldNome.isEditable());
        fldIdade.setEditable(!fldIdade.isEditable());
        fldCPF.setEditable(!fldCPF.isEditable());
        fldEmail.setEditable(!fldEmail.isEditable());
        jfldTelefone.setEditable(!jfldTelefone.isEditable());
        fldSenhaAntiga.setEditable(!fldSenhaAntiga.isEditable());
        fldSenhaNova.setEditable(!fldSenhaNova.isEditable());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField fldCPF;
    private javax.swing.JTextField fldEmail;
    private javax.swing.JTextField fldIdade;
    private javax.swing.JTextField fldNome;
    private javax.swing.JPasswordField fldSenhaAntiga;
    private javax.swing.JPasswordField fldSenhaNova;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbtEditar;
    private javax.swing.JTextField jfldTelefone;
    private javax.swing.JLabel lblBordaEsquerda;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblControleOrcamento;
    private javax.swing.JLabel lblDeslogar;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblHomePage;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblLinhaAltSenha;
    private javax.swing.JLabel lblLinhaDadP;
    private javax.swing.JLabel lblLinhinha;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JLabel lblRealizarCad;
    private javax.swing.JLabel lblSalas;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSenhaConf;
    private javax.swing.JLabel lblSessoes;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblUsername;
    // End of variables declaration//GEN-END:variables

}
