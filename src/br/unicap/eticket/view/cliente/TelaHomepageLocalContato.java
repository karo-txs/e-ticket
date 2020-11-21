package br.unicap.eticket.view.cliente;

import br.unicap.eticket.controller.usuarios.FachadaUsuarios;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.usuarios.Cliente;
import br.unicap.eticket.view.FrameInicio;
import br.unicap.eticket.view.TelaInicio;
import br.unicap.eticket.view.jDialogs.JDialogsControl;
import br.unicap.eticket.view.jDialogs.TelaPopupConfirmar;
import br.unicap.eticket.view.jDialogs.TelaPopupMissoes;
import br.unicap.eticket.viewAuxiliares.Notas;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TelaHomepageLocalContato extends javax.swing.JPanel {

    private Cliente cliente;
    private LocalGenerico local;

    public TelaHomepageLocalContato(LocalGenerico local, Cliente cliente) {
        initComponents();
        this.local = local;
        this.cliente = cliente;
        selecionarBotao(lblContato);
        this.initContato();
        this.initCliente();
        this.initLocal();
    }

    private void initLocal() {
        lblNomeDoLocal.setText(local.getNome());
        lblEstrelas.setText("");
        String caminho = Notas.qualCaminho(local.getNota()).getCaminho();
        lblEstrelas.setIcon(new javax.swing.ImageIcon(getClass().getResource(caminho)));

        Image im = new ImageIcon(local.getBanner()).getImage();
        Icon ic = new ImageIcon(im);
        jlbBanner.setIcon(ic);
    }

    private void initCliente() {
        
        this.lblTier.setVisible(false);
        this.lblUsername.setText("@" + cliente.getNickName());
        String img = FachadaUsuarios.getInstance().retornaImagemTier(cliente, this.local);
        if (img != null) {
            lblTier.setVisible(true);
            lblTier.setIcon(new javax.swing.ImageIcon(getClass().getResource(img)));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jpnEsquerda = new javax.swing.JPanel();
        lblDeslogar = new javax.swing.JLabel();
        lblLinhinha = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblHomepage = new javax.swing.JLabel();
        lblMinhasReservas = new javax.swing.JLabel();
        lblMeuPerfil = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblTier = new javax.swing.JLabel();
        lblBordaEsquerda1 = new javax.swing.JLabel();
        lblMissoes = new javax.swing.JLabel();
        lblEstrelas = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        fldTelefone = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        fldEmailAdm = new javax.swing.JTextField();
        fldEmailLocal = new javax.swing.JTextField();
        lblEmailEstabel = new javax.swing.JLabel();
        lblEmCartaz = new javax.swing.JLabel();
        lblSobre = new javax.swing.JLabel();
        lblContato = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        fldInstagram = new javax.swing.JTextField();
        fldFacebook = new javax.swing.JTextField();
        lblTelefone1 = new javax.swing.JLabel();
        lblNomeDoLocal = new javax.swing.JLabel();
        lblCaixaTitulo = new javax.swing.JLabel();
        lblCategoriasBar = new javax.swing.JLabel();
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

        lblLinhinha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/linhinha.png"))); // NOI18N
        jpnEsquerda.add(lblLinhinha, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 150, 360, 20));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/logoSemNome.png"))); // NOI18N
        jpnEsquerda.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 110, 110));

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
        jpnEsquerda.add(lblHomepage, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 110, 40));

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
        jpnEsquerda.add(lblMinhasReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 170, 40));

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
        jpnEsquerda.add(lblMeuPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 110, 40));

        lblUsername.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("@Cliente");
        lblUsername.setToolTipText("");
        jpnEsquerda.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 140, 40));

        lblTier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/icones/Tier3.png"))); // NOI18N
        lblTier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTierMouseClicked(evt);
            }
        });
        jpnEsquerda.add(lblTier, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 60, 40));

        lblBordaEsquerda1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/BordaEsquerda.png"))); // NOI18N
        lblBordaEsquerda1.setText("jLabel3");
        jpnEsquerda.add(lblBordaEsquerda1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 770));

        add(jpnEsquerda, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 290, 770));

        lblMissoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/icones/IconeMissao.png"))); // NOI18N
        lblMissoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMissoesMouseClicked(evt);
            }
        });
        add(lblMissoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 60, 40));

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

        fldInstagram.setBackground(new java.awt.Color(204, 204, 204));
        fldInstagram.setForeground(new java.awt.Color(102, 102, 102));
        add(fldInstagram, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 560, 160, -1));

        fldFacebook.setBackground(new java.awt.Color(204, 204, 204));
        fldFacebook.setForeground(new java.awt.Color(102, 102, 102));
        add(fldFacebook, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 530, 160, -1));

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
        fldTelefone.setText(local.getTelefone());
        fldEmailLocal.setText(local.getEmail());
        fldEmailAdm.setText(local.getAdmin().getEmail());
        fldFacebook.setText(local.getRedeSocial_facebook());
        fldInstagram.setText(local.getRedeSocial_instagram());
    }

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

    private void lblMissoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMissoesMouseClicked
        TelaPopupMissoes missoes = new TelaPopupMissoes(FrameInicio.getFrame(), true);
        missoes.setLocationRelativeTo(null);
        missoes.setVisible(true);
    }//GEN-LAST:event_lblMissoesMouseClicked

    private void lblTierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTierMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTierMouseClicked

    private void lblEmCartazMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEmCartazMouseClicked
        selecionarBotao(lblEmCartaz);
        FrameInicio.getFrame().setContentPane(new TelaHomepageLocal(this.local,this.cliente));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblEmCartazMouseClicked

    private void lblEmCartazMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEmCartazMouseEntered

    }//GEN-LAST:event_lblEmCartazMouseEntered

    private void lblEmCartazMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEmCartazMouseExited

    }//GEN-LAST:event_lblEmCartazMouseExited

    private void lblSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSobreMouseClicked
        selecionarBotao(lblSobre);
        FrameInicio.getFrame().setContentPane(new TelaHomepageLocalSobre(this.local,this.cliente));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblSobreMouseClicked

    private void lblSobreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSobreMouseEntered

    }//GEN-LAST:event_lblSobreMouseEntered

    private void lblSobreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSobreMouseExited

    }//GEN-LAST:event_lblSobreMouseExited

    private void lblContatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblContatoMouseClicked
        selecionarBotao(lblContato);
        FrameInicio.getFrame().setContentPane(new TelaHomepageLocalContato(this.local,this.cliente));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblContatoMouseClicked

    private void lblContatoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblContatoMouseEntered

    }//GEN-LAST:event_lblContatoMouseEntered

    private void lblContatoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblContatoMouseExited

    }//GEN-LAST:event_lblContatoMouseExited

    private void lblEnderecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEnderecoMouseClicked
        selecionarBotao(lblEndereco);
        FrameInicio.getFrame().setContentPane(new TelaHomepageLocalEndereco(this.local,this.cliente));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblEnderecoMouseClicked

    private void lblEnderecoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEnderecoMouseEntered

    }//GEN-LAST:event_lblEnderecoMouseEntered

    private void lblEnderecoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEnderecoMouseExited

    }//GEN-LAST:event_lblEnderecoMouseExited

    private void acenderBotao(JLabel lbl) {
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
    private javax.swing.JLabel jlbBanner;
    private javax.swing.JPanel jpnEsquerda;
    private javax.swing.JLabel lblBordaEsquerda1;
    private javax.swing.JLabel lblCaixaTitulo;
    private javax.swing.JLabel lblCategoriasBar;
    private javax.swing.JLabel lblContato;
    private javax.swing.JLabel lblDeslogar;
    private javax.swing.JLabel lblEmCartaz;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmailEstabel;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEstrelas;
    private javax.swing.JLabel lblHomepage;
    private javax.swing.JLabel lblLinhaDadP;
    private javax.swing.JLabel lblLinhinha;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMeuPerfil;
    private javax.swing.JLabel lblMinhasReservas;
    private javax.swing.JLabel lblMissoes;
    private javax.swing.JLabel lblNomeDoLocal;
    private javax.swing.JLabel lblSobre;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTelefone1;
    private javax.swing.JLabel lblTier;
    private javax.swing.JLabel lblUsername;
    // End of variables declaration//GEN-END:variables
}
