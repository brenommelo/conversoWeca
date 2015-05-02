/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.diagnostico.dominio.glasgow;

import br.ufmg.hc.telessaude.diagnostico.dominio.entity.PojoBase;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author paulo.gomes
 */
@Entity
@Table(name = "\"MINNESOTA_GROUP\"",schema = PojoBase.DB)
public class MinnesotaGroup  implements Serializable{
    
    @Id
    private Integer id;
    private String title;
    @Column(columnDefinition = "text")
    private String description;
    
    @Transient
    List<MinnesotaDict> codes;

    public MinnesotaGroup() {
    }

    public MinnesotaGroup(Integer id) {
        this.id = id;
    }

    public MinnesotaGroup(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MinnesotaDict> getCodes() {
        return codes;
    }

    public void setCodes(List<MinnesotaDict> codes) {
        this.codes = codes;
    }
    
}
