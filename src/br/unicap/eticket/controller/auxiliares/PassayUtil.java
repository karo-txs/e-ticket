package br.unicap.eticket.controller.auxiliares;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.passay.AlphabeticalCharacterRule;
import org.passay.DigitCharacterRule;
import org.passay.LengthRule;
import org.passay.MessageResolver;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.PropertiesMessageResolver;
import org.passay.Rule;
import org.passay.RuleResult;
import org.passay.SpecialCharacterRule;
import org.passay.UppercaseCharacterRule;
import org.passay.WhitespaceRule;

public class PassayUtil {
    private static final int TAMANHO_MINIMO = 4;
    private static final int TAMANHO_MAXIMO = 14;
    private static final int QUANTIDADE_DIGITOS = 2;
    private static final int QUANTIDADE_LETRAS = 2;
    
    public List<String> checaSenha(String senha) throws IOException{
	
	// regra de tamanho mínimo/máximo
	LengthRule lr = new LengthRule(TAMANHO_MINIMO, TAMANHO_MAXIMO);
	
	// regra de espaços não permitidos
	WhitespaceRule wr = new WhitespaceRule();
	
	// regra de caracter alfabético obrigatório
	AlphabeticalCharacterRule  ac = new AlphabeticalCharacterRule (QUANTIDADE_LETRAS); 
	
	// regra de dígitos obrigatórios
	DigitCharacterRule dc = new DigitCharacterRule(QUANTIDADE_DIGITOS);
	
	// regra de caracteres especiais obrigatórios
	SpecialCharacterRule  nac = new SpecialCharacterRule();
	
	// regra de caracter maiúsculo obrigatório
	UppercaseCharacterRule uc = new UppercaseCharacterRule();
	
	List<Rule> ruleList = new ArrayList<Rule>();
	ruleList.add(lr);
	ruleList.add(wr);
	ruleList.add(ac);
	ruleList.add(dc);
	ruleList.add(nac);
	ruleList.add(uc);
	
	Properties props = new Properties();
        
        try {
            props.load(new FileInputStream("src\\br\\unicap\\eticket\\controller\\auxiliares\\messages.properties"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PassayUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
	MessageResolver resolver = new PropertiesMessageResolver(props);
	
	PasswordValidator validator = new PasswordValidator(resolver, ruleList);
	PasswordData passwordData = new PasswordData(new String(senha));

	RuleResult result = validator.validate(passwordData);
	if (!result.isValid()) {
	  return validator.getMessages(result);
	}
	return null;
}
}
