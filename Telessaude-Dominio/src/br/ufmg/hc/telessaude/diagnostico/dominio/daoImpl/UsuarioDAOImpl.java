/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.UsuarioDAO;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.Usuario;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.diagnostico.dominio.hibernate.HibernateUtil;
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
public class UsuarioDAOImpl extends DaoBase<Usuario> implements UsuarioDAO {

    public UsuarioDAOImpl() {
        super(Usuario.class);
    }

    /**
     *
     * @param login
     * @param senha
     * @return
     * @throws DAOException
     */
    @Override
    public Usuario logon(final String login, final String senha) throws DAOException {
        try {
            final DetachedCriteria crit = DetachedCriteria.forClass(c);
            crit.add(Restrictions.eq("usuario", login));
            crit.add(Restrictions.eq("senha", senha));
            return (Usuario) crit.getExecutableCriteria(HibernateUtil.currentSession()).uniqueResult();
        } catch (Exception ex) {
            throw new DAOException(ex.getMessage());
        }
    }

    /**
     *
     * @param login
     * @return
     * @throws DAOException
     */
    @Override
    public Usuario findByLogin(final String login) throws DAOException {
        try {
            final DetachedCriteria crit = DetachedCriteria.forClass(c);
            crit.add(Restrictions.eq("usuario", login));
            return (Usuario) crit.getExecutableCriteria(HibernateUtil.currentSession()).uniqueResult();
        } catch (Exception ex) {
            throw new DAOException(ex.getMessage());
        }
    }

    @Override
    public List<Usuario> consultarTodos(int start, int maxResults) throws DAOException {
        return findByRestrictions(start, maxResults, Order.asc("nome"), (Criterion[]) null);
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
