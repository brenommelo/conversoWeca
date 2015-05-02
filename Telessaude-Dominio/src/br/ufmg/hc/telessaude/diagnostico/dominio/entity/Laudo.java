/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author igor.santos
 */
@Entity
@Table(name = "\"LAUDO\"", schema = PojoBase.DB)
public class Laudo extends PojoBase implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_LAUDO\"", nullable = false)
    private Integer id;
    
    @Column(name = "\"DATAINICIO\"", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datainicio;
    
    @Column(name = "\"DATAFIM\"")
    @Temporal(TemporalType.DATE)
    private Date datafim;
    
    @Column(name = "\"ESPECIALISTA\"")
    private Integer especialista;
    
    @Basic(optional = false)
    @Column(name = "\"CONTEUDO\"")
    private String conteudo;
    
    @JoinColumn(name = "\"ID_PLANTAO\"") //, referencedColumnName = "\"ID_PLANTAO\"")
    @ManyToOne(optional = false)
    private Plantao plantao;
    
    @JoinColumn(name = "\"ID_MODELOLAUDO\"") //, referencedColumnName = "\"ID_MODELOLAUDO\"")
    @ManyToOne(optional = false)
    private ModeloLaudo modeloLaudo;
    
    @JoinColumn(name = "\"ID_EXAME\"") //, referencedColumnName = "\"ID_EXAME\"")
    @ManyToOne(optional = false)
    private Exame exame;

    public Laudo() {
    }

    public Laudo(Integer id) {
        this.id = id;
    }

    public Laudo(Integer id, Date datainicio, Date datafim, Integer especialista, String conteudo) {
        this.id = id;
        this.datainicio = datainicio;
        this.datafim = datafim;
        this.especialista = especialista;
        this.conteudo = conteudo;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatafim() {
        return datafim;
    }

    public void setDatafim(Date datafim) {
        this.datafim = datafim;
    }

    public Integer getEspecialista() {
        return especialista;
    }

    public void setEspecialista(Integer especialista) {
        this.especialista = especialista;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Plantao getPlantao() {
        if (plantao == null) {
            plantao = new Plantao();
        }
        return plantao;
    }

    public void setPlantao(Plantao plantao) {
        this.plantao = plantao;
    }

    public ModeloLaudo getModeloLaudo() {
        if (modeloLaudo == null) {
            modeloLaudo = new ModeloLaudo();
        }
        return modeloLaudo;
    }

    public void setModeloLaudo(ModeloLaudo modeloLaudo) {
        this.modeloLaudo = modeloLaudo;
    }

    public Exame getExame() {
        if (exame == null) {
            exame = new Exame();
        }
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }
}