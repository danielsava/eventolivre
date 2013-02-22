
package br.com.eventolivre.commons.util;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author otaviojava
 */

public class CriptografiaUtil {

    private static final Logger LOGGER = Logger.getLogger(CriptografiaUtil.class.getName());
    public static final String SHA256 = "SHA-256";
    public static final String MD5 = "MD5";

    
    public  String criptografar(String frase, String algorismo) {
    


        return  DigestUtils.sha256Hex(frase);
    }
    
  
}