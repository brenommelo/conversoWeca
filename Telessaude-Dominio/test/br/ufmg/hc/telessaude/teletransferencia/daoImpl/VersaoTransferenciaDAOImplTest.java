/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.teletransferencia.daoImpl;

import br.ufmg.hc.telessaude.teletransferencia.entity.VersaoTransferencia;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author paulo.gomes
 */
public class VersaoTransferenciaDAOImplTest {
    
    public VersaoTransferenciaDAOImplTest() {
    }

    /**
     * Test of retornarUltimaVersao method, of class VersaoTransferenciaDAOImpl.
     */
    @Test
    public void testRetornarUltimaVersao() throws Exception {
        System.out.println("retornarUltimaVersao");
        VersaoTransferenciaDAOImpl instance = new VersaoTransferenciaDAOImpl();
        VersaoTransferencia result = instance.retornarUltimaVersao();
        assertTrue(result != null);
    }
   
    @Test
    public void testconsultarVersao() throws Exception {
        System.out.println("retornarUltimaVersao");
        VersaoTransferenciaDAOImpl instance = new VersaoTransferenciaDAOImpl();
        VersaoTransferencia result = instance.consultarVersao("1.0");
        assertTrue(result != null);
    }
    
}
