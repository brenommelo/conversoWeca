/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.teletransferencia.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author paulo.gomes
 */
@Entity
@Table(name = "versoes_transferencia", schema = PojoTransferencia.DB)
public class VersaoTransferencia implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "versao", unique = true)
    private String versao;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "data")
    private Date dataInclusao;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "versao_jdk")
    private String versaoJdk;
    
    @Column(name = "link_arquivo")
    private String linkArquivo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date data) {
        this.dataInclusao = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getVersaoJdk() {
        return versaoJdk;
    }

    public void setVersaoJdk(String versaoJdk) {
        this.versaoJdk = versaoJdk;
    }

    public String getLinkArquivo() {
        return linkArquivo;
    }

    public void setLinkArquivo(String linkArquivo) {
        this.linkArquivo = linkArquivo;
    }

}
