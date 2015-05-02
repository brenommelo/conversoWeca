/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversorbdweka.entidades.origem;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
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
 * @author paulo.gomes
 */
@Entity
@Table(name = "\"LAUDO_MINNESOTA\"", schema = PojoBase.DB)
public class LaudoMinnesota extends PojoBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_LAUDO_MINN\"", nullable = false)
    private Integer id;

    @Column(name = "\"INCLUSAO\"", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date inclusao;

    @Column(name = "\"REGISTRO\"", nullable = false)
    private Integer registro;

    @JoinColumn(name = "\"ID_EXAME\"") //, referencedColumnName = "\"ID_PLANTAO\"")
    @ManyToOne(optional = false)
    private Exame exame;

    @JoinColumn(name = "\"ID_MINN_DICT\"") //, referencedColumnName = "\"ID_PLANTAO\"")
    @ManyToOne(optional = false)
    private MinnesotaDict minnesotaDict;

    @JoinColumn(name = "\"ID_USUARIO\"") //, referencedColumnName = "\"ID_PLANTAO\"")
    @ManyToOne(optional = false)
    private Usuario usuario;

    public LaudoMinnesota() {
    }

    public LaudoMinnesota(Integer id) {
        this.id = id;
    }

    public LaudoMinnesota(Integer id, Date inclusao, Exame exame, MinnesotaDict minnesotaDict) {
        this.id = id;
        this.inclusao = inclusao;
        this.exame = exame;
        this.minnesotaDict = minnesotaDict;
    }

    public LaudoMinnesota(Integer id, Date inclusao, Integer registro, Exame exame, MinnesotaDict minnesotaDict, Usuario usuario) {
        this.id = id;
        this.inclusao = inclusao;
        this.registro = registro;
        this.exame = exame;
        this.minnesotaDict = minnesotaDict;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInclusao() {
        return inclusao;
    }

    public void setInclusao(Date inclusao) {
        this.inclusao = inclusao;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    public MinnesotaDict getMinnesotaDict() {
        return minnesotaDict;
    }

    public void setMinnesotaDict(MinnesotaDict minnesotaDict) {
        this.minnesotaDict = minnesotaDict;
    }

    public Integer getRegistro() {
        return registro;
    }

    public void setRegistro(Integer registro) {
        this.registro = registro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.registro);
        hash = 53 * hash + Objects.hashCode(this.exame);
        hash = 53 * hash + Objects.hashCode(this.minnesotaDict);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LaudoMinnesota other = (LaudoMinnesota) obj;
//        if (!Objects.equals(this.id, other.id)) {
//            return false;
//        }
        if (!Objects.equals(this.registro, other.registro)) {
            return false;
        }
        if (!Objects.equals(this.exame.getId(), other.exame.getId())) {
            return false;
        }
        if (!Objects.equals(this.minnesotaDict.getId(), other.minnesotaDict.getId())) {
            return false;
        }
        return true;
    }

}
