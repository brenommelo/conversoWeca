/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversorbdweka.entidades.origem;

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
@Table(name = "\"FRASE_ESPECIALISTA_ESPECIALIDADE\"", schema = PojoBase.DB)
public class FraseEspecialistaEspecialidade extends PojoBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_FRASE\"", nullable = false)
    private Integer id;
    @Column(name = "\"CONTEUDO\"", nullable = false)
    private String conteudo;
    @JoinColumn(name = "\"ID_ESPECIALISTA\"") //, referencedColumnName = "\"ID_ESPECIALISTA\"")
    @ManyToOne(optional = false)
    private Especialista especialista;
    @JoinColumn(name = "\"ID_ESPECIALIDADE\"") //, referencedColumnName = "\"ID_ESPECIALIDADE\"")
    @ManyToOne(optional = false)
    private Especialidade especialidade;

    public FraseEspecialistaEspecialidade() {
    }

    public FraseEspecialistaEspecialidade(Integer id) {
        this.id = id;
    }

    public FraseEspecialistaEspecialidade(Integer id, String conteudo) {
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

    public Especialista getEspecialista() {
        if (especialista == null) {
            especialista = new Especialista();
        }
        return especialista;
    }

    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }

    public Especialidade getEspecialidade() {
        if (especialidade == null) {
            especialidade = new Especialidade();
        }
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
}