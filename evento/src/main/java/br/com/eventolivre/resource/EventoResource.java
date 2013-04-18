package br.com.eventolivre.resource;

import br.com.eventolivre.bean.cache.EventoCache;
import br.com.eventolivre.model.Evento;
import br.com.eventolivre.model.vo.EventoVO;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *Recurso para obter as informações dos eventos
 * @author otaviojava
 */
@RequestScoped
@Path(value = "evento")
public class EventoResource implements Serializable{
    
    @Inject
    private EventoCache eventoCache;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON+ ";charset=utf-8")
    public List<EventoVO> listarEventos(){
        List<EventoVO> eventos=new LinkedList<EventoVO>();
        for(Evento evento:eventoCache.getEventos()){
            EventoVO eventoVO=new EventoVO();
            eventoVO.setId(evento.getId());
            eventoVO.setNome(evento.getNome());
            eventoVO.setDataEvento(evento.getDataEvento());
            eventos.add(eventoVO);
        }
        return eventos;
    }
}
