/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.auditoria.entity;

import br.ufmg.hc.telessaude.diagnostico.dominio.entity.Laudo;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.PojoBase;
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
import javax.persistence.TemporalType;

/**
 *
 * @author paulo.gomes
 */
@Entity
@Table(name = "\"AUDITORIA_ECG\"", schema = PojoBase.DB)
public class AuditoriaECG extends PojoBase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_AUDITORIA\"", nullable = false)
    private Integer id;

    @Column(name = "\"DATAINCLUSAO\"", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;

    @Column(name = "\"LAUDO_CORRETO\"")
    private boolean laudoCorreto;
    @Column(name = "\"RITMO_MARCAPASSO\"")
    private boolean ritmoMarcapasso;
    @Column(name = "\"EXTRA_SISTOLES\"")
    private boolean extraSistoles;
    @Column(name = "\"BRADIARRITMIAS\"")
    private boolean bradiarritmias;
    @Column(name = "\"FIBRILACAO\"")
    private boolean fibrilacao;
    @Column(name = "\"OUTRA_TAQUIARRITMIA\"")
    private boolean outraTaquiarritmia;
    @Column(name = "\"BLOQUEIOS\"")
    private boolean bloqueios;
    @Column(name = "\"PRE_EXCITACAO_VENTRICULAR\"")
    private boolean preExcitacaoVentricular;
    @Column(name = "\"SOBRECARGA_ATRIAL\"")
    private boolean sobrecargaAtrial;
    @Column(name = "\"SOBRECARGA_VENTRICULAR\"")
    private boolean sobrecargaVentricular;
    @Column(name = "\"ISQUEMIA\"")
    private boolean isquemia;
    @Column(name = "\"INATIVIDADE_ELETRICA\"")
    private boolean inatividadeEletrica;
    @Column(name = "\"REPOLARIZACAO\"")
    private boolean repolarizacao;
    @Column(name = "\"QT_LONGO\"")
    private boolean qTLongo;
    @Column(name = "\"DADOS_CLINICOS_INCORRETOS\"")
    private boolean dadosClinicosIncorretos;
    @Column(name = "\"INTERFERENCIA_EXCESSIVA\"")
    private boolean interferenciaExcessiva;
    @Column(name = "\"MENSURACOES_ERRADAS\"")
    private boolean mensuracoesErradas;
    @Column(name = "\"POSICIONAMENTO_ELETRODO_INCORRETO\"")
    private boolean posicionamentoEletrodoIncorreto;
    @Column(name = "\"POTENCIAL_ALTERACAO\"")
    private boolean potencialAlteracao;

    @Column(name = "\"OBSERVACAO\"", columnDefinition = "text default null")
    private String observacao;
    
    @JoinColumn(name = "\"ID_LAUDO\"")
    @ManyToOne(optional = false)
    private Laudo laudo;

    public AuditoriaECG() {
    }

    public AuditoriaECG(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public boolean isLaudoCorreto() {
        return laudoCorreto;
    }

    public void setLaudoCorreto(boolean laudoCorreto) {
        this.laudoCorreto = laudoCorreto;
    }

    public boolean isRitmoMarcapasso() {
        return ritmoMarcapasso;
    }

    public void setRitmoMarcapasso(boolean ritmoMarcapasso) {
        this.ritmoMarcapasso = ritmoMarcapasso;
    }

    public boolean isExtraSistoles() {
        return extraSistoles;
    }

    public void setExtraSistoles(boolean extraSistoles) {
        this.extraSistoles = extraSistoles;
    }

    public boolean isBradiarritmias() {
        return bradiarritmias;
    }

    public void setBradiarritmias(boolean bradiarritmias) {
        this.bradiarritmias = bradiarritmias;
    }

    public boolean isFibrilacao() {
        return fibrilacao;
    }

    public void setFibrilacao(boolean fibrilacao) {
        this.fibrilacao = fibrilacao;
    }

    public boolean isOutraTaquiarritmia() {
        return outraTaquiarritmia;
    }

    public void setOutraTaquiarritmia(boolean outraTaquiarritmia) {
        this.outraTaquiarritmia = outraTaquiarritmia;
    }

    public boolean isBloqueios() {
        return bloqueios;
    }

    public void setBloqueios(boolean bloqueios) {
        this.bloqueios = bloqueios;
    }

    public boolean isPreExcitacaoVentricular() {
        return preExcitacaoVentricular;
    }

    public void setPreExcitacaoVentricular(boolean preExcitacaoVentricular) {
        this.preExcitacaoVentricular = preExcitacaoVentricular;
    }

    public boolean isSobrecargaAtrial() {
        return sobrecargaAtrial;
    }

    public void setSobrecargaAtrial(boolean sobrecargaAtrial) {
        this.sobrecargaAtrial = sobrecargaAtrial;
    }

    public boolean isSobrecargaVentricular() {
        return sobrecargaVentricular;
    }

    public void setSobrecargaVentricular(boolean sobrecargaVentricular) {
        this.sobrecargaVentricular = sobrecargaVentricular;
    }

    public boolean isIsquemia() {
        return isquemia;
    }

    public void setIsquemia(boolean isquemia) {
        this.isquemia = isquemia;
    }

    public boolean isInatividadeEletrica() {
        return inatividadeEletrica;
    }

    public void setInatividadeEletrica(boolean inatividadeEletrica) {
        this.inatividadeEletrica = inatividadeEletrica;
    }

    public boolean isRepolarizacao() {
        return repolarizacao;
    }

    public void setRepolarizacao(boolean repolarizacao) {
        this.repolarizacao = repolarizacao;
    }

    public boolean isqTLongo() {
        return qTLongo;
    }

    public void setqTLongo(boolean qTLongo) {
        this.qTLongo = qTLongo;
    }

    public boolean isDadosClinicosIncorretos() {
        return dadosClinicosIncorretos;
    }

    public void setDadosClinicosIncorretos(boolean dadosClinicosIncorretos) {
        this.dadosClinicosIncorretos = dadosClinicosIncorretos;
    }

    public boolean isInterferenciaExcessiva() {
        return interferenciaExcessiva;
    }

    public void setInterferenciaExcessiva(boolean interferenciaExcessiva) {
        this.interferenciaExcessiva = interferenciaExcessiva;
    }

    public boolean isMensuracoesErradas() {
        return mensuracoesErradas;
    }

    public void setMensuracoesErradas(boolean mensuracoesErradas) {
        this.mensuracoesErradas = mensuracoesErradas;
    }

    public boolean isPosicionamentoEletrodoIncorreto() {
        return posicionamentoEletrodoIncorreto;
    }

    public void setPosicionamentoEletrodoIncorreto(boolean posicionamentoEletrodoIncorreto) {
        this.posicionamentoEletrodoIncorreto = posicionamentoEletrodoIncorreto;
    }

    public boolean isPotencialAlteracao() {
        return potencialAlteracao;
    }

    public void setPotencialAlteracao(boolean potencialAlteracao) {
        this.potencialAlteracao = potencialAlteracao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Laudo getLaudo() {
        return laudo;
    }

    public void setLaudo(Laudo laudo) {
        this.laudo = laudo;
    }    

}
