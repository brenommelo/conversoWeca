/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.entity;

import java.io.Serializable;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "\"HORARIO_PLANTAO\"", schema = PojoBase.DB)
public class HorarioPlantao extends PojoBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_HORARIOPLANTAO\"", nullable = false)
    private Integer id;
    @Column(name = "\"DIASEMANA\"", nullable = false)
    private String diaSemana;
    @Column(name = "\"HORAINICIO\"", nullable = false)
//    @Temporal(TemporalType.TIME)
    private Time horaInicio;
    @Column(name = "\"HORAFIM\"", nullable = false)
//    @Temporal(TemporalType.TIME)
    private Time horaFim;
    @JoinColumn(name = "\"ID_ESPECIALISTA\"") //, referencedColumnName = "\"ID_ESPECIALISTA\"")
    @ManyToOne(optional = false)
    private Especialista especialista;

    public HorarioPlantao() {
    }

    public HorarioPlantao(Integer id) {
        this.id = id;
    }

    public HorarioPlantao(Integer id, String diaSemana, Time horaInicio, Time horaFim) {
        this.id = id;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Time horaFim) {
        this.horaFim = horaFim;
    }

    public Especialista getEspecialista() {
        if(especialista == null) {
            especialista = new Especialista();
        }
        return especialista;
    }

    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }
}
