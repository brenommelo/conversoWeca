/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Transient;

/**
 *
 * @author igor.santos
 */
@Entity
@Table(name = "\"EXAME\"", schema = PojoBase.DB)
public class Exame extends PojoBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_EXAME\"", nullable = false)
    private Integer id;
    @Column(name = "\"DATAINCLUSAO\"", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datainclusao;
    @Column(name = "\"DATAREALIZACAO\"", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datarealizacao;
    @Column(name = "\"PATH\"")
    private String path;
    @Column(name = "\"VISUALIZADO\"")
    private Integer visualizado;
    @JoinColumn(name = "\"ID_TIPOEXAME\"") //, referencedColumnName = "\"ID_TIPOEXAME\"")
    @ManyToOne(optional = false)
    private TipoExame tipoExame;
    @JoinColumn(name = "\"ID_STATUS\"") //, referencedColumnName = "\"ID_STATUS\"")
    @ManyToOne(optional = false)
    private Status status;
    @JoinColumn(name = "\"ID_PRIORIDADE\"") //, referencedColumnName = "\"ID_PRIORIDADE\"")
    @ManyToOne(optional = false)
    private Prioridade prioridade;
    @JoinColumn(name = "\"ID_PONTOREMOTO\"") //, referencedColumnName = "\"ID_PONTOREMOTO\"")
    @ManyToOne(optional = false)
    private PontoRemoto pontoRemoto;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "\"ID_PACIENTE\"") //, referencedColumnName = "\"ID_PACIENTE\"")
    private Paciente paciente;
    
    @JoinColumn(name = "\"ID_ESPECIALISTA\"") //, referencedColumnName = "\"ID_ESPECIALISTA\"")
    @ManyToOne
    private Especialista especialista;
    @Transient
    private List<HistoricoClinico> historicosClinicos;
//    @OneToMany(fetch = FetchType.LAZY)
    @Transient
    private List<ConteudoExame> conteudosExames;
//    @OneToMany(fetch = FetchType.LAZY)
    @Transient
    private List<Laudo> laudos;

    public Exame() {
    }

    public Exame(Integer id) {
        this.id = id;
    }

    public Exame(Integer id, Date datainclusao, Date datarealizacao, String path, Integer visualizado) {
        this.id = id;
        this.datainclusao = datainclusao;
        this.datarealizacao = datarealizacao;
        this.path = path;
        this.visualizado = visualizado;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
    
        @Override
    public String toString() {
        return String.valueOf(id);
    }

    public Date getDatainclusao() {
        return datainclusao;
    }

    public void setDatainclusao(Date datainclusao) {
        this.datainclusao = datainclusao;
    }

    public Date getDatarealizacao() {
        return datarealizacao;
    }

    public void setDatarealizacao(Date datarealizacao) {
        this.datarealizacao = datarealizacao;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getVisualizado() {
        return visualizado;
    }

    public void setVisualizado(Integer visualizado) {
        this.visualizado = visualizado;
    }

    public TipoExame getTipoExame() {
//        if (tipoExame == null) {
//            tipoExame = new TipoExame();
//        }
        return tipoExame;
    }

    public void setTipoExame(TipoExame tipoExame) {
        this.tipoExame = tipoExame;
    }

    public Status getStatus() {
//        if (status == null) {
//            status = new Status();
//        }
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Prioridade getPrioridade() {
//        if (prioridade == null) {
//            prioridade = new Prioridade();
//        }
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public PontoRemoto getPontoRemoto() {
//        if (pontoRemoto == null) {
//            pontoRemoto = new PontoRemoto();
//        }
        return pontoRemoto;
    }

    public void setPontoRemoto(PontoRemoto pontoRemoto) {
        this.pontoRemoto = pontoRemoto;
    }

    public Paciente getPaciente() {
//        if (paciente == null) {
//            paciente = new Paciente();
//        }
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Especialista getEspecialista() {
//        if (especialista == null) {
//            especialista = new Especialista();
//        }
        return especialista;
    }

    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }

    public List<HistoricoClinico> getHistoricosClinicos() {
//        if (historicosClinicos == null) {
//            historicosClinicos = new ArrayList();
//        }
        return historicosClinicos;
    }

    public void setHistoricosClinicos(List<HistoricoClinico> historicosClinicos) {
        this.historicosClinicos = historicosClinicos;
    }

    public List<ConteudoExame> getConteudosExames() {
//        if (conteudosExames == null) {
//            conteudosExames = new ArrayList();
//        }
        return conteudosExames;
    }

    public void setConteudosExames(List<ConteudoExame> conteudosExames) {
        this.conteudosExames = conteudosExames;
    }

    public List<Laudo> getLaudos() {
//        if (laudos == null) {
//            laudos = new ArrayList();
//        }
                
        return laudos;
    }

    public void setLaudos(List<Laudo> laudos) {
        this.laudos = laudos;
    }
}
