/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.PontoRemotoDAO;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.PontoRemoto;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.diagnostico.dominio.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;

/**
 *
 * @author lucas.carvalho
 */
public class PontoRemotoDAOImpl extends DaoBase<PontoRemoto> implements PontoRemotoDAO {

    public PontoRemotoDAOImpl() {
        super(PontoRemoto.class);
    }

    @Override
    public List<PontoRemoto> consultarTodos(int start, int maxResults) throws DAOException {
        return (findByRestrictions(start, maxResults, (Criterion) null));
    }
    
        @Override
    public List<PontoRemoto> consultarTodos() throws DAOException {
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
    
    @Override
    public PontoRemoto consultarId(Integer id) throws DAOException
    {
        return (findById(id));
    }
}
