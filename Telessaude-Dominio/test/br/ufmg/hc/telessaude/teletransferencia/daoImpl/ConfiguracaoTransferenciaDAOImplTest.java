/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.teletransferencia.daoImpl;

import br.ufmg.hc.telessaude.teletransferencia.entity.ConfiguracaoTransferencia;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author paulo.gomes
 */
public class ConfiguracaoTransferenciaDAOImplTest {

    ConfiguracaoTransferenciaDAOImpl instance;

    public ConfiguracaoTransferenciaDAOImplTest() {
        instance = new ConfiguracaoTransferenciaDAOImpl();
    }

    /**
     * Test of consultarPelaChave method, of class
     * ConfiguracaoTransferenciaDAOImpl.
     */
    @Test
    public void testConsultarPelaChave() throws Exception {
        System.out.println("consultarPelaChave");
        String chave = "";
        ConfiguracaoTransferencia result = instance.consultarPelaChave(chave);
        assertNotNull(result);
    }

//    /**
//     * Test of consultarChave method, of class ConfiguracaoTransferenciaDAOImpl.
//     */
//    @Test
//    public void testConsultarChave() throws Exception {
//        System.out.println("consultarChave");
//        String chave = "";
//        int start = 0;
//        int maxResults = 0;
//        ConfiguracaoTransferenciaDAOImpl instance = new ConfiguracaoTransferenciaDAOImpl();
//        List<ConfiguracaoTransferencia> expResult = null;
//        List<ConfiguracaoTransferencia> result = instance.consultarChave(chave, start, maxResults);
//        assertEquals(expResult, result);
//    }
    /**
     * Test of consultarQuantidade method, of class
     * ConfiguracaoTransferenciaDAOImpl.
     */
    @Test
    public void testConsultarQuantidade() throws Exception {
        System.out.println("consultarQuantidade");
        String chave = "";
        Integer result = instance.consultarQuantidade(chave);
        assertTrue(result > 0);
    }

    /**
     * Test of consultarChave method, of class ConfiguracaoTransferenciaDAOImpl.
     */
    @Test
    public void testConsultarTodos() throws Exception {
        System.out.println("testConsultarTodos");
        List<ConfiguracaoTransferencia> result = instance.findAll();
        assertTrue(result != null && result.size() > 0);
    }

}
