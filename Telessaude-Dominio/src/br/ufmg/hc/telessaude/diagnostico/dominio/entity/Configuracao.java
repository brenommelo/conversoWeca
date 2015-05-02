/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author igor.santos
 */
@Entity
@Table(name = "\"CONFIGURACAO\"", schema = PojoBase.DB)
public class Configuracao implements Serializable {

    @Id
    @Column(name = "\"NOME\"", nullable = false)
    private String nome;
    @Column(name = "\"VALOR\"", nullable = false)
    private String valor;

    public Configuracao() {
    }

    public Configuracao(String nome, String valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
