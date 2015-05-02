/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.teletransferencia.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author weslley.matos
 */
@Entity
@Table(name = "exames", schema = PojoTransferencia.DB)
public class ExameTransferencia implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "data_inclusao")
    private Date dataInclusao;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "data_realizacao")
    private Date dataRealizacao;
    
    @Column(name = "link_arquivo")
    private String linkArquivo;
    
    @Column(name = "hash_arquivo")
    private String hashArquivo;
    
    @Column(name = "observacao")
    private String observacao;
    
    @Column(name = "cod_especialista")
    private String cod_especialista;
    
    @Column(name = "urgencia")
    private Boolean urgencia;
    
    @ManyToOne
    @JoinColumn(name = "id_paciente", referencedColumnName = "id")
    private PacienteTransferencia paciente;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_tipo_exame", referencedColumnName = "id")
    private TipoExameTransferencia tipoExame;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_ponto_remoto", referencedColumnName = "id")
    private PontoRemotoTransferencia pontoRemoto;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_status_exame", referencedColumnName = "id")
    private StatusTransferencia status;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private UsuarioTransferencia usuario;
    
    @Transient
    private List<LaudoTransferencia> laudos;

    public ExameTransferencia() {
    }
    
    public ExameTransferencia(Integer id) {
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
        if (!(object instanceof ExameTransferencia)) {
            return false;
        }
        ExameTransferencia other = (ExameTransferencia) object;
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
        return "br.ufmg.hc.telessaude.teletransferencia.entity.Exame[ id=" + getId() + " ]";
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

    /**
     * @return the dataInclusao
     */
    public Date getDataInclusao() {
        return dataInclusao;
    }

    /**
     * @param dataInclusao the dataInclusao to set
     */
    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Date getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(Date dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    /**
     * @return the linkArquivo
     */
    public String getLinkArquivo() {
        return linkArquivo;
    }

    /**
     * @param linkArquivo the linkArquivo to set
     */
    public void setLinkArquivo(String linkArquivo) {
        this.linkArquivo = linkArquivo;
    }

    public String getHashArquivo() {
        return hashArquivo;
    }

    public void setHashArquivo(String hashArquivo) {
        this.hashArquivo = hashArquivo;
    }
    
    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * @return the paciente
     */
    public PacienteTransferencia getPaciente() {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(PacienteTransferencia paciente) {
        this.paciente = paciente;
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

    /**
     * @return the pontoRemoto
     */
    public PontoRemotoTransferencia getPontoRemoto() {
        return pontoRemoto;
    }

    /**
     * @param pontoRemoto the pontoRemoto to set
     */
    public void setPontoRemoto(PontoRemotoTransferencia pontoRemoto) {
        this.pontoRemoto = pontoRemoto;
    }

    /**
     * @return the status
     */
    public StatusTransferencia getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(StatusTransferencia status) {
        this.status = status;
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

    public String getCod_especialista() {
        return cod_especialista;
    }

    public void setCod_especialista(String cod_especialista) {
        this.cod_especialista = cod_especialista;
    }

    public Boolean isUrgencia() {
        return urgencia;
    }

    public void setUrgencia(Boolean urgencia) {
        this.urgencia = urgencia;
    }    

    public List<LaudoTransferencia> getLaudos() {
        return laudos;
    }

    public void setLaudos(List<LaudoTransferencia> laudos) {
        this.laudos = laudos;
    }

}
