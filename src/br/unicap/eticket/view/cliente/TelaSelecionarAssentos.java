package br.unicap.eticket.view.cliente;

import br.unicap.eticket.controller.usuarios.ClienteController;
import br.unicap.eticket.viewAuxiliares.MatrizCadeiras;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.model.locaisAuxiliares.Sessao;
import br.unicap.eticket.model.usuarios.Cliente;
import br.unicap.eticket.view.FrameInicio;
import br.unicap.eticket.view.TelaInicio;
import br.unicap.eticket.view.jDialogs.JDialogsControl;
import br.unicap.eticket.view.jDialogs.TelaPopupConfirmar;
import java.awt.GridLayout;
import java.util.HashMap;
import javax.swing.JLabel;

public class TelaSelecionarAssentos extends javax.swing.JPanel {

    private Cliente cliente;
    private Sessao sessao;
    private HashMap<String, Boolean> ocupacao;
    MatrizCadeiras assentos;

    public TelaSelecionarAssentos(Cliente cliente, Sessao sessao) throws CadastroInexistenteException {
        initComponents();
        this.sessao = sessao;
        this.cliente = cliente;
        this.ocupacao = sessao.ocupacaoDeAssentosDaSessao();
        this.gerarAssentos(sessao.getSala().getFileirasX(), sessao.getSala().getFileirasY());
        this.initCliente();
    }

    private void initCliente() {
        ClienteController cc = new ClienteController();
        this.lblTier1.setVisible(false);
        this.lblUsername.setText("@" + cliente.getNickName());
        String img = cc.retornaImagemTier(cliente, this.sessao.getLocal());
        if (img != null) {
            lblTier1.setVisible(true);
            lblTier1.setIcon(new javax.swing.ImageIcon(getClass().getResource(img)));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtSelecionarAssento = new javax.swing.JButton();
        jpnAssentos = new javax.swing.JPanel();
        lblFilmeTitulo = new javax.swing.JLabel();
        lblTier1 = new javax.swing.JLabel();
        lblTela = new javax.swing.JLabel();
        jpnHorz = new javax.swing.JPanel();
        jpnVert = new javax.swing.JPanel();
        lblVerHorz = new javax.swing.JLabel();
        lblHomepage = new javax.swing.JLabel();
        lblMinhasReservas = new javax.swing.JLabel();
        lblMeuPerfil = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblLinhinha = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblDeslogar = new javax.swing.JLabel();
        lblBordaEsquerda = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(21, 17, 17));
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtSelecionarAssento.setBackground(new java.awt.Color(227, 0, 0));
        jbtSelecionarAssento.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jbtSelecionarAssento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoComprido (1).png"))); // NOI18N
        jbtSelecionarAssento.setText("Continuar");
        jbtSelecionarAssento.setBorder(null);
        jbtSelecionarAssento.setContentAreaFilled(false);
        jbtSelecionarAssento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtSelecionarAssento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtSelecionarAssento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtSelecionarAssentoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtSelecionarAssentoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtSelecionarAssentoMouseExited(evt);
            }
        });
        add(jbtSelecionarAssento, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 640, 200, 60));

        jpnAssentos.setLayout(new java.awt.GridLayout(5, 5, 10, 10));
        add(jpnAssentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 970, 510));

        lblFilmeTitulo.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        lblFilmeTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblFilmeTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFilmeTitulo.setText("Selecionar assento");
        add(lblFilmeTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 1000, 50));

        lblTier1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/icones/Tier3.png"))); // NOI18N
        lblTier1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTier1MouseClicked(evt);
            }
        });
        add(lblTier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 60, 40));

        lblTela.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        lblTela.setForeground(new java.awt.Color(21, 17, 17));
        lblTela.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTela.setText("T        E        L        A");
        lblTela.setOpaque(true);
        add(lblTela, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 610, 620, 40));

        jpnHorz.setForeground(new java.awt.Color(102, 102, 102));
        jpnHorz.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        add(jpnHorz, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 580, 970, 30));

        jpnVert.setForeground(new java.awt.Color(102, 102, 102));
        jpnVert.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        add(jpnVert, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 30, 510));

        lblVerHorz.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        lblVerHorz.setForeground(new java.awt.Color(21, 17, 17));
        lblVerHorz.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVerHorz.setOpaque(true);
        add(lblVerHorz, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 580, 30, 30));

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

        lblUsername.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("@Cliente");
        lblUsername.setToolTipText("");
        add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 140, 40));

        lblLinhinha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/linhinha.png"))); // NOI18N
        add(lblLinhinha, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 150, 360, 20));

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

    private void gerarAssentos(int x, int y) {

        jpnAssentos.setLayout(new GridLayout(x, y));
        jpnVert.setLayout(new GridLayout(x, 1));
        jpnHorz.setLayout(new GridLayout(1, y));

        assentos = new MatrizCadeiras(x, y, ocupacao);
        assentos.mostrarCadeiras(jpnAssentos,jpnVert,jpnHorz);

        FrameInicio.getFrame().revalidate();

    }
    private void jbtSelecionarAssentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSelecionarAssentoMouseClicked
        FrameInicio.getFrame().setContentPane(new TelaFinalizarReserva(cliente, sessao, assentos.getAtual().getName()));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_jbtSelecionarAssentoMouseClicked

    private void jbtSelecionarAssentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSelecionarAssentoMouseEntered
        jbtSelecionarAssento.setForeground(new java.awt.Color(191, 30, 30));
    }//GEN-LAST:event_jbtSelecionarAssentoMouseEntered

    private void jbtSelecionarAssentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSelecionarAssentoMouseExited
        jbtSelecionarAssento.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jbtSelecionarAssentoMouseExited

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

    private void lblTier1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTier1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTier1MouseClicked

    private void acenderBotao(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(204, 204, 204));
    }

    private void apagarBotao(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(255, 255, 255));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbtSelecionarAssento;
    private javax.swing.JPanel jpnAssentos;
    private javax.swing.JPanel jpnHorz;
    private javax.swing.JPanel jpnVert;
    private javax.swing.JLabel lblBordaEsquerda;
    private javax.swing.JLabel lblDeslogar;
    private javax.swing.JLabel lblFilmeTitulo;
    private javax.swing.JLabel lblHomepage;
    private javax.swing.JLabel lblLinhinha;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMeuPerfil;
    private javax.swing.JLabel lblMinhasReservas;
    private javax.swing.JLabel lblTela;
    private javax.swing.JLabel lblTier;
    private javax.swing.JLabel lblTier1;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblVerHorz;
    // End of variables declaration//GEN-END:variables
}
