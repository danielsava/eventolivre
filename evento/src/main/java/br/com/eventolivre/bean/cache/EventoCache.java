package br.com.eventolivre.bean.cache;

import br.com.eventolivre.model.Evento;
import br.com.eventolivre.service.EventoService;
import java.util.List;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *Classe para serviços de Cache dos eventos
 * @author otaviojava
 */
@Startup
@Singleton
public class EventoCache {
    
    private List<Evento> eventos;
    
    @Inject
    private EventoService eventoService;
    
    @Schedule(hour = "*/4")
    @Inject
    public void init(){
      eventos=eventoService.listarEventosAtuais();
    }

    public List<Evento> getEventos() {
        return eventos;
    }
    
    public Evento getEvento(Evento evento){
        
        return eventos.get(eventos.indexOf(evento));
    }
    
}
