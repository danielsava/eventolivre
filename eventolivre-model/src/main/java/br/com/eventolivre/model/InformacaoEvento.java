package br.com.eventolivre.model;

import br.com.eventolivre.commons.model.AbstractModel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *Classe que se destina a ter as informações do evento, como localização, hastag
 * @author otaviojava
 */
@Entity
@Table(name="inforomacao_evento")
public class InformacaoEvento extends AbstractModel<Long>{
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "cidade")
    private String cidade;
    
    @Column(name = "estado")
    private String estado;
    
    @Column(name = "endereco")
    private String endereço;
    
    @Column(name = "hastah")
    private String hastgah;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getHastgah() {
        return hastgah;
    }

    public void setHastgah(String hastgah) {
        this.hastgah = hastgah;
    }
    
    
}
