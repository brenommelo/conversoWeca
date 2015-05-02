/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.teletransferencia.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.GenericDao;
import br.ufmg.hc.telessaude.teletransferencia.entity.ProjetoTransferencia;
import java.util.List;

/**
 *
 * @author weslley.matos
 */
public interface ProjetoTransferenciaDAO extends GenericDao<ProjetoTransferencia>{
    
    /**
     * 
     * @param firstResult
     * @param maxResults
     * @return 
     */
    public List<ProjetoTransferencia> find(final int firstResult, final int maxResults);
    
    /**
     * 
     * @return 
     */
    public Integer count();
}
