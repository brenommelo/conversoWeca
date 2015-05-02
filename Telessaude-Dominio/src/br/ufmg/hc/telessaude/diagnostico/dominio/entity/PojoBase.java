/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.entity;

import java.io.Serializable;

/**
 *
 * @author paulo.gomes
 */
public abstract class PojoBase implements Serializable{
    
    public static final String DB = "\"DIAGNOSTICOBETA\"";

    public abstract Integer getId();

    public abstract void setId(Integer id);
}
