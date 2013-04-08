package br.com.eventolivre.commons.model;

import junit.framework.Assert;

import org.junit.Test;

public class EqualsTest {

	
	@Test
	public void equalsTest(){
		long id=1l;
		String nome="java";
		ObjetoA a=new ObjetoA(id, nome);
		ObjetoA a1=new ObjetoA(id, nome);
		Assert.assertEquals(a, a1);
		
	}
	
	@Test
	public void equalsNotTwoObjectsTest(){
		long id=1l;
		String nome="java";
		ObjetoA a=new ObjetoA(id, nome);
		ObjetoB a1=new ObjetoB(id, nome);
		Assert.assertFalse(a.equals(a1));
		
	}
	
	@Test
	public void equalsNotEqualsTest(){
		long id=1l;
		String nome="java";
		ObjetoA a=new ObjetoA(id, nome);
		ObjetoA a1=new ObjetoA(2l, nome);
		Assert.assertFalse(a.equals(a1));
	}
	
	
}
