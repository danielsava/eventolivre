package br.com.eventolivre.dao;

import br.com.eventolivre.commons.dao.AbstractDAO;
import br.com.eventolivre.model.Evento;
import java.util.Date;
import java.util.List;
import javax.inject.Singleton;
import javax.persistence.Query;

/**
 *
 * @author otaviojava
 */
@Singleton
public class EventoDAO extends AbstractDAO<Evento> {
    

    public EventoDAO() {
        super(Evento.class);
    }
    
    
    public List<Evento> listarEventosAtuais(){
        StringBuilder jpql=new StringBuilder();
        jpql.append(" from Evento where data >=:dataAtual");
        Query query=getEntityManager().createQuery(jpql.toString());
        query.setParameter("dataAtual", new Date());
        return query.getResultList();
    }
            
    public List<Evento> listarEventosCertificados(){
        StringBuilder jpql=new StringBuilder();
        jpql.append(" from Evento where enviarCeritificado =:enviarCeritificado ");
        Query query=getEntityManager().createQuery(jpql.toString());
        query.setParameter("enviarCeritificado", Boolean.TRUE);
        return query.getResultList();
        
        
    }

    public void gerarCertificado(Long codigoEvento) {
        StringBuilder jpql=new StringBuilder();
        jpql.append(" update Evento set enviarCeritificado=:enviarCeritificado  where id =:id");
        Query query=getEntityManager().createQuery(jpql.toString());
        query.setParameter("id", codigoEvento);
        query.setParameter("enviarCeritificado", Boolean.TRUE);
        query.executeUpdate();
    }
}
