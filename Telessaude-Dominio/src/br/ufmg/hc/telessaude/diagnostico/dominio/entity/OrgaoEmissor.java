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
import javax.persistence.Table;

/**
 *
 * @author igor.santos
 */
@Entity
@Table(name = "\"ORGAOEMISSOR\"", schema = PojoBase.DB)
public class OrgaoEmissor extends PojoBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_ORGAOEMISSOR\"", nullable = false)
    private Integer id;
    @Column(name = "\"NOME\"", nullable = false)
    private String nome;
    @Column(name = "\"SIGLA\"")
    private String sigla;

    public OrgaoEmissor() {
    }

    public OrgaoEmissor(Integer id) {
        this.id = id;
    }

    public OrgaoEmissor(Integer id, String nome, String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
