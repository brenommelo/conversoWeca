/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl.DaoBase;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.diagnostico.dominio.glasgow.MinnesotaGroup;
import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

/**
 *
 * @author paulo.gomes
 */
public class MinnesotaGroupDAOImpl extends DaoBase<MinnesotaGroup> {

    public MinnesotaGroupDAOImpl() {
        super(MinnesotaGroup.class);
    }
    
    public List<MinnesotaGroup> findAllOrderById() throws DAOException{
        return findByRestrictions(0, 0, Order.asc("id"), (Criterion[]) null);
    }

}
