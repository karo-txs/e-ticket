package br.unicap.eticket.viewAuxiliares;

import br.unicap.eticket.dao.EntreterimentoDAO;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.locaisAuxiliares.Entretenimento;
import br.unicap.eticket.model.usuarios.Cliente;
import br.unicap.eticket.model.usuarios.Usuario;
import br.unicap.eticket.view.FrameInicio;
import br.unicap.eticket.view.cliente.TelaEntSelecionado;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class VetorEntretenimentos implements ActionListener {

    private JButton atual;
    private LocalGenerico local;
    private Usuario user;

    private JButton[] vetorEntretenimentos;

    public VetorEntretenimentos(List<Entretenimento> entretenimento) {

        int tam = entretenimento.size();
        vetorEntretenimentos = new JButton[tam];

        for (int i = 0; i < tam; i++) {

            vetorEntretenimentos[i] = new JButton();

            Image im = new ImageIcon(entretenimento.get(i).getCapa()).getImage();
            Icon ic = new ImageIcon(im);
            vetorEntretenimentos[i].setIcon(ic);

            vetorEntretenimentos[i].setName(String.valueOf(entretenimento.get(i).getId()));

            vetorEntretenimentos[i].setContentAreaFilled(false);
            vetorEntretenimentos[i].addActionListener(this);

            vetorEntretenimentos[i].addMouseListener(new java.awt.event.MouseAdapter() {

                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    eventoMouseClicked(evt);
                }
            }
            );
        }
    }

    public JButton[] getEntretenimentos() {
        return vetorEntretenimentos;
    }

    public JButton getClicado() {
        return atual;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // ((JButton) e.getSource()).setEnabled(false);
        atual = (JButton) e.getSource();
        EntreterimentoDAO entD = new EntreterimentoDAO();
        Entretenimento clicado = entD.buscarPorId(Long.parseLong(atual.getName()));
        if (user instanceof Cliente) {
            try {
                FrameInicio.getFrame().setContentPane(new TelaEntSelecionado(local, clicado, (Cliente) user));
            } catch (CadastroInexistenteException ex) {
                Logger.getLogger(VetorEntretenimentos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        FrameInicio.getFrame().revalidate();
    }

    public void eventoMouseClicked(MouseEvent evt) {

        for (int i = 0; i < vetorEntretenimentos.length; i++) {

            if (vetorEntretenimentos[i].equals(atual)) {
                //trocarCor();
                //matrizString[i][j] = matrizBotoes[i][j].getText();
            }

        }

    }

    public JButton getAtual() {
        return atual;
    }

    public void setAtual(JButton atual) {
        this.atual = atual;
    }

    public LocalGenerico getLocal() {
        return local;
    }

    public void setLocal(LocalGenerico local) {
        this.local = local;
    }

    public Usuario getCliente() {
        return user;
    }

    public void setCliente(Usuario cliente) {
        this.user = cliente;
    }

    public JButton[] getVetorEntretenimentos() {
        return vetorEntretenimentos;
    }

    public void setVetorEntretenimentos(JButton[] vetorEntretenimentos) {
        this.vetorEntretenimentos = vetorEntretenimentos;
    }

}
