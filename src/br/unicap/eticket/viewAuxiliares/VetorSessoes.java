package br.unicap.eticket.viewAuxiliares;

import br.unicap.eticket.dao.LocalDAO;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.locaisAuxiliares.Sessao;
import br.unicap.eticket.model.usuarios.Cliente;
import br.unicap.eticket.view.FrameInicio;
import br.unicap.eticket.view.cliente.TelaHomepageLocal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;

public class VetorSessoes implements ActionListener{

    private JButton atual;
    private Cliente cliente;

    private JButton[] vetorSessoes;

    public VetorSessoes(List<Sessao> sessoes) {
        int tam = sessoes.size();
        vetorSessoes = new JButton[tam];

        for (int i = 0; i < tam; i++) {

            vetorSessoes[i] = new JButton();

            vetorSessoes[i].setName(String.valueOf(sessoes.get(i).getId()));
            
            vetorSessoes[i].setContentAreaFilled(false);
            vetorSessoes[i].addActionListener(this);

            vetorSessoes[i].addMouseListener(new java.awt.event.MouseAdapter() {

                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    eventoMouseClicked(evt);
                }
            }
            );
        }
    
    }

    public JButton[] getLocais() {
        return vetorSessoes;
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
        
        FrameInicio.getFrame().setContentPane(new TelaHomepageLocal(clicado,cliente));
        FrameInicio.getFrame().revalidate();
    }

    public void eventoMouseClicked(MouseEvent evt) {

        for (int i = 0; i < vetorSessoes.length; i++) {

            if (vetorSessoes[i].equals(atual)) {
                //trocarCor();

                //matrizString[i][j] = matrizBotoes[i][j].getText();
            }

        }

    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
