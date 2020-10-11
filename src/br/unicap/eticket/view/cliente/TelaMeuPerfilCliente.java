package br.unicap.eticket.view.cliente;

import br.unicap.eticket.control.usuarios.ClienteControl;
import br.unicap.eticket.control.validacoes.Conversor;
import br.unicap.eticket.excecoes.AtualizacaoMalSucedidaException;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosInvalidosException;
import br.unicap.eticket.model.auxiliares.Endereco;
import br.unicap.eticket.model.usuarios.Cliente;
import br.unicap.eticket.view.FrameInicio;
import br.unicap.eticket.view.TelaInicio;
import br.unicap.eticket.view.jDialogs.TelaPopupConfirmar;
import java.util.HashMap;
import javax.swing.JLabel;

public class TelaMeuPerfilCliente extends javax.swing.JPanel {

    private Cliente cliente;

    public TelaMeuPerfilCliente(Cliente cliente) {
        initComponents();
        this.cliente = cliente;
        this.initDados(cliente);
        if (cliente.getNickName() != null) {
            this.lblUsername.setText("@" + cliente.getNickName());
        }
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
        lblCPF = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        lblSenhaConf = new javax.swing.JLabel();
        fldEmail = new javax.swing.JTextField();
        lblLinhaAltSenha = new javax.swing.JLabel();
        fldCEP = new javax.swing.JTextField();
        lblCEP = new javax.swing.JLabel();
        jbtLocalizarCEP = new javax.swing.JButton();
        fldRua = new javax.swing.JTextField();
        lblRua = new javax.swing.JLabel();
        fldCidade = new javax.swing.JTextField();
        lblCidade = new javax.swing.JLabel();
        fldBairro = new javax.swing.JTextField();
        lblBairro = new javax.swing.JLabel();
        lblNum = new javax.swing.JLabel();
        fldUF = new javax.swing.JTextField();
        lblUF = new javax.swing.JLabel();
        fldComplemento = new javax.swing.JTextField();
        lblComplemento = new javax.swing.JLabel();
        fldPais = new javax.swing.JTextField();
        lblPais = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        fldIdade = new javax.swing.JTextField();
        fldTelefone = new javax.swing.JTextField();
        fldNum = new javax.swing.JTextField();
        fldCPF = new javax.swing.JTextField();
        lblLinhaEnd = new javax.swing.JLabel();
        lblLinhaDadP = new javax.swing.JLabel();
        lblHomepage = new javax.swing.JLabel();
        lblMinhasReservas = new javax.swing.JLabel();
        lblMeuPerfil = new javax.swing.JLabel();
        lblLinhinha = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblDeslogar = new javax.swing.JLabel();
        lblBordaEsquerda = new javax.swing.JLabel();
        jbtAlterarPerfil = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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
        add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, -1, -1));

        lblEmail.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("e-mail");
        add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, -1, -1));

        lblIdade.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblIdade.setForeground(new java.awt.Color(255, 255, 255));
        lblIdade.setText("idade");
        add(lblIdade, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, -1, -1));

        fldNome.setBackground(new java.awt.Color(204, 204, 204));
        fldNome.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldNome.setForeground(new java.awt.Color(102, 102, 102));
        fldNome.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 250, 20));

        fldSenhaAntiga.setBackground(new java.awt.Color(204, 204, 204));
        fldSenhaAntiga.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldSenhaAntiga.setForeground(new java.awt.Color(102, 102, 102));
        add(fldSenhaAntiga, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 520, 250, 20));

        fldSenhaNova.setBackground(new java.awt.Color(204, 204, 204));
        fldSenhaNova.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldSenhaNova.setForeground(new java.awt.Color(102, 102, 102));
        add(fldSenhaNova, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 570, 250, 20));

        lblCPF.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblCPF.setForeground(new java.awt.Color(255, 255, 255));
        lblCPF.setText("CPF");
        add(lblCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, -1, -1));

        lblSenha.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(255, 255, 255));
        lblSenha.setText("senha antiga");
        add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 500, 90, -1));

        lblSenhaConf.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblSenhaConf.setForeground(new java.awt.Color(255, 255, 255));
        lblSenhaConf.setText("nova senha");
        add(lblSenhaConf, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 550, -1, -1));

        fldEmail.setBackground(new java.awt.Color(204, 204, 204));
        fldEmail.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldEmail.setForeground(new java.awt.Color(102, 102, 102));
        fldEmail.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, 250, 20));

        lblLinhaAltSenha.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alterar senha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Impact", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        add(lblLinhaAltSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 460, 310, 150));

        fldCEP.setBackground(new java.awt.Color(204, 204, 204));
        fldCEP.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldCEP.setForeground(new java.awt.Color(102, 102, 102));
        fldCEP.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 210, 140, 20));

        lblCEP.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblCEP.setForeground(new java.awt.Color(255, 255, 255));
        lblCEP.setText("Digite Seu CEP");
        add(lblCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 190, -1, -1));

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
        add(jbtLocalizarCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 200, 160, 30));

        fldRua.setBackground(new java.awt.Color(204, 204, 204));
        fldRua.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldRua.setForeground(new java.awt.Color(102, 102, 102));
        fldRua.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 270, 280, 20));

        lblRua.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblRua.setForeground(new java.awt.Color(255, 255, 255));
        lblRua.setText("Rua");
        add(lblRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 250, -1, -1));

        fldCidade.setBackground(new java.awt.Color(204, 204, 204));
        fldCidade.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldCidade.setForeground(new java.awt.Color(102, 102, 102));
        fldCidade.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 330, 280, 20));

        lblCidade.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblCidade.setForeground(new java.awt.Color(255, 255, 255));
        lblCidade.setText("Cidade");
        add(lblCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 310, -1, -1));

        fldBairro.setBackground(new java.awt.Color(204, 204, 204));
        fldBairro.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldBairro.setForeground(new java.awt.Color(102, 102, 102));
        fldBairro.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 390, 280, 20));

        lblBairro.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblBairro.setForeground(new java.awt.Color(255, 255, 255));
        lblBairro.setText("Bairro");
        add(lblBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 370, -1, -1));

        lblNum.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblNum.setForeground(new java.awt.Color(255, 255, 255));
        lblNum.setText("Nº");
        add(lblNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 430, -1, -1));

        fldUF.setBackground(new java.awt.Color(204, 204, 204));
        fldUF.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldUF.setForeground(new java.awt.Color(102, 102, 102));
        fldUF.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldUF, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 450, 120, 20));

        lblUF.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblUF.setForeground(new java.awt.Color(255, 255, 255));
        lblUF.setText("UF");
        add(lblUF, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 430, -1, -1));

        fldComplemento.setBackground(new java.awt.Color(204, 204, 204));
        fldComplemento.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldComplemento.setForeground(new java.awt.Color(102, 102, 102));
        fldComplemento.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 510, 280, 20));

        lblComplemento.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblComplemento.setForeground(new java.awt.Color(255, 255, 255));
        lblComplemento.setText("Complemento");
        add(lblComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 490, -1, -1));

        fldPais.setBackground(new java.awt.Color(204, 204, 204));
        fldPais.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldPais.setForeground(new java.awt.Color(102, 102, 102));
        fldPais.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 570, 280, 20));

        lblPais.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblPais.setForeground(new java.awt.Color(255, 255, 255));
        lblPais.setText("País");
        add(lblPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 550, -1, -1));

        lblTelefone.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblTelefone.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefone.setText("telefone");
        add(lblTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, -1, -1));

        fldIdade.setBackground(new java.awt.Color(204, 204, 204));
        fldIdade.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldIdade.setForeground(new java.awt.Color(102, 102, 102));
        fldIdade.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldIdade, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 50, 20));

        fldTelefone.setBackground(new java.awt.Color(204, 204, 204));
        fldTelefone.setForeground(new java.awt.Color(102, 102, 102));
        add(fldTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 280, 160, -1));

        fldNum.setBackground(new java.awt.Color(204, 204, 204));
        fldNum.setForeground(new java.awt.Color(102, 102, 102));
        add(fldNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 450, 110, -1));

        fldCPF.setBackground(new java.awt.Color(204, 204, 204));
        fldCPF.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldCPF.setForeground(new java.awt.Color(102, 102, 102));
        fldCPF.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 350, 250, 20));

        lblLinhaEnd.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Impact", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        add(lblLinhaEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 150, 330, 460));

        lblLinhaDadP.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados pessoais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Impact", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        add(lblLinhaDadP, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 310, 310));

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

        lblLinhinha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/linhinha.png"))); // NOI18N
        add(lblLinhinha, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 150, 360, 20));

        lblUsername.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("@Cliente");
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

        lblBordaEsquerda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/BordaEsquerda.png"))); // NOI18N
        lblBordaEsquerda.setText("jLabel3");
        add(lblBordaEsquerda, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 320, 770));

        jbtAlterarPerfil.setBackground(new java.awt.Color(255, 255, 255));
        jbtAlterarPerfil.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jbtAlterarPerfil.setForeground(new java.awt.Color(255, 255, 255));
        jbtAlterarPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoCompridoEdicao.png"))); // NOI18N
        jbtAlterarPerfil.setText("Editar");
        jbtAlterarPerfil.setBorder(null);
        jbtAlterarPerfil.setContentAreaFilled(false);
        jbtAlterarPerfil.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtAlterarPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtAlterarPerfilMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtAlterarPerfilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtAlterarPerfilMouseExited(evt);
            }
        });
        jbtAlterarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAlterarPerfilActionPerformed(evt);
            }
        });
        add(jbtAlterarPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 630, -1, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/fundoGigante.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1370, 770));
    }// </editor-fold>//GEN-END:initComponents

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
                FrameInicio.mostrarPopUp(ex.getMessage(), true);
            }

        }
    }//GEN-LAST:event_jbtLocalizarCEPMouseClicked

    private void initDados(Cliente cliente) {
        fldNome.setText(cliente.getNome());
        fldIdade.setText(String.valueOf(cliente.getIdade()));
        fldCPF.setText(cliente.getCpf());
        fldEmail.setText(cliente.getEmail());
        fldTelefone.setText(cliente.getTelefone());

        Endereco end = cliente.getEndereco();
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

    private void jbtAlterarPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAlterarPerfilMouseClicked

        if (jbtAlterarPerfil.getText().equalsIgnoreCase("Salvar")) {
            ClienteControl cc = new ClienteControl();

            Endereco novoEnd = new Endereco(fldCEP.getText(), fldUF.getText(), fldCidade.getText(), fldBairro.getText(),
                    fldRua.getText(), fldNum.getText(), fldComplemento.getText());

            Cliente novo = new Cliente(fldNome.getText(), fldNome.getText(), fldEmail.getText(), cliente.getSenha(), Integer.parseInt(fldIdade.getText()),
                    fldCPF.getText(), fldTelefone.getText(), novoEnd);

            try {
                if (fldEmail.getText() != null && !fldEmail.getText().equalsIgnoreCase(cliente.getEmail())) {
                    cliente.atualizarEmail(fldEmail.getText());
                }
                if (String.valueOf(fldSenhaAntiga.getPassword()).equals(this.cliente.getSenha())) {
                    novo.setSenha(String.valueOf(fldSenhaNova.getPassword()));
                }
                cc.atualizar(novo);
                this.cliente = cc.buscar(cliente);
                this.initDados(cliente);
                FrameInicio.mostrarPopUp("Atualizado Com Sucesso!", false);

            } catch (CadastroInexistenteException | AtualizacaoMalSucedidaException ex) {
                FrameInicio.mostrarPopUp(ex.getMessage(), true);
            }

        }
        trocarNome();
        trocarEditable();
    }//GEN-LAST:event_jbtAlterarPerfilMouseClicked

    private void jbtAlterarPerfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAlterarPerfilMouseEntered
        jbtAlterarPerfil.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jbtAlterarPerfilMouseEntered

    private void jbtAlterarPerfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAlterarPerfilMouseExited
        jbtAlterarPerfil.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jbtAlterarPerfilMouseExited

    private void jbtAlterarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAlterarPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtAlterarPerfilActionPerformed

    private void jbtLocalizarCEPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtLocalizarCEPMouseEntered
        jbtLocalizarCEP.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jbtLocalizarCEPMouseEntered

    private void jbtLocalizarCEPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtLocalizarCEPMouseExited
        jbtLocalizarCEP.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jbtLocalizarCEPMouseExited

    private void setFieldsEditable(boolean b) {
        fldNome.setEditable(b);
        fldIdade.setEditable(b);
        fldCPF.setEditable(b);
        fldEmail.setEditable(b);
        fldTelefone.setEditable(b);
        fldBairro.setEditable(b);
        fldCEP.setEditable(b);
        fldCidade.setEditable(b);
        fldComplemento.setEditable(b);
        fldNum.setEditable(b);
        fldPais.setEditable(b);
        fldRua.setEditable(b);
        fldUF.setEditable(b);
        fldSenhaAntiga.setEditable(b);
        fldSenhaNova.setEditable(b);
    }

    private void acenderBotao(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(204, 204, 204));
    }

    private void apagarBotao(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(255, 255, 255));
    }

    private void trocarNome() {
        jbtAlterarPerfil.setText(jbtAlterarPerfil.getText().equalsIgnoreCase("Editar") ? "Salvar" : "Editar");
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

        fldNome.setEditable(!fldNome.isEditable());
        fldIdade.setEditable(!fldIdade.isEditable());
        fldTelefone.setEditable(!fldTelefone.isEditable());
        fldEmail.setEditable(!fldEmail.isEditable());
        fldCPF.setEditable(!fldCPF.isEditable());
        fldSenhaAntiga.setEditable(!fldSenhaAntiga.isEditable());
        fldSenhaNova.setEditable(!fldSenhaNova.isEditable());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fldBairro;
    private javax.swing.JTextField fldCEP;
    private javax.swing.JTextField fldCPF;
    private javax.swing.JTextField fldCidade;
    private javax.swing.JTextField fldComplemento;
    private javax.swing.JTextField fldEmail;
    private javax.swing.JTextField fldIdade;
    private javax.swing.JTextField fldNome;
    private javax.swing.JTextField fldNum;
    private javax.swing.JTextField fldPais;
    private javax.swing.JTextField fldRua;
    private javax.swing.JPasswordField fldSenhaAntiga;
    private javax.swing.JPasswordField fldSenhaNova;
    private javax.swing.JTextField fldTelefone;
    private javax.swing.JTextField fldUF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbtAlterarPerfil;
    private javax.swing.JButton jbtLocalizarCEP;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblBordaEsquerda;
    private javax.swing.JLabel lblCEP;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblComplemento;
    private javax.swing.JLabel lblDeslogar;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblHomepage;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblLinhaAltSenha;
    private javax.swing.JLabel lblLinhaDadP;
    private javax.swing.JLabel lblLinhaEnd;
    private javax.swing.JLabel lblLinhinha;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMeuPerfil;
    private javax.swing.JLabel lblMinhasReservas;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNum;
    private javax.swing.JLabel lblPais;
    private javax.swing.JLabel lblRealizarCad;
    private javax.swing.JLabel lblRua;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSenhaConf;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblUF;
    private javax.swing.JLabel lblUsername;
    // End of variables declaration//GEN-END:variables

}
