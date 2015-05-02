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
import javax.persistence.Table;

/**
 *
 * @author igor.santos
 */
@Entity
@Table(name = "\"ESPECIALIDADE\"", schema = PojoBase.DB)
public class Especialidade extends PojoBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_ESPECIALIDADE\"", nullable = false)
    private Integer id;
    @Column(name = "\"NOME\"", nullable = false)
    private String nome;
    @Column(name = "\"MODELOFRASE\"", nullable = false)
    private String modelofrase;

    public Especialidade() {
    }

    public Especialidade(Integer id) {
        this.id = id;
    }

    public Especialidade(Integer id, String nome, String modelofrase) {
        this.id = id;
        this.nome = nome;
        this.modelofrase = modelofrase;
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

    public String getModelofrase() {
        return modelofrase;
    }

    public void setModelofrase(String modelofrase) {
        this.modelofrase = modelofrase;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
}
