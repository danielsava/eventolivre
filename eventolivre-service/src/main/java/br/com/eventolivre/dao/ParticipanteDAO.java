package br.com.eventolivre.dao;

import br.com.eventolivre.commons.dao.AbstractDAO;
import br.com.eventolivre.model.Participante;
import java.util.List;
import javax.inject.Singleton;

/**
 *
 * @author otaviojava
 */
@Singleton
public class ParticipanteDAO extends AbstractDAO<Participante> {
    

    public ParticipanteDAO() {
        super(Participante.class);
    }
    
    public List<String> getInstituicoes(String instituicao){
    StringBuilder jpql=new StringBuilder();
    jpql.append("select DISTINCT(par.instituicao) from Participante par   ");
    jpql.append("where UPPER(instituicao) like (:instituicao) order by instituicao ");
    return getEntityManager().createQuery(jpql.toString()).setParameter("instituicao", instituicao.toUpperCase()+"%").getResultList();
    
    }

    public List<Participante> buscarEvento(Long codigoEvento) {
        StringBuilder jpql=new StringBuilder();
        jpql.append("select par from Participante par where par.evento.id=:evento  ");
        return getEntityManager().createQuery(jpql.toString()).setParameter("evento", codigoEvento).getResultList();
        
    }
}
