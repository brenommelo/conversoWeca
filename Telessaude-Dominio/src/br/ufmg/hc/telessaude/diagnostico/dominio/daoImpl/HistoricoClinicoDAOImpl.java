/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.HistoricoClinicoDAO;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.HistoricoClinico;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author paulo.gomes
 */
public class HistoricoClinicoDAOImpl extends DaoBase<HistoricoClinico> implements HistoricoClinicoDAO{

    public HistoricoClinicoDAOImpl() {
        super(HistoricoClinico.class);
    }

    @Override
    public List<HistoricoClinico> consultarPorIdExame(Integer idExame) throws DAOException {
        return findByRestrictions(0, Restrictions.eq("exame.id", idExame));
    }
    
}
