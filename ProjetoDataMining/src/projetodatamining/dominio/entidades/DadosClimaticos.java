/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetodatamining.dominio.entidades;

import java.util.Date;

/**
 *
 * @author breno
 */
public class DadosClimaticos {
    
    private Long id;
    private Long id_estacao;
    private String dataLeitura;
    private Float DirecaoVento;
    private Float VelocidadeVentoMedia;
    private Float VelocidadeVentoMaximaMedia;
    private Float EvaporacaoPiche;
    private Float EvapoBHPotencial;
    private Float EvapoBHReal;
    private Float InsolacaoTotal;
    private Float NebulosidadeMedia;
    private Float NumDiasPrecipitacao;
    private Float PrecipitacaoTotal;
    private Float PressaoNivelMarMedia;
    private Float PressaoMedia;
    private Float TempMaximaMedia;
    private Float TempCompensadaMedia;
    private Float TempMinimaMedia;
    private Float UmidadeRelativaMedia;
    private Float VisibilidadeMedia;

    public DadosClimaticos(Long id) {
        this.id = id;
    }

    public DadosClimaticos() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_estacao() {
        return id_estacao;
    }

    public void setId_estacao(Long id_estacao) {
        this.id_estacao = id_estacao;
    }
    public Float getDirecaoVento() {
        return DirecaoVento;
    }

    public void setDirecaoVento(Float DirecaoVento) {
        this.DirecaoVento = DirecaoVento;
    }

    public Float getVelocidadeVentoMedia() {
        return VelocidadeVentoMedia;
    }

    public void setVelocidadeVentoMedia(Float VelocidadeVentoMedia) {
        this.VelocidadeVentoMedia = VelocidadeVentoMedia;
    }

    public Float getVelocidadeVentoMaximaMedia() {
        return VelocidadeVentoMaximaMedia;
    }

    public void setVelocidadeVentoMaximaMedia(Float VelocidadeVentoMaximaMedia) {
        this.VelocidadeVentoMaximaMedia = VelocidadeVentoMaximaMedia;
    }

    public Float getEvaporacaoPiche() {
        return EvaporacaoPiche;
    }

    public void setEvaporacaoPiche(Float EvaporacaoPiche) {
        this.EvaporacaoPiche = EvaporacaoPiche;
    }

    public Float getEvapoBHPotencial() {
        return EvapoBHPotencial;
    }

    public void setEvapoBHPotencial(Float EvapoBHPotencial) {
        this.EvapoBHPotencial = EvapoBHPotencial;
    }

    public Float getEvapoBHReal() {
        return EvapoBHReal;
    }

    public void setEvapoBHReal(Float EvapoBHReal) {
        this.EvapoBHReal = EvapoBHReal;
    }

    public Float getInsolacaoTotal() {
        return InsolacaoTotal;
    }

    public void setInsolacaoTotal(Float InsolacaoTotal) {
        this.InsolacaoTotal = InsolacaoTotal;
    }

    public Float getNebulosidadeMedia() {
        return NebulosidadeMedia;
    }

    public void setNebulosidadeMedia(Float NebulosidadeMedia) {
        this.NebulosidadeMedia = NebulosidadeMedia;
    }

    public Float getNumDiasPrecipitacao() {
        return NumDiasPrecipitacao;
    }

    public void setNumDiasPrecipitacao(Float NumDiasPrecipitacao) {
        this.NumDiasPrecipitacao = NumDiasPrecipitacao;
    }

    public Float getPrecipitacaoTotal() {
        return PrecipitacaoTotal;
    }

    public void setPrecipitacaoTotal(Float PrecipitacaoTotal) {
        this.PrecipitacaoTotal = PrecipitacaoTotal;
    }

    public Float getPressaoNivelMarMedia() {
        return PressaoNivelMarMedia;
    }

    public void setPressaoNivelMarMedia(Float PressaoNivelMarMedia) {
        this.PressaoNivelMarMedia = PressaoNivelMarMedia;
    }

    public Float getPressaoMedia() {
        return PressaoMedia;
    }

    public void setPressaoMedia(Float PressaoMedia) {
        this.PressaoMedia = PressaoMedia;
    }

    public Float getTempMaximaMedia() {
        return TempMaximaMedia;
    }

    public void setTempMaximaMedia(Float TempMaximaMedia) {
        this.TempMaximaMedia = TempMaximaMedia;
    }

    public Float getTempCompensadaMedia() {
        return TempCompensadaMedia;
    }

    public void setTempCompensadaMedia(Float TempCompensadaMedia) {
        this.TempCompensadaMedia = TempCompensadaMedia;
    }

    public Float getTempMinimaMedia() {
        return TempMinimaMedia;
    }

    public void setTempMinimaMedia(Float TempMinimaMedia) {
        this.TempMinimaMedia = TempMinimaMedia;
    }

    public Float getUmidadeRelativaMedia() {
        return UmidadeRelativaMedia;
    }

    public void setUmidadeRelativaMedia(Float UmidadeRelativaMedia) {
        this.UmidadeRelativaMedia = UmidadeRelativaMedia;
    }

    public Float getVisibilidadeMedia() {
        return VisibilidadeMedia;
    }

    public void setVisibilidadeMedia(Float VisibilidadeMedia) {
        this.VisibilidadeMedia = VisibilidadeMedia;
    }

    public String getDataLeitura() {
        return dataLeitura;
    }

    public void setDataLeitura(String dataLeitura) {
        this.dataLeitura = dataLeitura;
    }
    
    
}
