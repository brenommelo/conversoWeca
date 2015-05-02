/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.teletransferencia.entity;

import java.io.Serializable;
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
 * @author weslley.matos
 */
@Entity
@Table(name = "permissoes", schema = PojoTransferencia.DB)
public class PermissaoTransferencia implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuario")
    private UsuarioTransferencia usuario;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_tipo_exame")
    private TipoExameTransferencia tipoExame;

    public PermissaoTransferencia() {
    }

    public PermissaoTransferencia(Integer id) {
        this.id = id;
    }
    
    public PermissaoTransferencia(UsuarioTransferencia id_user, TipoExameTransferencia tipoExame)
    {
        this.usuario = id_user;
        this.tipoExame = tipoExame;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) getUsuario().getId() + getTipoExame().getId();
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
        if (!(object instanceof PermissaoTransferencia)) {
            return false;
        }
        PermissaoTransferencia other = (PermissaoTransferencia) object;
        if ((this.getUsuario().getId() != other.getUsuario().getId()) && (this.getTipoExame().getId() != other.getTipoExame().getId())) {
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
        return "br.ufmg.hc.telessaude.teletransferencia.entity.Permissao[ usuario=" + getUsuario().getId() + ", tipoExame=" + getTipoExame().getId() + " ]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the usuario
     */
    public UsuarioTransferencia getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(UsuarioTransferencia usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the tipoExame
     */
    public TipoExameTransferencia getTipoExame() {
        return tipoExame;
    }

    /**
     * @param tipoExame the tipoExame to set
     */
    public void setTipoExame(TipoExameTransferencia tipoExame) {
        this.tipoExame = tipoExame;
    }
    
}
