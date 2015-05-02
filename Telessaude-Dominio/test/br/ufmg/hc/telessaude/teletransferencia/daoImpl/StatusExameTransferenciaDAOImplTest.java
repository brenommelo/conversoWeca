/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.teletransferencia.daoImpl;

import br.ufmg.hc.telessaude.teletransferencia.entity.StatusTransferencia;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author paulo.gomes
 */
public class StatusExameTransferenciaDAOImplTest {
    
    public StatusExameTransferenciaDAOImplTest() {
    }

    /**
     * Test of consultarPeloNome method, of class StatusExameTransferenciaDAOImpl.
     */
    @Test
    public void testConsultarPeloNome() throws Exception {
        System.out.println("consultarPeloNome");
        String nome = "CONCLUIDO";
        StatusExameTransferenciaDAOImpl instance = new StatusExameTransferenciaDAOImpl();
        StatusTransferencia result = instance.consultarPeloNome(nome);
        assertNotNull(result);
    }

    /**
     * Test of consultarTodos method, of class StatusExameTransferenciaDAOImpl.
     */
    @Test
    public void testConsultarTodos() throws Exception {
        System.out.println("consultarTodos");
        int start = 0;
        int maxResults = 0;
        StatusExameTransferenciaDAOImpl instance = new StatusExameTransferenciaDAOImpl();
        List<StatusTransferencia> result = instance.consultarTodos(start, maxResults);
        assertTrue(result.size() > 0);

    }

    /**
     * Test of consultarQuantidade method, of class StatusExameTransferenciaDAOImpl.
     */
    @Test
    public void testConsultarQuantidade() throws Exception {
        System.out.println("consultarQuantidade");
        StatusExameTransferenciaDAOImpl instance = new StatusExameTransferenciaDAOImpl();
        Integer result = instance.consultarQuantidade();
        assertTrue(result > 0);
    }

    /**
     * Test of consultarId method, of class StatusExameTransferenciaDAOImpl.
     */
    @Test
    public void testConsultarId() throws Exception {
        System.out.println("consultarId");
        String nomeStatus = "CONCLUIDO";
        StatusExameTransferenciaDAOImpl instance = new StatusExameTransferenciaDAOImpl();
        Integer result = instance.consultarId(nomeStatus);
        assertNotNull(result);
    }
    
}
