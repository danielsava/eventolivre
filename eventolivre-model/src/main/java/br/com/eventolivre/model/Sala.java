package br.com.eventolivre.model;

import br.com.eventolivre.commons.model.AbstractModel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Cada evento precisa ter uma ou mais atividades
 * Definindo assim o seu nome e qual sala ele estará se refirindo
 * @author otaviojava
 */
@Entity
public class Sala extends AbstractModel<Long>{
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
        
    @Column(nullable = false)
    private String nome;
    
    @ManyToOne
    @JoinColumn(name = "evento")
    private Evento evento;

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

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    
    
}
