/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.ModeloConteudoExameDAO;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.ModeloConteudoExame;
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
public class ModeloConteudoExameDAOImpl extends DaoBase<ModeloConteudoExame> implements ModeloConteudoExameDAO {

    public ModeloConteudoExameDAOImpl() {
        super(ModeloConteudoExame.class);
    }

    @Override
    public ModeloConteudoExame findByName(String name) throws DAOException {
        try {
            final DetachedCriteria crit = DetachedCriteria.forClass(c);
            final Criteria criteria = crit.getExecutableCriteria(HibernateUtil.currentSession());
            criteria.add(Restrictions.eq("conteudo", name));
            criteria.setMaxResults(1);
            return (ModeloConteudoExame) criteria.uniqueResult();
        } catch (HibernateException ex) {
            throw new DAOException(ex.getMessage());
        }
    }

}
