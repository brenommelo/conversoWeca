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
@Table(name = "\"EXAMECORROMPIDO\"", schema = PojoBase.DB)
public class ExameCorrompido extends PojoBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_EXAMECORROMPIDO\"", nullable = false)
    private Integer id;
    @Column(name = "\"NOMEARQUIVO\"", nullable = false)
    private String nomearquivo;
    @Column(name = "\"DATAINCLUSAO\"", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datainclusao;
    @Column(name = "\"DESCRICAO\"")
    private String descricao;
    @JoinColumn(name = "\"ID_PONTOREMOTO\"") //, referencedColumnName = "\"ID_PONTOREMOTO\"")
    @ManyToOne
    private PontoRemoto pontoRemoto;

    public ExameCorrompido() {
    }

    public ExameCorrompido(Integer id) {
        this.id = id;
    }

    public ExameCorrompido(Integer id, String nomearquivo, Date datainclusao, String descricao) {
        this.id = id;
        this.nomearquivo = nomearquivo;
        this.datainclusao = datainclusao;
        this.descricao = descricao;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomearquivo() {
        return nomearquivo;
    }

    public void setNomearquivo(String nomearquivo) {
        this.nomearquivo = nomearquivo;
    }

    public Date getDatainclusao() {
        return datainclusao;
    }

    public void setDatainclusao(Date datainclusao) {
        this.datainclusao = datainclusao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public PontoRemoto getPontoRemoto() {
        if (pontoRemoto == null) {
            pontoRemoto = new PontoRemoto();
        }
        return pontoRemoto;
    }

    public void setPontoRemoto(PontoRemoto pontoRemoto) {
        this.pontoRemoto = pontoRemoto;
    }
}