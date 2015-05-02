/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl.DaoBase;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.diagnostico.dominio.glasgow.MinnesotaCode;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author paulo.gomes
 */
public class MinnesotaCodeDAOImpl extends DaoBase<MinnesotaCode> {

    public MinnesotaCodeDAOImpl() {
        super(MinnesotaCode.class);
    }

    public List<MinnesotaCode> consultarPorIdExame(Integer idExame) throws DAOException {
        return findByRestrictions(0, Restrictions.eq("idExame", idExame));
    }

}
