
package br.com.eventolivre.service;

import br.com.eventolivre.commons.dao.AbstractDAO;
import br.com.eventolivre.commons.service.AbstractService;
import br.com.eventolivre.dao.AtividadeDAO;
import br.com.eventolivre.model.Atividade;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author otaviojava
 */
@Stateless
public class AtividadeService extends AbstractService<Atividade>  {

    @Inject
    private AtividadeDAO atividadeDAO;
    
    @Override
    public AbstractDAO<Atividade> getAbstractDAO() {
       return atividadeDAO;
    }
 
    public List<Atividade> listarSalaEvento(Long idSala) {
    return atividadeDAO.listarSalaEvento(idSala);
    }
     
}
