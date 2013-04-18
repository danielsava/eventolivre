package br.com.eventolivre.resource;

import br.com.eventolivre.model.Sala;
import br.com.eventolivre.model.vo.SalaVO;
import br.com.eventolivre.service.SalaService;
import java.io.Serializable;
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
@Path(value = "salas")
public class SalaResource implements Serializable{

    @Inject
    private SalaService salaService;
    
    @GET()
    @Path(value = "{idEvento}")
    @Produces(MediaType.APPLICATION_JSON+ ";charset=utf-8")
    public List<SalaVO> listarSalaEvento(@PathParam("idEvento") Long idEvento) {
    List<SalaVO> salasVOs=new LinkedList<SalaVO>();
    for(Sala sala: salaService.listarSalaEvento(idEvento)){
        SalaVO salaVO=new SalaVO();
        salaVO.setId(sala.getId());
        salaVO.setNome(sala.getNome());
        salaVO.setIdEvento(sala.getEvento().getId());
        salasVOs.add(salaVO);
    }
    return salasVOs;
    }
}
