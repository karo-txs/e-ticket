package br.unicap.eticket.view.admin;

import br.unicap.eticket.control.usuarios.AdminControl;
import br.unicap.eticket.control.validacoes.Conversor;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosInvalidosException;
import br.unicap.eticket.excecoes.DadosRepetidosException;
import br.unicap.eticket.excecoes.SenhaInvalidaException;
import br.unicap.eticket.model.auxiliares.Endereco;
import br.unicap.eticket.model.locais.Cinema;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.locais.Teatro;
import br.unicap.eticket.model.usuarios.Admin;
import br.unicap.eticket.view.FrameInicio;
import br.unicap.eticket.view.TelaInicio;
import br.unicap.eticket.view.jDialogs.CapturarCapa;
import br.unicap.eticket.view.jDialogs.JDialogsControl;
import java.awt.Color;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaCadastrarLocal extends javax.swing.JPanel {

    private CapturarCapa captura = new CapturarCapa();
    private Admin adm;

    public TelaCadastrarLocal(Admin adm) {
        initComponents();
        this.adm = adm;
        lblEntrar.setText("Bem-vindo(a), " + adm.getNome());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEntrar = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
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
        fldNomeDoLocal = new javax.swing.JTextField();
        jcbCategoria = new javax.swing.JComboBox<String>();
        jbtEntrar = new javax.swing.JButton();
        lblCategoria = new javax.swing.JLabel();
        jbtSelecionarImg = new javax.swing.JButton();
        jbtLocalizarCEP = new javax.swing.JButton();
        lblLinhaCadLocal = new javax.swing.JLabel();
        fldNum = new javax.swing.JTextField();
        fldCEP = new javax.swing.JTextField();
        lblCEP = new javax.swing.JLabel();
        lblLinhaEnd = new javax.swing.JLabel();
        lblBackCine = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEntrar.setBackground(new java.awt.Color(255, 255, 255));
        lblEntrar.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        lblEntrar.setForeground(new java.awt.Color(255, 255, 255));
        lblEntrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEntrar.setText("Bem-vindo, [nome do admin]!");
        add(lblEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 970, 90));

        lblNome.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("Nome do Local");
        add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 120, 30));

        fldRua.setBackground(new java.awt.Color(204, 204, 204));
        fldRua.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldRua.setForeground(new java.awt.Color(102, 102, 102));
        fldRua.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, 280, 20));

        lblRua.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblRua.setForeground(new java.awt.Color(255, 255, 255));
        lblRua.setText("Rua");
        add(lblRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 290, -1, -1));

        fldCidade.setBackground(new java.awt.Color(204, 204, 204));
        fldCidade.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldCidade.setForeground(new java.awt.Color(102, 102, 102));
        fldCidade.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 370, 280, 20));

        lblCidade.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblCidade.setForeground(new java.awt.Color(255, 255, 255));
        lblCidade.setText("Cidade");
        add(lblCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 350, -1, -1));

        fldBairro.setBackground(new java.awt.Color(204, 204, 204));
        fldBairro.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldBairro.setForeground(new java.awt.Color(102, 102, 102));
        fldBairro.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 430, 280, 20));

        lblBairro.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblBairro.setForeground(new java.awt.Color(255, 255, 255));
        lblBairro.setText("Bairro");
        add(lblBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 410, -1, -1));

        lblNum.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblNum.setForeground(new java.awt.Color(255, 255, 255));
        lblNum.setText("Nº");
        add(lblNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 470, -1, -1));

        fldUF.setBackground(new java.awt.Color(204, 204, 204));
        fldUF.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldUF.setForeground(new java.awt.Color(102, 102, 102));
        fldUF.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldUF, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 490, 120, 20));

        lblUF.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblUF.setForeground(new java.awt.Color(255, 255, 255));
        lblUF.setText("UF");
        add(lblUF, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 470, -1, -1));

        fldComplemento.setBackground(new java.awt.Color(204, 204, 204));
        fldComplemento.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldComplemento.setForeground(new java.awt.Color(102, 102, 102));
        fldComplemento.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 550, 280, 20));

        lblComplemento.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblComplemento.setForeground(new java.awt.Color(255, 255, 255));
        lblComplemento.setText("Complemento");
        add(lblComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 530, -1, -1));

        fldPais.setBackground(new java.awt.Color(204, 204, 204));
        fldPais.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldPais.setForeground(new java.awt.Color(102, 102, 102));
        fldPais.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 610, 280, 20));

        lblPais.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblPais.setForeground(new java.awt.Color(255, 255, 255));
        lblPais.setText("País");
        add(lblPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 590, -1, -1));

        fldNomeDoLocal.setBackground(new java.awt.Color(204, 204, 204));
        fldNomeDoLocal.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldNomeDoLocal.setForeground(new java.awt.Color(102, 102, 102));
        fldNomeDoLocal.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldNomeDoLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 250, 20));

        jcbCategoria.setBackground(new java.awt.Color(240, 240, 240));
        jcbCategoria.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        jcbCategoria.setForeground(new java.awt.Color(102, 102, 102));
        jcbCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-   Selecione  -", "Cinema", "Teatro" }));
        add(jcbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 250, 20));

        jbtEntrar.setBackground(new java.awt.Color(227, 0, 0));
        jbtEntrar.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jbtEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoComprido (1).png"))); // NOI18N
        jbtEntrar.setText("Cadastrar  Local");
        jbtEntrar.setBorder(null);
        jbtEntrar.setContentAreaFilled(false);
        jbtEntrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtEntrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtEntrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtEntrarMouseExited(evt);
            }
        });
        add(jbtEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 590, 200, 40));

        lblCategoria.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblCategoria.setForeground(new java.awt.Color(255, 255, 255));
        lblCategoria.setText("Categoria");
        add(lblCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 80, 20));

        jbtSelecionarImg.setBackground(new java.awt.Color(227, 0, 0));
        jbtSelecionarImg.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jbtSelecionarImg.setForeground(new java.awt.Color(255, 255, 255));
        jbtSelecionarImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/botoes/BotaoCompridoEdicao.png"))); // NOI18N
        jbtSelecionarImg.setText("Selecionar Capa");
        jbtSelecionarImg.setBorder(null);
        jbtSelecionarImg.setContentAreaFilled(false);
        jbtSelecionarImg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtSelecionarImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtSelecionarImgMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtSelecionarImgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtSelecionarImgMouseExited(evt);
            }
        });
        jbtSelecionarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSelecionarImgActionPerformed(evt);
            }
        });
        add(jbtSelecionarImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, 200, -1));

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
        add(jbtLocalizarCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 240, 160, 30));

        lblLinhaCadLocal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastrar Local", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Impact", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        add(lblLinhaCadLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 310, 460));

        fldNum.setBackground(new java.awt.Color(204, 204, 204));
        fldNum.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldNum.setForeground(new java.awt.Color(102, 102, 102));
        fldNum.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 490, 120, 20));

        fldCEP.setBackground(new java.awt.Color(204, 204, 204));
        fldCEP.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fldCEP.setForeground(new java.awt.Color(102, 102, 102));
        fldCEP.setPreferredSize(new java.awt.Dimension(302, 38));
        add(fldCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 250, 140, 20));

        lblCEP.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblCEP.setForeground(new java.awt.Color(255, 255, 255));
        lblCEP.setText("Digite Seu CEP");
        add(lblCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 230, -1, -1));

        lblLinhaEnd.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Impact", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        add(lblLinhaEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 190, 330, 460));

        lblBackCine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensRework/telas/TelaCadastro.png"))); // NOI18N
        add(lblBackCine, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));
    }// </editor-fold>//GEN-END:initComponents

    private void jbtEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtEntrarMouseClicked
        AdminControl admC = new AdminControl();
        Endereco end = new Endereco(fldCEP.getText(), fldUF.getText(), fldCidade.getText(),
                fldBairro.getText(), fldRua.getText(), fldNum.getText(), fldComplemento.getText());
        LocalGenerico local;
        if (jcbCategoria.getSelectedItem() == "Cinema") {
            local = new Cinema(fldNomeDoLocal.getText(), end);
        } else {
            local = new Teatro(fldNomeDoLocal.getText(), end);
        }
        adm.setLocalAdministrado(local);
        try {

            admC.cadastrar(adm.getNome(), adm.getEmail(), adm.getSenha(), adm.getLocalAdministrado());
            Admin cadastrado = admC.buscar(adm);
            if (captura.getImagemSelecionada() != null) {
                adm.getLocalAdministrado().inserirCapaESalvar(captura.getImagemSelecionada());
            }
            JDialogsControl.mostrarPopUp("Admin e local Cadastrados", false);
            FrameInicio.getFrame().setContentPane(new TelaInicio());
            FrameInicio.getFrame().revalidate();
        } catch (DadosRepetidosException | DadosInvalidosException | SenhaInvalidaException | CadastroInexistenteException ex) {
            JDialogsControl.mostrarPopUp(ex.getMessage(), true);
        } catch (IOException ex) {
            Logger.getLogger(TelaCadastrarLocal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtEntrarMouseClicked

    private void jbtEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtEntrarMouseEntered
        jbtEntrar.setForeground(new java.awt.Color(191, 30, 30));
    }//GEN-LAST:event_jbtEntrarMouseEntered

    private void jbtEntrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtEntrarMouseExited
        jbtEntrar.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jbtEntrarMouseExited

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
                JDialogsControl.mostrarPopUp(ex.getMessage(), true);
            }
        }
    }//GEN-LAST:event_jbtLocalizarCEPMouseClicked

    private void jbtLocalizarCEPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtLocalizarCEPMouseEntered
         jbtLocalizarCEP.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_jbtLocalizarCEPMouseEntered

    private void jbtLocalizarCEPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtLocalizarCEPMouseExited
         jbtLocalizarCEP.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_jbtLocalizarCEPMouseExited

    private void jbtSelecionarImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSelecionarImgMouseClicked
        captura.setLocationRelativeTo(null);
        captura.setVisible(true);
    }//GEN-LAST:event_jbtSelecionarImgMouseClicked

    private void jbtSelecionarImgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSelecionarImgMouseEntered
        jbtSelecionarImg.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_jbtSelecionarImgMouseEntered

    private void jbtSelecionarImgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSelecionarImgMouseExited
         jbtSelecionarImg.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_jbtSelecionarImgMouseExited

    private void jbtSelecionarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSelecionarImgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtSelecionarImgActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fldBairro;
    private javax.swing.JTextField fldCEP;
    private javax.swing.JTextField fldCidade;
    private javax.swing.JTextField fldComplemento;
    private javax.swing.JTextField fldNomeDoLocal;
    private javax.swing.JTextField fldNum;
    private javax.swing.JTextField fldPais;
    private javax.swing.JTextField fldRua;
    private javax.swing.JTextField fldUF;
    private javax.swing.JButton jbtEntrar;
    private javax.swing.JButton jbtLocalizarCEP;
    private javax.swing.JButton jbtSelecionarImg;
    private javax.swing.JComboBox<String> jcbCategoria;
    private javax.swing.JLabel lblBackCine;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCEP;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblComplemento;
    private javax.swing.JLabel lblEntrar;
    private javax.swing.JLabel lblLinhaCadLocal;
    private javax.swing.JLabel lblLinhaEnd;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNum;
    private javax.swing.JLabel lblPais;
    private javax.swing.JLabel lblRua;
    private javax.swing.JLabel lblUF;
    // End of variables declaration//GEN-END:variables
}
