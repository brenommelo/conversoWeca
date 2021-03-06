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
@Table(name = "\"MODELOHISTORICOCLINICO\"", schema = PojoBase.DB)
public class ModeloHistoricoClinico extends PojoBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_MODELOHISTORICOCLINICO\"", nullable = false)
    private Integer id;
    @Column(name = "\"DATAINCLUSAO\"", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datainclusao;
    @Column(name = "\"CONTEUDO\"", nullable = false)
    private String conteudo;
    @JoinColumn(name = "\"ID_TIPOEXAME\"") //, referencedColumnName = "\"ID_TIPOEXAME\"")
    @ManyToOne(optional = false)
    private TipoExame tipoExame;

    public ModeloHistoricoClinico() {
    }

    public ModeloHistoricoClinico(Integer id) {
        this.id = id;
    }

    public ModeloHistoricoClinico(Integer id, Date datainclusao, String conteudo) {
        this.id = id;
        this.datainclusao = datainclusao;
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

    public Date getDatainclusao() {
        return datainclusao;
    }

    public void setDatainclusao(Date datainclusao) {
        this.datainclusao = datainclusao;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public TipoExame getTipoExame() {
        if (tipoExame == null) {
            tipoExame = new TipoExame();
        }
        return tipoExame;
    }

    public void setTipoExame(TipoExame tipoExame) {
        this.tipoExame = tipoExame;
    }
}