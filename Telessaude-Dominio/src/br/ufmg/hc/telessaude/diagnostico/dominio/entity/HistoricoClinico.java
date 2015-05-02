/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author igor.santos
 */
@Entity
@Table(name = "\"HISTORICOCLINICO\"", schema = PojoBase.DB)
public class HistoricoClinico extends PojoBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_HISTORICOCLINICO\"", nullable = false)
    private Integer id;
    @Column(name = "\"CONTEUDO\"", nullable = false)
    private String conteudo;
    @JoinColumn(name = "\"ID_MODELOHISTORICOCLINICO\"") //, referencedColumnName = "\"ID_MODELOHISTORICOCLINICO\"")
    @ManyToOne(optional = false)
    private ModeloHistoricoClinico modeloHistoricoClinico;
    @JoinColumn(name = "\"ID_EXAME\"") //, referencedColumnName = "\"ID_EXAME\"")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Exame exame;

    public HistoricoClinico() {
    }

    public HistoricoClinico(Integer id) {
        this.id = id;
    }

    public HistoricoClinico(Integer id, String conteudo) {
        this.id = id;
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

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public ModeloHistoricoClinico getModeloHistoricoClinico() {
        if (modeloHistoricoClinico == null) {
            modeloHistoricoClinico = new ModeloHistoricoClinico();
        }
        return modeloHistoricoClinico;
    }

    public void setModeloHistoricoClinico(ModeloHistoricoClinico modeloHistoricoClinico) {
        this.modeloHistoricoClinico = modeloHistoricoClinico;
    }

    public Exame getExame() {
        if(exame == null) {
            exame = new Exame();
        }
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }
}