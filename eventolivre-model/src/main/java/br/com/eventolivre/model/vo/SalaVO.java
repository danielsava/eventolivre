package br.com.eventolivre.model.vo;

import java.io.Serializable;

/**
 *
 * @author otaviojava
 */
public class SalaVO implements  Serializable{
    
    private Long id;
        
    private String nome;
    
    
    private Long idEvento;

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

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }
    
    
    
    
}
