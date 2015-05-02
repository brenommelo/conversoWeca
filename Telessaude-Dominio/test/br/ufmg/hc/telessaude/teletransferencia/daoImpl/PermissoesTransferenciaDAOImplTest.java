/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.teletransferencia.daoImpl;

import br.ufmg.hc.telessaude.teletransferencia.entity.PermissaoTransferencia;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author paulo.gomes
 */
public class PermissoesTransferenciaDAOImplTest {
    
    public PermissoesTransferenciaDAOImplTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of consultarPorUsuario method, of class PermissoesTransferenciaDAOImpl.
     */
    @Test
    public void testConsultarPorUsuario() throws Exception {
        System.out.println("consultarPorUsuario");
        int id_usuario = 1;
        PermissoesTransferenciaDAOImpl instance = new PermissoesTransferenciaDAOImpl();
        List<PermissaoTransferencia> result = instance.consultarPorUsuario(id_usuario);
//        assertTrue(result == null );
        assertTrue(result != null && result.size() > 0 && result.get(0) != null);
    }
    
}
