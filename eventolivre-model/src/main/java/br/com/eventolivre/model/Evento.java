package br.com.eventolivre.model;

import br.com.eventolivre.commons.model.AbstractModel;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * É a atividade composta por várias pessoas com o objetivo de estar 
 * sobre tudo compartilhando informações aos seus participantes.
 * Ele é composto por salas e que por sua vez por atividades.
 * @author otaviojava
 */
@Entity
@Table(name="evento")
public class Evento extends AbstractModel<Long> {
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name="nome",nullable = false)
    private String nome;
    
    @Column(name="data",nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataEvento;
    
    @OneToMany(mappedBy="evento")
    private List<Participante> participantes;
    
   
    @ManyToOne
    @JoinColumn(name = "tipo_evento")
    private TipoEvento tipoEvento;

    @ManyToOne
    @JoinColumn(name = "informacao_evento")
    private InformacaoEvento informacaoEvento;
    
    @Column(name="enviar_certificado")
    private Boolean enviarCeritificado;
    
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

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }


    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public InformacaoEvento getInformacaoEvento() {
        return informacaoEvento;
    }

    public void setInformacaoEvento(InformacaoEvento informacaoEvento) {
        this.informacaoEvento = informacaoEvento;
    }

    public Boolean getEnviarCeritificado() {
        return enviarCeritificado;
    }

    public void setEnviarCeritificado(Boolean enviarCeritificado) {
        this.enviarCeritificado = enviarCeritificado;
    }

    
    
    
    
}
