package br.com.eventolivre.grade.bean;

import br.com.eventolivre.model.Atividade;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author otaviojava
 */
@ViewScoped
@ManagedBean
public class AtividadeBean implements Serializable{
    
     private Long codigoSala=0l;

    public Long getCodigoSala() {
        return codigoSala;
    }

    public void setCodigoSala(Long codigoSala) {
        this.codigoSala = codigoSala;
    }
     
    public List<Atividade> getAtividades(){
        List<Atividade> atividades=new LinkedList<Atividade>();
        
        Atividade atividade=new Atividade();
        atividade.setBio("Bio");
        atividade.setDescricao("Descrição");
        atividade.setHorario("8:00 9:00");
        atividade.setPalestrante("Bruno Souza");
        atividade.setTitulo("Java Open Source");
        
        Atividade atividade1=new Atividade();
        atividade1.setBio("Bio");
        atividade1.setDescricao("Descrição");
        atividade1.setHorario("9:00 10:00");
        atividade1.setPalestrante("Vinicius Senger");
        atividade1.setTitulo("Mundo Embarcado");
       
        
        atividades.add(atividade);
        atividades.add(atividade1);
        
        return atividades;
    
    }
    
    public String selecionar(){
        return "pm:atividades";
    }
     
}
