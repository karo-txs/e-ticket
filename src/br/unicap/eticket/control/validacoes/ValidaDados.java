package br.unicap.eticket.control.validacoes;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;
import br.unicap.eticket.excecoes.SenhaInvalidaException;
import br.unicap.eticket.model.auxiliares.Endereco;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaDados {

    /**
     * Valida se um nome é valido (Contendo apenas letras)
     *
     * @param nome
     * @return boolean
     */
    public static boolean validaNome(String nome) {
        return nome.replace(" ", "").matches("^[a-zA-Z]*$");
    }
    
    /**
     * Valida um nickname conforme as regras (menor de 10 caracteres e não inicia com números)
     * @param nick
     * @return boolean
     */
    public static boolean validaNickName(String nick){
        return nick.length()<=10 && !Character.isDigit(nick.charAt(0));
    }

    /**
     * Validação de um email
     *
     * @param email
     * @return boolean
     */
    public static boolean validaEmail(String email) {
        boolean valido = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                valido = true;
            }
        }
        return valido;
    }

    /**
     * Valida a estrutura de um site: 
     * www.______.com.br
     * @param site
     * @return
     */
    public static boolean validaSite(String site){
        return true;
    }
    /**
     * Validação de Telefones
     *
     * @param telefone
     * @return boolean
     */
    public static boolean validaTelefone(String telefone) {
        return telefone.matches("^\\d+$") && telefone.length()>=8 && telefone.length()<=11;
    }

    /**
     * Validação de CPF
     * 
     * @param cpf
     * @return boolean
     */
    public static boolean validaCpf(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        List<ValidationMessage> erros = cpfValidator.invalidMessagesFor(cpf);
        return erros.size() <= 0;
    }

    /**
     * Senha deve obedecer regras: - TAMANHO_MINIMO = 4; - TAMANHO_MAXIMO = 14;
     * - QUANTIDADE_DIGITOS = 2; - QUANTIDADE_LETRAS = 2;
     *
     * @param senha
     * @return boolean
     * @throws br.unicap.eticket.excecoes.SenhaInvalidaException
     * @throws java.io.IOException
     */
    public static boolean validaSenha(String senha) throws SenhaInvalidaException, IOException {
        PassayUtil passay = new PassayUtil();
        List<String> messages = passay.checaSenha(senha);
        // se retornou mensagens, entao nao passou nas regras..
        if (messages != null) {
            String mensagemErro = "";
            for (String msg : messages) {
                mensagemErro = mensagemErro.concat(msg + "--");
            }
            throw new SenhaInvalidaException(mensagemErro);
        } else {
            return true;
        }
    }

    /**
     * Valida um endereco por seu cep e numero
     *
     * @param end
     * @return boolean
     */
    public static boolean validaEndereco(Endereco end) {
        //CEP = buscarCep(end.getCEP());
        return validaQuantidade(end.getNum());
    }


    /**
     * Valida Valores que representam dinheiro
     *
     * @param val
     * @return boolean
     */
    public static boolean validaValor(String val) {
        try {
            double valor = Double.parseDouble(val);
            return valor >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Valida valores que representam quantidades
     *
     * @param val
     * @return boolean
     */
    public static boolean validaQuantidade(String val) {
        try {
            int valor = Integer.parseInt(val);
            return valor >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Valida nomes que não podem conter caracteres especiais mas podem conter
     * números e letras
     *
     * @param nome
     * @return boolean
     */
    public static boolean validaNomeSemCaracteresEspeciais(String nome) {
        return nome.replace(" ", "").matches("[A-Za-z0-9]+");
    }
}
