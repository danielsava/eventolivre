package br.com.eventolivre.model;

import br.com.eventolivre.commons.model.AbstractModel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Classe que identifica o participante do evento
 * @author otaviojava
 */
@Entity
@Table(name="participante")
public class Participante extends  AbstractModel<Long> {

    private static final int MINIMO_NOME=10;
    private static final int MAXIMO_NOME=80;
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    @Column(name="nome")
    @NotNull
    @Size(min = MINIMO_NOME, max = MAXIMO_NOME,message="O nome deverá ter o mínimo de 10 e o máximo 80 caracteres")
    private String nome;
    
    @Column(name="email")
    @NotNull
    private String email;
    
    @Column(name="instituicao")
    @NotNull
    private String instituicao;
    
    @Column(name="presente")
    private Boolean presente;
    
    @ManyToOne
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public Boolean getPresente() {
        return presente;
    }

    public void setPresente(Boolean presente) {
        this.presente = presente;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Participante() {
        
        evento=new Evento();
    }
    
    
    
    
    
}
