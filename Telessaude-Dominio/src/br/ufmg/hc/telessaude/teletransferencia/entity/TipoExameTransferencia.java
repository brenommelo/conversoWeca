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
import javax.persistence.Table;

/**
 *
 * @author weslley.matos
 */
@Entity
@Table(name = "tipos_exame", schema = PojoTransferencia.DB)
public class TipoExameTransferencia implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "extensao")
    private String extensao;
    
    @Column(name = "usar_arquivo_complementar")
    private Boolean usarArquivoComplementar;
    
    @Column(name = "exibir_cadastro_paciente")
    private Boolean exibirCadastroPaciente;
    
    @Column(name = "id_diagnostico")
    private Integer idDiagnostico;

    public TipoExameTransferencia() {
    }

    public TipoExameTransferencia(Integer id) {
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
        if (!(object instanceof TipoExameTransferencia)) {
            return false;
        }
        TipoExameTransferencia other = (TipoExameTransferencia) object;
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
        return nome.trim().toUpperCase();
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
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

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    public Boolean getUsarArquivoComplementar() {
        return usarArquivoComplementar;
    }
    
    public Boolean isUsarArquivoComplementar() {
        return usarArquivoComplementar;
    }

    public void setUsarArquivoComplementar(Boolean usarArquivoComplementar) {
        this.usarArquivoComplementar = usarArquivoComplementar;
    }

    public Boolean getExibirCadastroPaciente() {
        return exibirCadastroPaciente;
    }
    public Boolean isExibirCadastroPaciente() {
        return exibirCadastroPaciente;
    }

    public void setExibirCadastroPaciente(Boolean exibirCadastroPaciente) {
        this.exibirCadastroPaciente = exibirCadastroPaciente;
    }
    
    public Object getThis()
    {
        return(this);
    }
}
