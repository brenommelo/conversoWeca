/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conversorbdweka.entidades.origem;

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
@Table(name = "\"MINNESOTA_CODES\"",schema = PojoBase.DB)
public class MinnesotaCode implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "id_exame")
    private Integer idExame;
    private Integer code;
    private Integer site;
    @Column(name = "\"group\"")
    private Integer group;
    @Column(name = "minn_text")
    private String text;
    @Column(name = "loc_text")
    private String local;
    @Column(name = "register_num")
    private Integer register;

    public MinnesotaCode() {
    }

    public MinnesotaCode(Integer id) {
        this.id = id;
    }

    public MinnesotaCode(Integer id, Integer idExame, Integer code, Integer site, Integer group, String text, String local) {
        this.id = id;
        this.idExame = idExame;
        this.code = code;
        this.site = site;
        this.group = group;
        this.text = text;
        this.local = local;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdExame() {
        return idExame;
    }

    public void setIdExame(Integer idExame) {
        this.idExame = idExame;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getSite() {
        return site;
    }

    public void setSite(Integer site) {
        this.site = site;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Integer getRegister() {
        return register;
    }

    public void setRegister(Integer register) {
        this.register = register;
    }
    
}
