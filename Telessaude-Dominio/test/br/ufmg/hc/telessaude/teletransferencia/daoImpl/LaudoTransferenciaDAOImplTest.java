/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.teletransferencia.daoImpl;

import br.ufmg.hc.telessaude.teletransferencia.entity.LaudoTransferencia;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author paulo.gomes
 */
public class LaudoTransferenciaDAOImplTest {
    
    public LaudoTransferenciaDAOImplTest() {
    }

    /**
     * Test of consultarPorIdExame method, of class LaudoTransferenciaDAOImpl.
     */
//    @Test
    public void testConsultarPorIdExame() throws Exception {
        System.out.println("consultarPorIdExame");
        Integer idExame = null;
        LaudoTransferenciaDAOImpl instance = new LaudoTransferenciaDAOImpl();
        LaudoTransferencia expResult = null;
        LaudoTransferencia result = instance.consultarPorIdExame(idExame);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarLaudosPorIdExame method, of class LaudoTransferenciaDAOImpl.
     */
//    @Test
    public void testConsultarLaudosPorIdExame() throws Exception {
        System.out.println("consultarLaudosPorIdExame");
        Integer idExame = null;
        LaudoTransferenciaDAOImpl instance = new LaudoTransferenciaDAOImpl();
        List<LaudoTransferencia> expResult = null;
        List<LaudoTransferencia> result = instance.consultarLaudosPorIdExame(idExame);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarLaudosPorEspecialistaDoDia method, of class LaudoTransferenciaDAOImpl.
     */
    @Test
    public void testConsultarLaudosPorEspecialistaDoDia() throws Exception {
        System.out.println("consultarLaudosPorEspecialistaDoDia");
        Integer idUsuario = 3;
        LaudoTransferenciaDAOImpl instance = new LaudoTransferenciaDAOImpl();
        List<LaudoTransferencia> result = instance.consultarLaudosPorEspecialistaDoDia(idUsuario);
        assertTrue(result != null && result.size() > 0);
    }
    
}
