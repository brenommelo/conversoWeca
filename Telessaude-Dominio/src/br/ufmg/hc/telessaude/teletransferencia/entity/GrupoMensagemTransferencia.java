/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.teletransferencia.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author paulo.gomes
 */
@Entity
@Table(name = "grupo_mensagens", schema = PojoTransferencia.DB)
public class GrupoMensagemTransferencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_criacao",nullable = true)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuario")
    private UsuarioTransferencia usuario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_mensagem")
    private MensagemTransferencia mensagem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public UsuarioTransferencia getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioTransferencia usuario) {
        this.usuario = usuario;
    }

    public MensagemTransferencia getMensagem() {
        return mensagem;
    }

    public void setMensagem(MensagemTransferencia mensagem) {
        this.mensagem = mensagem;
    }
    
    
    
    
}
