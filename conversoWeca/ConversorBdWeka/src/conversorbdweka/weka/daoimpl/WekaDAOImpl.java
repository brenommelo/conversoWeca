/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversorbdweka.weka.daoimpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl.DaoBase;
import conversorbdweka.weka.ModeloWeka;
import conversorbdweka.weka.dao.WekaDAO;

/**
 *
 * @author paulo.gomes
 */
public class WekaDAOImpl extends DaoBase<ModeloWeka> implements WekaDAO{

    public WekaDAOImpl() {
        super(ModeloWeka.class);
    }
    
}
