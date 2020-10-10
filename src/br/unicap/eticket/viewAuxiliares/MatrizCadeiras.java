package br.unicap.eticket.viewAuxiliares;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import javax.swing.JButton;

public class MatrizCadeiras implements ActionListener {

    private JButton atual;

    private JButton[][] matrizBotoes;

    /**
     * Gera uma matriz de cadeiras
     * @param x
     * @param y
     * @param ocupacao
     */
    public MatrizCadeiras(int x, int y, HashMap<String, Boolean> ocupacao) {

        matrizBotoes = new JButton[x][y];

        char numLinha = 'A';
        numLinha = (char) (numLinha + x - 1);
        int numColuna = 1;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrizBotoes[i][j] = new JButton();
                matrizBotoes[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cadeira.png")));
                matrizBotoes[i][j].setContentAreaFilled(false);
                matrizBotoes[i][j].addActionListener(this);

                matrizBotoes[i][j].setName(numLinha + "" + numColuna);
                this.assentoOcupado(matrizBotoes[i][j], ocupacao.get(numLinha + "" + numColuna));

                matrizBotoes[i][j].addMouseListener(new java.awt.event.MouseAdapter() {

                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        eventoMouseClicked(evt);
                    }
                }
                );
                numColuna++;
            }
            numColuna = 1;
            numLinha--;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        atual = (JButton) e.getSource();
    }

    public void eventoMouseClicked(MouseEvent evt) {

        for (JButton[] matrizBotoe : matrizBotoes) {
            for (JButton matrizBotoe1 : matrizBotoe) {
                if (matrizBotoe1.equals(atual)) {
                    matrizBotoe1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cadeiraSelecionada.png")));
                } else {
                    matrizBotoe1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cadeira.png")));
                }
            }
        }

    }

    private void assentoOcupado(JButton bt, boolean ocupacao) {
        bt.setEnabled(!ocupacao);
    }

    public JButton getAtual() {
        return this.atual;
    }

    public JButton[][] getAssentos() {
        return matrizBotoes;
    }
}
