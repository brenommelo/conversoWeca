/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.teletransferencia.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.teletransferencia.entity.ExameTransferencia;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author paulo.gomes
 */
public class ExameTransferenciaDAOImplTest {

    int id_pontoRemoto = 1;
    int start = 0;
    int maxResult = 0;

    public ExameTransferenciaDAOImplTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of consultarQuantidadeExames method, of class
     * ExameTransferenciaDAOImpl.
     */
//    @Test
    public void testConsultarQuantidadeExames() throws Exception {
        System.out.println("consultarQuantidadeExames");
        String status = "CONCLUIDO";
        ExameTransferenciaDAOImpl instance = new ExameTransferenciaDAOImpl();
        int result = instance.consultarQuantidadeExames(id_pontoRemoto, status);
        assertTrue(result > 0);
    }
    
//    @Test
    public void testExamePorId() throws Exception {
        System.out.println("testExamePorId");
        ExameTransferenciaDAOImpl instance = new ExameTransferenciaDAOImpl();
        ExameTransferencia exame = instance.findById(10);
        assertNotNull(exame);
    }

    /**
     * Test of consultarExamesConcluidos method, of class
     * ExameTransferenciaDAOImpl.
     */
//    @Test
    public void testConsultarExamesConcluidos() throws Exception {
        System.out.println("consultarExamesConcluidos");
        String nomePaciente = "";
        ExameTransferenciaDAOImpl instance = new ExameTransferenciaDAOImpl();
        List<ExameTransferencia> result = instance.consultarExamesConcluidos(nomePaciente, id_pontoRemoto, start, maxResult);
        assertTrue(result != null && result.size() > 0);
    }
    /**
     * Test of consultarExamesConcluidos method, of class
     * ExameTransferenciaDAOImpl.
     */
//    @Test
    public void testConsultarExamesNaoConcluidos() throws Exception {
        System.out.println("testConsultarExamesNaoConcluidos");
        ExameTransferenciaDAOImpl instance = new ExameTransferenciaDAOImpl();
        List<ExameTransferencia> result = instance.consultarExamesNaoLaudados(1);
        assertTrue(result != null && result.size() > 0);
    }
    
//    @Test
//    public void testConsultarTodos() throws Exception {
//        System.out.println("consultarExamesConcluidos");
//        String nomePaciente = "";
//        ExameTransferenciaDAOImpl instance = new ExameTransferenciaDAOImpl();
//        List<ExameTransferencia> result = instance.findAll();
//        assertTrue(result != null && result.size() > 0);
//    }

    /**
     * Test of consultarExames method, of class ExameTransferenciaDAOImpl.
     */
//    @Test
    public void testConsultarExames() throws Exception {
        System.out.println("consultarExames");
        ExameTransferenciaDAOImpl instance = new ExameTransferenciaDAOImpl();
        List<ExameTransferencia> result = instance.consultarExames(id_pontoRemoto, start, maxResult);
        assertTrue(result != null && result.size() > 0);
    }

    @Test
    public void testProximoExame() throws DAOException{
        System.out.println("testProximoExame");
        ExameTransferenciaDAOImpl instance = new ExameTransferenciaDAOImpl();
        ExameTransferencia result = instance.retornarProximoExameNaFila(3);
        assertTrue(result != null);
    }
    
}
