package br.unicap.eticket.view.cliente;

import br.unicap.eticket.controller.auxiliares.Conversor;
import br.unicap.eticket.controller.auxiliares.Gerador;
import br.unicap.eticket.controller.localAuxiliares.SessaoController;
import br.unicap.eticket.controller.usuarios.ClienteController;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.entretenimentos.Entretenimento;
import br.unicap.eticket.model.locaisAuxiliares.Sessao;
import br.unicap.eticket.model.usuarios.Cliente;
import br.unicap.eticket.view.FrameInicio;
import br.unicap.eticket.view.TelaInicio;
import br.unicap.eticket.view.jDialogs.JDialogsControl;
import br.unicap.eticket.view.jDialogs.TelaPopupConfirmar;
import br.unicap.eticket.viewAuxiliares.Notas;
import java.awt.Image;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class TelaEntSelecionado extends javax.swing.JPanel {

    private Long[] idSessoes;
    private Cliente cliente;
    private LocalGenerico local;
    private Entretenimento ent;
    private JButton[] labelSemana;

    public TelaEntSelecionado(LocalGenerico local, Entretenimento ent, Cliente cliente) throws CadastroInexistenteException {
        initComponents();
        this.local = local;
        this.ent = ent;
        this.cliente = cliente;
        initEntretenimento();
        initSessoes(Calendar.getInstance());
        initDatas();
        this.initCliente();
    }

    private void initCliente() {
        ClienteController cc = new ClienteController();
        this.lblTier.setVisible(false);
        this.lblUsername.setText("@" + cliente.getNickName());
        String img = cc.retornaImagemTier(cliente, local);
        if (img != null) {
            lblTier.setVisible(true);
            lblTier.setIcon(new javax.swing.ImageIcon(getClass().getResource(img)));
        }
    }

    private void initSessoes(Calendar dia) throws CadastroInexistenteException {
        SessaoController sc = new SessaoController();
        List<Sessao> sessoes = sc.sessoesPorEntEData(ent, this.local, dia);
        this.idSessoes = sc.listarIDs(sessoes);
        lstSessoes.setModel(new javax.swing.DefaultComboBoxModel<>(sc.formataDadosAbreviados(sessoes)));
    }

    private void initDatas() {
        this.labelSemana = new JButton[]{jbtHoje, jbtDia1, jbtDia2, jbtDia3, jbtDia4, jbtDia5, jbtDia6};
        diaSelecionado(jbtHoje);
        String[] semana = Gerador.geraSemana();

        int i = 0;
        for (JButton j : this.labelSemana) {
            j.setText("<html><center> " + semana[i]);
            i++;
        }
    }

    private void initEntretenimento() {
        lblFilmeTitulo.setText(ent.getNome());
        lblDuracaoMinutos.setText(String.valueOf(ent.getDuracao() + " minutos"));
        lblNomeDiretor.setText(ent.getDiretor());
        lblFilmeDescricao.setText("<html>" + ent.getSinopse());

        Image im = new ImageIcon(ent.getCapa()).getImage();
        Icon ic = new ImageIcon(im);
        lblFilmeCapa.setIcon(ic);

        lblEstrelas.setText("");
        String caminho = Notas.qualCaminho(ent.getNota()).getCaminho();
        lblEstrelas.setIcon(new javax.swing.ImageIcon(getClass().getResource(caminho)));
         String caminhoIconClassificacao = null;
        if (ent.getClassificacao().getCaminho() != null) {
            caminhoIconClassificacao = ent.getClassificacao().getCaminho();
            lblClassificacao.setIcon(new javax.swing.ImageIcon(getClass().getResource(caminhoIconClassificacao)));
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTier = new javax.swing.JLabel();
        lblFilmeCapa = new javax.swing.JLabel();
        lblFilmeTitulo = new javax.swing.JLabel();
        lblFilmeDescricao = new javax.swing.JLabel();
        lblEstrelas = new javax.swing.JLabel();
        lblSessoes = new javax.swing.JLabel();
        jbtSelecionarAssentos = new javax.swing.JButton();
        lblClassificacao = new javax.swing.JLabel();
        lblNomeDiretor = new javax.swing.JLabel();
        lblSinopse = new javax.swing.JLabel();
        lblTracoVert = new javax.swing.JLabel();
        lblDiretor = new javax.swing.JLabel();
        lblDuracao = new javax.swing.JLabel();
        lblDuracaoMinutos = new javax.swing.JLabel();
        jbtHoje = new javax.swing.JButton();
        jbtDia1 = new javax.swing.JButton();
        jbtDia2 = new javax.swing.JButton();
        jbtDia3 = new javax.swing.JButton();
        jbtDia4 = new javax.swing.JButton();
        jbtDia5 = new javax.swing.JButton();
        jbtDia6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstSessoes = new javax.swing.JList<String>();
        jLabel1 = new javax.swing.JLabel();
        lblHomepage = new javax.swing.JLabel();
        lblMinhasReservas = new javax.swing.JLabel();
        lblMeuPerfil = new javax.swing.JLabel();
        lblLinhinha = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblDeslogar = new javax.swing.JLabel();
        lblBordaEsquerda = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(21, 17, 17));
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/icones/Tier3.png"))); // NOI18N
        lblTier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTierMouseClicked(evt);
            }
        });
        add(lblTier, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 60, 40));

        lblFilmeCapa.setOpaque(true);
        lblFilmeCapa.setPreferredSize(new java.awt.Dimension(145, 213));
        add(lblFilmeCapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, -1, -1));

        lblFilmeTitulo.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        lblFilmeTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblFilmeTitulo.setText("Harry Potter e as Relíquias da Morte pt. 2");
        add(lblFilmeTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 460, 50));

        lblFilmeDescricao.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        lblFilmeDescricao.setForeground(new java.awt.Color(255, 255, 255));
        lblFilmeDescricao.setText("<html> informações do filme informações do filme informações do filme informações do filme informações do filme informações do filme informações do filme informações do filme informações do filme informações do filme informações do filme informações do filme  informações do filme informações do filme informações do filme informações do filme  informações do filme informações do filme informações do filme informações do filme");
        lblFilmeDescricao.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        add(lblFilmeDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 610, 140));

        lblEstrelas.setFont(new java.awt.Font("Segoe UI Symbol", 2, 16)); // NOI18N
        lblEstrelas.setForeground(new java.awt.Color(153, 153, 153));
        add(lblEstrelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 170, 30));

        lblSessoes.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        lblSessoes.setForeground(new java.awt.Color(255, 255, 255));
        lblSessoes.setText("Sessões");
        add(lblSessoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 130, 90, 30));

        jbtSelecionarAssentos.setBackground(new java.awt.Color(227, 0, 0));
        jbtSelecionarAssentos.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jbtSelecionarAssentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoComprido2 (1)_1.png"))); // NOI18N
        jbtSelecionarAssentos.setText("<html><center>Selecionar assentos");
        jbtSelecionarAssentos.setBorder(null);
        jbtSelecionarAssentos.setContentAreaFilled(false);
        jbtSelecionarAssentos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtSelecionarAssentos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtSelecionarAssentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtSelecionarAssentosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtSelecionarAssentosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtSelecionarAssentosMouseExited(evt);
            }
        });
        add(jbtSelecionarAssentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 590, 260, 50));

        lblClassificacao.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblClassificacao.setForeground(new java.awt.Color(255, 255, 255));
        lblClassificacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/class12.png"))); // NOI18N
        lblClassificacao.setText("Classificação indicativa: ");
        lblClassificacao.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        add(lblClassificacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 180, 30));

        lblNomeDiretor.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblNomeDiretor.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeDiretor.setText("J.K Rowling");
        lblNomeDiretor.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblNomeDiretor.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        add(lblNomeDiretor, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, 410, 20));

        lblSinopse.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblSinopse.setForeground(new java.awt.Color(255, 255, 255));
        lblSinopse.setText("Sinopse");
        add(lblSinopse, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, 60, 30));

        lblTracoVert.setOpaque(true);
        add(lblTracoVert, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 90, 1, 570));

        lblDiretor.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblDiretor.setForeground(new java.awt.Color(255, 255, 255));
        lblDiretor.setText("Diretor:");
        lblDiretor.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblDiretor.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        add(lblDiretor, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 50, 20));

        lblDuracao.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblDuracao.setForeground(new java.awt.Color(255, 255, 255));
        lblDuracao.setText("Duração: ");
        lblDuracao.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblDuracao.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        add(lblDuracao, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 60, 20));

        lblDuracaoMinutos.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblDuracaoMinutos.setForeground(new java.awt.Color(255, 255, 255));
        lblDuracaoMinutos.setText("112 minutos");
        lblDuracaoMinutos.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblDuracaoMinutos.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        add(lblDuracaoMinutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 80, 20));

        jbtHoje.setBackground(new java.awt.Color(227, 0, 0));
        jbtHoje.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jbtHoje.setForeground(new java.awt.Color(255, 255, 255));
        jbtHoje.setText("<html><center>HOJE 07/10");
        jbtHoje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbtHoje.setContentAreaFilled(false);
        jbtHoje.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtHoje.setOpaque(true);
        jbtHoje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtHojeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtHojeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtHojeMouseExited(evt);
            }
        });
        jbtHoje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtHojeActionPerformed(evt);
            }
        });
        add(jbtHoje, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 180, 80, 50));

        jbtDia1.setBackground(new java.awt.Color(227, 0, 0));
        jbtDia1.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jbtDia1.setForeground(new java.awt.Color(255, 255, 255));
        jbtDia1.setText("<html><center>HOJE 07/10");
        jbtDia1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbtDia1.setContentAreaFilled(false);
        jbtDia1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtDia1.setOpaque(true);
        jbtDia1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtDia1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtDia1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtDia1MouseExited(evt);
            }
        });
        add(jbtDia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 230, 80, 50));

        jbtDia2.setBackground(new java.awt.Color(227, 0, 0));
        jbtDia2.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jbtDia2.setForeground(new java.awt.Color(255, 255, 255));
        jbtDia2.setText("<html><center>HOJE 07/10");
        jbtDia2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbtDia2.setContentAreaFilled(false);
        jbtDia2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtDia2.setOpaque(true);
        jbtDia2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtDia2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtDia2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtDia2MouseExited(evt);
            }
        });
        add(jbtDia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 280, 80, 50));

        jbtDia3.setBackground(new java.awt.Color(227, 0, 0));
        jbtDia3.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jbtDia3.setForeground(new java.awt.Color(255, 255, 255));
        jbtDia3.setText("<html><center>HOJE 07/10");
        jbtDia3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbtDia3.setContentAreaFilled(false);
        jbtDia3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtDia3.setOpaque(true);
        jbtDia3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtDia3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtDia3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtDia3MouseExited(evt);
            }
        });
        add(jbtDia3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 330, 80, 50));

        jbtDia4.setBackground(new java.awt.Color(227, 0, 0));
        jbtDia4.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jbtDia4.setForeground(new java.awt.Color(255, 255, 255));
        jbtDia4.setText("<html><center>HOJE 07/10");
        jbtDia4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbtDia4.setContentAreaFilled(false);
        jbtDia4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtDia4.setOpaque(true);
        jbtDia4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtDia4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtDia4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtDia4MouseExited(evt);
            }
        });
        add(jbtDia4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 380, 80, 50));

        jbtDia5.setBackground(new java.awt.Color(227, 0, 0));
        jbtDia5.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jbtDia5.setForeground(new java.awt.Color(255, 255, 255));
        jbtDia5.setText("<html><center>HOJE 07/10");
        jbtDia5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbtDia5.setContentAreaFilled(false);
        jbtDia5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtDia5.setOpaque(true);
        jbtDia5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtDia5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtDia5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtDia5MouseExited(evt);
            }
        });
        add(jbtDia5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 430, 80, 50));

        jbtDia6.setBackground(new java.awt.Color(227, 0, 0));
        jbtDia6.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jbtDia6.setForeground(new java.awt.Color(255, 255, 255));
        jbtDia6.setText("<html><center>HOJE 07/10");
        jbtDia6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbtDia6.setContentAreaFilled(false);
        jbtDia6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtDia6.setOpaque(true);
        jbtDia6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtDia6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtDia6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtDia6MouseExited(evt);
            }
        });
        add(jbtDia6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 480, 80, 50));

        lstSessoes.setBackground(new java.awt.Color(21, 17, 17));
        lstSessoes.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        lstSessoes.setForeground(new java.awt.Color(255, 255, 255));
        lstSessoes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "IMAX | Sala-2 | 14:00", "IMAX | Sala-2 | 14:00", "IMAX | Sala-2 | 14:00", "IMAX | Sala-2 | 14:00", "SALA3D | Sala-21 | 14:00", "" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstSessoes.setFixedCellHeight(50);
        lstSessoes.setName(""); // NOI18N
        lstSessoes.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(lstSessoes);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 180, 230, 350));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 170, 330, 370));

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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/fundoGigante.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 0, 1370, 770));
    }// </editor-fold>//GEN-END:initComponents

    private void jbtSelecionarAssentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSelecionarAssentosMouseClicked
        SessaoController sessaoC = new SessaoController();
        int valSelecionado = lstSessoes.getSelectedIndex();
        Long idSelecionado = this.idSessoes[valSelecionado];
        System.out.println("ID -> " + idSelecionado);
        System.out.println("AQUI ESTA" + sessaoC.buscarPorId(idSelecionado));
        try {
            FrameInicio.getFrame().setContentPane(new TelaSelecionarAssentos(cliente, sessaoC.buscarPorId(idSelecionado)));
        } catch (CadastroInexistenteException ex) {
            Logger.getLogger(TelaEntSelecionado.class.getName()).log(Level.SEVERE, null, ex);
        }
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_jbtSelecionarAssentosMouseClicked

    private void jbtSelecionarAssentosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSelecionarAssentosMouseEntered
        jbtSelecionarAssentos.setForeground(new java.awt.Color(191, 30, 30));
    }//GEN-LAST:event_jbtSelecionarAssentosMouseEntered

    private void jbtSelecionarAssentosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSelecionarAssentosMouseExited
        jbtSelecionarAssentos.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jbtSelecionarAssentosMouseExited

    private void jbtHojeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtHojeMouseClicked
        diaSelecionado(jbtHoje);
        try {
            this.initSessoes(Conversor.converterParaData(jbtHoje.getText()));
        } catch (CadastroInexistenteException ex) {
            Logger.getLogger(TelaEntSelecionado.class.getName()).log(Level.SEVERE, null, ex);
        }
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_jbtHojeMouseClicked

    private void jbtHojeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtHojeMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtHojeMouseEntered

    private void jbtHojeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtHojeMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtHojeMouseExited

    private void jbtDia1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDia1MouseClicked

        this.listarSessoes(jbtDia1);
        FrameInicio.getFrame().revalidate();

    }//GEN-LAST:event_jbtDia1MouseClicked

    private void jbtDia1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDia1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtDia1MouseEntered

    private void jbtDia1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDia1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtDia1MouseExited

    private void jbtDia2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDia2MouseClicked
        this.listarSessoes(jbtDia2);
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_jbtDia2MouseClicked

    private void jbtDia2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDia2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtDia2MouseEntered

    private void jbtDia2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDia2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtDia2MouseExited

    private void jbtDia3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDia3MouseClicked
        this.listarSessoes(jbtDia3);
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_jbtDia3MouseClicked

    private void jbtDia3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDia3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtDia3MouseEntered

    private void jbtDia3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDia3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtDia3MouseExited

    private void jbtDia4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDia4MouseClicked
        this.listarSessoes(jbtDia4);
    }//GEN-LAST:event_jbtDia4MouseClicked

    private void jbtDia4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDia4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtDia4MouseEntered

    private void jbtDia4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDia4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtDia4MouseExited

    private void jbtDia5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDia5MouseClicked
        this.listarSessoes(jbtDia5);
    }//GEN-LAST:event_jbtDia5MouseClicked

    private void jbtDia5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDia5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtDia5MouseEntered

    private void jbtDia5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDia5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtDia5MouseExited

    private void jbtDia6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDia6MouseClicked
        this.listarSessoes(jbtDia6);
    }//GEN-LAST:event_jbtDia6MouseClicked

    private void jbtDia6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDia6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtDia6MouseEntered

    private void jbtDia6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDia6MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtDia6MouseExited

    private void jbtHojeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtHojeActionPerformed

    }//GEN-LAST:event_jbtHojeActionPerformed

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

    private void lblTierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTierMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTierMouseClicked

    private void diaSelecionado(JButton jbt) {
        jbtHoje.setBackground(new java.awt.Color(102, 102, 102));
        jbtDia1.setBackground(new java.awt.Color(102, 102, 102));
        jbtDia2.setBackground(new java.awt.Color(102, 102, 102));
        jbtDia3.setBackground(new java.awt.Color(102, 102, 102));
        jbtDia4.setBackground(new java.awt.Color(102, 102, 102));
        jbtDia5.setBackground(new java.awt.Color(102, 102, 102));
        jbtDia6.setBackground(new java.awt.Color(102, 102, 102));

        jbt.setBackground(new java.awt.Color(204, 0, 0));
    }

    public void listarSessoes(JButton jbt) {
        diaSelecionado(jbt);
        try {
            this.initSessoes(Conversor.converterParaData(jbt.getText()));
        } catch (CadastroInexistenteException ex) {
            Logger.getLogger(TelaEntSelecionado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void acenderBotao(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(204, 204, 204));
    }

    private void apagarBotao(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(255, 255, 255));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtDia1;
    private javax.swing.JButton jbtDia2;
    private javax.swing.JButton jbtDia3;
    private javax.swing.JButton jbtDia4;
    private javax.swing.JButton jbtDia5;
    private javax.swing.JButton jbtDia6;
    private javax.swing.JButton jbtHoje;
    private javax.swing.JButton jbtSelecionarAssentos;
    private javax.swing.JLabel lblBordaEsquerda;
    private javax.swing.JLabel lblClassificacao;
    private javax.swing.JLabel lblDeslogar;
    private javax.swing.JLabel lblDiretor;
    private javax.swing.JLabel lblDuracao;
    private javax.swing.JLabel lblDuracaoMinutos;
    private javax.swing.JLabel lblEstrelas;
    private javax.swing.JLabel lblFilmeCapa;
    private javax.swing.JLabel lblFilmeDescricao;
    private javax.swing.JLabel lblFilmeTitulo;
    private javax.swing.JLabel lblHomepage;
    private javax.swing.JLabel lblLinhinha;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMeuPerfil;
    private javax.swing.JLabel lblMinhasReservas;
    private javax.swing.JLabel lblNomeDiretor;
    private javax.swing.JLabel lblSessoes;
    private javax.swing.JLabel lblSinopse;
    private javax.swing.JLabel lblTier;
    private javax.swing.JLabel lblTracoVert;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JList<String> lstSessoes;
    // End of variables declaration//GEN-END:variables
}
