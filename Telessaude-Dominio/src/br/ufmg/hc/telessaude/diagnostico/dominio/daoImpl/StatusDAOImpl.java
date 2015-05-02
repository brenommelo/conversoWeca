/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.StatusDAO;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.Status;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.diagnostico.dominio.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author paulo.gomes
 */
public class StatusDAOImpl extends DaoBase<Status> implements StatusDAO {

    public StatusDAOImpl() {
        super(Status.class);
    }

    @Override
    public Status findByName(String name) throws DAOException {
        try {
            final DetachedCriteria crit = DetachedCriteria.forClass(c);
            final Criteria criteria = crit.getExecutableCriteria(HibernateUtil.currentSession());
            criteria.add(Restrictions.eq("nome", name));
            criteria.setMaxResults(1);
            return (Status) criteria.uniqueResult();
        } catch (HibernateException ex) {
            throw new DAOException(ex.getMessage());
        }
    }

}
