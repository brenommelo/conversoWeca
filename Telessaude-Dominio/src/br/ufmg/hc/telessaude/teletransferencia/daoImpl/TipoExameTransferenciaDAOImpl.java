/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.teletransferencia.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl.DaoBase;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.diagnostico.dominio.hibernate.HibernateUtil;
import br.ufmg.hc.telessaude.teletransferencia.dao.TipoExameTransferenciaDAO;
import br.ufmg.hc.telessaude.teletransferencia.entity.TipoExameTransferencia;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

/**
 *
 * @author paulo.gomes
 */
public class TipoExameTransferenciaDAOImpl extends DaoBase<TipoExameTransferencia> implements TipoExameTransferenciaDAO {

    public TipoExameTransferenciaDAOImpl() {
        super(TipoExameTransferencia.class);
    }

    @Override
    public List<TipoExameTransferencia> consultarTodos(int start, int maxResults) throws DAOException {
        return findByRestrictions(start, maxResults, Order.asc("nome"), (Criterion[]) null);
    }

    @Override
    public List<TipoExameTransferencia> consultarTodos() throws DAOException {
        return (this.findAll());
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

}
