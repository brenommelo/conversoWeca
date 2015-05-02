/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.teletransferencia.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.teletransferencia.entity.PermissaoTransferencia;
import br.ufmg.hc.telessaude.teletransferencia.entity.UsuarioTransferencia;
import br.ufmg.hc.telessaude.teletransferencia.entity.VersaoTransferencia;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author paulo.gomes
 */
public class UsuarioTransferenciaDAOImplTest {
    
    public UsuarioTransferenciaDAOImplTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findByIdDiagnostico method, of class UsuarioTransferenciaDAOImpl.
     */
//    @Test
//    public void testFindByIdDiagnosticoComPermissoes() throws Exception {
//        System.out.println("findByIdDiagnostico");
//        int idDiagnostico = 1;
//        UsuarioTransferenciaDAOImpl instance = new UsuarioTransferenciaDAOImpl();
//        UsuarioTransferencia result = instance.findByIdDiagnostico(idDiagnostico);
//        assertTrue(result != null && result.getPermissoes().size() > 0);
//    }
//    
//    @Test
//    public void testFindByIdDiagnostico() throws Exception {
//        System.out.println("findByIdDiagnostico");
//        int idDiagnostico = 1;
//        UsuarioTransferenciaDAOImpl instance = new UsuarioTransferenciaDAOImpl();
//        UsuarioTransferencia result = instance.findByIdDiagnostico(idDiagnostico);
//        assertNotNull(result);
//    }
    
    @Test
    public void testsaveOrUpdate() throws DAOException
    {
        
        UsuarioTransferencia userTrans = new UsuarioTransferencia();
        userTrans.setIdDiagnostico(923);
        userTrans.setVersaoApp(new VersaoTransferencia());
        userTrans.setPermissoes(new ArrayList<PermissaoTransferencia>());
        UsuarioTransferenciaDAOImpl instance = new UsuarioTransferenciaDAOImpl();
        
        instance.saveOrUpdate(userTrans);
        assertNotNull(userTrans.getId());
        
    }
    
}
