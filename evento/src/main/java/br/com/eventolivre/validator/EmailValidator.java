package br.com.eventolivre.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *Classe para realizar a validação do emil
 * @author otaviojava
 */
@FacesValidator("EmailValidator")
public class EmailValidator implements Validator{
   
   private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\." +"[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" +"(\\.[A-Za-z]{2,})$";
   public static final String MESNSAGEM_CAMPO__OBRIGATÓRIO = "Campo Obrigatório";
   public static final String MENSAGEM_EMAIL_INVÁLIDO = "Email inválido!";
 
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

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if(value==null||value.toString().trim().equals("")){
            criarMensagemErro(MESNSAGEM_CAMPO__OBRIGATÓRIO);
        }
        else if(!validate(value)){
            criarMensagemErro(MENSAGEM_EMAIL_INVÁLIDO);
        }
        
        
    }
    
    /**
     * Esse método é utilizado para a crição da mensagem de erro 
     * @param mensagem - informação do erro
     * @throws ValidatorException -exceção que será lançada com a informação do erro
     */
    private void criarMensagemErro(String mensagem)throws ValidatorException{
             FacesMessage mensagemErro =new FacesMessage(mensagem,mensagem);
             mensagemErro.setSeverity(FacesMessage.SEVERITY_ERROR);
             throw new ValidatorException(mensagemErro);
    }
}
