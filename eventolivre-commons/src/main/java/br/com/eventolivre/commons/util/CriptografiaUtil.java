
package br.com.eventolivre.commons.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Classe utilitária para a criptografia
 * @author otaviojava
 */
public class CriptografiaUtil {

	/**
	 * Codec para o SHA-256
	 */
    public static final String SHA256 = "SHA-256";
    /**
     * Codec para o MD5
     */
    public static final String MD5 = "MD5";

    
    public  String criptografar(String frase, String algorismo) {
    


        return  DigestUtils.sha256Hex(frase);
    }
    
  
}