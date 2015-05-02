/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.teletransferencia.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl.DaoBase;
import br.ufmg.hc.telessaude.teletransferencia.dao.MensagemTransferenciaDAO;
import br.ufmg.hc.telessaude.teletransferencia.entity.MensagemTransferencia;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author paulo.gomes
 */
public class MensagemTransferenciaDAOImpl extends DaoBase<MensagemTransferencia> implements MensagemTransferenciaDAO{

    public MensagemTransferenciaDAOImpl() {
        super(MensagemTransferencia.class);
    }
    
    /**
     * 
     * @param firstResult
     * @param maxResults
     * @param entity
     * @return 
     */
    @Override
    public List<MensagemTransferencia> findByRestrictions(final int firstResult, final int maxResults, final MensagemTransferencia entity) {
        final Criteria criteria = createCustomCriteria();
        if(entity.getTexto() != null && !entity.getTexto().isEmpty()) {
            final Criterion criterion = Restrictions.like("texto", entity.getTexto(), MatchMode.ANYWHERE);
            criteria.add(criterion);    
        }
        
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResults);
        
        return criteria.list();
    }
    
    /**
     * 
     * @param entity
     * @return 
     */
    @Override
    public Integer countByRestrictions(final MensagemTransferencia entity) {
        final Criteria criteria = createCustomCriteria();
        final Projection projection = Projections.projectionList().add(Projections.count("id"));
        criteria.setProjection(projection);
        
        if(entity.getTexto() != null && !entity.getTexto().isEmpty()) {
            final Criterion criterion = Restrictions.like("texto", entity.getTexto(), MatchMode.ANYWHERE);
            criteria.add(criterion);    
        }
        
        return (Integer) criteria.uniqueResult();
    }
    
}
