/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.commons;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author paulo.gomes
 */
public class MCryptTest {

    public MCryptTest() {
    }

    /**
     * Test of encrypt method, of class MCrypt.
     */
    @Test
    public void testEncryptDecrypt() throws Exception {
        System.out.println("testEncryptDecrypt");
        String text = "/var/ftp/transferencia/lista.ctp";
        MCrypt instance = new MCrypt();
        String result = instance.encrypt(text);
        System.out.println(result);
        String saida = instance.decrypt(result);
        System.out.println(saida);
        assertEquals(text, saida);
    }

}
