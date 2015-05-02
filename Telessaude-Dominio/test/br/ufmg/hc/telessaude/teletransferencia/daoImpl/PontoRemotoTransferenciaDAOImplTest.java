/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.teletransferencia.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.teletransferencia.entity.PontoRemotoTransferencia;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author paulo.gomes
 */
public class PontoRemotoTransferenciaDAOImplTest {
    
    public PontoRemotoTransferenciaDAOImplTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testConsultarTodos() throws DAOException {
        List<PontoRemotoTransferencia> pontos = new PontoRemotoTransferenciaDAOImpl().findAll();
        assertTrue(pontos != null && pontos.size() > 0);
    }
    
    @Test
    public void testConsultarPorId() throws DAOException {
        PontoRemotoTransferencia pontos = new PontoRemotoTransferenciaDAOImpl().findById(1);
        assertTrue(pontos != null);
    }
    
}
