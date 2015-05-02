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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author weslley.matos
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "laudos", schema = PojoTransferencia.DB)
public class LaudoTransferencia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_especialista")
    private EspecialistaTransferencia especialista;

    @ManyToOne
    @JoinColumn(name = "id_exame")
    private ExameTransferencia exame;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "data_inclusao")
    private Date dataInclusao;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "data_realizacao")
    private Date dataRealizacao;

    @Column(name = "link_arquivo")
    private String linkArquivo;

    @Column(name = "conteudo", columnDefinition = "TEXT")
    private String conteudo;

    public LaudoTransferencia() {
    }

    public LaudoTransferencia(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (Integer) getId();
        return hash;
    }

    /**
     *
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LaudoTransferencia)) {
            return false;
        }
        LaudoTransferencia other = (LaudoTransferencia) object;
        if (this.getId() != other.getId()) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "br.ufmg.hc.telessaude.teletransferencia.entity.Laudo[ id=" + getId() + " ]";
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the especialista
     */
    public EspecialistaTransferencia getEspecialista() {
        return especialista;
    }

    /**
     * @param especialista the especialista to set
     */
    public void setEspecialista(EspecialistaTransferencia especialista) {
        this.especialista = especialista;
    }

    /**
     * @return the exame
     */
    public ExameTransferencia getExame() {
        return exame;
    }

    /**
     * @param exame the exame to set
     */
    public void setExame(ExameTransferencia exame) {
        this.exame = exame;
    }

    /**
     * @return the dataInclusao
     */
    public Date getDataInclusao() {
        return dataInclusao;
    }

    /**
     * @param dataInclusao the dataInclusao to set
     */
    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    /**
     * @return the linkArquivo
     */
    public String getLinkArquivo() {
        return linkArquivo;
    }

    /**
     * @param linkArquivo the linkArquivo to set
     */
    public void setLinkArquivo(String linkArquivo) {
        this.linkArquivo = linkArquivo;
    }

    public Date getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(Date dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

}
