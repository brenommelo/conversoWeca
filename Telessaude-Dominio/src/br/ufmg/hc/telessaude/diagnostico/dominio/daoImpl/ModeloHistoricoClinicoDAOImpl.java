/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.ModeloHistoricoClinicoDAO;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.ModeloHistoricoClinico;
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
public class ModeloHistoricoClinicoDAOImpl extends DaoBase<ModeloHistoricoClinico> implements ModeloHistoricoClinicoDAO {

    public ModeloHistoricoClinicoDAOImpl() {
        super(ModeloHistoricoClinico.class);
    }

    @Override
    public ModeloHistoricoClinico findByName(String name) throws DAOException {
        try {
            final DetachedCriteria crit = DetachedCriteria.forClass(c);
            final Criteria criteria = crit.getExecutableCriteria(HibernateUtil.currentSession());
            criteria.add(Restrictions.eq("conteudo", name));
            criteria.setMaxResults(1);
            return (ModeloHistoricoClinico) criteria.uniqueResult();
        } catch (HibernateException ex) {
            throw new DAOException(ex.getMessage());
        }
    }

}
