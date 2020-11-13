package br.unicap.eticket.viewAuxiliares;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MatrizCadeiras implements ActionListener {

    private JButton atual;
    private int x, y;
    private JButton[][] matrizBotoes;

    /**
     * Gera uma matriz de cadeiras
     *
     * @param x
     * @param y
     * @param ocupacao
     */
    public MatrizCadeiras(int x, int y, HashMap<String, Boolean> ocupacao) {
        this.x = x;
        this.y = y;
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

    public void mostrarCadeiras(JPanel jpnAssentos, JPanel jpnVert, JPanel jpnHorz) {

        char a = 'A';
        a = (char) (a + x - 1);
        for (int i = 0; i < x; i++) {
            JLabel lbl = new JLabel();

            lbl.setText(String.valueOf(a));
            lbl.setFont(new java.awt.Font("Impact", 0, 24));
            lbl.setForeground(new java.awt.Color(102, 102, 102));
            lbl.setHorizontalAlignment(0);
            jpnVert.add(lbl);

            a--;

            for (int j = 0; j < y; j++) {
                jpnAssentos.add(this.getAssentos()[i][j]);
            }
        }

        for (int i = 0; i < y; i++) {
            JLabel lbl2 = new JLabel();
            lbl2.setText(String.valueOf(i + 1));
            lbl2.setFont(new java.awt.Font("Impact", 0, 24));
            lbl2.setForeground(new java.awt.Color(102, 102, 102));
            lbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jpnHorz.add(lbl2);
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
