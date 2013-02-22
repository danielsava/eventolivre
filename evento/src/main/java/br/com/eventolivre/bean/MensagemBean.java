
package br.com.eventolivre.bean;

import java.io.Serializable;
import javax.enterprise.inject.Model;

/**
 *
 * @author otaviojava
 */
@Model
public class MensagemBean implements  Serializable {
    
    
    private static final String MENSAGEM_OBRIGATORIO="Campo Obrigatório";
    
    public String getMensagemObrigatorio(){
    return MENSAGEM_OBRIGATORIO;
    }
    
}
