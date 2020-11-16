package br.unicap.eticket.controller.auxiliares;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;
import br.unicap.eticket.excecoes.DadosInvalidosException;
import br.unicap.eticket.excecoes.SenhaInvalidaException;
import br.unicap.eticket.model.auxiliares.Endereco;
import java.io.IOException;
import java.util.Calendar;
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
    public static boolean validaNome(String nome) throws DadosInvalidosException {
        if (!nome.equals("") && nome != null) {
            if (nome.replace(" ", "").matches("^[a-zA-Z]*$")) {
                return true;
            } else {
                throw new DadosInvalidosException("Nome");
            }
        }
        return false;
    }

    /**
     * Validada se uma idade é válida (entre 0 e 120 anos)
     * @param idade
     * @return
     */
    public static boolean validaIdade(String idade) {
        if (idade != null && !idade.equals("")) {
            try {
                int valor = Integer.parseInt(idade);
                return valor >= 0 && valor <= 120;
            } catch (NumberFormatException e) {
                throw new DadosInvalidosException("Idade");
            }
        }
        return false;
    }

    /**
     * Valida um nickname conforme as regras (menor de 10 caracteres e não
     * inicia com números)
     *
     * @param nick
     * @return boolean
     */
    public static boolean validaNickName(String nick) {
        return nick.length() <= 10 && !Character.isDigit(nick.charAt(0));
    }

    /**
     * Valida dados financeiros de um cartao de credito
     *
     * @param numero
     * @param nomeNoCartao
     * @param dataExpiracao
     * @param codigoSeguranca
     * @return String
     */
    public static String validaDadosFinanceirosCredito(String numero, String nomeNoCartao, Calendar dataExpiracao, int codigoSeguranca) {
        String dadoIncorreto = "VALIDO";
        if (!validaNumero(numero) || numero.length() != 16) {
            dadoIncorreto = "Número";
        } else {
            if (!validaNome(nomeNoCartao)) {
                dadoIncorreto = "NomeNoCartao";
            } else {
                if (!validaNumero(String.valueOf(codigoSeguranca)) || String.valueOf(codigoSeguranca).length() != 3) {
                    dadoIncorreto = "Codigo de Segurança";
                }
            }
        }
        return dadoIncorreto;
    }

    /**
     * Validação de um email
     *
     * @param email
     * @return boolean
     */
    public static boolean validaEmail(String email) throws DadosInvalidosException {
        if (email != null && !email.equals("")) {
            if (email.length() > 0) {
                String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
                Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(email);
                if (matcher.matches()) {
                    return true;
                }
            } else {
                throw new DadosInvalidosException("Email");
            }
        }
        return false;
    }

    /**
     * Valida a estrutura de um site: www.______.com.br
     *
     * @param site
     * @return
     */
    public static boolean validaSite(String site) {
        return true;
    }

    /**
     * Validação de Telefones
     *
     * @param telefone
     * @return boolean
     */
    public static boolean validaTelefone(String telefone) throws DadosInvalidosException {
        if (telefone != null && !telefone.equals("")) {
            if (telefone.matches("^\\d+$") && telefone.length() >= 8 && telefone.length() <= 11) {
                return true;
            } else {
                throw new DadosInvalidosException("Telefone");
            }
        }
        return false;
    }

    /**
     * Validação de CPF
     *
     * @param cpf
     * @return boolean
     */
    public static boolean validaCpf(String cpf) throws DadosInvalidosException{
        CPFValidator cpfValidator = new CPFValidator();
        
          if (cpf!= null && !" ".equals(cpf) && !"".equals(cpf)) {
              List<ValidationMessage> erros = cpfValidator.invalidMessagesFor(cpf);
              if(erros.size()<=0){
                  return true;
              }else {
                throw new DadosInvalidosException("Cpf");
            }
        }
        return false;
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
        if (val != null && !val.equals("")) {
            try {
                double valor = Double.parseDouble(val);
                return valor >= 0;
            } catch (NumberFormatException e) {
                throw new DadosInvalidosException("Quantidade");
            }
        }
        return false;
    }

    /**
     * Valida valores que representam quantidades
     *
     * @param val
     * @return boolean
     */
    public static boolean validaQuantidade(String val) {
        if (val != null && !val.equals("")) {
            try {
                int valor = Integer.parseInt(val);
                return valor >= 0;
            } catch (NumberFormatException e) {
                throw new DadosInvalidosException("Quantidade");
            }
        }
        return false;
    }

    /**
     * Valida se a string so contem numeros
     *
     * @param num
     * @return boolean
     */
    public static boolean validaNumero(String num) {
        return num.matches("^\\d+$");
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
