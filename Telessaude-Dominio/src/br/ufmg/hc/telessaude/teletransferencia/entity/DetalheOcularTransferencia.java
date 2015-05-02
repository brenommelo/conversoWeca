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
 * @author paulo.gomes
 */
@Entity
@Table(name = "detalhes_oculares", schema = PojoTransferencia.DB)
public class DetalheOcularTransferencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "qualidade_imagem")
    private String qualidadeImagem;

    @Column(name = "disco_optico_anormal")
    private boolean discoOpticoAnormal;

    @Column(name = "disco_optico_escavacao")
    private float discoOpticoEscavacao;

    @Column(name = "macula_anormal")
    private boolean maculaAnormal;

    @Column(name = "rede_vascular_anormal")
    private boolean redeVascularAnormal;

    @Column(name = "periferia_retiniana_anormal")
    private boolean periferiaRetinianaAnormal;

    @Column(name = "microaneurismas")
    private boolean microaneurismas;

    @Column(name = "hemorragias_retinianas")
    private boolean hemorragiasRetinianas;

    @Column(name = "manchas_algodonosas")
    private boolean manchasAlgodonosas;

    @Column(name = "exsudatos_duros")
    private boolean exsudatosDuros;

    @Column(name = "emcs")
    private boolean emcs;

    @Column(name = "neovascularizacao_retina")
    private boolean neovascularizacaoRetina;

    @Column(name = "neovascularizacao_disco")
    private boolean neovascularizacaoDisco;

    @Column(name = "irma")
    private boolean irma;

    @Column(name = "hemorragia_preretiniana")
    private boolean hemorragiaPreretiniana;

    @Column(name = "hemorragia_vitrea")
    private boolean hemorragiaVitrea;

    @Column(name = "descolamento_tradicional")
    private boolean descolamentoTradicional;

    @Column(name = "observacao", columnDefinition = "text")
    private String observacao;

    public DetalheOcularTransferencia(Integer id) {
        this.id = id;
    }

    public DetalheOcularTransferencia() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQualidadeImagem() {
        return qualidadeImagem;
    }

    public void setQualidadeImagem(String qualidadeImagem) {
        this.qualidadeImagem = qualidadeImagem;
    }

    public boolean isDiscoOpticoAnormal() {
        return discoOpticoAnormal;
    }

    public void setDiscoOpticoAnormal(boolean discoOpticoAnormal) {
        this.discoOpticoAnormal = discoOpticoAnormal;
    }

    public float getDiscoOpticoEscavacao() {
        return discoOpticoEscavacao;
    }

    public void setDiscoOpticoEscavacao(float discoOpticoEscavacao) {
        this.discoOpticoEscavacao = discoOpticoEscavacao;
    }

    public boolean isMaculaAnormal() {
        return maculaAnormal;
    }

    public void setMaculaAnormal(boolean maculaAnormal) {
        this.maculaAnormal = maculaAnormal;
    }

    public boolean isRedeVascularAnormal() {
        return redeVascularAnormal;
    }

    public void setRedeVascularAnormal(boolean redeVascularAnormal) {
        this.redeVascularAnormal = redeVascularAnormal;
    }

    public boolean isPeriferiaRetinianaAnormal() {
        return periferiaRetinianaAnormal;
    }

    public void setPeriferiaRetinianaAnormal(boolean periferiaRetinianaAnormal) {
        this.periferiaRetinianaAnormal = periferiaRetinianaAnormal;
    }

    public boolean isMicroaneurismas() {
        return microaneurismas;
    }

    public void setMicroaneurismas(boolean microaneurismas) {
        this.microaneurismas = microaneurismas;
    }

    public boolean isHemorragiasRetinianas() {
        return hemorragiasRetinianas;
    }

    public void setHemorragiasRetinianas(boolean hemorragiasRetinianas) {
        this.hemorragiasRetinianas = hemorragiasRetinianas;
    }

    public boolean isManchasAlgodonosas() {
        return manchasAlgodonosas;
    }

    public void setManchasAlgodonosas(boolean manchasAlgodonosas) {
        this.manchasAlgodonosas = manchasAlgodonosas;
    }

    public boolean isExsudatosDuros() {
        return exsudatosDuros;
    }

    public void setExsudatosDuros(boolean exsudatosDuros) {
        this.exsudatosDuros = exsudatosDuros;
    }

    public boolean isEmcs() {
        return emcs;
    }

    public void setEmcs(boolean emcs) {
        this.emcs = emcs;
    }

    public boolean isHemorragiaPreretiniana() {
        return hemorragiaPreretiniana;
    }

    public void setHemorragiaPreretiniana(boolean hemorragiaPreretiniana) {
        this.hemorragiaPreretiniana = hemorragiaPreretiniana;
    }

    public boolean isHemorragiaVitrea() {
        return hemorragiaVitrea;
    }

    public void setHemorragiaVitrea(boolean hemorragiaVitrea) {
        this.hemorragiaVitrea = hemorragiaVitrea;
    }

    public boolean isDescolamentoTradicional() {
        return descolamentoTradicional;
    }

    public void setDescolamentoTradicional(boolean descolamentoTradicional) {
        this.descolamentoTradicional = descolamentoTradicional;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public boolean isNeovascularizacaoRetina() {
        return neovascularizacaoRetina;
    }

    public void setNeovascularizacaoRetina(boolean neovascularizacaoRetina) {
        this.neovascularizacaoRetina = neovascularizacaoRetina;
    }

    public boolean isNeovascularizacaoDisco() {
        return neovascularizacaoDisco;
    }

    public void setNeovascularizacaoDisco(boolean neovascularizacaoDisco) {
        this.neovascularizacaoDisco = neovascularizacaoDisco;
    }

    public boolean isIrma() {
        return irma;
    }

    public void setIrma(boolean irma) {
        this.irma = irma;
    }

}
