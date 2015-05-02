/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.teletransferencia.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.teletransferencia.dao.GrupoMensagemTransferenciaDAO;
import br.ufmg.hc.telessaude.teletransferencia.entity.GrupoMensagemTransferencia;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author paulo.gomes
 */
public class GrupoMensagemTransferenciaDAOImplTest {
    
    GrupoMensagemTransferenciaDAO instance;
    
    public GrupoMensagemTransferenciaDAOImplTest() {
        instance = new GrupoMensagemTransferenciaDAOImpl();
    }

    @Test
    public void testConsultarTodasMensagensPorUsuario() throws DAOException {
        Integer id = 1;
        List<GrupoMensagemTransferencia> msg = instance.consultarPorUsuario(id);
        assertTrue(msg != null && msg.size() > 0);
    }
    
    @Test
    public void testConsultarTodasMensagensPorUsuarioNaoEnviada() throws DAOException {
        Integer id = 1;
        List<GrupoMensagemTransferencia> msg = instance.consultarPorUsuarioNaoEnviada(id);
        assertTrue(msg != null && msg.size() > 0);
    }
    
}
