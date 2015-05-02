/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.teletransferencia.entity;

import java.io.Serializable;
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
 * @author weslley.matos
 */
@Entity
@Table(name = "especialistas", schema = PojoTransferencia.DB)
public class EspecialistaTransferencia implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "nome")
    private String nome;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuario",unique = true)
    private UsuarioTransferencia usuario;
    
    @Column(name = "id_diagnostico")
    private Integer idDiagnostico;

    public EspecialistaTransferencia() {
    }

    public EspecialistaTransferencia(Integer id) {
        this.id = id;
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
        if (!(object instanceof EspecialistaTransferencia)) {
            return false;
        }
        EspecialistaTransferencia other = (EspecialistaTransferencia) object;
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
        return "br.ufmg.hc.telessaude.teletransferencia.entity.Especialista[ id=" + getId() + " ]";
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UsuarioTransferencia getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioTransferencia usuario) {
        this.usuario = usuario;
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
    
}
