/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.entity;

import java.io.Serializable;
import java.sql.Time;
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
@Table(name = "\"CREDITO_PLANTAO\"", schema = PojoBase.DB)
public class CreditoPlantao extends PojoBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_CREDITOPLANTAO\"", nullable = false)
    private Integer id;
    @Column(name = "\"HORAINICIO\"", nullable = false)
//    @Temporal(TemporalType.TIME)
    private Time horaInicio;
    @Column(name = "\"HORAFIM\"", nullable = false)
//    @Temporal(TemporalType.TIME)
    private Time horaFim;
    @Column(name = "\"DATACREDITO\"", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataCredito;
    @JoinColumn(name = "\"ID_ESPECIALISTA\"")
    @ManyToOne(optional = false)
    private Especialista especialista;

    public CreditoPlantao() {
    }

    public CreditoPlantao(Integer id) {
        this.id = id;
    }

    public CreditoPlantao(Integer id, Time horaInicio, Time horaFim, Date dataCredito) {
        this.id = id;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.dataCredito = dataCredito;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public Time getHoraFim() {
        return horaFim;
    }

    public Date getDataCredito() {
        return dataCredito;
    }

    public Especialista getEspecialista() {
        if(especialista == null) {
            especialista = new Especialista();
        }
        
        return especialista;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFim(Time horaFim) {
        this.horaFim = horaFim;
    }

    public void setDataCredito(Date dataCredito) {
        this.dataCredito = dataCredito;
    }

    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
