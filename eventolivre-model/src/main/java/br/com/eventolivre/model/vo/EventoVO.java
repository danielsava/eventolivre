package br.com.eventolivre.model.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Essa classe contém as informações do evento que serão enviadas via 
 * WebService
 * @author otaviojava
 */
public class EventoVO implements  Serializable{
    
    private Long id;
    
    private String nome;
    
    private Date dataEvento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }
    
    
}
