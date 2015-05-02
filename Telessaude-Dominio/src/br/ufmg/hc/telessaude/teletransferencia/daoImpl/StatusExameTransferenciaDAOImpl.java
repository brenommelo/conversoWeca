/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.teletransferencia.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl.DaoBase;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.diagnostico.dominio.hibernate.HibernateUtil;
import br.ufmg.hc.telessaude.teletransferencia.dao.StatusExameTransferenciaDAO;
import br.ufmg.hc.telessaude.teletransferencia.entity.StatusTransferencia;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author paulo.gomes
 */
public class StatusExameTransferenciaDAOImpl extends DaoBase<StatusTransferencia> implements StatusExameTransferenciaDAO {

    public StatusExameTransferenciaDAOImpl() {
        super(StatusTransferencia.class);
    }

    @Override
    public StatusTransferencia consultarPeloNome(String nome) throws DAOException {
        List<StatusTransferencia> status = findByRestrictions(1, Restrictions.eq("nome", nome));
        if (status != null && status.size() > 0) {
            return status.get(0);
        }
        return null;
    }

    @Override
    public List<StatusTransferencia> consultarTodos(int start, int maxResults) throws DAOException {
        return findByRestrictions(start, maxResults, (Criterion[]) null);
    }
    
    @Override
    public Integer consultarQuantidade() throws DAOException {
        Integer quantidade = 0;
        try {
            final DetachedCriteria crit = DetachedCriteria.forClass(c);
            final Criteria criteria = crit.getExecutableCriteria(HibernateUtil.currentSession());
            criteria.setProjection(Projections.count("id"));
            quantidade = (Integer) criteria.uniqueResult();
            return quantidade != null ? quantidade : 0;

        } catch (HibernateException ex) {
            throw new DAOException(ex.getMessage());
        }
    }

    @Override
    public Integer consultarId(String nomeStatus) throws DAOException {
        List<Object> status = findByRestrictions(0, 1, getProjectList(Projections.property("id")), Restrictions.eq("nome", nomeStatus));
        if (status != null && status.size() > 0) {
            return (Integer)status.get(0);
        }
        return null;
    }

}
