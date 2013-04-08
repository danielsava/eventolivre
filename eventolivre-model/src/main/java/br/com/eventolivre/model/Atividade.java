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
 * Cada sala é composta por uma atividade.
 * Essa pode ser um curso, palestras, coding dojo, etc.
 * @author otaviojava
 */
@Entity
public class Atividade extends AbstractModel<Long>{
    
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private Integer ordem;
    
    @Column(nullable = false)
    private String horario;
    
    @Column(nullable = false)
    private String tipo;
    
    @Column(nullable = false)
    private String titulo;
    
    @Column(nullable = false)
    private String descricao;
    
    @Column(nullable = false)
    private String palestrante;
    
    @Column(nullable = false)
    private String bio;

    @ManyToOne
    @JoinColumn(name = "sala")
    private Sala sala;
    
    public Long getId() {
        return id;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPalestrante() {
        return palestrante;
    }

    public void setPalestrante(String palestrante) {
        this.palestrante = palestrante;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
    
    
    
}
