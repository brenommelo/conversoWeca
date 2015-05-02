/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.entity.ModeloHistoricoClinico;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;

/**
 *
 * @author paulo.gomes
 */
public interface ModeloHistoricoClinicoDAO extends GenericDao<ModeloHistoricoClinico>{
    
    public ModeloHistoricoClinico findByName(String name) throws DAOException;
    
}
