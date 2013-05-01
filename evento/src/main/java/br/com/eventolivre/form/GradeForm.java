package br.com.eventolivre.form;

import br.com.eventolivre.model.Atividade;
import br.com.eventolivre.model.Sala;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author otaviojava
 */
public class GradeForm implements Serializable{
    
    private List<Sala> salas;
    
    private List<Atividade> atividades;  
    
    private Sala sala;
    
    private Atividade atividade;
    
    private Long codigoEvento=2l;

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public Long getCodigoEvento() {
        return codigoEvento;
    }

    public void setCodigoEvento(Long codigoEvento) {
        this.codigoEvento = codigoEvento;
    }
    
    
    
}
