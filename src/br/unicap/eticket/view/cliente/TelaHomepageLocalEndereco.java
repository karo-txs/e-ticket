package br.unicap.eticket.view.cliente;

import br.unicap.eticket.controller.usuarios.ClienteController;
import br.unicap.eticket.model.auxiliares.Endereco;
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

public class TelaHomepageLocalEndereco extends javax.swing.JPanel {

    private Cliente cliente;
    private LocalGenerico local;

    public TelaHomepageLocalEndereco(LocalGenerico local, Cliente cliente) {
        initComponents();
        this.local = local;
        this.cliente = cliente;
        selecionarBotao(lblEndereco);
        this.initEndereco(local);
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
        ClienteController cc = new ClienteController();
        this.lblTier.setVisible(false);
        this.lblUsername.setText("@" + cliente.getNickName());
        String img = cc.retornaImagemTier(cliente, this.local);
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
        lblHomepage1 = new javax.swing.JLabel();
        lblMinhasReservas = new javax.swing.JLabel();
        lblMeuPerfil = new javax.swing.JLabel();
        lblTier = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblBordaEsquerda = new javax.swing.JLabel();
        lblEstrelas = new javax.swing.JLabel();
        lblNomeDoLocal = new javax.swing.JLabel();
        lblCaixaTitulo = new javax.swing.JLabel();
        lblEmCartaz = new javax.swing.JLabel();
        lblSobre = new javax.swing.JLabel();
        lblContato = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        lblMissoes = new javax.swing.JLabel();
        lblCategoriasBar = new javax.swing.JLabel();
        lblCEP = new javax.swing.JLabel();
        fldCEP = new javax.swing.JTextField();
        fldRua = new javax.swing.JTextField();
        lblRua = new javax.swing.JLabel();
        fldCidade = new javax.swing.JTextField();
        lblCidade = new javax.swing.JLabel();
        fldBairro = new javax.swing.JTextField();
        lblBairro = new javax.swing.JLabel();
        fldNum = new javax.swing.JTextField();
        lblNum = new javax.swing.JLabel();
        fldUF = new javax.swing.JTextField();
        lblUF = new javax.swing.JLabel();
        fldComplemento = new javax.swing.JTextField();
        lblComplemento = new javax.swing.JLabel();
        lblPais = new javax.swing.JLabel();
        fldPais = new javax.swing.JTextField();
        lblLinhaEnd = new javax.swing.JLabel();
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

        lblHomepage1.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        lblHomepage1.setForeground(new java.awt.Color(255, 255, 255));
        lblHomepage1.setText("HomePage");
        lblHomepage1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblHomepage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomepage1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHomepage1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHomepage1MouseExited(evt);
            }
        });
        jpnEsquerda.add(lblHomepage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 110, 40));

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

        lblTier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/icones/Tier3.png"))); // NOI18N
        lblTier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTierMouseClicked(evt);
            }
        });
        jpnEsquerda.add(lblTier, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 60, 40));

        lblUsername.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("@Cliente");
        lblUsername.setToolTipText("");
        jpnEsquerda.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 140, 40));

        lblBordaEsquerda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/BordaEsquerda.png"))); // NOI18N
        lblBordaEsquerda.setText("jLabel3");
        jpnEsquerda.add(lblBordaEsquerda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 770));

        add(jpnEsquerda, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 290, 770));

        lblEstrelas.setFont(new java.awt.Font("Segoe UI Symbol", 2, 16)); // NOI18N
        lblEstrelas.setForeground(new java.awt.Color(153, 153, 153));
        add(lblEstrelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, 170, 30));

        lblNomeDoLocal.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        lblNomeDoLocal.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeDoLocal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomeDoLocal.setText("Cinemark");
        add(lblNomeDoLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, 370, 40));

        lblCaixaTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaixaTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/caixaTitulo.png"))); // NOI18N
        add(lblCaixaTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 1080, 90));

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

        lblMissoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/icones/IconeMissao.png"))); // NOI18N
        lblMissoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMissoesMouseClicked(evt);
            }
        });
        add(lblMissoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 60, 40));

        lblCategoriasBar.setBackground(new java.awt.Color(0, 0, 0));
        lblCategoriasBar.setForeground(new java.awt.Color(102, 102, 102));
        lblCategoriasBar.setOpaque(true);
        add(lblCategoriasBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 1080, 70));

        lblCEP.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblCEP.setForeground(new java.awt.Color(255, 255, 255));
        lblCEP.setText("CEP");
        add(lblCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, -1, -1));

        fldCEP.setBackground(new java.awt.Color(204, 204, 204));
        fldCEP.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldCEP.setForeground(new java.awt.Color(102, 102, 102));
        fldCEP.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 140, 20));

        fldRua.setBackground(new java.awt.Color(204, 204, 204));
        fldRua.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldRua.setForeground(new java.awt.Color(102, 102, 102));
        fldRua.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 410, 250, 20));

        lblRua.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblRua.setForeground(new java.awt.Color(255, 255, 255));
        lblRua.setText("Rua");
        add(lblRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, -1, -1));

        fldCidade.setBackground(new java.awt.Color(204, 204, 204));
        fldCidade.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldCidade.setForeground(new java.awt.Color(102, 102, 102));
        fldCidade.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 460, 250, 20));

        lblCidade.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblCidade.setForeground(new java.awt.Color(255, 255, 255));
        lblCidade.setText("Cidade");
        add(lblCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 440, -1, -1));

        fldBairro.setBackground(new java.awt.Color(204, 204, 204));
        fldBairro.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldBairro.setForeground(new java.awt.Color(102, 102, 102));
        fldBairro.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 510, 250, 20));

        lblBairro.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblBairro.setForeground(new java.awt.Color(255, 255, 255));
        lblBairro.setText("Bairro");
        add(lblBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, -1, -1));

        fldNum.setBackground(new java.awt.Color(204, 204, 204));
        fldNum.setForeground(new java.awt.Color(102, 102, 102));
        add(fldNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 410, 110, -1));

        lblNum.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblNum.setForeground(new java.awt.Color(255, 255, 255));
        lblNum.setText("Nº");
        add(lblNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 390, -1, -1));

        fldUF.setBackground(new java.awt.Color(204, 204, 204));
        fldUF.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldUF.setForeground(new java.awt.Color(102, 102, 102));
        fldUF.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldUF, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 410, 120, 20));

        lblUF.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblUF.setForeground(new java.awt.Color(255, 255, 255));
        lblUF.setText("UF");
        add(lblUF, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 390, -1, -1));

        fldComplemento.setBackground(new java.awt.Color(204, 204, 204));
        fldComplemento.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldComplemento.setForeground(new java.awt.Color(102, 102, 102));
        fldComplemento.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 460, 250, 20));

        lblComplemento.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblComplemento.setForeground(new java.awt.Color(255, 255, 255));
        lblComplemento.setText("Complemento");
        add(lblComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 440, -1, -1));

        lblPais.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblPais.setForeground(new java.awt.Color(255, 255, 255));
        lblPais.setText("País");
        add(lblPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 490, -1, -1));

        fldPais.setBackground(new java.awt.Color(204, 204, 204));
        fldPais.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldPais.setForeground(new java.awt.Color(102, 102, 102));
        fldPais.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 510, 250, 20));

        lblLinhaEnd.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Impact", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        add(lblLinhaEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, 600, 300));

        jlbBanner.setBackground(new java.awt.Color(21, 17, 17));
        jlbBanner.setForeground(new java.awt.Color(21, 17, 17));
        jlbBanner.setOpaque(true);
        add(jlbBanner, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 1080, 170));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/fundoGigante.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));
    }// </editor-fold>//GEN-END:initComponents

    private void initEndereco(LocalGenerico local) {
        Endereco end = local.getEndereco();
        fldBairro.setText(end.getBairro());
        fldCEP.setText(end.getCep());
        fldCidade.setText(end.getCidade());
        fldComplemento.setText(end.getComplemento());
        fldNum.setText(end.getNum());
        fldPais.setText("Brasil");
        fldRua.setText(end.getLogradouro());
        fldUF.setText(end.getUf());
        this.trocarEditable();
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

    private void lblHomepage1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomepage1MouseClicked
        FrameInicio.getFrame().setContentPane(new TelaHomepageCliente(cliente));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblHomepage1MouseClicked

    private void lblHomepage1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomepage1MouseEntered
        acenderBotao(lblHomepage1);
    }//GEN-LAST:event_lblHomepage1MouseEntered

    private void lblHomepage1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomepage1MouseExited
        apagarBotao(lblHomepage1);
    }//GEN-LAST:event_lblHomepage1MouseExited

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
        fldBairro.setEditable(!fldBairro.isEditable());
        fldCEP.setEditable(!fldCEP.isEditable());
        fldCidade.setEditable(!fldCidade.isEditable());
        fldComplemento.setEditable(!fldComplemento.isEditable());
        fldNum.setEditable(!fldNum.isEditable());
        fldPais.setEditable(!fldPais.isEditable());
        fldRua.setEditable(!fldRua.isEditable());
        fldUF.setEditable(!fldUF.isEditable());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField fldBairro;
    private javax.swing.JTextField fldCEP;
    private javax.swing.JTextField fldCidade;
    private javax.swing.JTextField fldComplemento;
    private javax.swing.JTextField fldNum;
    private javax.swing.JTextField fldPais;
    private javax.swing.JTextField fldRua;
    private javax.swing.JTextField fldUF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jlbBanner;
    private javax.swing.JPanel jpnEsquerda;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblBordaEsquerda;
    private javax.swing.JLabel lblCEP;
    private javax.swing.JLabel lblCaixaTitulo;
    private javax.swing.JLabel lblCategoriasBar;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblComplemento;
    private javax.swing.JLabel lblContato;
    private javax.swing.JLabel lblDeslogar;
    private javax.swing.JLabel lblEmCartaz;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEstrelas;
    private javax.swing.JLabel lblHomepage1;
    private javax.swing.JLabel lblLinhaEnd;
    private javax.swing.JLabel lblLinhinha;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMeuPerfil;
    private javax.swing.JLabel lblMinhasReservas;
    private javax.swing.JLabel lblMissoes;
    private javax.swing.JLabel lblNomeDoLocal;
    private javax.swing.JLabel lblNum;
    private javax.swing.JLabel lblPais;
    private javax.swing.JLabel lblRua;
    private javax.swing.JLabel lblSobre;
    private javax.swing.JLabel lblTier;
    private javax.swing.JLabel lblUF;
    private javax.swing.JLabel lblUsername;
    // End of variables declaration//GEN-END:variables
}
