/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.teletransferencia.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl.DaoBase;
import br.ufmg.hc.telessaude.teletransferencia.dao.ProjetoTransferenciaDAO;
import br.ufmg.hc.telessaude.teletransferencia.entity.ProjetoTransferencia;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

/**
 *
 * @author weslley.matos
 */
public class ProjetoTransferenciaDAOImpl extends DaoBase<ProjetoTransferencia> implements ProjetoTransferenciaDAO{
    
    /**
     * 
     */
    public ProjetoTransferenciaDAOImpl() {
        super(ProjetoTransferencia.class);
    }

    /**
     * 
     * @param firstResult
     * @param maxResults
     * @return 
     */
    @Override
    public List<ProjetoTransferencia> find(final int firstResult, final int maxResults) {
        final Criteria criteria = createCustomCriteria();
        
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResults);
        
        return criteria.list();
        
    }

    /**
     * 
     * @return 
     */
    @Override
    public Integer count() {
        final Criteria criteria = createCustomCriteria();
        final Projection projection = Projections.projectionList().add(Projections.count("id"));
        criteria.setProjection(projection);
        
        return (Integer) criteria.uniqueResult();
    }
}
