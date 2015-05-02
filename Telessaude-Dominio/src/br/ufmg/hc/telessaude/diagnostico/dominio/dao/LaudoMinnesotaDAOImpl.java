/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl.DaoBase;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.diagnostico.dominio.glasgow.LaudoMinnesota;
import br.ufmg.hc.telessaude.diagnostico.dominio.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author paulo.gomes
 */
public class LaudoMinnesotaDAOImpl extends DaoBase<LaudoMinnesota> {

    public LaudoMinnesotaDAOImpl() {
        super(LaudoMinnesota.class);
    }
    
    public List<LaudoMinnesota> consultarPorExame(Integer idExame) throws DAOException{
        return this.findByRestrictions(0, 0, Order.asc("exame"), Restrictions.eq("exame.id", idExame));
    }

    public void saveOrUpdate(List<LaudoMinnesota> object) throws DAOException {
        try {
            session = HibernateUtil.currentSession();
            transaction = session.beginTransaction();
            for (LaudoMinnesota laudoMinnesota : object) {
                session.saveOrUpdate(laudoMinnesota);
            }
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            throw new DAOException(ex.getMessage());
        } finally {
            this.closeSession();
        }
    }
    
    
    
    

}
