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
@Table(name = "\"PERFILUSUARIO\"", schema = PojoBase.DB)
public class PerfilUsuario extends PojoBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_PERFILUSUARIO\"", nullable = false)
    private Integer id;
    @Column(name = "\"NOME\"", nullable = false)
    private String nome;

    public PerfilUsuario() {
    }

    public PerfilUsuario(Integer id) {
        this.id = id;
    }

    public PerfilUsuario(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
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

    @Override
    public String toString() {
        return this.nome;
    }
}