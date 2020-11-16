package br.unicap.eticket.viewAuxiliares;

import br.unicap.eticket.dao.LocalDAO;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.usuarios.Cliente;
import br.unicap.eticket.view.FrameInicio;
import br.unicap.eticket.view.cliente.TelaHomepageLocal;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class VetorLocais implements ActionListener {

    private JButton atual;
    private Cliente cliente;

    private JButton[] vetorLocais;

    public VetorLocais(List<LocalGenerico> locais) {
        int tam = locais.size();
        if (tam != 0) {
            vetorLocais = new JButton[tam];

            for (int i = 0; i < tam; i++) {

                vetorLocais[i] = new JButton();

                Image im = new ImageIcon(locais.get(i).getCapa()).getImage();
                Icon ic = new ImageIcon(im);
                vetorLocais[i].setIcon(ic);

                vetorLocais[i].setName(String.valueOf(locais.get(i).getId()));

                vetorLocais[i].setContentAreaFilled(false);
                vetorLocais[i].addActionListener(this);

                vetorLocais[i].addMouseListener(new java.awt.event.MouseAdapter() {

                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        eventoMouseClicked(evt);
                    }
                }
                );
            }
        }

    }

    public void ajustarPaineis(JScrollPane jpnScroll, JPanel jpnScrollInterno, int qtdes) {
        if (qtdes < 5) {
            jpnScroll.setPreferredSize(new Dimension((223) * qtdes, 145));
        } else {
            jpnScroll.setPreferredSize(new Dimension(1020, 145));
        }
        jpnScrollInterno.setPreferredSize(new Dimension((213 + 10) * qtdes, 145));
        jpnScrollInterno.setLayout(new GridLayout(1, 10, qtdes, 0));

        for (int i = 0; i < qtdes; i++) {
            jpnScrollInterno.add(this.getLocais()[i]);
        }
    }

    public void mostrarLocais(JLabel lblLocalMsg, JScrollPane jpnScroll, JPanel jpnScrollInterno, Cliente cliente) {
        if (this.vetorLocais == null || this.vetorLocais.length==0) {
            lblLocalMsg.setVisible(true);
            jpnScroll.setVisible(false);
        } else {
            this.setCliente(cliente);
            this.ajustarPaineis(jpnScroll, jpnScrollInterno, this.vetorLocais.length);
        }
    }

    public JButton[] getLocais() {
        return vetorLocais;
    }

    public JButton getClicado() {
        return atual;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // ((JButton) e.getSource()).setEnabled(false);
        atual = (JButton) e.getSource();
        LocalDAO cineD = new LocalDAO();
        LocalGenerico clicado = cineD.buscarPorId(Long.parseLong(atual.getName()));

        FrameInicio.getFrame().setContentPane(new TelaHomepageLocal(clicado, cliente));
        FrameInicio.getFrame().revalidate();
    }

    public void eventoMouseClicked(MouseEvent evt) {
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
