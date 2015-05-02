/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.teletransferencia.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author weslley.matos
 */
@Entity
@Table(name = "usuarios", schema = PojoTransferencia.DB)
public class UsuarioTransferencia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_diagnostico")
    private Integer idDiagnostico;

//    @OneToMany
    @OneToMany(mappedBy = "usuario", targetEntity = PermissaoTransferencia.class)
    @JoinColumn(name = "id_usuario")
    private List<PermissaoTransferencia> permissoes;

    @ManyToOne
    @JoinColumn(name = "versao_app")
    private VersaoTransferencia versaoApp;

    @Transient
    private br.ufmg.hc.telessaude.diagnostico.dominio.entity.Usuario usuarioDiag;

    public UsuarioTransferencia() {
    }

    public UsuarioTransferencia(Integer id) {
        this.id = id;
    }

    public br.ufmg.hc.telessaude.diagnostico.dominio.entity.Usuario getUsuarioDiag() {
        return usuarioDiag;
    }

    public void setUsuarioDiag(br.ufmg.hc.telessaude.diagnostico.dominio.entity.Usuario usuarioDiag) {
        this.usuarioDiag = usuarioDiag;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (Integer) getId();
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
        if (!(object instanceof UsuarioTransferencia)) {
            return false;
        }
        UsuarioTransferencia other = (UsuarioTransferencia) object;
        if (this.getId() != other.getId()) {
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
        return "br.ufmg.hc.telessaude.teletransferencia.entity.Usuario[ id=" + getId() + " ]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the idDiagnostico
     */
    public Integer getIdDiagnostico() {
        return idDiagnostico;
    }

    /**
     * @param idDiagnostico the idDiagnostico to set
     */
    public void setIdDiagnostico(Integer idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public List<PermissaoTransferencia> getPermissoes() {
        if(permissoes == null)
            permissoes = new ArrayList<>();
        return permissoes;
    }

    public void setPermissoes(List<PermissaoTransferencia> permissoes) {
        this.permissoes = permissoes;
    }

    public VersaoTransferencia getVersaoApp() {
        return versaoApp;
    }

    public void setVersaoApp(VersaoTransferencia versaoApp) {
        this.versaoApp = versaoApp;
    }

}
