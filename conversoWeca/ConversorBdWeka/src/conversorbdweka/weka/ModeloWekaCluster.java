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

/**
 *
 * @author breno
 */
@Entity
@Table(name = "weka_cluster", schema = "\"MODELO_WEKA\"")
public class ModeloWekaCluster extends PojoBase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"id_weka\"", nullable = false)
    private Integer id;
    private Integer idProfissional;
    private Double tempoLaudo;
    //medicamentos
    private Integer amiodarona;
    private Integer betaBloqueadores;
    private Integer bloqueadorCalcio;
    private Integer digital;
    private Integer diureticos;
    private Integer iec;
    private Integer outros;
    //sexo
    private Integer sexo;
    //imc
    private Double imc;
    //idade
    private Integer idade;
    //comorbidades
    private Integer tabagismo;
    private Integer revascularizacaoPrevia;
    private Integer obesidade;
    private Integer infartoPrevio;
    private Integer historicoFamiliar;
    private Integer hipertencao;
    private Integer drc;
    private Integer dpoc;
    private Integer chagas;
    private Integer dislipidemia;
    private Integer diabetesMelitus;
    private Integer paSistolica;
    private Integer paDiastolica;
    
    private Integer glHeartRate;
    private Integer glHeartRateVariability;
    private Integer glPFrontalAxis;
    private Integer glQrsFrontalAxis;
    private Integer glStFrontalAxis;
    private Integer glSinusAverageRR;
    private Integer glSinusRate;
    private Integer glStdDevNormRRIntervals;
    private Integer glTFrontalAxis;
    private Integer glVentAverageRR;
    private Integer glVentRate;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmiodarona() {
        return amiodarona;
    }

    public void setAmiodarona(Integer amiodarona) {
        this.amiodarona = amiodarona;
    }

    public Integer getBetaBloqueadores() {
        return betaBloqueadores;
    }

    public void setBetaBloqueadores(Integer betaBloqueadores) {
        this.betaBloqueadores = betaBloqueadores;
    }

    public Integer getBloqueadorCalcio() {
        return bloqueadorCalcio;
    }

    public void setBloqueadorCalcio(Integer bloqueadorCalcio) {
        this.bloqueadorCalcio = bloqueadorCalcio;
    }

    public Integer getDigital() {
        return digital;
    }

    public void setDigital(Integer digital) {
        this.digital = digital;
    }

    public Integer getDiureticos() {
        return diureticos;
    }

    public void setDiureticos(Integer diureticos) {
        this.diureticos = diureticos;
    }

    public Integer getIec() {
        return iec;
    }

    public void setIec(Integer iec) {
        this.iec = iec;
    }

    public Integer getOutros() {
        return outros;
    }

    public void setOutros(Integer outros) {
        this.outros = outros;
    }

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public Double getImc() {
        return imc;
    }

    public void setImc(Double imc) {
        this.imc = imc;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }


    public Integer getTabagismo() {
        return tabagismo;
    }

    public void setTabagismo(Integer tabagismo) {
        this.tabagismo = tabagismo;
    }

    public Integer getRevascularizacaoPrevia() {
        return revascularizacaoPrevia;
    }

    public void setRevascularizacaoPrevia(Integer revascularizacaoPrevia) {
        this.revascularizacaoPrevia = revascularizacaoPrevia;
    }

    public Integer getObesidade() {
        return obesidade;
    }

    public void setObesidade(Integer obesidade) {
        this.obesidade = obesidade;
    }

    public Integer getInfartoPrevio() {
        return infartoPrevio;
    }

    public void setInfartoPrevio(Integer infartoPrevio) {
        this.infartoPrevio = infartoPrevio;
    }

    public Integer getHistoricoFamiliar() {
        return historicoFamiliar;
    }

    public void setHistoricoFamiliar(Integer historicoFamiliar) {
        this.historicoFamiliar = historicoFamiliar;
    }

    public Integer getHipertencao() {
        return hipertencao;
    }

    public void setHipertencao(Integer hipertencao) {
        this.hipertencao = hipertencao;
    }

    public Integer getDrc() {
        return drc;
    }

    public void setDrc(Integer drc) {
        this.drc = drc;
    }

    public Integer getDpoc() {
        return dpoc;
    }

    public void setDpoc(Integer dpoc) {
        this.dpoc = dpoc;
    }

    public Integer getChagas() {
        return chagas;
    }

    public void setChagas(Integer chagas) {
        this.chagas = chagas;
    }

    public Integer getDislipidemia() {
        return dislipidemia;
    }

    public void setDislipidemia(Integer dislipidemia) {
        this.dislipidemia = dislipidemia;
    }

    public Integer getDiabetesMelitus() {
        return diabetesMelitus;
    }

    public void setDiabetesMelitus(Integer diabetesMelitus) {
        this.diabetesMelitus = diabetesMelitus;
    }

    public Integer getPaSistolica() {
        return paSistolica;
    }

    public void setPaSistolica(Integer paSistolica) {
        this.paSistolica = paSistolica;
    }

    public Integer getPaDiastolica() {
        return paDiastolica;
    }

    public void setPaDiastolica(Integer paDiastolica) {
        this.paDiastolica = paDiastolica;
    }

    public Integer getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(Integer idProfissional) {
        this.idProfissional = idProfissional;
    }

    public Double getTempoLaudo() {
        return tempoLaudo;
    }

    public void setTempoLaudo(Double tempoLaudo) {
        this.tempoLaudo = tempoLaudo;
    }

    public Integer getGlHeartRate() {
        return glHeartRate;
    }

    public void setGlHeartRate(Integer glHeartRate) {
        this.glHeartRate = glHeartRate;
    }

    public Integer getGlHeartRateVariability() {
        return glHeartRateVariability;
    }

    public void setGlHeartRateVariability(Integer glHeartRateVariability) {
        this.glHeartRateVariability = glHeartRateVariability;
    }

    public Integer getGlPFrontalAxis() {
        return glPFrontalAxis;
    }

    public void setGlPFrontalAxis(Integer glPFrontalAxis) {
        this.glPFrontalAxis = glPFrontalAxis;
    }

    public Integer getGlQrsFrontalAxis() {
        return glQrsFrontalAxis;
    }

    public void setGlQrsFrontalAxis(Integer glQrsFrontalAxis) {
        this.glQrsFrontalAxis = glQrsFrontalAxis;
    }

    public Integer getGlStFrontalAxis() {
        return glStFrontalAxis;
    }

    public void setGlStFrontalAxis(Integer glStFrontalAxis) {
        this.glStFrontalAxis = glStFrontalAxis;
    }

    public Integer getGlSinusAverageRR() {
        return glSinusAverageRR;
    }

    public void setGlSinusAverageRR(Integer glSinusAverageRR) {
        this.glSinusAverageRR = glSinusAverageRR;
    }

    public Integer getGlSinusRate() {
        return glSinusRate;
    }

    public void setGlSinusRate(Integer glSinusRate) {
        this.glSinusRate = glSinusRate;
    }

    public Integer getGlStdDevNormRRIntervals() {
        return glStdDevNormRRIntervals;
    }

    public void setGlStdDevNormRRIntervals(Integer glStdDevNormRRIntervals) {
        this.glStdDevNormRRIntervals = glStdDevNormRRIntervals;
    }

    public Integer getGlTFrontalAxis() {
        return glTFrontalAxis;
    }

    public void setGlTFrontalAxis(Integer glTFrontalAxis) {
        this.glTFrontalAxis = glTFrontalAxis;
    }

    public Integer getGlVentAverageRR() {
        return glVentAverageRR;
    }

    public void setGlVentAverageRR(Integer glVentAverageRR) {
        this.glVentAverageRR = glVentAverageRR;
    }

    public Integer getGlVentRate() {
        return glVentRate;
    }

    public void setGlVentRate(Integer glVentRate) {
        this.glVentRate = glVentRate;
    }

}
