package br.com.eventolivre.dao;

import br.com.eventolivre.commons.dao.AbstractDAO;
import br.com.eventolivre.model.Atividade;
import java.util.List;
import javax.inject.Singleton;
import javax.persistence.Query;

/**
 *
 * @author otaviojava
 */
@Singleton
public class AtividadeDAO extends AbstractDAO<Atividade> {
    

    public AtividadeDAO() {
        super(Atividade.class);
    }
    
      public List<Atividade> listarSalaEvento(Long idSala) {
        StringBuilder jpql = new StringBuilder();
        jpql.append(" from Atividade where sala.id= :idSala");
        Query query = getEntityManager().createQuery(jpql.toString());
        query.setParameter("idSala", idSala);
        return query.getResultList();
    }

    
}
