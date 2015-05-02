/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.teletransferencia.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.GenericDao;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.teletransferencia.entity.ConfiguracaoTransferencia;
import java.util.List;

/**
 *
 * @author paulo.gomes
 */
public interface ConfiguracaoTransferenciaDAO extends GenericDao<ConfiguracaoTransferencia>{
    
    public ConfiguracaoTransferencia consultarPelaChave(final String chave) throws DAOException;
    
    public List<ConfiguracaoTransferencia> consultarChave(final String chave, final int start, final int maxResults) throws DAOException;

    public Integer consultarQuantidade(String chave) throws DAOException;
    
}
