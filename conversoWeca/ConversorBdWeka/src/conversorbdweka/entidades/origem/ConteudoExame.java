/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversorbdweka.entidades.origem;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "\"CONTEUDOEXAME\"", schema = PojoBase.DB)
public class ConteudoExame extends PojoBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_CONTEUDOEXAME\"", nullable = false)
    private Integer id;
    @Column(name = "\"CONTEUDO\"", nullable = false)
    private String conteudo;
    @JoinColumn(name = "\"ID_MODELOCONTEUDOEXAME\"")
    @ManyToOne(optional = false)
    private ModeloConteudoExame modeloConteudoExame;
    @JoinColumn(name = "\"ID_EXAME\"")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Exame exame;

    public ConteudoExame() {
    }

    public ConteudoExame(Integer id) {
        this.id = id;
    }

    public ConteudoExame(Integer id, String conteudo) {
        this.id = id;
        this.conteudo = conteudo;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public ModeloConteudoExame getModeloConteudoExame() {
        if (modeloConteudoExame == null) {
            modeloConteudoExame = new ModeloConteudoExame();
        }
        return modeloConteudoExame;
    }

    public void setModeloConteudoExame(ModeloConteudoExame modeloConteudoExame) {
        this.modeloConteudoExame = modeloConteudoExame;
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
}
