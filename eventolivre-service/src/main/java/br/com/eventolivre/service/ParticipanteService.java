
package br.com.eventolivre.service;

import br.com.eventolivre.commons.dao.AbstractDAO;
import br.com.eventolivre.commons.service.AbstractService;
import br.com.eventolivre.dao.ParticipanteDAO;
import br.com.eventolivre.model.Participante;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author otaviojava
 */
@Stateless
public class ParticipanteService extends AbstractService<Participante>  {

    @Inject
    private ParticipanteDAO participanteDAO;
    @Override
    public AbstractDAO<Participante> getAbstractDAO() {
       return participanteDAO;
    }
    
    public List<String> getInstituicoes(String instituicoes){
    return participanteDAO.getInstituicoes(instituicoes);
    }
}
