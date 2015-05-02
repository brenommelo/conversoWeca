/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.teletransferencia.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.GenericDao;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.teletransferencia.entity.LaudoTransferencia;
import java.util.List;

/**
 *
 * @author paulo.gomes
 */
public interface LaudoTransferenciaDAO extends GenericDao<LaudoTransferencia>{
    
    public LaudoTransferencia consultarPorIdExame(Integer idExame) throws DAOException;
    
    public List<LaudoTransferencia> consultarLaudosPorIdExame(Integer idExame) throws DAOException;
    
    public List<LaudoTransferencia> consultarLaudosPorEspecialistaDoDia(Integer idUsuario) throws DAOException;
    
}
