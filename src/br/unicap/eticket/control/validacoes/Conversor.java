package br.unicap.eticket.control.validacoes;

import br.unicap.eticket.excecoes.DadosInvalidosException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Conversor {
       
    /**
     * Converte uma Imagem em um vetor de bytes
     * @param url
     * @return byte[]
     */
    public static byte[] converterImagemEmByte(String url){
        File file = new File(url);
        byte[] bFile = new byte[(int) file.length()];

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bFile;
    }
    /**
     * Retorna o endereço de um cep dado
     *
     * @param cep
     * @return HashMap
     */
    public static HashMap<String, String> coverterCepEmEndereco(String cep) throws DadosInvalidosException {
        LinkedHashMap<String, String> endereco = new LinkedHashMap<>();
        String json;

        try {
            URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));
            json = jsonSb.toString();

            json = json.replaceAll("[{},:]", "");
            json = json.replaceAll("\"", "\n");
            String array[] = new String[30];
            array = json.split("\n");

            endereco.put("Logradouro", array[7]);
            endereco.put("Bairro", array[15]);
            endereco.put("Cidade", array[19]);
            endereco.put("UF", array[23]);

        } catch (Exception e) {
            throw new DadosInvalidosException("CEP");
        }
        return endereco;
    }
}
