/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversorbdweka.weka.daoimpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl.DaoBase;
import conversorbdweka.weka.ModeloWekaCluster;
import conversorbdweka.weka.dao.WekaClusterDAO;

/**
 *
 * @author paulo.gomes
 */
public class WekaClusterDAOImpl extends DaoBase<ModeloWekaCluster> implements WekaClusterDAO{

    public WekaClusterDAOImpl() {
        super(ModeloWekaCluster.class);
    }
    
}
