package br.unicap.eticket.view.cliente;

import br.unicap.eticket.viewAuxiliares.VetorLocais;
import br.unicap.eticket.control.locais.LocalControl;
import br.unicap.eticket.model.locais.Cinema;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.usuarios.Cliente;
import br.unicap.eticket.view.FrameInicio;
import br.unicap.eticket.view.TelaInicio;
import br.unicap.eticket.view.jDialogs.TelaPopupConfirmar;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class TelaHomepageCliente extends javax.swing.JPanel {

    private Cliente cliente;
    private JLabel label = new JLabel();
    private int bannerAtual = 1;
    private boolean primeiraEntrada = true;

    public TelaHomepageCliente(Cliente cliente) {
        initComponents();
        this.cliente = cliente;
        lblCinemasMsg.setVisible(false);
        lblTeatrosMsg.setVisible(false);
        jpnScrollCinemas.setVisible(true);
        jpnScrollTeatro.setVisible(true);

        LocalControl localC = new LocalControl();
        List<LocalGenerico> cines = localC.todosCinemas();

        this.trocarBanner();
        if (this.primeiraEntrada) {
            if (cines.isEmpty()) {
                lblCinemasMsg.setVisible(true);
                jpnScrollCinemas.setVisible(false);
            } else {
                mostrarLocais(cines);
            }

            List<LocalGenerico> teatros = localC.todosTeatros();
            if (teatros.isEmpty()) {
                lblTeatrosMsg.setVisible(true);
                jpnScrollTeatro.setVisible(false);
            } else {
                mostrarLocais(teatros);
            }
        }
        this.primeiraEntrada = false;
        if (cliente.getNickName() != null) {
            this.lblUsername.setText("@" + cliente.getNickName());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblLinhinha = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblDeslogar = new javax.swing.JLabel();
        lblHomepage = new javax.swing.JLabel();
        lblMinhasReservas = new javax.swing.JLabel();
        lblMeuPerfil = new javax.swing.JLabel();
        lblBordaEsquerda = new javax.swing.JLabel();
        jpnScroll = new javax.swing.JScrollPane();
        jpnScrollInterno = new javax.swing.JPanel();
        jpnTopo = new javax.swing.JPanel();
        jlbBanner = new javax.swing.JLabel();
        lblTeatrosMsg = new javax.swing.JLabel();
        lblCategorias = new javax.swing.JLabel();
        lblCategoriasBar = new javax.swing.JLabel();
        jpnScrollCinemas = new javax.swing.JScrollPane();
        jpnScrollInternoCinema = new javax.swing.JPanel();
        lblCategorias1 = new javax.swing.JLabel();
        lblCategoriasBar1 = new javax.swing.JLabel();
        jpnScrollTeatro = new javax.swing.JScrollPane();
        jpnScrollInternoTeatro = new javax.swing.JPanel();
        lblCinemasMsg = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(14, 14, 14));
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        lblBordaEsquerda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/BordaEsquerda.png"))); // NOI18N
        lblBordaEsquerda.setText("jLabel3");
        add(lblBordaEsquerda, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 320, 770));

        jpnScroll.setBackground(new java.awt.Color(51, 51, 51));
        jpnScroll.setBorder(null);
        jpnScroll.setHorizontalScrollBar(null);

        jpnScrollInterno.setBackground(new java.awt.Color(21, 17, 17));
        jpnScrollInterno.setPreferredSize(new java.awt.Dimension(998, 1200));
        jpnScrollInterno.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jpnTopoLayout = new javax.swing.GroupLayout(jpnTopo);
        jpnTopo.setLayout(jpnTopoLayout);
        jpnTopoLayout.setHorizontalGroup(
            jpnTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTopoLayout.createSequentialGroup()
                .addComponent(jlbBanner, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpnTopoLayout.setVerticalGroup(
            jpnTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbBanner, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );

        jpnScrollInterno.add(jpnTopo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 170));

        lblTeatrosMsg.setFont(new java.awt.Font("Segoe UI Symbol", 2, 18)); // NOI18N
        lblTeatrosMsg.setForeground(new java.awt.Color(240, 240, 240));
        lblTeatrosMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTeatrosMsg.setText("Sem teatros cadastrados no momento!");
        jpnScrollInterno.add(lblTeatrosMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 650, 400, 30));

        lblCategorias.setBackground(new java.awt.Color(51, 51, 51));
        lblCategorias.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        lblCategorias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCategorias.setText("Cinemas");
        jpnScrollInterno.add(lblCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 230, 60));

        lblCategoriasBar.setBackground(new java.awt.Color(204, 204, 204));
        lblCategoriasBar.setForeground(new java.awt.Color(102, 102, 102));
        lblCategoriasBar.setOpaque(true);
        jpnScrollInterno.add(lblCategoriasBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 1060, 60));

        jpnScrollCinemas.setBackground(new java.awt.Color(51, 51, 51));
        jpnScrollCinemas.setBorder(null);
        jpnScrollCinemas.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jpnScrollCinemas.setPreferredSize(new java.awt.Dimension(3000, 150));

        jpnScrollInternoCinema.setBackground(new java.awt.Color(21, 17, 17));
        jpnScrollInternoCinema.setPreferredSize(new java.awt.Dimension(1020, 213));
        jpnScrollInternoCinema.setLayout(new java.awt.GridLayout(1, 10, 10, 0));
        jpnScrollCinemas.setViewportView(jpnScrollInternoCinema);

        jpnScrollInterno.add(jpnScrollCinemas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        lblCategorias1.setBackground(new java.awt.Color(51, 51, 51));
        lblCategorias1.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        lblCategorias1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCategorias1.setText("Teatros");
        jpnScrollInterno.add(lblCategorias1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 580, 230, 60));

        lblCategoriasBar1.setBackground(new java.awt.Color(204, 204, 204));
        lblCategoriasBar1.setForeground(new java.awt.Color(102, 102, 102));
        lblCategoriasBar1.setOpaque(true);
        jpnScrollInterno.add(lblCategoriasBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 1060, 60));

        jpnScrollTeatro.setBackground(new java.awt.Color(51, 51, 51));
        jpnScrollTeatro.setBorder(null);
        jpnScrollTeatro.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jpnScrollTeatro.setPreferredSize(new java.awt.Dimension(3000, 150));

        jpnScrollInternoTeatro.setBackground(new java.awt.Color(21, 17, 17));
        jpnScrollInternoTeatro.setPreferredSize(new java.awt.Dimension(1020, 213));
        jpnScrollInternoTeatro.setLayout(new java.awt.GridLayout(1, 10, 10, 0));
        jpnScrollTeatro.setViewportView(jpnScrollInternoTeatro);

        jpnScrollInterno.add(jpnScrollTeatro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 690, -1, -1));

        lblCinemasMsg.setFont(new java.awt.Font("Segoe UI Symbol", 2, 18)); // NOI18N
        lblCinemasMsg.setForeground(new java.awt.Color(240, 240, 240));
        lblCinemasMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCinemasMsg.setText("Sem cinemas cadastrados no momento!");
        jpnScrollInterno.add(lblCinemasMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 400, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/fundoGigante.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jpnScrollInterno.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-290, 170, 1366, 5000));

        jpnScroll.setViewportView(jpnScrollInterno);

        add(jpnScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 1080, 940));
    }// </editor-fold>//GEN-END:initComponents

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

    private void mostrarLocais(List<LocalGenerico> local) {

        int x = local.size();

        VetorLocais locais = new VetorLocais(local);
        locais.setCliente(cliente);
        if (x != 0) {
            if (local.get(0) instanceof Cinema) {

                if (x < 5) {
                    jpnScrollCinemas.setPreferredSize(new Dimension((223) * x, 145));
                } else {
                    jpnScrollCinemas.setPreferredSize(new Dimension(1020, 145));
                }
                jpnScrollInternoCinema.setPreferredSize(new Dimension((213 + 10) * x, 145));
                jpnScrollInternoCinema.setLayout(new GridLayout(1, 10, x, 0));

                for (int i = 0; i < x; i++) {
                    jpnScrollInternoCinema.add(locais.getLocais()[i]);
                }
            } else {

                if (x < 5) {
                    jpnScrollTeatro.setPreferredSize(new Dimension((223) * x, 145));
                } else {
                    jpnScrollTeatro.setPreferredSize(new Dimension(1020, 145));
                }
                jpnScrollInternoTeatro.setPreferredSize(new Dimension((213 + 10) * x, 145));
                jpnScrollInternoTeatro.setLayout(new GridLayout(1, 10, x, 0));

                for (int i = 0; i < x; i++) {
                    jpnScrollInternoTeatro.add(locais.getLocais()[i]);
                }
            }
        }

        FrameInicio.getFrame().revalidate();
    }

    private void trocarBanner() {
        Timer t = new Timer(5000, e -> {
            troca();
        });
        t.setInitialDelay(0);
        t.start();
    }

    private boolean troca() {
        ImageIcon im;
        Icon ic = null;
        im = new ImageIcon("src\\imagensRework\\Banner (" + this.bannerAtual + ").png");
        ic = new ImageIcon(im.getImage());
        this.bannerAtual += 1;
        if (this.bannerAtual == 5) {
            this.bannerAtual = 1;
        }
        this.jlbBanner.setIcon(ic);
        return true;
    }

    private void acenderBotao(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(204, 204, 204));
    }

    private void apagarBotao(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(255, 255, 255));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jlbBanner;
    private javax.swing.JScrollPane jpnScroll;
    private javax.swing.JScrollPane jpnScrollCinemas;
    private javax.swing.JPanel jpnScrollInterno;
    private javax.swing.JPanel jpnScrollInternoCinema;
    private javax.swing.JPanel jpnScrollInternoTeatro;
    private javax.swing.JScrollPane jpnScrollTeatro;
    private javax.swing.JPanel jpnTopo;
    private javax.swing.JLabel lblBordaEsquerda;
    private javax.swing.JLabel lblCategorias;
    private javax.swing.JLabel lblCategorias1;
    private javax.swing.JLabel lblCategoriasBar;
    private javax.swing.JLabel lblCategoriasBar1;
    private javax.swing.JLabel lblCinemasMsg;
    private javax.swing.JLabel lblDeslogar;
    private javax.swing.JLabel lblHomepage;
    private javax.swing.JLabel lblLinhinha;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMeuPerfil;
    private javax.swing.JLabel lblMinhasReservas;
    private javax.swing.JLabel lblTeatrosMsg;
    private javax.swing.JLabel lblUsername;
    // End of variables declaration//GEN-END:variables
}
