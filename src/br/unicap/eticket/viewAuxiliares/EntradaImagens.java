package br.unicap.eticket.viewAuxiliares;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EntradaImagens {

    public static String caminhoBanner(JLabel jlbBanner, JPanel jp){
        Object[] imagemECaminho = capturarImagemSelecionada(jp);

        ImageIcon img = (ImageIcon) imagemECaminho[1];
        jlbBanner.setIcon(new ImageIcon(img.getImage().getScaledInstance(
                jlbBanner.getWidth(), jlbBanner.getHeight(), Image.SCALE_DEFAULT)));
        return EntradaImagens.caminhoCompleto((String) imagemECaminho[0]);
    }
    
    public static Object[] capturarImagemSelecionada(JPanel jp) {
        Object[] imagemECaminho = new Object[2];
        
        JFileChooser arquivo = new JFileChooser();
        arquivo.setDialogTitle("Selecione uma Capa:");
        arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int opc = arquivo.showOpenDialog(jp);
        if (opc == JFileChooser.APPROVE_OPTION) {
            File file = new File("Caminho");
            file = arquivo.getSelectedFile();
             imagemECaminho[0] = file.getAbsolutePath();

             imagemECaminho[1] = new ImageIcon(arquivo.getSelectedFile().getPath());
            return imagemECaminho;
        } else {
            return null;
        }
    }
    
    public static String caminhoCompleto(String caminho) {
        char[] chars = caminho.toCharArray();
        String aux = "";

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '\\') {
                aux = aux.concat(Character.toString(chars[i]));
            } else {
                aux = aux.concat(Character.toString(chars[i])).concat(Character.toString(chars[i]));
            }
        }

        return aux;
    }
}
