/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.auditoria.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.auditoria.dao.AuditoriaECGDAO;
import br.ufmg.hc.telessaude.diagnostico.dominio.auditoria.entity.AuditoriaECG;
import br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl.DaoBase;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author paulo.gomes
 */
public class AuditoriaECGDAOImpl extends DaoBase<AuditoriaECG> implements AuditoriaECGDAO {

    public AuditoriaECGDAOImpl() {
        super(AuditoriaECG.class);
    }

    @Override
    public List<AuditoriaECG> consultarAuditoria(Integer idLaudo) throws DAOException {
        return findByRestrictions(0, 0, Order.desc("laudo.id"), Restrictions.eq("laudo.id", idLaudo));
    }

}
