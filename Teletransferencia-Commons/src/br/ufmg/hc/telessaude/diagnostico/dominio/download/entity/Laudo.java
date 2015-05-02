/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.diagnostico.dominio.download.entity;

/**
 *
 * @author weslley.matos
 */
public class Laudo {
    
    private int id_exame;
    
    private int id_usuario;
    
    private String dataRealizacao;
    
    private String diretorioLaudo;

    /**
     * @return the id_exame
     */
    public int getIdExame() {
        return id_exame;
    }

    /**
     * @param id_exame the id_exame to set
     */
    public void setIdExame(int id_exame) {
        this.id_exame = id_exame;
    }

    /**
     * @return the id_usuario
     */
    public int getIdUsuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setIdUsuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the dataRealizacao
     */
    public String getDataRealizacao() {
        return dataRealizacao;
    }

    /**
     * @param dataRealizacao the dataRealizacao to set
     */
    public void setDataRealizacao(String dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    /**
     * @return the diretorioLaudo
     */
    public String getDiretorioLaudo() {
        return diretorioLaudo;
    }

    /**
     * @param diretorioLaudo the diretorioLaudo to set
     */
    public void setDiretorioLaudo(String diretorioLaudo) {
        this.diretorioLaudo = diretorioLaudo;
    }
    
}
