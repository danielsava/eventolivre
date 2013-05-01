package br.com.eventolivre.grade.bean;

import java.io.Serializable;
import javax.enterprise.inject.Model;

/**
 * Classe que ficarão as mensagems do sistema
 * @author otaviojava
 */
@Model
public class MensagemBean implements  Serializable{
    
    
    public String getTitulo(){
    
        return "Evento Livre";
    }
}
