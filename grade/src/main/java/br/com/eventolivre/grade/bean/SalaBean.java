package br.com.eventolivre.grade.bean;

import br.com.eventolivre.model.Evento;
import br.com.eventolivre.model.Sala;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *Classe que representa as opções para a sala
 * @author otaviojava
 */
@ViewScoped
@ManagedBean
public class SalaBean implements  Serializable{
    
    private Long codigoEvento=0l;
    
    private Evento evento=new Evento();

    public Long getCodigoEvento() {
        return codigoEvento;
    }

    public void setCodigoEvento(Long codigoEvento) {
        this.codigoEvento = codigoEvento;
    }
    
    public String selecionar(){
        return "pm:salas";
    }
    
    public List<Sala> getSalas(){
        if(codigoEvento.equals(Long.valueOf(1l))){
            evento.setNome("Flisol SSA");
        }
        else{
            evento.setNome("Flisol CE");
        }
        
        List<Sala> salas=new LinkedList<Sala>();
        Sala sala=new Sala();
        sala.setId(codigoEvento);
        sala.setNome("Sala A");
        
        Sala salaB=new Sala();
        salaB.setId(codigoEvento);
        salaB.setNome("Sala B");
        salas.add(sala);
        salas.add(salaB);
        
        return salas;
        
    }

    public Evento getEvento() {
        return evento;
    }
    
    
    
}
