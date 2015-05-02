/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.teletransferencia.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.GenericDao;
import br.ufmg.hc.telessaude.teletransferencia.entity.MensagemTransferencia;
import java.util.List;

/**
 *
 * @author paulo.gomes
 */
public interface MensagemTransferenciaDAO extends GenericDao<MensagemTransferencia>{
 
    /**
     * 
     * @param firstResult
     * @param maxResults
     * @param entity
     * @return 
     */
    public List<MensagemTransferencia> findByRestrictions(final int firstResult, final int maxResults, final MensagemTransferencia entity);
    
    /**
     * 
     * @param entity
     * @return 
     */
    public Integer countByRestrictions(final MensagemTransferencia entity);
}
