
package br.com.eventolivre.commons.model;

import java.io.Serializable;

/**
 *Interface base para a @see AbstractModel
 *Serve para  enviar ou modificar o id
 *@param T será o id
 * @author otavio
 */

public interface  BaseModel<T>  extends  Serializable{
    
    
     T  getId();
    
     void  setId(T id);
    
}
