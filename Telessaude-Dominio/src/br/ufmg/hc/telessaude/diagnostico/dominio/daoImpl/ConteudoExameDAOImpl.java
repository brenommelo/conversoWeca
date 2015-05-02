/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.ConteudoExameDAO;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.ConteudoExame;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author paulo.gomes
 */
public class ConteudoExameDAOImpl extends DaoBase<ConteudoExame> implements ConteudoExameDAO {

    public ConteudoExameDAOImpl() {
        super(ConteudoExame.class);
    }

    @Override
    public List<ConteudoExame> consultarPorIdExame(Integer idExame) throws DAOException {
        return findByRestrictions(0, Restrictions.eq("exame.id", idExame));
    }

}
