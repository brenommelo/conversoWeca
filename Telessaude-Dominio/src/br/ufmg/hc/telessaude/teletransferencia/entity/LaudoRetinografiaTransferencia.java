/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.teletransferencia.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author paulo.gomes
 */
@Entity
@PrimaryKeyJoinColumn
@Table(name = "laudos_retinografia", schema = PojoTransferencia.DB)
public class LaudoRetinografiaTransferencia extends LaudoTransferencia implements Serializable {

    @ManyToOne
    @JoinColumn(name = "olho_esquerdo", nullable = false)
    private DetalheOcularTransferencia olhoEsquedo;

    @ManyToOne
    @JoinColumn(name = "olho_direito", nullable = false)
    private DetalheOcularTransferencia olhoDireito;
    
    @ManyToOne
    @JoinColumn(name = "conclusao", nullable = true)
    private RespostaRetinografiaTransferencia conclusao;

    public DetalheOcularTransferencia getOlhoEsquedo() {
        return olhoEsquedo;
    }

    public void setOlhoEsquedo(DetalheOcularTransferencia olhoEsquedo) {
        this.olhoEsquedo = olhoEsquedo;
    }

    public DetalheOcularTransferencia getOlhoDireito() {
        return olhoDireito;
    }

    public void setOlhoDireito(DetalheOcularTransferencia olhoDireito) {
        this.olhoDireito = olhoDireito;
    }

    public RespostaRetinografiaTransferencia getConclusao() {
        return conclusao;
    }

    public void setConclusao(RespostaRetinografiaTransferencia conclusao) {
        this.conclusao = conclusao;
    }
    
}
