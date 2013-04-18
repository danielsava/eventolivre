
package br.com.eventolivre.service;

import br.com.eventolivre.commons.dao.AbstractDAO;
import br.com.eventolivre.commons.service.AbstractService;
import br.com.eventolivre.dao.SalaDAO;
import br.com.eventolivre.model.Sala;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author otaviojava
 */
@Stateless
public class SalaService extends AbstractService<Sala>  {

    @Inject
    private SalaDAO salaDAO;
    
    @Override
    public AbstractDAO<Sala> getAbstractDAO() {
       return salaDAO;
    }
 
    public List<Sala> listarSalaEvento(Long idEvento) {
        return salaDAO.listarSalaEvento(idEvento);
    }
     
}
