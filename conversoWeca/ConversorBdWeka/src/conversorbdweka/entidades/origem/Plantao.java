/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversorbdweka.entidades.origem;

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
@Table(name = "\"PLANTAO\"", schema = PojoBase.DB)
public class Plantao extends PojoBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_PLANTAO\"", nullable = false)
    private Integer id;
    @Column(name = "\"DATAINICIO\"", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datainicio;
    @Column(name = "\"DATAFIM\"")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datafim;
    @JoinColumn(name = "\"ID_ESPECIALISTA\"") //, referencedColumnName = "\"ID_ESPECIALISTA\"")
    @ManyToOne(optional = false)
    private Especialista especialista;

    public Plantao() {
    }

    public Plantao(Integer id) {
        this.id = id;
    }

    public Plantao(Integer id, Date datainicio, Date datafim) {
        this.id = id;
        this.datainicio = datainicio;
        this.datafim = datafim;
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

    public Especialista getEspecialista() {
        if (especialista == null) {
            especialista = new Especialista();
        }
        return especialista;
    }

    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }
}