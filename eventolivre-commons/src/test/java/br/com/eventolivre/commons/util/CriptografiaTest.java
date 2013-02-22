package br.com.eventolivre.commons.util;

import org.junit.Assert;
import org.junit.Test;


public class CriptografiaTest {
    
    @Test
    public void criptografarTest(){
    CriptografiaUtil criptografiaUtil=new CriptografiaUtil();
    System.out.println(criptografiaUtil.criptografar("java", CriptografiaUtil.SHA256));
    Assert.assertNotNull(criptografiaUtil.criptografar("java", CriptografiaUtil.SHA256));
    }
    
    @Test
    public void criptografarEqualsTest(){
    CriptografiaUtil criptografiaUtil=new CriptografiaUtil();
    Assert.assertEquals(criptografiaUtil.criptografar("java", CriptografiaUtil.SHA256), criptografiaUtil.criptografar("java", CriptografiaUtil.SHA256));
    }
    
    @Test
    public void criptografarNotEqualsTest(){
    CriptografiaUtil criptografiaUtil=new CriptografiaUtil();
    Assert.assertFalse(criptografiaUtil.criptografar("java", CriptografiaUtil.SHA256)==criptografiaUtil.criptografar("php", CriptografiaUtil.SHA256));
    }
    
    @Test
    public void criptografarOtherAlgorismTest(){
    CriptografiaUtil criptografiaUtil=new CriptografiaUtil();
    Assert.assertFalse(criptografiaUtil.criptografar("java", CriptografiaUtil.MD5)==criptografiaUtil.criptografar("php", CriptografiaUtil.SHA256));
    }
    
}