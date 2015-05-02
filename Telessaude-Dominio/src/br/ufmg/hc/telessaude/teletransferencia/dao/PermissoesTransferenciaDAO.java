/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.teletransferencia.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.GenericDao;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.teletransferencia.entity.PermissaoTransferencia;
import java.util.List;

/**
 *
 * @author paulo.gomes
 */
public interface PermissoesTransferenciaDAO extends GenericDao<PermissaoTransferencia>{
    
    public List<PermissaoTransferencia> consultarPorUsuario(int id_usuario) throws DAOException;
    
    public List<Object> consultarIdsTipoExamePorUsuario(final int id_usuario) throws DAOException;
    

}
