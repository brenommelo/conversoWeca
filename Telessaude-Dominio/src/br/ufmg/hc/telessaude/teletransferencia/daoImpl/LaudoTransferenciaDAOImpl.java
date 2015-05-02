/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.teletransferencia.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl.DaoBase;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.diagnostico.dominio.hibernate.HibernateUtil;
import br.ufmg.hc.telessaude.teletransferencia.dao.LaudoTransferenciaDAO;
import br.ufmg.hc.telessaude.teletransferencia.entity.LaudoTransferencia;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author paulo.gomes
 */
public class LaudoTransferenciaDAOImpl extends DaoBase<LaudoTransferencia> implements LaudoTransferenciaDAO {

    public LaudoTransferenciaDAOImpl() {
        super(LaudoTransferencia.class);
    }

    @Override
    public LaudoTransferencia consultarPorIdExame(Integer idExame) throws DAOException {
        List<LaudoTransferencia> laudos = findByRestrictions(0, Restrictions.eq("exame.id", idExame));
        if (laudos != null && laudos.size() > 0) {
            return laudos.get(0);
        }
        return null;
    }

    @Override
    public List<LaudoTransferencia> consultarLaudosPorIdExame(Integer idExame) throws DAOException {
        return findByRestrictions(0, Restrictions.eq("exame.id", idExame));
    }

    @Override
    public List<LaudoTransferencia> consultarLaudosPorEspecialistaDoDia(Integer idUsuario) throws DAOException {
        final DetachedCriteria crit = DetachedCriteria.forClass(c);
        final Criteria criteria = crit.getExecutableCriteria(HibernateUtil.currentSession());
        criteria.createAlias("especialista", "esp");

        criteria.add(Restrictions.eq("esp.usuario.id", idUsuario));
        Calendar dataIn = Calendar.getInstance();
        dataIn.set(Calendar.HOUR_OF_DAY, 0);
        dataIn.set(Calendar.MINUTE, 0);
        dataIn.set(Calendar.SECOND, 0);
        Calendar dataFim = Calendar.getInstance();
        dataFim.set(Calendar.HOUR_OF_DAY, 23);
        dataFim.set(Calendar.MINUTE, 59);
        dataFim.set(Calendar.SECOND, 59);

        criteria.add(Restrictions.between("dataInclusao", dataIn.getTime(), dataFim.getTime()));
        criteria.addOrder(Order.desc("dataInclusao"));
        return criteria.list();
    }

}
