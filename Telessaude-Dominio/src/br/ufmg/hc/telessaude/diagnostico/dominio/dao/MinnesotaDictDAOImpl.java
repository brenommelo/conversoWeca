/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl.DaoBase;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.diagnostico.dominio.glasgow.MinnesotaDict;
import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author paulo.gomes
 */
public class MinnesotaDictDAOImpl extends DaoBase<MinnesotaDict> {

    public MinnesotaDictDAOImpl() {
        super(MinnesotaDict.class);
    }

    public List<MinnesotaDict> findAllOrderByGroup() throws DAOException {
        return findByRestrictions(0, 0, Order.asc("group"), (Criterion[]) null);
    }

    public List<MinnesotaDict> findByGroup(Integer group) throws DAOException {
        return findByRestrictions(0, Restrictions.eq("group", group));
    }

    public MinnesotaDict findBy(MinnesotaDict dict) throws DAOException {
        List<MinnesotaDict> result = findByRestrictions(1,
                dict.getGroup() != null ? Restrictions.eq("group", dict.getGroup()) : null,
                dict.getCode() != null ? Restrictions.eq("code", dict.getCode()) : null,
                dict.getLocalText() != null && !dict.getLocalText().isEmpty() ? Restrictions.eq("localText", dict.getLocalText()) : null
        );
        if (result != null && result.size() > 0) {
            return result.get(0);
        }
        return null;
    }

}
