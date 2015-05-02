/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.teletransferencia.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.GenericDao;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.teletransferencia.entity.UsuarioTransferencia;
import java.util.List;

/**
 *
 * @author paulo.gomes
 */
public interface UsuarioTransferenciaDAO extends GenericDao<UsuarioTransferencia>{
    
    public UsuarioTransferencia findByIdDiagnostico(int idDiagnostico)throws DAOException;
    public List<UsuarioTransferencia> consultarTodos(int start, int maxResults) throws DAOException;
    public Integer consultarQuantidade() throws DAOException;
    
}
