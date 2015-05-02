/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.entity.Laudo;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import java.util.List;

/**
 *
 * @author paulo.gomes
 */
public interface LaudoDAO extends GenericDao<Laudo>{
    
    public List<Laudo> consultarPorIdExame(Integer id) throws DAOException;
    
    public Laudo consultarUnicoPorIdExame(Integer id) throws DAOException;
    
}
