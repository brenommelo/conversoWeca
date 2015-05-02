/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.teletransferencia.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl.DaoBase;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.diagnostico.dominio.hibernate.HibernateUtil;
import br.ufmg.hc.telessaude.teletransferencia.dao.UsuarioTransferenciaDAO;
import br.ufmg.hc.telessaude.teletransferencia.entity.UsuarioTransferencia;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author paulo.gomes
 */
public class UsuarioTransferenciaDAOImpl extends DaoBase<UsuarioTransferencia> implements UsuarioTransferenciaDAO {

    public UsuarioTransferenciaDAOImpl() {
        super(UsuarioTransferencia.class);
    }

    @Override
    public UsuarioTransferencia findByIdDiagnostico(int idDiagnostico) throws DAOException {
        try {
            DetachedCriteria crit = DetachedCriteria.forClass(c);
            crit.add(Restrictions.eq("idDiagnostico", idDiagnostico));
            return (UsuarioTransferencia) crit.getExecutableCriteria(HibernateUtil.currentSession()).uniqueResult();
        } catch (Exception ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    @Override
    public List<UsuarioTransferencia> consultarTodos(int start, int maxResults) throws DAOException {
        return findByRestrictions(start, maxResults,Order.asc("nome"), (Criterion[]) null);
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
