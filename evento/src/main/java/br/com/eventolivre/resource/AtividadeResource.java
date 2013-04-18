package br.com.eventolivre.resource;

import br.com.eventolivre.model.Atividade;
import br.com.eventolivre.model.vo.AtividadeVO;
import br.com.eventolivre.service.AtividadeService;
import java.util.LinkedList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author otaviojava
 */
@RequestScoped
@Path(value = "atividades")
public class AtividadeResource {
    
    @Inject
    private AtividadeService atividadeService;
    
    @GET()
    @Path(value = "{idSala}")
    @Produces(MediaType.APPLICATION_JSON+ ";charset=utf-8")
    public List<AtividadeVO> listarSalaEvento(@PathParam(value = "idSala") Long idSala){
        
        List<AtividadeVO> atividades=new LinkedList<AtividadeVO>();
    
        for(Atividade atividade:atividadeService.listarSalaEvento(idSala)){
            AtividadeVO atividadeVO=new AtividadeVO();
            atividadeVO.setId(atividade.getId());
            atividadeVO.setBio(atividade.getBio());
            atividadeVO.setDescricao(atividadeVO.getDescricao());
            atividadeVO.setHorario(atividade.getHorario());
            atividadeVO.setIdSala(atividade.getSala().getId());
            atividadeVO.setOrdem(atividade.getOrdem());
            atividadeVO.setPalestrante(atividadeVO.getPalestrante());
            atividadeVO.setTitulo(atividade.getTitulo());
            
        }
        
        return atividades;
    }
}
