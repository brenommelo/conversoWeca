/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.commons;

import com.logs.CustomLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import org.apache.log4j.Logger;

/**
 *
 * @author weslley.matos
 */
public class HashUtils {

    private static final Logger log = CustomLogger.getLogger(HashUtils.class);

    private static MessageDigest digest;

    static {
        try {
            digest = MessageDigest.getInstance("SHA-512"); //One of the following "SHA-1", "SHA-256", "SHA-384", and "SHA-512"  
        } catch (Exception ex) {
            log.error("erro ao criar a instancia do MessageDigest : SHA ", ex);
        }
    }

    /**
     *
     * @param file
     * @return
     * @throws Exception
     */
    public static String createHashCode(final File file) throws Exception {
        if (!file.exists()) {
            return null;
        }
        
        final byte[] b = createChecksum(file);
        String result = "";
        
        for (int i = 0; i < b.length; i++) {
            result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
        }
        
        return result;
    }

    /**
     * 
     * @param file
     * @return
     * @throws Exception 
     */
    private static byte[] createChecksum(final File file) throws Exception {
        try (InputStream fis = new FileInputStream(file)) {
            final byte[] buffer = new byte[1024];
            int numRead;
            
            do {
                numRead = fis.read(buffer);
                if (numRead > 0) {
                    digest.update(buffer, 0, numRead);
                }
            } while (numRead != -1);
        }
        
        return digest.digest();
    }
}
