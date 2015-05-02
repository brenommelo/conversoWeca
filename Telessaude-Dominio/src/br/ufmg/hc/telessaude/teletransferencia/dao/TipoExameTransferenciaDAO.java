/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.teletransferencia.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.GenericDao;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.teletransferencia.entity.TipoExameTransferencia;
import java.util.List;

/**
 *
 * @author paulo.gomes
 */
public interface TipoExameTransferenciaDAO extends GenericDao<TipoExameTransferencia>{
    
    public List<TipoExameTransferencia> consultarTodos(final int start, int maxResults) throws DAOException;
    
    public List<TipoExameTransferencia> consultarTodos() throws DAOException;

    public Integer consultarQuantidade() throws DAOException;
    
}
