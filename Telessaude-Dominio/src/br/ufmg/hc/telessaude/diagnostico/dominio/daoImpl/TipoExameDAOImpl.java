/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.TipoExameDAO;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.TipoExame;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.diagnostico.dominio.hibernate.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author paulo.gomes
 */
public class TipoExameDAOImpl extends DaoBase<TipoExame> implements TipoExameDAO {

    public TipoExameDAOImpl() {
        super(TipoExame.class);
    }

    @Override
    public TipoExame findByName(String name) throws DAOException {
        try {
            final DetachedCriteria crit = DetachedCriteria.forClass(c);
            final Criteria criteria = crit.getExecutableCriteria(HibernateUtil.currentSession());
            criteria.add(Restrictions.eq("nome", name));
            criteria.setMaxResults(1);
            return (TipoExame) criteria.uniqueResult();
        } catch (HibernateException ex) {
            throw new DAOException(ex.getMessage());
        }
    }

}
