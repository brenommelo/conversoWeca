/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.PerfilDAO;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.PerfilUsuario;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import java.util.List;

/**
 *
 * @author lucas.carvalho
 */
public class PerfilDAOImpl extends DaoBase<PerfilUsuario> implements PerfilDAO{

    public PerfilDAOImpl() {
        super(PerfilUsuario.class);
    }
    
    @Override
    public List<PerfilUsuario> consultarTodos() throws DAOException
    {
        return(this.findAll());
    }
    
    @Override
    public PerfilUsuario saveOrUpdate(PerfilUsuario obj) throws DAOException
    {
        return (this.saveOrUpdate(obj));
    }
    
    @Override
    public PerfilUsuario BuscarId(Integer id) throws DAOException
    {
        return(this.findById(id));
    }
    
}
