package br.com.eventolivre.commons.model;

/**
 * Classe Abstrata que usa o @see BaseModel como Objeto Fantasma
 * @author otavio
 */
public  abstract class AbstractModel<T> implements BaseModel<T> {
    
	private static final int HASH_CODE = 31;
	private static final int HASH_VALUE = 3;
	private static final long serialVersionUID = -119307763575509876L;

	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractModel other = (AbstractModel) obj;
        if (this.getId() != other.getId() && (this.getId() == null || !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return HASH_CODE * HASH_VALUE + (this.getId() != null ? this.getId().hashCode() : 0);
    }
}
