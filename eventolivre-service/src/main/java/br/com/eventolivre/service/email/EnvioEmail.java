
package br.com.eventolivre.service.email;

import br.com.eventolivre.model.Participante;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *Servico de enviar email 
 * @author otaviojava
 */
@Singleton
public class EnvioEmail {
  @Resource(name = "email/evenioRelatorio")
  private Session mailSession;
    
   /**
    * Este método é utilizado para confirmar a inscrição do
    * @param participante 
    */
   public void enviarConfirmacao(Participante participante) {
      
       GerarMensagem mensagem=new ConfirmacaoInscricaoMensagem(participante);
 try {
                
        Transport.send(mensagem.criarMensagem(mailSession));
              
      } catch (Exception ex) {
          Logger.getLogger(EnvioEmail.class.getName()).log(Level.SEVERE, "Aconteceu um erro ao enviar o email", ex);
      }
      
      }
   
    
  
    
}
