package br.com.eventolivre.model.local;

import br.com.eventolivre.commons.model.AbstractModel;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Classe base para localização do evento
 * 
 * @author otaviojava
 */
@MappedSuperclass
public class Localizacao extends AbstractModel<Long>{
  
    private static final int TAMANHO_SIGLA=20;
    private static final int TAMANHO_NOME=120;
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(name = "sigla",nullable = false,length = TAMANHO_SIGLA)
    private String sigla;
    
    @Column(name = "nome",nullable = false,length = TAMANHO_NOME)
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
