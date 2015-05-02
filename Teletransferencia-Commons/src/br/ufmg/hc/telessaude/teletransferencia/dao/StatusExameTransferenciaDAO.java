/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.teletransferencia.dao;

/**
 *
 * @author paulo.gomes
 */
public interface StatusExameTransferenciaDAO {
    
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
}
