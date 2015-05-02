/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conversorbdweka;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.EcgAnalysDAOImpl;
import br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl.ExameDAOImpl;
import br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl.HistoricoClinicoDAOImpl;
import br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl.LaudoDAOImpl;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.Exame;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.HistoricoClinico;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.Laudo;
import br.ufmg.hc.telessaude.diagnostico.dominio.glasgow.EcgAnalys;
import br.ufmg.hc.telessaude.telediagnostico.xmlfactory.gerador.XMLFactory;
import conversorbdweka.utilidades.DAOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author breno
 */
public class ConversorBdWeka {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            List<Exame> lista =new ExameDAOImpl().findAll();
            List<HistoricoClinico> hist = new HistoricoClinicoDAOImpl().consultarPorIdExame(lista.get(0).getId());
            
             br.ufmg.hc.telessaude.telediagnostico.xmlfactory.estruturaantiga.HistoricoClinico histo = new XMLFactory().gerarHistoricoClinicoXMLAntigo(hist.get(0).getConteudo(), "UTF-8");
            
            List<EcgAnalys> analises = new EcgAnalysDAOImpl().findByIdExame(lista.get(0).getId());
           Laudo laudos = new LaudoDAOImpl().consultarUnicoPorIdExame(lista.get(0).getId());
            System.out.println(lista.size());
        } catch (br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException ex) {
            Logger.getLogger(ConversorBdWeka.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
