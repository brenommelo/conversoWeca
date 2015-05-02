/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.entity;

import java.io.Serializable;

/**
 *
 * @author weslley.matos
 */
public class DadoClinico implements Serializable {
    
    private String descricao;
    
    private String valor;
    
    /**
     * 
     * @param descricao
     * @param valor 
     */
    public DadoClinico(String descricao, String valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

   
}
