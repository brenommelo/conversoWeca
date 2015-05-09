/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversorbdweka;

import br.ufmg.hc.telessaude.diagnostico.dominio.entity.Exame;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.Laudo;
import br.ufmg.hc.telessaude.diagnostico.dominio.glasgow.EcgAnalys;
import br.ufmg.hc.telessaude.diagnostico.dominio.glasgow.MinnesotaCode;
import br.ufmg.hc.telessaude.telediagnostico.xmlfactory.estruturaantiga.HistoricoClinico;
import br.ufmg.hc.telessaude.telediagnostico.xmlfactory.estruturaantiga.Investigacao;
import conversorbdweka.weka.ModeloWeka;
import conversorbdweka.weka.ModeloWekaCluster;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author breno
 */
public class CarregarModeloWekaCluster {

    HistoricoClinico histroricoClinico;
    Laudo laudo;
    EcgAnalys resultadoGlasgow;
    MinnesotaCode resultadoMinnessota;
    private Integer tabagismo = 0;
    private Integer revascularizacaoPrevia= 0;
    private Integer obesidade= 0;
    private Integer infartoPrevio= 0;
    private Integer historicoFamiliar= 0;
    private Integer hipertencao= 0;
    private Integer drc= 0;
    private Integer dpoc= 0;
    private Integer chagas= 0;
    private Integer dislipidemia= 0;
    private Integer diabetesMelitus= 0;

    public CarregarModeloWekaCluster(HistoricoClinico histroricoClinico, Laudo laudo, EcgAnalys resultadoGlasgow, MinnesotaCode resultadoMinnessota) {
        this.histroricoClinico = histroricoClinico;
        this.laudo = laudo;
        this.resultadoGlasgow = resultadoGlasgow;
        this.resultadoMinnessota = resultadoMinnessota;
    }

    public CarregarModeloWekaCluster() {
    }

    public ModeloWekaCluster carregarModelo(Exame exame, HistoricoClinico histroricoClinico, Laudo laudo, EcgAnalys resultadoGlasgow, MinnesotaCode resultadoMinnessota) {
        ModeloWekaCluster modelo = new ModeloWekaCluster();

//       PROFISSIONAL
        modelo.setIdProfissional(laudo.getId());
        modelo.setTempoLaudo(retornarTempoLaudo(laudo));

//       PACIENTE
        modelo.setIdade(retornarFaixaIdade(exame.getPaciente().getDatanascimento()));
        modelo.setSexo(retornarSexo(exame.getPaciente().getSexo()));
        modelo.setPaDiastolica(retorarDiastolica(histroricoClinico));
        modelo.setPaSistolica(retorarSistolica(histroricoClinico));

        modelo.setImc(retornarFaixaImc(histroricoClinico.getDADOSCLINICOS().getIMC()));

//       RESULTADOS
//       HISTORICO
//        medicamentos
        modelo.setAmiodarona(retornarMedicamentos(histroricoClinico, "amiodarona"));
        modelo.setBetaBloqueadores(retornarMedicamentos(histroricoClinico, "betaBloqueadores"));
        modelo.setBloqueadorCalcio(retornarMedicamentos(histroricoClinico, "bloqueadorCalcio"));
        modelo.setDigital(retornarMedicamentos(histroricoClinico, "digital"));
        modelo.setDiureticos(retornarMedicamentos(histroricoClinico, "diureticos"));
        modelo.setIec(retornarMedicamentos(histroricoClinico, "enziamConversora"));
        modelo.setOutros(retornarMedicamentos(histroricoClinico, "outros"));
//        doencas
        retornarComorbidades(histroricoClinico);
        modelo.setTabagismo(tabagismo);  
        modelo.setRevascularizacaoPrevia(revascularizacaoPrevia);  
        modelo.setObesidade(obesidade);  
        modelo.setInfartoPrevio(infartoPrevio);  
        modelo.setHistoricoFamiliar(historicoFamiliar);  
        modelo.setHipertencao(hipertencao);  
        modelo.setDrc(drc);  
        modelo.setDpoc(dpoc);  
        modelo.setChagas(chagas);  
        modelo.setDislipidemia(dislipidemia);  
        modelo.setDiabetesMelitus(diabetesMelitus);  
        
        modelo.setGlHeartRate(resultadoGlasgow.getHeartRate());
        modelo.setGlHeartRateVariability(resultadoGlasgow.getHeartRateVariability());
        modelo.setGlPFrontalAxis(resultadoGlasgow.getpFrontalAxis());
        modelo.setGlQrsFrontalAxis(resultadoGlasgow.getQrsFrontalAxis());
        modelo.setGlSinusAverageRR(resultadoGlasgow.getSinusAverageRR());
        modelo.setGlSinusRate(resultadoGlasgow.getSinusRate());
        modelo.setGlStFrontalAxis(resultadoGlasgow.gettFrontalAxis());
        modelo.setGlStdDevNormRRIntervals(resultadoGlasgow.getStdDevNormRRIntervals());
        modelo.setGlTFrontalAxis(resultadoGlasgow.gettFrontalAxis());
        modelo.setGlVentAverageRR(resultadoGlasgow.getVentAverageRR());
        modelo.setGlVentRate(resultadoGlasgow.getVentRate());
        
        return modelo;

    }

