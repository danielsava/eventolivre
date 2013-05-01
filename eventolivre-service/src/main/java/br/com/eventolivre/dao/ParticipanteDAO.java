package br.com.eventolivre.dao;

import br.com.eventolivre.commons.dao.AbstractDAO;
import br.com.eventolivre.model.Participante;
import java.util.List;
import javax.inject.Singleton;
import javax.persistence.Query;

/**
 *
 * @author otaviojava
 */
@Singleton
public class ParticipanteDAO extends AbstractDAO<Participante> {
    private static final int MAXIMO_LOTE_CERTIFICADO = 100;
    

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
    
    /**
     * Realiza a busca dos participantes para a geração do certificado
     * @param codigoEvento - evento no qual será gerado o certificado
     * @return  - participantes do evento presentes e que o seu certificado ainda não foi enviado
     */
    public List<Participante> buscarEventoCertificado(Long codigoEvento){
        StringBuilder jpql=new StringBuilder();
        jpql.append(" select par from Participante par where par.evento.id=:evento  ");
        jpql.append(" and par.presente =  true and par.enviado = false ");
        Query query=getEntityManager().createQuery(jpql.toString());
        query.setParameter("evento", codigoEvento);
        query.setMaxResults(MAXIMO_LOTE_CERTIFICADO);
        return query.getResultList();
    }
}
