package br.unicap.eticket.view.jDialogs;

import br.unicap.eticket.controller.localAuxiliares.ReservaController;
import br.unicap.eticket.controller.usuarios.ClienteController;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosFinanceirosInvalidosException;
import br.unicap.eticket.model.auxiliares.Reserva;
import br.unicap.eticket.model.usuarios.Cliente;
import br.unicap.eticket.model.usuarios.financeiro.DadosFinanceirosCliente;
import java.awt.Color;
import java.util.Calendar;

public class TelaPopupPagarReserva extends javax.swing.JDialog {

    private Cliente cliente;
    private Reserva reserva;
    private boolean confirmarAcao;

    public TelaPopupPagarReserva(java.awt.Frame parent, boolean modal, Cliente cliente, Reserva reserva) {
        super(parent, modal);
        initComponents();
        confirmarAcao = false;
        this.cliente = cliente;
        this.reserva = reserva;
        this.initDados();
        this.trocarEditable();
        this.setBackground(new java.awt.Color(0, 0, 0, 0));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTotal = new javax.swing.JLabel();
        lblTotalApagar = new javax.swing.JLabel();
        fldCod = new javax.swing.JTextField();
        jcbMes = new javax.swing.JComboBox<String>();
        jcbAno = new javax.swing.JComboBox<String>();
        lblData = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        fldNomeNoCartao = new javax.swing.JTextField();
        jbtAlterarDados = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        lblNum = new javax.swing.JLabel();
        fldNumeroCartao = new javax.swing.JTextField();
        lblLinhaDadP = new javax.swing.JLabel();
        jbtNao = new javax.swing.JButton();
        jbtSim = new javax.swing.JButton();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTotal.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblTotal.setText("R$20,00");
        getContentPane().add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 100, 30));

        lblTotalApagar.setFont(new java.awt.Font("Impact", 0, 16)); // NOI18N
        lblTotalApagar.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalApagar.setText("Total a pagar:");
        getContentPane().add(lblTotalApagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 100, 30));

        fldCod.setBackground(new java.awt.Color(204, 204, 204));
        fldCod.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldCod.setForeground(new java.awt.Color(102, 102, 102));
        fldCod.setPreferredSize(new java.awt.Dimension(302, 38));
        getContentPane().add(fldCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 50, 20));

        jcbMes.setBackground(new java.awt.Color(204, 204, 204));
        jcbMes.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        jcbMes.setForeground(new java.awt.Color(102, 102, 102));
        jcbMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-    Mês   -", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        getContentPane().add(jcbMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 80, -1));

        jcbAno.setBackground(new java.awt.Color(204, 204, 204));
        jcbAno.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        jcbAno.setForeground(new java.awt.Color(102, 102, 102));
        jcbAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-    Ano   -", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028" }));
        getContentPane().add(jcbAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 80, -1));

        lblData.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblData.setForeground(new java.awt.Color(255, 255, 255));
        lblData.setText("Data se Expiração");
        getContentPane().add(lblData, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 100, -1));

        lblCodigo.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblCodigo.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigo.setText("Código de segurança");
        getContentPane().add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 130, -1));

        fldNomeNoCartao.setBackground(new java.awt.Color(204, 204, 204));
        fldNomeNoCartao.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldNomeNoCartao.setForeground(new java.awt.Color(102, 102, 102));
        fldNomeNoCartao.setPreferredSize(new java.awt.Dimension(302, 38));
        getContentPane().add(fldNomeNoCartao, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 250, 20));

        jbtAlterarDados.setBackground(new java.awt.Color(255, 255, 255));
        jbtAlterarDados.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jbtAlterarDados.setForeground(new java.awt.Color(255, 255, 255));
        jbtAlterarDados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoCompridoEdicao.png"))); // NOI18N
        jbtAlterarDados.setText("Editar");
        jbtAlterarDados.setBorder(null);
        jbtAlterarDados.setContentAreaFilled(false);
        jbtAlterarDados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtAlterarDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtAlterarDadosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtAlterarDadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtAlterarDadosMouseExited(evt);
            }
        });
        jbtAlterarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAlterarDadosActionPerformed(evt);
            }
        });
        getContentPane().add(jbtAlterarDados, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 200, 40));

        lblNome.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("Nome no Cartão");
        getContentPane().add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 100, -1));

        lblNum.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblNum.setForeground(new java.awt.Color(255, 255, 255));
        lblNum.setText("Número do cartão");
        getContentPane().add(lblNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 100, -1));

        fldNumeroCartao.setBackground(new java.awt.Color(204, 204, 204));
        fldNumeroCartao.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldNumeroCartao.setForeground(new java.awt.Color(102, 102, 102));
        fldNumeroCartao.setPreferredSize(new java.awt.Dimension(302, 38));
        getContentPane().add(fldNumeroCartao, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 250, 20));

        lblLinhaDadP.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Financeiros", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Impact", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        getContentPane().add(lblLinhaDadP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 460, 160));

        jbtNao.setBackground(new java.awt.Color(227, 0, 0));
        jbtNao.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jbtNao.setForeground(new java.awt.Color(0, 0, 0));
        jbtNao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoComprido (1).png"))); // NOI18N
        jbtNao.setText("Cancelar");
        jbtNao.setBorder(null);
        jbtNao.setContentAreaFilled(false);
        jbtNao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtNao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtNao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtNaoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtNaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtNaoMouseExited(evt);
            }
        });
        jbtNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtNaoActionPerformed(evt);
            }
        });
        getContentPane().add(jbtNao, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 200, 40));

        jbtSim.setBackground(new java.awt.Color(227, 0, 0));
        jbtSim.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jbtSim.setForeground(new java.awt.Color(0, 0, 0));
        jbtSim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoComprido (1).png"))); // NOI18N
        jbtSim.setText("Concluir Pagamento");
        jbtSim.setBorder(null);
        jbtSim.setContentAreaFilled(false);
        jbtSim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtSim.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtSim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtSimMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtSimMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtSimMouseExited(evt);
            }
        });
        getContentPane().add(jbtSim, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 200, 40));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/fundos/FundoAvaliacao.png"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initDados() {
        DadosFinanceirosCliente dados = cliente.getDadosFinanceiros();
        if (dados.getDataExpiracao() != null) {
            jcbAno.setSelectedItem(String.valueOf(dados.getDataExpiracao().get(Calendar.YEAR)));
            jcbMes.setSelectedIndex(dados.getDataExpiracao().get(Calendar.MONTH) + 1);
            fldNumeroCartao.setText(dados.getNumero());
            fldNomeNoCartao.setText(dados.getNomeNoCartao());
            fldCod.setText(String.valueOf(dados.getCodigoSeguranca()));

            double total;
            if (cliente.isEspecial()) {
                ReservaController rv = new ReservaController();
                double[] ingresso = rv.mostrarIngresso(cliente, reserva);
                total = ingresso[0];
                //double desconto = this.reserva.getValorIngresso() * clienteE.getDesconto(this.reserva.getSessao().getLocal());
                //total = this.reserva.getValorIngresso() - desconto;
                lblTotal.setText(String.format("R$%.2f", total));
            } else {
                total = this.reserva.getValorIngresso();
                lblTotal.setText(String.format("R$%.2f", total));
            }
        }
    }

    public boolean getConfirmarAcao() {
        return this.confirmarAcao;
    }

    private void jbtSimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSimMouseClicked
        if (this.dadosCompletos()) {
            this.confirmarAcao = true;
            this.dispose();
        } else {
            JDialogsControl.mostrarPopUp("Dados Incompletos", true);
        }
    }//GEN-LAST:event_jbtSimMouseClicked

    private void jbtSimMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSimMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtSimMouseEntered

    private void jbtSimMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSimMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtSimMouseExited

    private void jbtAlterarDadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAlterarDadosMouseClicked
        ClienteController clienteC = new ClienteController();
        if (jbtAlterarDados.getText().equalsIgnoreCase("Salvar")) {
            Calendar data = Calendar.getInstance();
            if (jcbAno.getSelectedIndex() != -1 && jcbMes.getSelectedIndex() != -1) {
                data.set(Calendar.YEAR, Integer.parseInt(jcbAno.getSelectedItem().toString()));
                data.set(Calendar.MONTH, jcbMes.getSelectedIndex() - 1);
                try {
                    clienteC.preencherDadosFinanceiros(cliente,fldNumeroCartao.getText(), fldNomeNoCartao.getText(),
                            data, Integer.parseInt(fldCod.getText()));
                    cliente = clienteC.buscar(cliente);
                } catch (DadosFinanceirosInvalidosException | CadastroInexistenteException ex) {
                    JDialogsControl.mostrarPopUp(ex.getMessage(), true);
                }
            } else {
                 JDialogsControl.mostrarPopUp("Data de expiração não selecionada!", true);
            }
        }
        trocarNome();
        trocarEditable();
    }//GEN-LAST:event_jbtAlterarDadosMouseClicked

    private void jbtAlterarDadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAlterarDadosMouseEntered
        jbtAlterarDados.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_jbtAlterarDadosMouseEntered

    private void jbtAlterarDadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAlterarDadosMouseExited
        jbtAlterarDados.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_jbtAlterarDadosMouseExited

    private void jbtAlterarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAlterarDadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtAlterarDadosActionPerformed

    private void jbtNaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtNaoMouseClicked
        this.confirmarAcao = false;
        this.dispose();
    }//GEN-LAST:event_jbtNaoMouseClicked

    private void jbtNaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtNaoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtNaoMouseEntered

    private void jbtNaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtNaoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtNaoMouseExited

    private void jbtNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtNaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtNaoActionPerformed
    private void trocarNome() {
        jbtAlterarDados.setText(jbtAlterarDados.getText().equalsIgnoreCase("Editar") ? "Salvar" : "Editar");
    }

    private void trocarEditable() {
        jcbAno.setEnabled(!jcbAno.isEnabled());
        jcbMes.setEnabled(!jcbMes.isEnabled());
        fldNumeroCartao.setEditable(!fldNumeroCartao.isEditable());
        fldNomeNoCartao.setEditable(!fldNomeNoCartao.isEditable());
        fldCod.setEditable(!fldCod.isEditable());
    }

    private boolean dadosCompletos() {
        return jcbAno.getSelectedIndex() != -1 && jcbMes.getSelectedIndex() != -1 && !fldNomeNoCartao.getText().equals("")
                && !fldNomeNoCartao.getText().equals("") && !fldCod.getText().equals("");
    }

    public Cliente getCliente() {
        return cliente;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fldCod;
    private javax.swing.JTextField fldNomeNoCartao;
    private javax.swing.JTextField fldNumeroCartao;
    private javax.swing.JButton jbtAlterarDados;
    private javax.swing.JButton jbtNao;
    private javax.swing.JButton jbtSim;
    private javax.swing.JComboBox<String> jcbAno;
    private javax.swing.JComboBox<String> jcbMes;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblLinhaDadP;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNum;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalApagar;
    // End of variables declaration//GEN-END:variables
}
