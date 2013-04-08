package br.com.eventolivre.model.local;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author otaviojava
 */
@Entity
public class Cidade extends Localizacao{
    
    @ManyToOne
    @JoinColumn(name = "estado",nullable = false)
    private Estado estado;

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    
}
