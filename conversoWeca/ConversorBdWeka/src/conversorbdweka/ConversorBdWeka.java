/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversorbdweka;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.EcgAnalysDAOImpl;
import br.ufmg.hc.telessaude.diagnostico.dominio.dao.MinnesotaCodeDAOImpl;
import br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl.ExameDAOImpl;
import br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl.HistoricoClinicoDAOImpl;
import br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl.LaudoDAOImpl;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.Exame;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.HistoricoClinico;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.Laudo;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.diagnostico.dominio.glasgow.EcgAnalys;
import br.ufmg.hc.telessaude.diagnostico.dominio.glasgow.MinnesotaCode;
import br.ufmg.hc.telessaude.telediagnostico.xmlfactory.gerador.XMLFactory;
import conversorbdweka.weka.ModeloWeka;
import conversorbdweka.weka.ModeloWekaCluster;
import conversorbdweka.weka.daoimpl.WekaClusterDAOImpl;
import conversorbdweka.weka.daoimpl.WekaDAOImpl;
import java.util.ArrayList;
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
//        iniciarCarga();
//        criarTxt();
        criarTxtCluster();
    }

    public static void criarTxtCluster() {
        try {
            List<ModeloWekaCluster> listaWeka = new WekaClusterDAOImpl().findAll();
            List<String> listaTexto = new ArrayList();
//            for (ModeloWekaCluster modeloWeka : listaWeka) {
//                if (!listaTexto.contains(modeloWeka.getComorbidades())) {
//                    listaTexto.add(modeloWeka.getComorbidades());
//
//                }
//            }
//            for (String string : listaTexto) {
//                System.out.println(string);
//            }
            listaTexto.add("@relation ModeloWekaCluster");

            listaTexto.add("@attribute idProfissional numeric");
            listaTexto.add("@attribute tempoLaudo numeric");
            listaTexto.add("@attribute amiodarona numeric");
            listaTexto.add("@attribute betaBloqueadores numeric");
            listaTexto.add("@attribute bloqueadorCalcio numeric");
            listaTexto.add("@attribute digital numeric");
            listaTexto.add("@attribute diureticos numeric");
            listaTexto.add("@attribute iec numeric");
            listaTexto.add("@attribute outros numeric");
            listaTexto.add("@attribute sexo numeric");
            listaTexto.add("@attribute imc numeric");
            listaTexto.add("@attribute idade numeric");
            listaTexto.add("@attribute tabagismo numeric");
            listaTexto.add("@attribute revascularizacaoPrevia numeric");
            listaTexto.add("@attribute obesidade numeric");
            listaTexto.add("@attribute infartoPrevio numeric");
            listaTexto.add("@attribute historicoFamiliar numeric");
            listaTexto.add("@attribute hipertencao numeric");
            listaTexto.add("@attribute drc numeric");
            listaTexto.add("@attribute dpoc numeric");
            listaTexto.add("@attribute chagas numeric");
            listaTexto.add("@attribute dislipidemia numeric");
            listaTexto.add("@attribute diabetesMelitus numeric");
            listaTexto.add("@attribute paSistolica numeric");
            listaTexto.add("@attribute paDiastolica numeric");
            listaTexto.add("@attribute glHeartRate numeric");
            listaTexto.add("@attribute glHeartRateVariability numeric");
            listaTexto.add("@attribute glPFrontalAxis numeric");
            listaTexto.add("@attribute glQrsFrontalAxis numeric");
            listaTexto.add("@attribute glStFrontalAxis numeric");
            listaTexto.add("@attribute glSinusAverageRR numeric");
            listaTexto.add("@attribute glSinusRate numeric");
            listaTexto.add("@attribute glStdDevNormRRIntervals numeric");
            listaTexto.add("@attribute glTFrontalAxis numeric");
            listaTexto.add("@attribute glVentAverageRR numeric");
            listaTexto.add("@attribute glVentRate numeric");
            listaTexto.add("@data");
            for (ModeloWekaCluster modeloWeka : listaWeka) {
                listaTexto.add(
                        String.valueOf(modeloWeka.getIdProfissional()) + ","
                        + String.valueOf(modeloWeka.getTempoLaudo()) + ","
                        + String.valueOf(modeloWeka.getAmiodarona()) + ","
                        + String.valueOf(modeloWeka.getBetaBloqueadores()) + ","
                        + String.valueOf(modeloWeka.getBloqueadorCalcio()) + ","
                        + String.valueOf(modeloWeka.getDigital()) + ","
                        + String.valueOf(modeloWeka.getDiureticos()) + ","
                        + String.valueOf(modeloWeka.getIec()) + ","
                        + String.valueOf(modeloWeka.getOutros()) + ","
                        + String.valueOf(modeloWeka.getSexo()) + ","
                        + String.valueOf(modeloWeka.getImc()) + ","
                        + String.valueOf(modeloWeka.getIdade()) + ","
                        + String.valueOf(modeloWeka.getTabagismo()) + ","
                        + String.valueOf(modeloWeka.getRevascularizacaoPrevia()) + ","
                        + String.valueOf(modeloWeka.getObesidade()) + ","
                        + String.valueOf(modeloWeka.getInfartoPrevio()) + ","
                        + String.valueOf(modeloWeka.getHistoricoFamiliar()) + ","
                        + String.valueOf(modeloWeka.getHipertencao()) + ","
                        + String.valueOf(modeloWeka.getDrc()) + ","
                        + String.valueOf(modeloWeka.getDpoc()) + ","
                        + String.valueOf(modeloWeka.getChagas()) + ","
                        + String.valueOf(modeloWeka.getDislipidemia()) + ","
                        + String.valueOf(modeloWeka.getDiabetesMelitus()) + ","
                        + String.valueOf(modeloWeka.getPaSistolica()) + ","
                        + String.valueOf(modeloWeka.getPaDiastolica()) + ","
                        + String.valueOf(modeloWeka.getGlHeartRate()) + ","
                        + String.valueOf(modeloWeka.getGlHeartRateVariability()) + ","
                        + String.valueOf(modeloWeka.getGlPFrontalAxis()) + ","
                        + String.valueOf(modeloWeka.getGlQrsFrontalAxis()) + ","
                        + String.valueOf(modeloWeka.getGlStFrontalAxis()) + ","
                        + String.valueOf(modeloWeka.getGlSinusAverageRR()) + ","
                        + String.valueOf(modeloWeka.getGlSinusRate()) + ","
                        + String.valueOf(modeloWeka.getGlStdDevNormRRIntervals()) + ","
                        + String.valueOf(modeloWeka.getGlTFrontalAxis()) + ","
                        + String.valueOf(modeloWeka.getGlVentAverageRR()) + ","
                        + String.valueOf(modeloWeka.getGlVentRate())
                );
            }
            new EscreverArquivo().criarTxt(listaTexto);
        } catch (DAOException ex) {
            Logger.getLogger(ConversorBdWeka.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void criarTxt() {
        try {
            List<ModeloWeka> listaWeka = new WekaDAOImpl().findAll();
            List<String> listaTexto = new ArrayList();
            for (ModeloWeka modeloWeka : listaWeka) {
                if (!listaTexto.contains(modeloWeka.getComorbidades())) {
                    listaTexto.add(modeloWeka.getComorbidades());

                }
            }
            for (String string : listaTexto) {
                System.out.println(string);
            }
            listaTexto.add("@relation ModeloWeka");
            listaTexto.add("@attribute tempoLaudo { 0 a 5s, 5 a 30s, 30s a 60s,1min a 10min, maior de 10min }");
            listaTexto.add("@attribute medicamentos {Nenhum- , Outros-, Diureticos-, BetaBloqueadores-, BetaBloqueadores- Diureticos-, Diureticos- Outros-, BetaBloqueadores- Diureticos- Outros-, Amiodarona- Outros-, Digital- Diureticos-, Amiodarona- Diureticos- Outros-, BetaBloqueadores- Outros-, Amiodarona- BetaBloqueadores- Diureticos-, BetaBloqueadores- Digital- Diureticos-, BetaBloqueadores- Digital-, Digital- Diureticos- Outros-, Amiodarona- BetaBloqueadores- Digital- Diureticos-, Digital-, Amiodarona-, Digital- Outros-, BetaBloqueadores- Digital- Outros-, Amiodarona- Diureticos-,}");
            listaTexto.add("@attribute Aproveitamento numeric");
            listaTexto.add("@attribute BomComportamento { true, false }");
            listaTexto.add("@attribute ReuniaoPais { yes, no }");
            listaTexto.add("@data");

        } catch (DAOException ex) {
            Logger.getLogger(ConversorBdWeka.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void iniciarCarga() {
        try {
            List<Exame> lista = new ExameDAOImpl().findAll();

            for (Exame exame : lista) {

                List<HistoricoClinico> hist = new HistoricoClinicoDAOImpl().consultarPorIdExame(exame.getId());

                br.ufmg.hc.telessaude.telediagnostico.xmlfactory.estruturaantiga.HistoricoClinico histo = new XMLFactory().gerarHistoricoClinicoXMLAntigo(hist.get(0).getConteudo(), "UTF-8");

                List<EcgAnalys> analises = new EcgAnalysDAOImpl().findByIdExame(exame.getId());

                Laudo laudos = new LaudoDAOImpl().consultarUnicoPorIdExame(exame.getId());
                List<MinnesotaCode> minnesota = new MinnesotaCodeDAOImpl().consultarPorIdExame(exame.getId());

                CarregarModeloWeka carregar = new CarregarModeloWeka();
                CarregarModeloWekaCluster carregarCluster = new CarregarModeloWekaCluster();
                if (exame.getId() > 0 && laudos != null && analises != null && !analises.isEmpty() && minnesota != null && !minnesota.isEmpty()) {
//                    ModeloWeka weka = carregar.carregarModelo(exame, histo, laudos, analises.get(0), minnesota.get(0));

                    ModeloWekaCluster wekaCluster = carregarCluster.carregarModelo(exame, histo, laudos, analises.get(0), minnesota.get(0));

                    new WekaClusterDAOImpl().saveOrUpdate(wekaCluster);
//                    new WekaDAOImpl().saveOrUpdate(weka);
                    System.out.println(exame.getId());
                }

            }

        } catch (br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException ex) {
            Logger.getLogger(ConversorBdWeka.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