    private Integer retorarDiastolica(HistoricoClinico historicoClinico) {
        String pa = historicoClinico.getDADOSCLINICOS().getPRESSAOARTERIAL();
        if (pa == null || pa.isEmpty()) {
            return 0;
        }
        String[] pas = null;
        if (pa.contains("-")) {
            pas = pa.split("-");
        } else if (pa.contains("x")) {
            pas = pa.split("x");

        } else if (pa.contains("X")) {
            pas = pa.split("X");

        }
        if (pa.length() <= 2) {
            return 0;
        }
        String sistolica = pas[0];
        String diastolica = pas[1];
        return Integer.valueOf(diastolica);
    }

    private Integer retorarSistolica(HistoricoClinico historicoClinico) {
        String pa = historicoClinico.getDADOSCLINICOS().getPRESSAOARTERIAL();
        if (pa == null || pa.isEmpty()) {
            return 0;
        }
        String[] pas = null;
        if (pa.contains("-")) {
            pas = pa.split("-");
        } else if (pa.contains("x")) {
            pas = pa.split("x");

        } else if (pa.contains("X")) {
            pas = pa.split("X");

        }
        if (pa.length() <= 2) {
            return 0;
        }
        String sistolica = pas[0];
        String diastolica = pas[1];
        return Integer.valueOf(sistolica);
    }

    public Double retornarTempoLaudo(Laudo laudo) {
        Calendar inicio = Calendar.getInstance();
        inicio.setTime(laudo.getDatainicio());
        Calendar fim = Calendar.getInstance();
        fim.setTime(laudo.getDatafim());

        Integer hora = fim.get(Calendar.HOUR_OF_DAY) - inicio.get(Calendar.HOUR_OF_DAY);
        Integer minuto = fim.get(Calendar.MINUTE) - inicio.get(Calendar.MINUTE);
        Integer segundos = fim.get(Calendar.SECOND) - inicio.get(Calendar.SECOND);
        Integer mili = fim.get(Calendar.MILLISECOND) - inicio.get(Calendar.MILLISECOND);

        Long result = (Long) fim.getTimeInMillis() - inicio.getTimeInMillis();
        return result / 1000d;
//        if (result < 5000) {
//            return "0 a 5s";
//        } else if (result >= 5 * 1000 && result < 30 * 1000) {
//            return "5 a 30s";
//        } else if (result >= 30 * 1000 && result < 60 * 1000) {
//            return "30s a 60s";
//        } else if (result >= 60 * 1000 && result < 600 * 1000) {
//            return "1min a 10min";
//        } else if (result < 600 * 1000) {
//            return "maior de 10min";
//
//        }
//
//        return "";
    }


    public String retornarInvestigacaoDor(Investigacao inv) {

        return "nao";
    }

    public Integer retornarComorbidades(HistoricoClinico historicoClinico) {
        String resultado = "";
        if (historicoClinico.getCOMORBIDADESEFATORESEMRISCO().getDIABETESMELLITUS().equalsIgnoreCase("SIM")
               ){
            diabetesMelitus = 1;
        }
        if (historicoClinico.getCOMORBIDADESEFATORESEMRISCO().getDISLIPIDEMIA().equalsIgnoreCase("SIM")
                ){
             dislipidemia= 1;
        }
        if (historicoClinico.getCOMORBIDADESEFATORESEMRISCO().getDOENCADECHAGAS().equalsIgnoreCase("SIM")
               ){
            chagas = 1;
        }
        if (historicoClinico.getCOMORBIDADESEFATORESEMRISCO().getDOENCAPULMONARCRONICA().equalsIgnoreCase("SIM")
                ){
            dpoc= 1;
        }
        if (historicoClinico.getCOMORBIDADESEFATORESEMRISCO().getDOENCARENALCRONICA().equalsIgnoreCase("SIM")
               ){
            drc = 1;
        }
        if (historicoClinico.getCOMORBIDADESEFATORESEMRISCO().getHIPERTENCAOARTERIAL().equalsIgnoreCase("SIM")
               ){
            hipertencao = 1;
        }
        if (historicoClinico.getCOMORBIDADESEFATORESEMRISCO().getHISTORICOFAMILIARDOENCACORONARIANA().equalsIgnoreCase("SIM")
               ){
            historicoFamiliar = 1;
        }
        if (historicoClinico.getCOMORBIDADESEFATORESEMRISCO().getINFARTOMIOCARDIOPREVIO().equalsIgnoreCase("SIM")
                ){
            infartoPrevio = 1;
        }
        if (historicoClinico.getCOMORBIDADESEFATORESEMRISCO().getOBESIDADE().equalsIgnoreCase("SIM")
                ){
            obesidade= 1;
        }
        if (historicoClinico.getCOMORBIDADESEFATORESEMRISCO().getREVASCULARIZACAMIOCARDICAPREVIA().equalsIgnoreCase("SIM")
               ){
            revascularizacaoPrevia = 1;
        }
        if (historicoClinico.getCOMORBIDADESEFATORESEMRISCO().getTABAGISMO().equalsIgnoreCase("SIM")
                ){
            tabagismo = 1;
        }
        return 0;

    }

