package br.unicap.eticket.view.admin;

import br.unicap.eticket.control.validacoes.Conversor;
import br.unicap.eticket.excecoes.AtualizacaoMalSucedidaException;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosInvalidosException;
import br.unicap.eticket.model.auxiliares.Endereco;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.usuarios.Admin;
import br.unicap.eticket.view.FrameInicio;
import br.unicap.eticket.view.TelaInicio;
import br.unicap.eticket.view.jDialogs.JDialogsControl;
import br.unicap.eticket.view.jDialogs.TelaPopupConfirmar;
import br.unicap.eticket.viewAuxiliares.Notas;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.util.HashMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

public class TelaHomepageEndereco extends javax.swing.JPanel {

    private Admin adm;
    private LocalGenerico local;

    public TelaHomepageEndereco(Admin adm) {
        initComponents();
        this.adm = adm;
        this.local = adm.getLocalAdministrado();
        selecionarBotao(lblEndereco);
        this.initEndereco(local);
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
        lblBordaEsquerda = new javax.swing.JLabel();
        jbtAlterarBanner = new javax.swing.JButton();
        lblEndereco = new javax.swing.JLabel();
        lblContato = new javax.swing.JLabel();
        lblLojinha = new javax.swing.JLabel();
        lblSobre = new javax.swing.JLabel();
        lblEmCartaz = new javax.swing.JLabel();
        lblEstrelas = new javax.swing.JLabel();
        lblNomeDoLocal = new javax.swing.JLabel();
        lblCaixaTitulo = new javax.swing.JLabel();
        lblCategoriasBar = new javax.swing.JLabel();
        lblCEP = new javax.swing.JLabel();
        fldCEP = new javax.swing.JTextField();
        jbtLocalizarCEP = new javax.swing.JButton();
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
        jbtAlterarEnd = new javax.swing.JButton();
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

        lblEndereco.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        lblEndereco.setForeground(new java.awt.Color(255, 255, 255));
        lblEndereco.setText("Endereço");
        lblEndereco.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEndereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEnderecoMouseClicked(evt);
            }
        });
        add(lblEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 200, 90, 40));

        lblContato.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        lblContato.setForeground(new java.awt.Color(255, 255, 255));
        lblContato.setText("Contato");
        lblContato.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblContato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblContatoMouseClicked(evt);
            }
        });
        add(lblContato, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 200, 90, 40));

        lblLojinha.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        lblLojinha.setForeground(new java.awt.Color(255, 255, 255));
        lblLojinha.setText("Loja Virtual");
        lblLojinha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLojinha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLojinhaMouseClicked(evt);
            }
        });
        add(lblLojinha, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 200, 90, 40));

        lblSobre.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        lblSobre.setForeground(new java.awt.Color(255, 255, 255));
        lblSobre.setText("Sobre");
        lblSobre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSobreMouseClicked(evt);
            }
        });
        add(lblSobre, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 70, 40));

        lblEmCartaz.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        lblEmCartaz.setForeground(new java.awt.Color(51, 102, 255));
        lblEmCartaz.setText("Em Cartaz");
        lblEmCartaz.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEmCartaz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEmCartazMouseClicked(evt);
            }
        });
        add(lblEmCartaz, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 90, 40));

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

        lblCategoriasBar.setBackground(new java.awt.Color(0, 0, 0));
        lblCategoriasBar.setForeground(new java.awt.Color(102, 102, 102));
        lblCategoriasBar.setOpaque(true);
        add(lblCategoriasBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 1080, 70));

        lblCEP.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblCEP.setForeground(new java.awt.Color(255, 255, 255));
        lblCEP.setText("Digite Seu CEP");
        add(lblCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, -1, -1));

        fldCEP.setBackground(new java.awt.Color(204, 204, 204));
        fldCEP.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldCEP.setForeground(new java.awt.Color(102, 102, 102));
        fldCEP.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 140, 20));

        jbtLocalizarCEP.setBackground(new java.awt.Color(227, 0, 0));
        jbtLocalizarCEP.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jbtLocalizarCEP.setForeground(new java.awt.Color(255, 255, 255));
        jbtLocalizarCEP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoCompridoLupa (2).png"))); // NOI18N
        jbtLocalizarCEP.setText("Localizar CEP");
        jbtLocalizarCEP.setBorder(null);
        jbtLocalizarCEP.setContentAreaFilled(false);
        jbtLocalizarCEP.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtLocalizarCEP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtLocalizarCEPMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtLocalizarCEPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtLocalizarCEPMouseExited(evt);
            }
        });
        add(jbtLocalizarCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 350, 150, 30));

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

        jbtAlterarEnd.setBackground(new java.awt.Color(255, 255, 255));
        jbtAlterarEnd.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jbtAlterarEnd.setForeground(new java.awt.Color(255, 255, 255));
        jbtAlterarEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoCompridoEdicao.png"))); // NOI18N
        jbtAlterarEnd.setText("Editar");
        jbtAlterarEnd.setBorder(null);
        jbtAlterarEnd.setContentAreaFilled(false);
        jbtAlterarEnd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtAlterarEnd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtAlterarEndMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtAlterarEndMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtAlterarEndMouseExited(evt);
            }
        });
        jbtAlterarEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAlterarEndActionPerformed(evt);
            }
        });
        add(jbtAlterarEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 550, 200, 40));

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

        FrameInicio.getFrame().setContentPane(new TelaHomepageEndereco(local.getAdmin()));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblHomePageMouseClicked

    private void lblHomePageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomePageMouseEntered
        ascenderBotao(lblHomePage);
    }//GEN-LAST:event_lblHomePageMouseEntered

    private void lblHomePageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomePageMouseExited
        apagarBotao(lblHomePage);
    }//GEN-LAST:event_lblHomePageMouseExited

    private void lblEmCartazMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEmCartazMouseClicked
        selecionarBotao(lblEmCartaz);
        FrameInicio.getFrame().setContentPane(new TelaHomepageAdmin(this.adm));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblEmCartazMouseClicked

    private void lblSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSobreMouseClicked
        selecionarBotao(lblSobre);
        FrameInicio.getFrame().setContentPane(new TelaHomepageSobre(this.adm));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblSobreMouseClicked

    private void lblLojinhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLojinhaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblLojinhaMouseClicked

    private void lblContatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblContatoMouseClicked
        selecionarBotao(lblContato);
        FrameInicio.getFrame().setContentPane(new TelaHomepageContato(this.adm));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblContatoMouseClicked

    private void lblEnderecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEnderecoMouseClicked
        selecionarBotao(lblEndereco);
        FrameInicio.getFrame().setContentPane(new TelaHomepageEndereco(this.adm));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_lblEnderecoMouseClicked

    private void jbtLocalizarCEPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtLocalizarCEPMouseClicked
        if (!fldCEP.getText().equals("")) {
            HashMap<String, String> endereco = null;
            try {
                endereco = Conversor.coverterCepEmEndereco(fldCEP.getText());
                fldPais.setText("Brasil");
                fldRua.setText(endereco.get("Logradouro"));
                fldBairro.setText(endereco.get("Bairro"));
                fldCidade.setText(endereco.get("Cidade"));
                fldUF.setText(endereco.get("UF"));
            } catch (DadosInvalidosException ex) {
                JDialogsControl.mostrarPopUp(ex.getMessage(),true);
            }

        }
    }//GEN-LAST:event_jbtLocalizarCEPMouseClicked

    private void jbtLocalizarCEPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtLocalizarCEPMouseEntered
         jbtLocalizarCEP.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_jbtLocalizarCEPMouseEntered

    private void jbtLocalizarCEPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtLocalizarCEPMouseExited
       jbtLocalizarCEP.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_jbtLocalizarCEPMouseExited

    private void jbtAlterarEndMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAlterarEndMouseClicked

        if (jbtAlterarEnd.getText().equalsIgnoreCase("Salvar")) {
            try {
                Endereco novoEnd = new Endereco(fldCEP.getText(), fldUF.getText(), fldCidade.getText(), fldBairro.getText(),
                        fldRua.getText(), fldNum.getText(), fldComplemento.getText());
                if (!this.local.getEndereco().equals(novoEnd)) {
                    local.atualizarEnd(novoEnd);
                }
            } catch (CadastroInexistenteException | AtualizacaoMalSucedidaException ex) {
                JDialogsControl.mostrarPopUp(ex.getMessage(),true);
            }

        }
        trocarNome();
        trocarEditable();
    }//GEN-LAST:event_jbtAlterarEndMouseClicked

    private void jbtAlterarEndMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAlterarEndMouseEntered
        jbtAlterarEnd.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_jbtAlterarEndMouseEntered

    private void jbtAlterarEndMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAlterarEndMouseExited
         jbtAlterarEnd.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_jbtAlterarEndMouseExited

    private void jbtAlterarEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAlterarEndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtAlterarEndActionPerformed

    private void jbtAlterarBannerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAlterarBannerMouseClicked
        JFileChooser arquivo = new JFileChooser();
        arquivo.setDialogTitle("Selecione uma Capa:");
        arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int opc = arquivo.showOpenDialog(this);
        if (opc == JFileChooser.APPROVE_OPTION) {
            File file = new File("Caminho");
            file = arquivo.getSelectedFile();
            String fileName = file.getAbsolutePath();

            ImageIcon img = new ImageIcon(arquivo.getSelectedFile().getPath());
            jlbBanner.setIcon(new ImageIcon(img.getImage().getScaledInstance(
                jlbBanner.getWidth(), jlbBanner.getHeight(), Image.SCALE_DEFAULT)));

    String caminhoCompleto = this.caminhoCompleto(fileName);
    adm.getLocalAdministrado().inserirBannerESalvar(caminhoCompleto);
    }
    }//GEN-LAST:event_jbtAlterarBannerMouseClicked

    private void jbtAlterarBannerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAlterarBannerMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtAlterarBannerMouseEntered

    private void jbtAlterarBannerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAlterarBannerMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtAlterarBannerMouseExited

    private void ascenderBotao(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(204, 204, 204));
    }

    private void apagarBotao(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(255, 255, 255));
    }

    private void selecionarBotao(JLabel lbl) {
        lblEmCartaz.setForeground(new java.awt.Color(255, 255, 255));
        lblContato.setForeground(new java.awt.Color(255, 255, 255));
        lblLojinha.setForeground(new java.awt.Color(255, 255, 255));
        lblEndereco.setForeground(new java.awt.Color(255, 255, 255));
        lblSobre.setForeground(new java.awt.Color(255, 255, 255));
        lbl.setForeground(new java.awt.Color(51, 102, 255));
    }

    private void trocarNome() {
        jbtAlterarEnd.setText(jbtAlterarEnd.getText().equalsIgnoreCase("Editar") ? "Salvar" : "Editar");
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
        jbtLocalizarCEP.setEnabled(!jbtLocalizarCEP.isEnabled());
    }
     private String caminhoCompleto(String caminho) {
        char[] chars = caminho.toCharArray();
        String aux = "";

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '\\') {
                aux = aux.concat(Character.toString(chars[i]));
            } else {
                aux = aux.concat(Character.toString(chars[i])).concat(Character.toString(chars[i]));
            }
        }

        return aux;
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
    private javax.swing.JButton jbtAlterarBanner;
    private javax.swing.JButton jbtAlterarEnd;
    private javax.swing.JButton jbtLocalizarCEP;
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
    private javax.swing.JLabel lblControleOrcamento;
    private javax.swing.JLabel lblDeslogar;
    private javax.swing.JLabel lblEmCartaz;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEstrelas;
    private javax.swing.JLabel lblHomePage;
    private javax.swing.JLabel lblLinhaEnd;
    private javax.swing.JLabel lblLinhinha;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLojinha;
    private javax.swing.JLabel lblNomeDoLocal;
    private javax.swing.JLabel lblNum;
    private javax.swing.JLabel lblPais;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JLabel lblRua;
    private javax.swing.JLabel lblSalas;
    private javax.swing.JLabel lblSessoes;
    private javax.swing.JLabel lblSobre;
    private javax.swing.JLabel lblUF;
    private javax.swing.JLabel lblUsername;
    // End of variables declaration//GEN-END:variables
}
