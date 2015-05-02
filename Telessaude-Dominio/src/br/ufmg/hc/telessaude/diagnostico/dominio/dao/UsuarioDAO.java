/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.entity.Usuario;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import java.util.List;

/**
 *
 * @author paulo.gomes
 */
public interface UsuarioDAO extends GenericDao<Usuario>{
       
    /**
     * 
     * @param login
     * @param senha
     * @return
     * @throws DAOException 
     */
    public Usuario logon(final String login, final String senha) throws DAOException;
    
    /**
     * 
     * @param login
     * @return
     * @throws DAOException 
     */
    public Usuario findByLogin(final String login) throws DAOException;
    
    public List<Usuario> consultarTodos(int start, int maxResults) throws DAOException;
    
    public Integer consultarQuantidade() throws DAOException;
    
}
