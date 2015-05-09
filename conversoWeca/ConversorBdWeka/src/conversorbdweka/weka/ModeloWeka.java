/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversorbdweka.weka;

import br.ufmg.hc.telessaude.diagnostico.dominio.entity.PojoBase;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author breno
 */
@Entity
@Table(name = "weka", schema = "\"MODELO_WEKA\"")
public class ModeloWeka extends PojoBase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"id_weka\"", nullable = false)
    private Integer id;
    private Integer profissionalId;
    private String imc;
    
    private String idade;
    private String sexo;
    private String pressaoArterial;
    @Type(type = "org.hibernate.type.TextType")
    private String glasgowResult;
//    private String minessotaResult;
    
    private String tempoLaudo;
    
    private String medicamentos;
    
    private String comorbidades;
    
    
    private String invertigacaoDor;

    /**
     * @return the id
     */
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the profissionalId
     */
    public Integer getProfissionalId() {
        return profissionalId;
    }

    /**
     * @param profissionalId the profissionalId to set
     */
    public void setProfissionalId(Integer profissionalId) {
        this.profissionalId = profissionalId;
    }

    /**
     * @return the tempoLaudo
     */
    public String getTempoLaudo() {
        return tempoLaudo;
    }

    /**
     * @param tempoLaudo the tempoLaudo to set
     */
    public void setTempoLaudo(String tempoLaudo) {
        this.tempoLaudo = tempoLaudo;
    }

    /**
     * @return the glasgowResult
     */
    public String getGlasgowResult() {
        return glasgowResult;
    }

    /**
     * @param glasgowResult the glasgowResult to set
     */
    public void setGlasgowResult(String glasgowResult) {
        this.glasgowResult = glasgowResult;
    }

//    /**
//     * @return the minessotaResult
//     */
//    public String getMinessotaResult() {
//        return minessotaResult;
//    }
//
//    /**
//     * @param minessotaResult the minessotaResult to set
//     */
//    public void setMinessotaResult(String minessotaResult) {
//        this.minessotaResult = minessotaResult;
//    }

    /**
     * @return the pressaoArterial
     */
    public String getPressaoArterial() {
        return pressaoArterial;
    }

    /**
     * @param pressaoArterial the pressaoArterial to set
     */
    public void setPressaoArterial(String pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }

    /**
     * @return the imc
     */
    public String getImc() {
        return imc;
    }

    /**
     * @param imc the imc to set
     */
    public void setImc(String imc) {
        this.imc = imc;
    }
    /**
     * @return the invertigacaoDor
     */
    public String getInvertigacaoDor() {
        return invertigacaoDor;
    }

    /**
     * @param invertigacaoDor the invertigacaoDor to set
     */
    public void setInvertigacaoDor(String invertigacaoDor) {
        this.invertigacaoDor = invertigacaoDor;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getComorbidades() {
        return comorbidades;
    }

    public void setComorbidades(String comorbidades) {
        this.comorbidades = comorbidades;
    }

}
