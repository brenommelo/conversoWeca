/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.diagnostico.dominio.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.entity.PontoRemoto;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import java.util.List;

/**
 *
 * @author lucas.carvalho
 */
public interface PontoRemotoDAO extends GenericDao<PontoRemoto>{
    
    public List<PontoRemoto> consultarTodos(int start, int maxResults) throws DAOException;
    public List<PontoRemoto> consultarTodos() throws DAOException;
    public Integer consultarQuantidade() throws DAOException;
    public PontoRemoto consultarId(Integer id) throws DAOException;
    
}
