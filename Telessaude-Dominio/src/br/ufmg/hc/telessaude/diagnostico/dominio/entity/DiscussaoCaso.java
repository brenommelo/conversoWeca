/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "\"DISCUSSAOCASO\"", schema = PojoBase.DB)
public class DiscussaoCaso extends PojoBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_DISCUSSAOCASO\"", nullable = false)
    private Integer id;
    @Column(name = "\"DATAINICIO\"", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datainicio;
    @Column(name = "\"DATAFIM\"")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datafim;
    @Column(name = "\"ESPECIALISTA\"")
    private Integer especialista;
    @Column(name = "\"RESUMO\"")
    private String resumo;
    @Column(name = "\"SOLICITANTE\"")
    private String solicitante;
    @JoinColumn(name = "\"ID_PRIORIDADE\"") //, referencedColumnName = "\"ID_PRIORIDADE\"")
    @ManyToOne(optional = false)
    private Prioridade prioridade;
    @JoinColumn(name = "\"ID_PLANTAO\"") //) //, referencedColumnName = "\"ID_PLANTAO\"")
    @ManyToOne(optional = false)
    private Plantao plantao;
    @JoinColumn(name = "\"ID_PACIENTE\"") //, referencedColumnName = "\"ID_PACIENTE\"")
    @ManyToOne(optional = false)
    private Paciente paciente;
    @JoinColumn(name = "\"ID_CIDADE\"") //, referencedColumnName = "\"ID_CIDADE\"")
    @ManyToOne(optional = false)
    private Cidade cidade;

    public DiscussaoCaso() {
    }

    public DiscussaoCaso(Integer id) {
        this.id = id;
    }

    public DiscussaoCaso(Integer id, Date datainicio, Date datafim, Integer especialista, String resumo, String solicitante) {
        this.id = id;
        this.datainicio = datainicio;
        this.datafim = datafim;
        this.especialista = especialista;
        this.resumo = resumo;
        this.solicitante = solicitante;
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

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public Prioridade getPrioridade() {
        if (prioridade == null) {
            prioridade = new Prioridade();
        }
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
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

    public Paciente getPaciente() {
        if (paciente == null) {
            paciente = new Paciente();
        }
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Cidade getCidade() {
        if (cidade == null) {
            cidade = new Cidade();
        }
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
