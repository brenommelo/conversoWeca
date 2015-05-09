/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetodatamining.dominio.entidades;

/**
 *
 * @author breno
 */
public class ComercioExterior {
    private Long id;
    private Municipio municipio;
    private String mes;
    private Integer ano;
    private Float valorExportacoes;
    private Float valorImportacoes;
    private Float pesoExportacoes;
    private Float pesoImportacoes;
    private Float complexidadeEconomica;
    private Float diversidadeProdutos;
    private Float diversidadeDestino;
    private Float diversidadeDestinoEfetiva;
    private Float diversidadeEfetivaProdutos;
    private Float crescimentoNominalImportUmAno;
    private Float crescimentoNominalImportCincoAnos;
    private Float crescimentoNominalExportUmAno;
    private Float crescimentoNominalExportCincoAnos;

    public ComercioExterior() {
    }

    public ComercioExterior(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Float getValorExportacoes() {
        return valorExportacoes;
    }

    public void setValorExportacoes(Float valorExportacoes) {
        this.valorExportacoes = valorExportacoes;
    }

    public Float getValorImportacoes() {
        return valorImportacoes;
    }

    public void setValorImportacoes(Float valorImportacoes) {
        this.valorImportacoes = valorImportacoes;
    }

    public Float getPesoExportacoes() {
        return pesoExportacoes;
    }

    public void setPesoExportacoes(Float pesoExportacoes) {
        this.pesoExportacoes = pesoExportacoes;
    }

    public Float getPesoImportacoes() {
        return pesoImportacoes;
    }

    public void setPesoImportacoes(Float pesoImportacoes) {
        this.pesoImportacoes = pesoImportacoes;
    }

    public Float getComplexidadeEconomica() {
        return complexidadeEconomica;
    }

    public void setComplexidadeEconomica(Float complexidadeEconomica) {
        this.complexidadeEconomica = complexidadeEconomica;
    }

    public Float getDiversidadeEfetivaProdutos() {
        return diversidadeEfetivaProdutos;
    }

    public void setDiversidadeEfetivaProdutos(Float diversidadeEfetivaProdutos) {
        this.diversidadeEfetivaProdutos = diversidadeEfetivaProdutos;
    }

    public Float getCrescimentoNominalImportUmAno() {
        return crescimentoNominalImportUmAno;
    }

    public void setCrescimentoNominalImportUmAno(Float crescimentoNominalImportUmAno) {
        this.crescimentoNominalImportUmAno = crescimentoNominalImportUmAno;
    }

    public Float getCrescimentoNominalImportCincoAnos() {
        return crescimentoNominalImportCincoAnos;
    }

    public void setCrescimentoNominalImportCincoAnos(Float crescimentoNominalImportCincoAnos) {
        this.crescimentoNominalImportCincoAnos = crescimentoNominalImportCincoAnos;
    }

    public Float getCrescimentoNominalExportUmAno() {
        return crescimentoNominalExportUmAno;
    }

    public void setCrescimentoNominalExportUmAno(Float crescimentoNominalExportUmAno) {
        this.crescimentoNominalExportUmAno = crescimentoNominalExportUmAno;
    }

    public Float getCrescimentoNominalExportCincoAnos() {
        return crescimentoNominalExportCincoAnos;
    }

    public void setCrescimentoNominalExportCincoAnos(Float crescimentoNominalExportCincoAnos) {
        this.crescimentoNominalExportCincoAnos = crescimentoNominalExportCincoAnos;
    }

    public Float getDiversidadeProdutos() {
        return diversidadeProdutos;
    }

    public void setDiversidadeProdutos(Float diversidadeProdutos) {
        this.diversidadeProdutos = diversidadeProdutos;
    }

    public Float getDiversidadeDestino() {
        return diversidadeDestino;
    }

    public void setDiversidadeDestino(Float diversidadeDestino) {
        this.diversidadeDestino = diversidadeDestino;
    }

    public Float getDiversidadeDestinoEfetiva() {
        return diversidadeDestinoEfetiva;
    }

    public void setDiversidadeDestinoEfetiva(Float diversidadeDestinoEfetiva) {
        this.diversidadeDestinoEfetiva = diversidadeDestinoEfetiva;
    }

    
    
}
