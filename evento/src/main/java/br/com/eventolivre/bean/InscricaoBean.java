
package br.com.eventolivre.bean;

import br.com.eventolivre.service.email.EnvioEmail;
import br.com.eventolivre.bean.cache.EventoCache;
import br.com.eventolivre.commons.bean.AbstractBean;
import br.com.eventolivre.model.Evento;
import br.com.eventolivre.model.Participante;
import br.com.eventolivre.service.ParticipanteService;
import br.com.eventolivre.validator.EmailValidator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author otaviojava
 */
@ManagedBean
@SessionScoped
public class InscricaoBean  extends AbstractBean{
    
    
    private Participante participante;
    
    private boolean inscrito=false;
    
    @Inject
    private EnvioEmail envioEmail;
    
    @Inject
    private EmailValidator validador;
    
    @Inject
    private ParticipanteService participanteService;
    
    @Inject
    private EventoCache eventoCache;
    
    private Evento evento;

   @Inject
   public void init(){
   participante=new Participante();
   evento=new Evento();
   }
    
    

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }
    
    
    public void salvar(){

        if(!validador.validate(participante.getEmail())){
        adicionarMensagemAviso("Email com formato inválido!");
            return;
        }
        evento=eventoCache.getEvento(participante.getEvento());
        participante.setEvento(evento);
        participante.setPresente(Boolean.FALSE);
        participanteService.create(participante);
        envioEmail.enviarConfirmacao(participante);
        participante=new Participante();
        inscrito=true;
        
        adicionarMensagemInfo(" Inscrito com Sucesso!!");
        
        
    }
    
 
    public List<String> complete(String query) {  
    
    return participanteService.getInstituicoes(query);
    }

    public boolean isInscrito() {
        return inscrito;
    }

    public void setInscrito(boolean inscrito) {
        this.inscrito = inscrito;
    }

    public Evento getEvento() {
        return evento;
    }
    
    
}
