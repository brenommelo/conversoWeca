/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversorbdweka.entidades.origem;

import java.io.Serializable;

/**
 *
 * @author paulo.gomes
 */
public abstract class PojoBase implements Serializable{
    
//    public static final String DB = "\"DIAGNOSTICOBETA\"";
    public static final String DB = "\"DIAGNOSTICOSAMITROP\"";

    public abstract Integer getId();

    public abstract void setId(Integer id);
}
