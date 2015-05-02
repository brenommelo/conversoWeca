/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.teletransferencia.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl.DaoBase;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.diagnostico.dominio.hibernate.HibernateUtil;
import br.ufmg.hc.telessaude.teletransferencia.dao.ConfiguracaoTransferenciaDAO;
import br.ufmg.hc.telessaude.teletransferencia.entity.ConfiguracaoTransferencia;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author paulo.gomes
 */
public class ConfiguracaoTransferenciaDAOImpl extends DaoBase<ConfiguracaoTransferencia> implements ConfiguracaoTransferenciaDAO{

    public ConfiguracaoTransferenciaDAOImpl() {
        super(ConfiguracaoTransferencia.class);
    }

    @Override
    public ConfiguracaoTransferencia consultarPelaChave(String chave) throws DAOException {
        List<ConfiguracaoTransferencia> configs = findByRestrictions(1, Restrictions.eq("chave", chave));
        if (configs != null && configs.size() > 0) {
            return configs.get(0);
        }
        return null;
    }

    @Override
    public List<ConfiguracaoTransferencia> consultarChave(String chave, int start, int maxResults) throws DAOException {
        return findByRestrictions(start, maxResults, Restrictions.ilike("chave", chave, MatchMode.ANYWHERE));
    }

    @Override
    public Integer consultarQuantidade(String chave) throws DAOException{
         Integer quantidade = 0;
        try {
            final DetachedCriteria crit = DetachedCriteria.forClass(c);
            final Criteria criteria = crit.getExecutableCriteria(HibernateUtil.currentSession());
            if (chave != null) {
                criteria.add(Restrictions.ilike("chave", chave, MatchMode.ANYWHERE));
            }
            criteria.setProjection(Projections.count("id"));
            quantidade = (Integer) criteria.uniqueResult();
            return quantidade != null ? quantidade : 0;

        } catch (HibernateException ex) {
            throw new DAOException(ex.getMessage());
        }
    }


    
    
    
}
