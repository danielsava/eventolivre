
package br.com.eventolivre.service.email;

import br.com.eventolivre.model.Participante;
import br.com.eventolivre.model.vo.CertificadoVO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.mail.Session;
import javax.mail.Transport;

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
      
       
            enviarEmail(new ConfirmacaoInscricaoMensagem(participante));
      }
   

   public void enviarCertificado(CertificadoVO certificadoVO){
   
       enviarEmail(new GerarCertificadoMensagem(certificadoVO));
   }
   
private void enviarEmail(GerarMensagem mensagem) {
 try {
                
        Transport.send(mensagem.criarMensagem(mailSession));
              
      } catch (Exception ex) {
          Logger.getLogger(EnvioEmail.class.getName()).log(Level.SEVERE, "Aconteceu um erro ao enviar o email", ex);
      }
      

}
    
}
