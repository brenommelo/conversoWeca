/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author igor.santos
 */
@Entity
@Table(name = "\"ESPECIALISTA\"", schema = PojoBase.DB)
public class Especialista extends PojoBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_ESPECIALISTA\"", nullable = false)
    private Integer id;
    @Column(name = "\"NOME\"", nullable = false)
    private String nome;
    @Column(name = "\"NUMEROREGISTRO\"")
    private String numeroregistro;
    @JoinColumn(name = "\"ID_ORGAOEMISSOR\"") //, referencedColumnName = "\"ID_ORGAOEMISSOR\"")
    @ManyToOne
    private OrgaoEmissor orgaoEmissor;
    @JoinColumn(name = "\"ID_USUARIO\"") //, referencedColumnName = "\"ID_USUARIO\"")
    @ManyToOne
    private Usuario usuario;
    @JoinColumn(name = "\"ID_STATUS\"") //, referencedColumnName = "\"ID_STATUS\"")
    @ManyToOne
    private Status status;
    @JoinColumn(name = "\"ID_EXAME\"") //, referencedColumnName = "\"ID_EXAME\"")
    @ManyToOne
    private Exame exame;
    
    @Column(name = "\"TEMPOESPERA\"")
    private int tempoEspera;
    
    @OneToMany
    private List<FraseEspecialistaEspecialidade> frasesEspecialistaEspecialidade;
    
    

    public Especialista() {
    }

    public Especialista(Integer id) {
        this.id = id;
    }

    public Especialista(Integer id, String nome, String numeroregistro) {
        this.id = id;
        this.nome = nome;
        this.numeroregistro = numeroregistro;
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

    public String getNumeroregistro() {
        return numeroregistro;
    }

    public void setNumeroregistro(String numeroregistro) {
        this.numeroregistro = numeroregistro;
    }

    public OrgaoEmissor getOrgaoEmissor() {
        if (orgaoEmissor == null) {
            orgaoEmissor = new OrgaoEmissor();
        }
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(OrgaoEmissor orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public Usuario getUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Status getStatus() {
        if (status == null) {
            status = new Status();
        }
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Exame getExame() {
        if (exame == null) {
            exame = new Exame();
        }
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    public List<FraseEspecialistaEspecialidade> getFrasesEspecialistaEspecialidade() {
        if (frasesEspecialistaEspecialidade == null) {
            frasesEspecialistaEspecialidade = new ArrayList();
        }
        return frasesEspecialistaEspecialidade;
    }

    public void setFrasesEspecialistaEspecialidade(List<FraseEspecialistaEspecialidade> frasesEspecialistaEspecialidade) {
        this.frasesEspecialistaEspecialidade = frasesEspecialistaEspecialidade;
    }

    /**
     * @return the tempoEspera
     */
    public int getTempoEspera() {
        return tempoEspera;
    }

    /**
     * @param tempoEspera the tempoEspera to set
     */
    public void setTempoEspera(int tempoEspera) {
        this.tempoEspera = tempoEspera;
    }
}
