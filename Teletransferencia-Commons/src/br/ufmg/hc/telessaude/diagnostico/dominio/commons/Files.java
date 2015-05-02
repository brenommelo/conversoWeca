/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.diagnostico.dominio.commons;

/**
 *
 * @author weslley.matos
 */
public enum Files {
    
    CONFIGURATION("configuration.ini"), 
    POSTGRESQL("postgresql.ini"),
    CONFIG("config.ini"),
    CONFIGURACAO("config.ini");
    
    private final String name;
    
    /**
     * 
     * @param name 
     */
    Files(final String name) {
        this.name = name;
    }
    
    /**
     * 
     * @return 
     */
    public String getFileName() {
        return name;
    }
}