    public Integer retornarMedicamentos(HistoricoClinico histroricoClinico, String medic) {
        String resultado = "";
        if (histroricoClinico.getMEDICAMENTOSEMUSO().getAMIODARONA().equalsIgnoreCase("SIM")
                && medic.equals("amiodarona")) {
            return 1;
        }
        if (histroricoClinico.getMEDICAMENTOSEMUSO().getBETABLOQUEADORES().equalsIgnoreCase("SIM")
                && medic.equals("betaBloqueadores")) {
            return 1;

        }
        if (histroricoClinico.getMEDICAMENTOSEMUSO().getBLOQUEADORESDECALCIO().equalsIgnoreCase("SIM")
                && medic.equals("bloqueadorCalcio")) {
            return 1;

        }
        if (histroricoClinico.getMEDICAMENTOSEMUSO().getDIGITAL().equalsIgnoreCase("SIM")
                && medic.equals("digital")) {
            return 1;
        }
        if (histroricoClinico.getMEDICAMENTOSEMUSO().getDIURETICOS().equalsIgnoreCase("SIM")
                && medic.equals("diureticos")) {
            return 1;
        }
        if (histroricoClinico.getMEDICAMENTOSEMUSO().getINIBIDORESDAENZIMACONVERSORA().equalsIgnoreCase("SIM")
                && medic.equals("enziamConversora")) {
            return 1;

        }
        if (histroricoClinico.getMEDICAMENTOSEMUSO().getOUTROS().equalsIgnoreCase("SIM")
                && medic.equals("outros")) {
            return 1;

        }
        return 0;
    }

    public Double retornarFaixaImc(String imcStr) {
        Double imc = 0.0;
        if (imcStr != null && !imcStr.isEmpty()) {
            if (imcStr.contains(",")) {
                imcStr = imcStr.replace(",", ".");
            }
            return imc = Double.valueOf(imcStr);
        }
        return 0.0;
//        if (imc == 0) {
//            return "Imc nao informado";
//        } else if (imc < 20) {
//            return "Imc menor 20";
//        } else if (imc >= 20 && imc < 25) {
//            return "Imc entre 20 e 25";
//        } else if (imc >= 25) {
//            return "Imc maior 25";
//        }
//        return "Imc nao informado";
    }

    public Integer retornarSexo(String sexo) {
        if (sexo.equalsIgnoreCase("M")) {
            return 0;
        } else {
            return 1;
        }
    }

    public Integer retornarFaixaIdade(Date data) {
        Integer idade = calcularIdade(data);
        return idade;
//        if (idade < 20) {
//            return "0 - 20 anos";
//        } else if (idade >= 20 && idade < 30) {
//            return "0 - 20 anos";
//        } else if (idade >= 30 && idade < 40) {
//            return "30 - 40 anos";
//        } else if (idade >= 40 && idade < 50) {
//            return "40 - 50 anos";
//        } else if (idade >= 50 && idade < 60) {
//            return "50 - 60 anos";
//        } else if (idade >= 60 && idade < 70) {
//            return "60 - 70 anos";
//        } else if (idade >= 70 && idade < 80) {
//            return "70 - 80 anos";
//        } else if (idade >= 80 && idade < 90) {
//            return "80 - 90 anos";
//        } else if (idade >= 90) {
//            return "Maior 90 anos";
//        }
//
//        return "";
    }

    public Integer calcularIdade(Date data) {
        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.setTime(data);
        Calendar dataAtual = Calendar.getInstance();

        Integer diferencaMes = dataAtual.get(Calendar.MONTH) - dataNascimento.get(Calendar.MONTH);
        Integer diferencaDia = dataAtual.get(Calendar.DAY_OF_MONTH) - dataNascimento.get(Calendar.DAY_OF_MONTH);
        Integer idade = (dataAtual.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR));

        if (diferencaMes < 0 || (diferencaMes == 0 && diferencaDia < 0)) {
            idade--;
        }

        return idade;
    }

}
