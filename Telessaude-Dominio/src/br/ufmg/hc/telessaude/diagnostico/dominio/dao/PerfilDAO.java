/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.diagnostico.dominio.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.entity.PerfilUsuario;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import java.util.List;

/**
 *
 * @author lucas.carvalho
 */
public interface PerfilDAO extends GenericDao<PerfilUsuario>{
    
    public List<PerfilUsuario> consultarTodos() throws DAOException;
    
    public PerfilUsuario saveOrUpdate(PerfilUsuario obj) throws DAOException;
    
    public PerfilUsuario BuscarId(Integer id) throws DAOException;
    
}
