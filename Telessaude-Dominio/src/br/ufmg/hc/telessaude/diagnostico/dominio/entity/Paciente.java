/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author igor.santos
 */
@Entity
@Table(name = "\"PACIENTE\"", schema = PojoBase.DB)
public class Paciente extends PojoBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_PACIENTE\"", nullable = false)
    private Integer id;
    @Column(name = "\"NOME\"", nullable = false)
    private String nome;
    @Column(name = "\"DATANASCIMENTO\"", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datanascimento;
    @Column(name = "\"SEXO\"", nullable = false)
    private String sexo;
    @Column(name = "\"TIPOSANGUINEO\"")
    private String tiposanguineo;
    @Column(name = "\"REGISTROCLINICO\"")
    private String registroclinico;
    @Column(name = "\"ENDERECO\"")
    private String endereco;
    @Column(name = "\"CIDADE\"")
    private String cidade;
    @Column(name = "\"ESTADO\"")
    private String estado;
    @Column(name = "\"PAIS\"")
    private String pais;
    @Column(name = "\"CEP\"")
    private String cep;
    @Column(name = "\"TELEFONE1\"")
    private String telefone1;
    @Column(name = "\"TELEFONE2\"")
    private String telefone2;
    @Column(name = "\"NATURALIDADE\"")
    private String naturalidade;
    @Column(name = "\"NOMEMAE\"")
    private String nomemae;
    @Column(name = "\"CARTAOSUS\"")
    private String cartaosus;

    public Paciente() {
    }

    public Paciente(Integer id) {
        this.id = id;
    }

    public Paciente(Integer id, String nome, Date datanascimento, String sexo, String tiposanguineo, String registroclinico, String endereco, String cidade, String estado, String pais, String cep, String telefone1, String telefone2, String naturalidade, String nomemae, String cartaosus) {
        this.id = id;
        this.nome = nome;
        this.datanascimento = datanascimento;
        this.sexo = sexo;
        this.tiposanguineo = tiposanguineo;
        this.registroclinico = registroclinico;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.cep = cep;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.naturalidade = naturalidade;
        this.nomemae = nomemae;
        this.cartaosus = cartaosus;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTiposanguineo() {
        return tiposanguineo;
    }

    public void setTiposanguineo(String tiposanguineo) {
        this.tiposanguineo = tiposanguineo;
    }

    public String getRegistroclinico() {
        return registroclinico;
    }

    public void setRegistroclinico(String registroclinico) {
        this.registroclinico = registroclinico;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNomemae() {
        return nomemae;
    }

    public void setNomemae(String nomemae) {
        this.nomemae = nomemae;
    }

    public String getCartaosus() {
        return cartaosus;
    }

    public void setCartaosus(String cartaosus) {
        this.cartaosus = cartaosus;
    }
}