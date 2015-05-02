/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.teletransferencia.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.GenericDao;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.teletransferencia.entity.StatusTransferencia;
import java.util.List;

/**
 *
 * @author paulo.gomes
 */
public interface StatusExameTransferenciaDAO extends GenericDao<StatusTransferencia>{
    
    public enum STATUS{
        EM_PROCESSAMENTO("EM PROCESSAMENTO"),
        CONCLUIDO("CONCLUIDO"),
        ERRO("ERRO"),
        LAUDANDO("LAUDANDO");
        private String nome;

        private STATUS(String nomeStatus) {
            this.nome = nomeStatus;
        }

        @Override
        public String toString() {
            return this.nome;
        }
        
    }
    
    public StatusTransferencia consultarPeloNome(final String nome) throws DAOException;
    
    public List<StatusTransferencia> consultarTodos(final int start, int maxResults) throws DAOException;
    
    public Integer consultarQuantidade() throws DAOException;
    
    public Integer consultarId(final String nomeStatus) throws DAOException; 
    
}
