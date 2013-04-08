package br.com.eventolivre.model.local;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author otaviojava
 */
@Entity
public class Estado extends Localizacao{
    
    @ManyToOne
    @JoinColumn(name = "pais",nullable = false)
    private Pais pais;
    
    

    
    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    
    
}
