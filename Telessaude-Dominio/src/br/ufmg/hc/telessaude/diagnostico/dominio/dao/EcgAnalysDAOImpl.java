/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl.DaoBase;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.diagnostico.dominio.glasgow.EcgAnalys;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author paulo.gomes
 */
public class EcgAnalysDAOImpl extends DaoBase<EcgAnalys> {

    public EcgAnalysDAOImpl() {
        super(EcgAnalys.class);
    }   
    
    public List<EcgAnalys> findByIdExame(Integer id) throws DAOException{
        return findByRestrictions(0, 0, Order.asc("register"),Restrictions.eq("idExame", id));
    }

}
