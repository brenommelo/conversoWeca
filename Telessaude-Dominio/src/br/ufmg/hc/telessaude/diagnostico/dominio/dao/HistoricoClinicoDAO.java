/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.entity.HistoricoClinico;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import java.util.List;

/**
 *
 * @author paulo.gomes
 */
public interface HistoricoClinicoDAO extends GenericDao<HistoricoClinico>{
    
    public List<HistoricoClinico> consultarPorIdExame(Integer idExame) throws DAOException;
    
}
