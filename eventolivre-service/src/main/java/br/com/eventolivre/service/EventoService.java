
package br.com.eventolivre.service;

import br.com.eventolivre.commons.dao.AbstractDAO;
import br.com.eventolivre.commons.service.AbstractService;
import br.com.eventolivre.dao.EventoDAO;
import br.com.eventolivre.model.Evento;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author otaviojava
 */
@Stateless
public class EventoService extends AbstractService<Evento>  {

    @Inject
    private EventoDAO eventoDAO;
    @Override
    public AbstractDAO<Evento> getAbstractDAO() {
       return eventoDAO;
    }
 
     public List<Evento> listarEventosAtuais(){
     return eventoDAO.listarEventosAtuais();
     }
     
     public List<Evento> listarEventosCertificados(){
         return eventoDAO.listarEventosCertificados();
     }

    public void gerarCertificado(Long codigoEvento) {
        eventoDAO.gerarCertificado(codigoEvento);
    }
     
}
