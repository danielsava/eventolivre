
package br.com.eventolivre.service;

import br.com.eventolivre.model.Evento;
import br.com.eventolivre.model.Participante;
import br.com.eventolivre.model.vo.CertificadoVO;
import br.com.eventolivre.service.email.EnvioEmail;
import br.com.eventolivre.service.report.CertificadoReport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Asynchronous;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author otaviojava
 */
@Singleton
@Startup
public class EnviaEmailBath {
    
    @Inject
    private EventoService eventoService;
    
    @Inject
    private CertificadoReport certificadoReport;
    
    @Inject
    private EnvioEmail envioEmail;
    
    @Inject
    private ParticipanteService participanteService;
    
  @PostConstruct
  @Schedule(minute = "*", hour = "*/5")
  @Asynchronous
  public void enviarEmailBath(){
    Logger logger=Logger.getLogger(ParticipanteService.class.getName());
    logger.info("Iniciando o Bath de envio de email");
    for(Evento evento:eventoService.listarEventosCertificados()){
    int contador=1;
    
    for(Participante participante:participanteService.buscarEventoCertificado(evento.getId())){
        CertificadoVO certificadoVO=new CertificadoVO(participante,certificadoReport.gerarCertificado(participante));
        envioEmail.enviarCertificado(certificadoVO);
        participante.setEnviado(Boolean.TRUE);
        participanteService.edit(participante);
        
        if(contador%20==0){
            logger.log(Level.INFO, "Enviando o email n\u00famero: {0} para o evento: {1}", new Object[]{contador, participante.getEvento().getNome()});
        }
        contador++;
       }
       
       logger.info("Encerrando o processo de envio de email");   
        
    }
    
}
    
}