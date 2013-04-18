package br.com.eventolivre.dao;

import br.com.eventolivre.commons.dao.AbstractDAO;
import br.com.eventolivre.model.Evento;
import br.com.eventolivre.model.Sala;
import java.util.Date;
import java.util.List;
import javax.inject.Singleton;
import javax.persistence.Query;

/**
 *
 * @author otaviojava
 */
@Singleton
public class SalaDAO extends AbstractDAO<Sala> {
    

    public SalaDAO() {
        super(Sala.class);
    }
    
    public List<Sala> listarSalaEvento(Long idEvento) {
        StringBuilder jpql = new StringBuilder();
        jpql.append(" from Sala where evento.id= :idEvento");
        Query query = getEntityManager().createQuery(jpql.toString());
        query.setParameter("idEvento", idEvento);
        return query.getResultList();
    }

}
