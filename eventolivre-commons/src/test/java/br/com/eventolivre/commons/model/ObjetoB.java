package br.com.eventolivre.commons.model;

public class ObjetoB  extends AbstractModel<Long>{

	private static final long serialVersionUID = -8209314255265142980L;

	private Long id;
	
	private String nome;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ObjetoB(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	
	public ObjetoB() {
	
	}
	
	
}
