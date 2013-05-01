package br.com.eventolivre.bean;

import br.com.eventolivre.form.GradeForm;
import br.com.eventolivre.service.AtividadeService;
import br.com.eventolivre.service.SalaService;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 * Grade responsável por estar cadastrando a grade e as salas do evento
 * @author otaviojava
 */
@ViewScoped
@ManagedBean
public class GradeBean implements Serializable{
    
    private GradeForm gradeForm;
    @Inject
    private AtividadeService atividadeService;
    @Inject
    private SalaService salaService;
    
    
    @Inject
    public void init(){
     gradeForm.setSalas(salaService.listarSalaEvento(gradeForm.getCodigoEvento()));
     
    }
    
}
