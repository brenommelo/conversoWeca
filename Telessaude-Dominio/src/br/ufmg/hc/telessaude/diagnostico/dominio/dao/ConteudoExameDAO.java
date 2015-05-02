/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.entity.ConteudoExame;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import java.util.List;

/**
 *
 * @author paulo.gomes
 */
public interface ConteudoExameDAO extends GenericDao<ConteudoExame>{
    
    public List<ConteudoExame> consultarPorIdExame(Integer idExame) throws DAOException;
    
}
