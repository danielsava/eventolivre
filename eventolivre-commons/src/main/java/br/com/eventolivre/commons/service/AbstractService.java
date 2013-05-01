package br.com.eventolivre.commons.service;

import br.com.eventolivre.commons.dao.AbstractDAO;
import java.util.List;

/**
 *
 * @author otavio
 */
public abstract  class AbstractService<T> {
   public abstract AbstractDAO<T> getAbstractDAO();
    
    public void create(T entity) {
      getAbstractDAO().create(entity);
    }

    
    public void edit(T entity) {
     getAbstractDAO().edit(entity);
    }

    public void remove(T entity) {
     getAbstractDAO().remove(entity);
    }

    public T findById(Object id) {
      return getAbstractDAO().find(id);
    }

    public List<T> findAll() {
   return getAbstractDAO().findAll();
    }

    public List<T> findRange(int[] range) {
       
        return getAbstractDAO().findRange(range);
    }

    public Long count() {
        
        return getAbstractDAO().count();
    }
}