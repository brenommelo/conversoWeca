/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.entity;

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
 * @author igor.santos
 */
@Entity
@Table(name = "\"PONTOREMOTO\"", schema = PojoBase.DB)
public class PontoRemoto extends PojoBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_PONTOREMOTO\"", nullable = false)
    private Integer id;
    @Column(name = "\"NOME\"", nullable = false)
    private String nome;
    @Column(name = "\"CNPJ\"")
    private String cnpj;
    @Column(name = "\"CNES\"")
    private String cnes;
    @Column(name = "\"IDENTIFICADOR\"")
    private String identificador;
    @JoinColumn(name = "\"ID_ENDERECO\"") //, referencedColumnName = "\"ID_ENDERECO\"")
    @ManyToOne(optional = false)
    private Endereco endereco;
    @JoinColumn(name = "\"ID_CLIENTE\"") //, referencedColumnName = "\"ID_CLIENTE\"")
    @ManyToOne(optional = false)
    private Cliente cliente;

    public PontoRemoto() {
    }

    public PontoRemoto(Integer id) {
        this.id = id;
    }

    public PontoRemoto(Integer id, String nome, String cnpj, String cnes, String identificador) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.cnes = cnes;
        this.identificador = identificador;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnes() {
        return cnes;
    }

    public void setCnes(String cnes) {
        this.cnes = cnes;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Endereco getEndereco() {
//        if (endereco == null) {
//            endereco = new Endereco();
//        }
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Cliente getCliente() {
//        if (cliente == null) {
//            cliente = new Cliente();
//        }
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}