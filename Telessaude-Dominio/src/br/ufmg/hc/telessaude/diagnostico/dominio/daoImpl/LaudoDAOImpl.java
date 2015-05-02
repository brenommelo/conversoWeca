/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.LaudoDAO;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.Laudo;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author paulo.gomes
 */
public class LaudoDAOImpl extends DaoBase<Laudo> implements LaudoDAO {

    public LaudoDAOImpl() {
        super(Laudo.class);
    }

    @Override
    public List<Laudo> consultarPorIdExame(Integer id) throws DAOException {
        return findByRestrictions(0, Restrictions.eq("exame.id", id));
    }

    @Override
    public Laudo consultarUnicoPorIdExame(Integer id) throws DAOException {
        List<Laudo> lds = findByRestrictions(1, Restrictions.eq("exame.id", id));
        if (lds != null && lds.size() > 0) {
            return lds.get(0);
        }
        return null;
    }

}
