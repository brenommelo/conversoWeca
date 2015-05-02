/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.teletransferencia.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.GenericDao;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.teletransferencia.entity.EspecialistaTransferencia;
import java.util.List;

/**
 *
 * @author paulo.gomes
 */
public interface EspecialistaTransferenciaDAO extends GenericDao<EspecialistaTransferencia>{
    
    public EspecialistaTransferencia consultarPeloIdUsuario(final Integer idUsuario) throws DAOException;
    
    public List<EspecialistaTransferencia> consultarPeloNome(final String nome) throws DAOException;
    public List<EspecialistaTransferencia> consultarPeloNome(final String nome, final int start, final int maxResults) throws DAOException;
    
}
