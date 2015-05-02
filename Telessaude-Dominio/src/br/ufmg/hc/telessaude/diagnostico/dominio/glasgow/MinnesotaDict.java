/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.diagnostico.dominio.glasgow;

import br.ufmg.hc.telessaude.diagnostico.dominio.entity.PojoBase;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author paulo.gomes
 */
@Entity
@Table(name = "\"MINNESOTA_DICT\"",schema = PojoBase.DB)
public class MinnesotaDict implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    @Column(name = "local_text")
    private String localText;
    @Column(columnDefinition = "text")
    private String descrition;
    @Column(name = "group_code")
    private Integer group;

    public MinnesotaDict() {
    }

    public MinnesotaDict(Integer id) {
        this.id = id;
    }

    public MinnesotaDict(Integer id, String code, String localText, String descrition) {
        this.id = id;
        this.code = code;
        this.localText = localText;
        this.descrition = descrition;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLocalText() {
        return localText;
    }

    public void setLocalText(String localText) {
        this.localText = localText;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }
    
}
