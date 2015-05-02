/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.diagnostico.dominio.download.entity;

/**
 *
 * @author breno.melo
 */
public class Exame {
    
    private String nomePaciente;
    
    private String nomeMaePaciente;
    
    private String dataNascimento;
    
    private String diretorioArquivo;
    
    private String hashArquivo;
    
    private String diretorioZip;
    
    private String diretorioXml;
    
    private char sexo;
    
    private String dataRealzacao;
    
    private String tipoExame;
    
    private int id_paciente;
    
    private int id_pontoRemoto;
    
    private int id_usuario;
    
    private int id_exame;
    
    private String observacoes;


    public Exame() {
    }

    /**
     * @return the nomePaciente
     */
    public String getNomePaciente() {
        return nomePaciente;
    }

    /**
     * @param nomePaciente the nomePaciente to set
     */
    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    /**
     * @return the nomeMaePaciente
     */
    public String getNomeMaePaciente() {
        return nomeMaePaciente;
    }

    /**
     * @param nomeMaePaciente the nomeMaePaciente to set
     */
    public void setNomeMaePaciente(String nomeMaePaciente) {
        this.nomeMaePaciente = nomeMaePaciente;
    }

    /**
     * @return the dataNascimento
     */
    public String getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the diretorioArquivo
     */
    public String getDiretorioArquivo() {
        return diretorioArquivo;
    }

    /**
     * @param diretorioArquivo the diretorioArquivo to set
     */
    public void setDiretorioArquivo(String diretorioArquivo) {
        this.diretorioArquivo = diretorioArquivo;
    }

    public String getHashArquivo() {
        return hashArquivo;
    }

    public void setHashArquivo(String hashArquivo) {
        this.hashArquivo = hashArquivo;
    }

    /**
     * @return the diretorioZip
     */
    public String getDiretorioZip() {
        return diretorioZip;
    }

    /**
     * @param diretorioZip the diretorioZip to set
     */
    public void setDiretorioZip(String diretorioZip) {
        this.diretorioZip = diretorioZip;
    }

    /**
     * @return the diretorioXml
     */
    public String getDiretorioXml() {
        return diretorioXml;
    }

    /**
     * @param diretorioXml the diretorioXml to set
     */
    public void setDiretorioXml(String diretorioXml) {
        this.diretorioXml = diretorioXml;
    }

    /**
     * @return the sexo
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the dataRealzacao
     */
    public String getDataRealzacao() {
        return dataRealzacao;
    }

    /**
     * @param dataRealzacao the dataRealzacao to set
     */
    public void setDataRealzacao(String dataRealzacao) {
        this.dataRealzacao = dataRealzacao;
    }

    /**
     * @return the tipoExame
     */
    public String getTipoExame() {
        return tipoExame;
    }

    /**
     * @param tipoExame the tipoExame to set
     */
    public void setTipoExame(String tipoExame) {
        this.tipoExame = tipoExame;
    }

    /**
     * @return the id_paciente
     */
    public int getIdPaciente() {
        return id_paciente;
    }

    /**
     * @param id_paciente the id_paciente to set
     */
    public void setIdPaciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    /**
     * @return the id_pontoRemoto
     */
    public int getIdPontoRemoto() {
        return id_pontoRemoto;
    }

    /**
     * @param id_pontoRemoto the id_pontoRemoto to set
     */
    public void setIdPontoRemoto(int id_pontoRemoto) {
        this.id_pontoRemoto = id_pontoRemoto;
    }

    /**
     * @return the id_usuario
     */
    public int getIdUsuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setIdUsuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the id_exame
     */
    public int getIdExame() {
        return id_exame;
    }

    /**
     * @param id_exame the id_exame to set
     */
    public void setIdExame(int id_exame) {
        this.id_exame = id_exame;
    }

    /**
     * @return the observacoes
     */
    public String getObservacoes() {
        return observacoes;
    }

    /**
     * @param observacoes the observacoes to set
     */
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

   
    
    
}
