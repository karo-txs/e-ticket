package br.unicap.eticket.view.admin;

import br.unicap.eticket.controller.locais.LocalController;
import br.unicap.eticket.controller.usuarios.AdminController;
import br.unicap.eticket.excecoes.AtualizacaoMalSucedidaException;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.usuarios.Admin;
import br.unicap.eticket.view.FrameInicio;
import br.unicap.eticket.view.TelaInicio;
import br.unicap.eticket.view.jDialogs.JDialogsControl;
import br.unicap.eticket.view.jDialogs.TelaPopupConfirmar;
import br.unicap.eticket.viewAuxiliares.EntradaImagens;
import br.unicap.eticket.viewAuxiliares.Notas;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

public class TelaHomepageContato extends javax.swing.JPanel {
    
    private Admin adm;
    private LocalGenerico local;
    
    public TelaHomepageContato(Admin adm) {
        initComponents();
        this.adm = adm;
        this.local = adm.getLocalAdministrado();
        this.lblNomeDoLocal.setText(local.getNome());
        selecionarBotao(lblContato);
        this.initContato();
        this.initLocal();
    }
    
    private void initLocal() {
        this.lblNomeDoLocal.setText(local.getNome());
        String caminho = Notas.qualCaminho(local.getNota()).getCaminho();
        lblEstrelas.setIcon(new javax.swing.ImageIcon(getClass().getResource(caminho)));
        
        Image im = new ImageIcon(local.getBanner()).getImage();
        Icon ic = new ImageIcon(im);
        jlbBanner.setIcon(ic);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jpnEsquerda = new javax.swing.JPanel();
        lblDeslogar = new javax.swing.JLabel();
        lblPerfil = new javax.swing.JLabel();
        lblControleOrcamento = new javax.swing.JLabel();
        lblSessoes = new javax.swing.JLabel();
        lblSalas = new javax.swing.JLabel();
        lblHomePage = new javax.swing.JLabel();
        lblLinhinha = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblEventos = new javax.swing.JLabel();
        lblBordaEsquerda = new javax.swing.JLabel();
        jbtAlterarBanner = new javax.swing.JButton();
        lblEstrelas = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        fldTelefone = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        fldEmailAdm = new javax.swing.JTextField();
        fldEmailLocal = new javax.swing.JTextField();
        lblEmailEstabel = new javax.swing.JLabel();
        fldInstagram = new javax.swing.JTextField();
        fldFacebook = new javax.swing.JTextField();
        lblEmCartaz = new javax.swing.JLabel();
        lblSobre = new javax.swing.JLabel();
        lblContato = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        lblTelefone1 = new javax.swing.JLabel();
        lblNomeDoLocal = new javax.swing.JLabel();
        lblCaixaTitulo = new javax.swing.JLabel();
        lblCategoriasBar = new javax.swing.JLabel();
        jbtAlterarContato = new javax.swing.JButton();
        lblLinhaDadP = new javax.swing.JLabel();
        jlbBanner = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(14, 14, 14));
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnEsquerda.setBackground(new java.awt.Color(102, 0, 0));
        jpnEsquerda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jpnEsquerda.add(lblDeslogar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 650, 150, 40));

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
        jpnEsquerda.add(lblPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 150, 40));

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
        jpnEsquerda.add(lblControleOrcamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 230, 40));

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
        jpnEsquerda.add(lblSessoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 110, 40));

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
        jpnEsquerda.add(lblSalas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 110, 40));

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
        jpnEsquerda.add(lblHomePage, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 110, 40));

        lblLinhinha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/linhinha.png"))); // NOI18N
        jpnEsquerda.add(lblLinhinha, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 150, 360, 20));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/logoSemNome.png"))); // NOI18N
        jpnEsquerda.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 110, 110));

        lblUsername.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("@Admin");
        lblUsername.setToolTipText("");
        jpnEsquerda.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 140, 40));

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
        jpnEsquerda.add(lblEventos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 90, 40));

        lblBordaEsquerda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/BordaEsquerda.png"))); // NOI18N
        lblBordaEsquerda.setText("jLabel3");
        jpnEsquerda.add(lblBordaEsquerda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 770));

        add(jpnEsquerda, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 290, 770));

        jbtAlterarBanner.setBackground(new java.awt.Color(255, 255, 255));
        jbtAlterarBanner.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jbtAlterarBanner.setText("Alterar Banner");
        jbtAlterarBanner.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbtAlterarBanner.setContentAreaFilled(false);
        jbtAlterarBanner.setOpaque(true);
        jbtAlterarBanner.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtAlterarBannerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtAlterarBannerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtAlterarBannerMouseExited(evt);
            }
        });
        add(jbtAlterarBanner, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 160, 100, 20));

        lblEstrelas.setFont(new java.awt.Font("Segoe UI Symbol", 2, 16)); // NOI18N
        lblEstrelas.setForeground(new java.awt.Color(153, 153, 153));
        add(lblEstrelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, 170, 30));

        lblTelefone.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblTelefone.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefone.setText("Telefone");
        add(lblTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 330, -1, -1));

        fldTelefone.setBackground(new java.awt.Color(204, 204, 204));
        fldTelefone.setForeground(new java.awt.Color(102, 102, 102));
        add(fldTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 350, 160, -1));

        lblEmail.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("E-mail do Administrador");
        add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 390, -1, -1));

        fldEmailAdm.setBackground(new java.awt.Color(204, 204, 204));
        fldEmailAdm.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldEmailAdm.setForeground(new java.awt.Color(102, 102, 102));
        fldEmailAdm.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldEmailAdm, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 410, 250, 20));

        fldEmailLocal.setBackground(new java.awt.Color(204, 204, 204));
        fldEmailLocal.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldEmailLocal.setForeground(new java.awt.Color(102, 102, 102));
        fldEmailLocal.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldEmailLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 470, 250, 20));

        lblEmailEstabel.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblEmailEstabel.setForeground(new java.awt.Color(255, 255, 255));
        lblEmailEstabel.setText("E-mail do Estabelecimento");
        add(lblEmailEstabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 450, -1, -1));

        fldInstagram.setBackground(new java.awt.Color(204, 204, 204));
        fldInstagram.setForeground(new java.awt.Color(102, 102, 102));
        add(fldInstagram, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 560, 160, -1));

        fldFacebook.setBackground(new java.awt.Color(204, 204, 204));
        fldFacebook.setForeground(new java.awt.Color(102, 102, 102));
        add(fldFacebook, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 530, 160, -1));

        lblEmCartaz.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        lblEmCartaz.setForeground(new java.awt.Color(51, 102, 255));
        lblEmCartaz.setText("Em Cartaz");
        lblEmCartaz.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEmCartaz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEmCartazMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblEmCartazMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblEmCartazMouseExited(evt);
            }
        });
        add(lblEmCartaz, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, 90, 40));

        lblSobre.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        lblSobre.setForeground(new java.awt.Color(255, 255, 255));
        lblSobre.setText("Sobre");
        lblSobre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSobreMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSobreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSobreMouseExited(evt);
            }
        });
        add(lblSobre, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 200, 70, 40));

        lblContato.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        lblContato.setForeground(new java.awt.Color(255, 255, 255));
        lblContato.setText("Contato");
        lblContato.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblContato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblContatoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblContatoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblContatoMouseExited(evt);
            }
        });
        add(lblContato, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 200, 90, 40));

        lblEndereco.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        lblEndereco.setForeground(new java.awt.Color(255, 255, 255));
        lblEndereco.setText("Endereço");
        lblEndereco.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEndereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEnderecoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblEnderecoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblEnderecoMouseExited(evt);
            }
        });
        add(lblEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 200, 90, 40));

        lblTelefone1.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblTelefone1.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefone1.setText("Redes Sociais");
        add(lblTelefone1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 510, -1, -1));

        lblNomeDoLocal.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        lblNomeDoLocal.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeDoLocal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomeDoLocal.setText("Cinemark");
        add(lblNomeDoLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, 370, 40));

        lblCaixaTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaixaTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/caixaTitulo.png"))); // NOI18N
        add(lblCaixaTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 1080, 90));

        lblCategoriasBar.setBackground(new java.awt.Color(0, 0, 0));
        lblCategoriasBar.setForeground(new java.awt.Color(102, 102, 102));
        lblCategoriasBar.setOpaque(true);
        add(lblCategoriasBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 1080, 70));

        jbtAlterarContato.setBackground(new java.awt.Color(255, 255, 255));
        jbtAlterarContato.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jbtAlterarContato.setForeground(new java.awt.Color(255, 255, 255));
        jbtAlterarContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoCompridoEdicao.png"))); // NOI18N
        jbtAlterarContato.setText("Editar");
        jbtAlterarContato.setBorder(null);
        jbtAlterarContato.setContentAreaFilled(false);
        jbtAlterarContato.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtAlterarContato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtAlterarContatoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtAlterarContatoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtAlterarContatoMouseExited(evt);
            }
        });
        jbtAlterarContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAlterarContatoActionPerformed(evt);
            }
        });
        add(jbtAlterarContato, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 610, 220, 40));

        lblLinhaDadP.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contatos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Impact", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        add(lblLinhaDadP, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 290, 320, 370));

        jlbBanner.setBackground(new java.awt.Color(21, 17, 17));
        jlbBanner.setForeground(new java.awt.Color(21, 17, 17));
        jlbBanner.setOpaque(true);
        add(jlbBanner, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 1080, 170));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/fundoGigante.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));
    }// </editor-fold>//GEN-END:initComponents

    private void initContato() {
        this.trocarEditable();
        LocalController localC = new LocalController();
        LocalGenerico atual;
        try {
            atual = localC.buscarPorId(this.local.getId());
            fldTelefone.setText(atual.getTelefone());
            fldEmailLocal.setText(atual.getEmail());
            fldEmailAdm.setText(atual.getAdmin().getEmail());
            fldFacebook.setText(atual.getRedeSocial_facebook());
            fldInstagram.setText(atual.getRedeSocial_instagram());
        } catch (CadastroInexistenteException ex) {
            JDialogsControl.mostrarPopUp(ex.getMessage(), true);
        }
    }

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
        
        FrameInicio.getFrame().setContentPane(new TelaListaDeSessoes(local));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblSessoesMouseClicked

    private void lblSessoesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSessoesMouseEntered
        ascenderBotao(lblSessoes);
    }//GEN-LAST:event_lblSessoesMouseEntered

    private void lblSessoesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSessoesMouseExited
        apagarBotao(lblSessoes);
    }//GEN-LAST:event_lblSessoesMouseExited

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

    private void lblHomePageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomePageMouseClicked
        
        FrameInicio.getFrame().setContentPane(new TelaHomepageContato(local.getAdmin()));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblHomePageMouseClicked

    private void lblHomePageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomePageMouseEntered
        ascenderBotao(lblHomePage);
    }//GEN-LAST:event_lblHomePageMouseEntered

    private void lblHomePageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomePageMouseExited
        apagarBotao(lblHomePage);
    }//GEN-LAST:event_lblHomePageMouseExited

    private void jbtAlterarContatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAlterarContatoMouseClicked
        AdminController admC = new AdminController(); 
        LocalController localC = new LocalController();
        if (jbtAlterarContato.getText().equalsIgnoreCase("Salvar")) {
           
            LocalGenerico novo;
            try {
                novo = (LocalGenerico) local.clone();
                novo.setTelefone(fldTelefone.getText());
                novo.setEmail(fldEmailLocal.getText());
                novo.setRedeSocial_facebook(fldFacebook.getText());
                novo.setRedeSocial_instragam(fldInstagram.getText());
                localC.atualizar(novo);
                
                admC.atualizarChave(adm, fldEmailAdm.getText());
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(TelaHomepageContato.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CadastroInexistenteException | AtualizacaoMalSucedidaException ex) {
                JDialogsControl.mostrarPopUp(ex.getMessage(), true);
            }
            
        }
        trocarNome();
        trocarEditable();
    }//GEN-LAST:event_jbtAlterarContatoMouseClicked

    private void jbtAlterarContatoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAlterarContatoMouseEntered
         jbtAlterarContato.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_jbtAlterarContatoMouseEntered

    private void jbtAlterarContatoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAlterarContatoMouseExited
        jbtAlterarContato.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_jbtAlterarContatoMouseExited

    private void jbtAlterarContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAlterarContatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtAlterarContatoActionPerformed

    private void jbtAlterarBannerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAlterarBannerMouseClicked
        String caminho = EntradaImagens.caminhoBanner(jlbBanner, this);
        adm.getLocalAdministrado().inserirBannerESalvar(caminho);//chamar control
    }//GEN-LAST:event_jbtAlterarBannerMouseClicked

    private void jbtAlterarBannerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAlterarBannerMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtAlterarBannerMouseEntered

    private void jbtAlterarBannerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAlterarBannerMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtAlterarBannerMouseExited

    private void lblEventosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEventosMouseClicked
        FrameInicio.getFrame().setContentPane(new TelaCriarEventos(this.adm.getLocalAdministrado()));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblEventosMouseClicked

    private void lblEventosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEventosMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblEventosMouseEntered

    private void lblEventosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEventosMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lblEventosMouseExited

    private void lblEmCartazMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEmCartazMouseClicked
        selecionarBotao(lblEmCartaz);
        FrameInicio.getFrame().setContentPane(new TelaHomepageAdmin(this.adm));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblEmCartazMouseClicked

    private void lblEmCartazMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEmCartazMouseEntered

    }//GEN-LAST:event_lblEmCartazMouseEntered

    private void lblEmCartazMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEmCartazMouseExited

    }//GEN-LAST:event_lblEmCartazMouseExited

    private void lblSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSobreMouseClicked
        selecionarBotao(lblSobre);
        FrameInicio.getFrame().setContentPane(new TelaHomepageSobre(this.adm));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblSobreMouseClicked

    private void lblSobreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSobreMouseEntered

    }//GEN-LAST:event_lblSobreMouseEntered

    private void lblSobreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSobreMouseExited

    }//GEN-LAST:event_lblSobreMouseExited

    private void lblContatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblContatoMouseClicked
        selecionarBotao(lblContato);
        FrameInicio.getFrame().setContentPane(new TelaHomepageContato(this.adm));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblContatoMouseClicked

    private void lblContatoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblContatoMouseEntered

    }//GEN-LAST:event_lblContatoMouseEntered

    private void lblContatoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblContatoMouseExited

    }//GEN-LAST:event_lblContatoMouseExited

    private void lblEnderecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEnderecoMouseClicked
        selecionarBotao(lblEndereco);
        FrameInicio.getFrame().setContentPane(new TelaHomepageEndereco(this.adm));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblEnderecoMouseClicked

    private void lblEnderecoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEnderecoMouseEntered

    }//GEN-LAST:event_lblEnderecoMouseEntered

    private void lblEnderecoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEnderecoMouseExited

    }//GEN-LAST:event_lblEnderecoMouseExited
    
    private void ascenderBotao(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(204, 204, 204));
    }
    
    private void apagarBotao(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(255, 255, 255));
    }
    
    private void selecionarBotao(JLabel lbl) {
        lblEmCartaz.setForeground(new java.awt.Color(255, 255, 255));
        lblContato.setForeground(new java.awt.Color(255, 255, 255));
        lblEndereco.setForeground(new java.awt.Color(255, 255, 255));
        lblSobre.setForeground(new java.awt.Color(255, 255, 255));
        lbl.setForeground(new java.awt.Color(51, 102, 255));
    }
    
    private void trocarNome() {
        jbtAlterarContato.setText(jbtAlterarContato.getText().equalsIgnoreCase("Editar") ? "Salvar" : "Editar");
    }
    
    private void trocarEditable() {
        fldTelefone.setEditable(!fldTelefone.isEditable());
        fldEmailLocal.setEditable(!fldEmailLocal.isEditable());
        fldEmailAdm.setEditable(!fldEmailAdm.isEditable());
        fldFacebook.setEditable(!fldFacebook.isEditable());
        fldInstagram.setEditable(!fldInstagram.isEditable());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField fldEmailAdm;
    private javax.swing.JTextField fldEmailLocal;
    private javax.swing.JTextField fldFacebook;
    private javax.swing.JTextField fldInstagram;
    private javax.swing.JTextField fldTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbtAlterarBanner;
    private javax.swing.JButton jbtAlterarContato;
    private javax.swing.JLabel jlbBanner;
    private javax.swing.JPanel jpnEsquerda;
    private javax.swing.JLabel lblBordaEsquerda;
    private javax.swing.JLabel lblCaixaTitulo;
    private javax.swing.JLabel lblCategoriasBar;
    private javax.swing.JLabel lblContato;
    private javax.swing.JLabel lblControleOrcamento;
    private javax.swing.JLabel lblDeslogar;
    private javax.swing.JLabel lblEmCartaz;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmailEstabel;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEstrelas;
    private javax.swing.JLabel lblEventos;
    private javax.swing.JLabel lblHomePage;
    private javax.swing.JLabel lblLinhaDadP;
    private javax.swing.JLabel lblLinhinha;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNomeDoLocal;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JLabel lblSalas;
    private javax.swing.JLabel lblSessoes;
    private javax.swing.JLabel lblSobre;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTelefone1;
    private javax.swing.JLabel lblUsername;
    // End of variables declaration//GEN-END:variables
}
