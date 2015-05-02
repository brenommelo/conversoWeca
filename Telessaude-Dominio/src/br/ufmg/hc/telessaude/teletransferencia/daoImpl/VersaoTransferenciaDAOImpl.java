/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.teletransferencia.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl.DaoBase;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.diagnostico.dominio.hibernate.HibernateUtil;
import br.ufmg.hc.telessaude.teletransferencia.dao.VersaoTransferenciaDAO;
import br.ufmg.hc.telessaude.teletransferencia.entity.VersaoTransferencia;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author paulo.gomes
 */
public class VersaoTransferenciaDAOImpl extends DaoBase<VersaoTransferencia> implements VersaoTransferenciaDAO {
    
    public VersaoTransferenciaDAOImpl() {
        super(VersaoTransferencia.class);
        
    }
    
    @Override
    public VersaoTransferencia retornarUltimaVersao() throws DAOException {
        VersaoTransferencia versao = null;
        try {
            final DetachedCriteria crit = DetachedCriteria.forClass(c);
            crit.addOrder(Order.desc("versao"));
            final Criteria criteria = crit.getExecutableCriteria(HibernateUtil.currentSession());
            criteria.setMaxResults(1);
            versao = (VersaoTransferencia) criteria.uniqueResult();
            return versao;
        } catch (HibernateException ex) {
            throw new DAOException(ex.getMessage());
        }
    }
    
    @Override
    public Integer consultarQuantidade(String versao) throws DAOException {
        Integer quantidade = 0;
        try {
            final DetachedCriteria crit = DetachedCriteria.forClass(c);
            final Criteria criteria = crit.getExecutableCriteria(HibernateUtil.currentSession());
            
            criteria.add(Restrictions.ilike("versao", versao, MatchMode.ANYWHERE));
            
            criteria.setProjection(Projections.count("id"));
            quantidade = (Integer) criteria.uniqueResult();
            return quantidade != null ? quantidade : 0;
            
        } catch (HibernateException ex) {
            throw new DAOException(ex.getMessage());
        }
    }
    
    @Override
    public List<VersaoTransferencia> consultarChave(String versao, int start, int maxResult) throws DAOException {
        return findByRestrictions(start, maxResult, Order.desc("versao"), Restrictions.ilike("versao", versao, MatchMode.ANYWHERE));
    }
    
    @Override
    public VersaoTransferencia consultarVersao(String versaoStr) throws DAOException {
        VersaoTransferencia versao = null;
        try {
            final DetachedCriteria crit = DetachedCriteria.forClass(c);
            crit.add(Restrictions.eq("versao", versaoStr));
            final Criteria criteria = crit.getExecutableCriteria(HibernateUtil.currentSession());
            criteria.setMaxResults(1);
            versao = (VersaoTransferencia) criteria.uniqueResult();
            return versao;
        } catch (HibernateException ex) {
            throw new DAOException(ex.getMessage());
        }
    }
    
}
