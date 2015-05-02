/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conversorbdweka.entidades.origem;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author weslley.matos
 */
@Entity
@Table(name = "\"ENVIOEMAIL\"", schema = PojoBase.DB)
public class EnvioEmail extends PojoBase implements Serializable{
    
    @Id
    @OneToOne
    @JoinColumn(name = "\"ID_USUARIO\"") //, referencedColumnName = "\"ID_USUARIO\"")
    private Usuario usuario;
    
    @Column(name = "\"TEMPO1\"")
    private int tempo1;
    
    @Column(name = "\"TEMPO2\"")
    private int tempo2;
    
    public EnvioEmail() {
        
    }
    
    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void setId(Integer id) {
        //
    }
    
    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        if(usuario == null) {
            usuario = new Usuario();
        }
        
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    /**
     * @return the tempo1
     */
    public int getTempo1() {
        return tempo1;
    }

    /**
     * @param tempo1 the tempo1 to set
     */
    public void setTempo1(int tempo1) {
        this.tempo1 = tempo1;
    }

    /**
     * @return the tempo2
     */
    public int getTempo2() {
        return tempo2;
    }

    /**
     * @param tempo2 the tempo2 to set
     */
    public void setTempo2(int tempo2) {
        this.tempo2 = tempo2;
    }
}
