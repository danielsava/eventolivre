
package br.com.eventolivre.bean;

import br.com.eventolivre.bean.cache.EventoCache;
import br.com.eventolivre.model.Evento;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author otaviojava
 */
@ApplicationScoped
@Named
public class ListaBean implements Serializable {
    
    @Inject
    private EventoCache eventoCache;
    
    
    public List<Evento> getEventos(){
    return eventoCache.getEventos();
    }
}
