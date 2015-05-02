/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.entity.Status;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;

/**
 *
 * @author paulo.gomes
 */
public interface StatusDAO extends GenericDao<Status>{
    
    public Status findByName(String name) throws DAOException;
    
}
