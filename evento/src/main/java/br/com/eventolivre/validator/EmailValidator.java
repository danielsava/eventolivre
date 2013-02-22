package br.com.eventolivre.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *Classe para realizar a validação do emil
 * @author otaviojava
 */

public class EmailValidator {
   
   private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\." +"[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" +"(\\.[A-Za-z]{2,})$";
 
	private Pattern pattern;
 
	public EmailValidator(){
		  pattern = Pattern.compile(EMAIL_PATTERN);
	}
 
	
	public boolean validate(Object value)  {
		
		Matcher	matcher = pattern.matcher(value.toString());
		if(!matcher.matches()){
 
			return false;
                        
		}
                    return true;
	}
     
}
