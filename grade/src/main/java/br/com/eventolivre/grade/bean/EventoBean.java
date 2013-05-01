package br.com.eventolivre.grade.bean;

import br.com.eventolivre.model.Evento;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author otaviojava
 */
@ViewScoped
@ManagedBean
public class EventoBean implements  Serializable{
    
    
    public List<Evento> getEventos(){
    List<Evento> eventos=new LinkedList<Evento>();
    
    Evento evento=new Evento();
    evento.setDataEvento(new Date());
    evento.setNome("FLISOL 2013 SSA");
    evento.setId(1l);
    
    Evento evento2=new Evento();
    evento2.setDataEvento(new Date());
    evento2.setNome("FLISOL 2013 Ceará");
    evento2.setId(2l);
    eventos.add(evento);
    eventos.add(evento2);
    
    return eventos;
    }
}
