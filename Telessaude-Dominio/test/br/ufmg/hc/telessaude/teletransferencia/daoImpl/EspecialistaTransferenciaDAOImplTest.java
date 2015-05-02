/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.teletransferencia.daoImpl;

import br.ufmg.hc.telessaude.teletransferencia.entity.EspecialistaTransferencia;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author paulo.gomes
 */
public class EspecialistaTransferenciaDAOImplTest {
    
    public EspecialistaTransferenciaDAOImplTest() {
    }

    /**
     * Test of consultarPeloIdUsuario method, of class EspecialistaTransferenciaDAOImpl.
     */
    @Test
    public void testConsultarPeloIdUsuario() throws Exception {
        System.out.println("consultarPeloIdUsuario");
        Integer idUsuario = 1;
        EspecialistaTransferenciaDAOImpl instance = new EspecialistaTransferenciaDAOImpl();
        EspecialistaTransferencia result = instance.consultarPeloIdUsuario(idUsuario);
        assertNotNull(result);
    }

    /**
     * Test of consultarPeloNome method, of class EspecialistaTransferenciaDAOImpl.
     */
//    @Test
    public void testConsultarPeloNome_String() throws Exception {
        System.out.println("consultarPeloNome");
        String nome = "";
        EspecialistaTransferenciaDAOImpl instance = new EspecialistaTransferenciaDAOImpl();
        List<EspecialistaTransferencia> expResult = null;
        List<EspecialistaTransferencia> result = instance.consultarPeloNome(nome);
        assertEquals(expResult, result);
    }
    
}
