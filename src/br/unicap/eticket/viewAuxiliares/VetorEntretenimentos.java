package br.unicap.eticket.viewAuxiliares;

import br.unicap.eticket.dao.EntretenimentoDAO;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.entretenimentos.Entretenimento;
import br.unicap.eticket.model.usuarios.Cliente;
import br.unicap.eticket.model.usuarios.Usuario;
import br.unicap.eticket.view.FrameInicio;
import br.unicap.eticket.view.cliente.TelaEntSelecionado;
import java.awt.Dimension;
import java.awt.GridLayout;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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

    public void ajustarPaineis(JScrollPane jpnScroll, JPanel jpnScrollInterno, int qtdeEnts) {
        if (qtdeEnts != 0 && qtdeEnts < 6) {

            jpnScroll.setPreferredSize(new Dimension((145 + 10) * qtdeEnts, 223));
            jpnScrollInterno.setLayout(new GridLayout(1, 10, qtdeEnts, 10));
            jpnScrollInterno.setPreferredSize(new Dimension((145 + 10) * qtdeEnts, 223));
        } else if (((qtdeEnts / 6) + 1) < 2) {

            jpnScroll.setPreferredSize(new Dimension(930, 223 * ((qtdeEnts / 6) + 1)));

            jpnScrollInterno.setLayout(new GridLayout(((qtdeEnts / 6) + 1), 10, 6, 10));
            jpnScrollInterno.setPreferredSize(new Dimension((145 + 10) * 6, 223 * ((qtdeEnts / 6) + 1)));

        } else {

            jpnScroll.setPreferredSize(new Dimension(930, 223 * 2));
            jpnScrollInterno.setLayout(new GridLayout(((qtdeEnts / 6) + 1), 10, 6, 10));
            jpnScrollInterno.setPreferredSize(new Dimension((145 + 10) * 6, 223 * ((qtdeEnts / 6) + 1)));

        }
    }

    public void adicionarEntsAoPainel(JPanel jpnScrollInterno) {
        for (JButton entretenimento : this.getEntretenimentos()) {
            jpnScrollInterno.add(entretenimento);
        }
    }
    
    public void mostrarEntreterimentos(JScrollPane jpnScroll, JPanel jpnScrollInterno, LocalGenerico local, Usuario u) {
        this.ajustarPaineis(jpnScroll, jpnScrollInterno, this.vetorEntretenimentos.length);
        this.setLocal(local);
        this.user = u;
        this.adicionarEntsAoPainel(jpnScrollInterno);
        FrameInicio.getFrame().revalidate();
    }


    public JButton[] getEntretenimentos() {
        return vetorEntretenimentos;
    }

    public JButton getClicado() {
        return atual;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
atual = (JButton) e.getSource();
        EntretenimentoDAO entD = new EntretenimentoDAO();
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
    
    public void setCliente(Usuario u){
        this.user = u;
    }

    public Usuario getCliente() {
        return user;
    }

    public JButton[] getVetorEntretenimentos() {
        return vetorEntretenimentos;
    }

    public void setVetorEntretenimentos(JButton[] vetorEntretenimentos) {
        this.vetorEntretenimentos = vetorEntretenimentos;
    }

}
