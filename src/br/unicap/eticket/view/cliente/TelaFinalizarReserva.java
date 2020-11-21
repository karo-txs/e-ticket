package br.unicap.eticket.view.cliente;

import br.unicap.eticket.controller.localAuxiliares.FachadaLocais;
import br.unicap.eticket.controller.usuarios.FachadaUsuarios;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosInvalidosException;
import br.unicap.eticket.excecoes.DadosRepetidosException;
import br.unicap.eticket.excecoes.SubiuDeTierException;
import br.unicap.eticket.model.auxiliares.Endereco;
import br.unicap.eticket.model.auxiliares.Reserva;
import br.unicap.eticket.model.locaisAuxiliares.Sessao;
import br.unicap.eticket.model.usuarios.Cliente;
import br.unicap.eticket.model.usuarios.ClienteEspecial;
import br.unicap.eticket.view.FrameInicio;
import br.unicap.eticket.view.TelaInicio;
import br.unicap.eticket.view.jDialogs.JDialogsControl;
import br.unicap.eticket.view.jDialogs.TelaPopupConfirmar;
import br.unicap.eticket.view.jDialogs.TelaPopupPagarReserva;
import br.unicap.eticket.view.jDialogs.TelaPopupQRCode;
import br.unicap.eticket.view.jDialogs.TelaPopupSubiuTier;
import java.awt.Image;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TelaFinalizarReserva extends javax.swing.JPanel {

    private Cliente cliente;
    private Sessao sessao;
    private String numCadeira;
    private Reserva reserva;

    public TelaFinalizarReserva(Cliente cliente, Sessao sessao, String numCadeira) {
        initComponents();
        this.cliente = cliente;
        this.sessao = sessao;
        this.numCadeira = numCadeira;
        initReserva();
        initLocal();
        this.initCliente();
    }

    private void initCliente() {
        
        this.lblTier.setVisible(false);
        this.lblUsername.setText("@" + cliente.getNickName());
        String img = FachadaUsuarios.getInstance().retornaImagemTier(cliente, sessao.getLocal());
        if (img != null) {
            lblTier.setVisible(true);
            lblTier.setIcon(new javax.swing.ImageIcon(getClass().getResource(img)));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtFinalizar = new javax.swing.JButton();
        lblDesconto = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();
        lblLocalCapa = new javax.swing.JLabel();
        lblFilmeCapa = new javax.swing.JLabel();
        lblAssento = new javax.swing.JLabel();
        lblNomeSala = new javax.swing.JLabel();
        lblLocalNome1 = new javax.swing.JLabel();
        lblNomeFilme = new javax.swing.JLabel();
        lblDataCompleta = new javax.swing.JLabel();
        lblSala = new javax.swing.JLabel();
        lblLocalNome = new javax.swing.JLabel();
        lblEndLocaBairroCidadeUF = new javax.swing.JLabel();
        lblEndRuaENum = new javax.swing.JLabel();
        lblTier = new javax.swing.JLabel();
        lblAsse = new javax.swing.JLabel();
        lblDat = new javax.swing.JLabel();
        lblTot = new javax.swing.JLabel();
        lblDes = new javax.swing.JLabel();
        lblPre = new javax.swing.JLabel();
        lblHor = new javax.swing.JLabel();
        lblHoraMin = new javax.swing.JLabel();
        lblSes1 = new javax.swing.JLabel();
        lblNomeSessao1 = new javax.swing.JLabel();
        jbtVoltar = new javax.swing.JButton();
        lblBack = new javax.swing.JLabel();
        lblHomepage = new javax.swing.JLabel();
        lblMinhasReservas = new javax.swing.JLabel();
        lblMeuPerfil = new javax.swing.JLabel();
        lblLinhinha = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblDeslogar = new javax.swing.JLabel();
        lblBordaEsquerda = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(21, 17, 17));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtFinalizar.setBackground(new java.awt.Color(227, 0, 0));
        jbtFinalizar.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jbtFinalizar.setForeground(new java.awt.Color(255, 255, 255));
        jbtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoComprido2 (1).png"))); // NOI18N
        jbtFinalizar.setText("Finalizar");
        jbtFinalizar.setBorder(null);
        jbtFinalizar.setContentAreaFilled(false);
        jbtFinalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtFinalizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtFinalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtFinalizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtFinalizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtFinalizarMouseExited(evt);
            }
        });
        add(jbtFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 550, 180, 40));

        lblDesconto.setFont(new java.awt.Font("Impact", 0, 16)); // NOI18N
        lblDesconto.setForeground(new java.awt.Color(255, 255, 255));
        lblDesconto.setText("10%");
        add(lblDesconto, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 510, 60, 30));

        lblTotal.setFont(new java.awt.Font("Impact", 0, 16)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblTotal.setText("R$10,00");
        add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 540, 80, 30));

        lblPreco.setFont(new java.awt.Font("Impact", 0, 16)); // NOI18N
        lblPreco.setForeground(new java.awt.Color(255, 255, 255));
        lblPreco.setText("R$13,50");
        add(lblPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 490, 80, 30));

        lblLocalCapa.setOpaque(true);
        lblLocalCapa.setPreferredSize(new java.awt.Dimension(145, 213));
        add(lblLocalCapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, 213, 145));

        lblFilmeCapa.setOpaque(true);
        lblFilmeCapa.setPreferredSize(new java.awt.Dimension(145, 213));
        add(lblFilmeCapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 260, -1, -1));

        lblAssento.setFont(new java.awt.Font("Impact", 0, 16)); // NOI18N
        lblAssento.setForeground(new java.awt.Color(255, 255, 255));
        lblAssento.setText("A1");
        add(lblAssento, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 470, 70, 30));

        lblNomeSala.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblNomeSala.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeSala.setText("Sala1");
        add(lblNomeSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 470, 80, 30));

        lblLocalNome1.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        lblLocalNome1.setForeground(new java.awt.Color(255, 255, 255));
        lblLocalNome1.setText("Finalização de Reserva");
        add(lblLocalNome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 360, 30));

        lblNomeFilme.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblNomeFilme.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeFilme.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomeFilme.setText("Nome do filme");
        add(lblNomeFilme, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 230, 240, 30));

        lblDataCompleta.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblDataCompleta.setForeground(new java.awt.Color(255, 255, 255));
        lblDataCompleta.setText("30/10/2020");
        add(lblDataCompleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 510, 90, 30));

        lblSala.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblSala.setForeground(new java.awt.Color(255, 255, 255));
        lblSala.setText("Sala :");
        add(lblSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 470, 60, 30));

        lblLocalNome.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblLocalNome.setForeground(new java.awt.Color(255, 255, 255));
        lblLocalNome.setText("Nome");
        add(lblLocalNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, 170, 30));

        lblEndLocaBairroCidadeUF.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        lblEndLocaBairroCidadeUF.setForeground(new java.awt.Color(255, 255, 255));
        lblEndLocaBairroCidadeUF.setText("Bairro CIdade Uf");
        add(lblEndLocaBairroCidadeUF, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 430, 250, 20));

        lblEndRuaENum.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        lblEndRuaENum.setForeground(new java.awt.Color(255, 255, 255));
        lblEndRuaENum.setText("Rua e num");
        add(lblEndRuaENum, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 410, 250, 20));

        lblTier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/icones/Tier3.png"))); // NOI18N
        lblTier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTierMouseClicked(evt);
            }
        });
        add(lblTier, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 60, 40));

        lblAsse.setFont(new java.awt.Font("Impact", 0, 16)); // NOI18N
        lblAsse.setForeground(new java.awt.Color(255, 255, 255));
        lblAsse.setText("Assento:");
        add(lblAsse, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 470, 80, 30));

        lblDat.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblDat.setForeground(new java.awt.Color(255, 255, 255));
        lblDat.setText("Data:");
        add(lblDat, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 510, 60, 30));

        lblTot.setFont(new java.awt.Font("Impact", 0, 16)); // NOI18N
        lblTot.setForeground(new java.awt.Color(255, 255, 255));
        lblTot.setText("Total:");
        add(lblTot, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 540, 40, 30));

        lblDes.setFont(new java.awt.Font("Impact", 0, 16)); // NOI18N
        lblDes.setForeground(new java.awt.Color(255, 255, 255));
        lblDes.setText("Desconto:");
        add(lblDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 510, 70, 30));

        lblPre.setFont(new java.awt.Font("Impact", 0, 16)); // NOI18N
        lblPre.setForeground(new java.awt.Color(255, 255, 255));
        lblPre.setText("Valor Do Ingresso:");
        add(lblPre, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 490, 160, 30));

        lblHor.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblHor.setForeground(new java.awt.Color(255, 255, 255));
        lblHor.setText("Horário:");
        add(lblHor, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 530, 60, 30));

        lblHoraMin.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblHoraMin.setForeground(new java.awt.Color(255, 255, 255));
        lblHoraMin.setText("12:45");
        add(lblHoraMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 530, 80, 30));

        lblSes1.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblSes1.setForeground(new java.awt.Color(255, 255, 255));
        lblSes1.setText("Sessão:");
        add(lblSes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 490, 60, 30));

        lblNomeSessao1.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblNomeSessao1.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeSessao1.setText("Sessão03");
        add(lblNomeSessao1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 490, 180, 30));

        jbtVoltar.setBackground(new java.awt.Color(227, 0, 0));
        jbtVoltar.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jbtVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoCompridoRetorno.png"))); // NOI18N
        jbtVoltar.setText("Voltar");
        jbtVoltar.setBorder(null);
        jbtVoltar.setContentAreaFilled(false);
        jbtVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtVoltar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtVoltarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtVoltarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtVoltarMouseExited(evt);
            }
        });
        add(jbtVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 560, 160, 60));

        lblBack.setBackground(new java.awt.Color(153, 0, 0));
        lblBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/FundoTicketDeitado.png"))); // NOI18N
        add(lblBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 780, 450));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/fundoGigante.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 0, 1370, 770));
    }// </editor-fold>//GEN-END:initComponents

    private void initReserva() {
        DateFormat df = new SimpleDateFormat("HH:mm");
        DateFormat dfDia = new SimpleDateFormat("dd/MM/yyyy");
        double[] ingresso = null;
        try {
            reserva = new Reserva(sessao, numCadeira);
        } catch (CadastroInexistenteException ex) {
            JDialogsControl.mostrarPopUp(ex.getMessage(), true);
        }
        
        lblNomeFilme.setText(this.sessao.getEntretenimento().getNome());
        lblNomeSala.setText(this.sessao.getSala().getNome());
        lblNomeSessao1.setText(this.sessao.getNome());
        lblAssento.setText(this.sessao.getNome());
        lblHoraMin.setText(df.format(this.sessao.getDataInicial().getTime()));
        lblDataCompleta.setText(dfDia.format(this.sessao.getDataInicial().getTime()));
        lblAssento.setText(numCadeira);

        ingresso = FachadaLocais.getInstance().mostrarIngresso(cliente, reserva);
        lblTotal.setText(String.format("R$ %.2f", ingresso[0]));
        lblPreco.setText(String.format("R$ %.2f", ingresso[1]));
        lblDesconto.setText(String.format("%.2f%%", ingresso[2] * 100));

        Image im = new ImageIcon(this.sessao.getEntretenimento().getCapa()).getImage();
        Icon ic = new ImageIcon(im);
        lblFilmeCapa.setIcon(ic);
    }

    private void initLocal() {
        lblLocalNome.setText(this.reserva.getSessao().getLocal().getNome());
        Endereco end = this.sessao.getLocal().getEndereco();
        lblEndRuaENum.setText(end.getLogradouro() + ", " + end.getNum());
        lblEndLocaBairroCidadeUF.setText(end.getBairro() + ", " + end.getCidade() + ", " + end.getUf());
        Image im = new ImageIcon(this.sessao.getLocal().getCapa()).getImage();
        Icon ic = new ImageIcon(im);
        lblLocalCapa.setIcon(ic);
    }

    private void jbtFinalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFinalizarMouseClicked
        
        try {
            Reserva rFeita = FachadaUsuarios.getInstance().fazerReserva(cliente, sessao, numCadeira); 

            TelaPopupPagarReserva ppPagar = new TelaPopupPagarReserva(FrameInicio.getFrame(), true, cliente, this.reserva);
            ppPagar.setLocationRelativeTo(null);
            ppPagar.setVisible(true);
            cliente = ppPagar.getCliente(); 

            if (ppPagar.getConfirmarAcao()) {
                try {
                    double valor = FachadaUsuarios.getInstance().pagaReserva(cliente, rFeita);
                } catch (SubiuDeTierException ex) {
                    JDialogsControl.mostrarPopUp(new TelaPopupSubiuTier(FrameInicio.getFrame(), true, (ClienteEspecial) cliente,
                            this.reserva.getSessao().getLocal()));
                }

                
                cliente = FachadaUsuarios.getInstance().buscar(cliente);

                TelaPopupQRCode ppQrCode = new TelaPopupQRCode(FrameInicio.getFrame(), true, rFeita.getQrCode(), cliente);
                ppQrCode.setLocationRelativeTo(null);
                ppQrCode.setVisible(true);
            } else {
                FachadaUsuarios.getInstance().cancelarReserva(cliente, rFeita);
                JDialogsControl.mostrarPopUp("Operação Cancelada!", true);
            }
        } catch (CadastroInexistenteException | DadosRepetidosException | DadosInvalidosException ex) {
            JDialogsControl.mostrarPopUp(ex.getMessage(), true);
        }
    }//GEN-LAST:event_jbtFinalizarMouseClicked

    private void jbtFinalizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFinalizarMouseEntered
        jbtFinalizar.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jbtFinalizarMouseEntered

    private void jbtFinalizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFinalizarMouseExited
        jbtFinalizar.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jbtFinalizarMouseExited

    private void jbtVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtVoltarMouseClicked
        try {
            FrameInicio.getFrame().setContentPane(new TelaSelecionarAssentos(cliente, sessao));
            FrameInicio.getFrame().revalidate();
        } catch (CadastroInexistenteException ex) {
            Logger.getLogger(TelaFinalizarReserva.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jbtVoltarMouseClicked

    private void jbtVoltarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtVoltarMouseEntered
        jbtVoltar.setForeground(new java.awt.Color(191, 30, 30));
    }//GEN-LAST:event_jbtVoltarMouseEntered

    private void jbtVoltarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtVoltarMouseExited
        jbtVoltar.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jbtVoltarMouseExited

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

    private void acenderBotao(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(204, 204, 204));
    }

    private void apagarBotao(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(255, 255, 255));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbtFinalizar;
    private javax.swing.JButton jbtVoltar;
    private javax.swing.JLabel lblAsse;
    private javax.swing.JLabel lblAssento;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblBordaEsquerda;
    private javax.swing.JLabel lblDat;
    private javax.swing.JLabel lblDataCompleta;
    private javax.swing.JLabel lblDes;
    private javax.swing.JLabel lblDesconto;
    private javax.swing.JLabel lblDeslogar;
    private javax.swing.JLabel lblEndLocaBairroCidadeUF;
    private javax.swing.JLabel lblEndRuaENum;
    private javax.swing.JLabel lblFilmeCapa;
    private javax.swing.JLabel lblHomepage;
    private javax.swing.JLabel lblHor;
    private javax.swing.JLabel lblHoraMin;
    private javax.swing.JLabel lblLinhinha;
    private javax.swing.JLabel lblLocalCapa;
    private javax.swing.JLabel lblLocalNome;
    private javax.swing.JLabel lblLocalNome1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMeuPerfil;
    private javax.swing.JLabel lblMinhasReservas;
    private javax.swing.JLabel lblNomeFilme;
    private javax.swing.JLabel lblNomeSala;
    private javax.swing.JLabel lblNomeSessao1;
    private javax.swing.JLabel lblPre;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblSala;
    private javax.swing.JLabel lblSes1;
    private javax.swing.JLabel lblTier;
    private javax.swing.JLabel lblTot;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblUsername;
    // End of variables declaration//GEN-END:variables
}
