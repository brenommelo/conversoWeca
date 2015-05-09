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
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author breno
 */
public class CarregarModeloWeka {

    HistoricoClinico histroricoClinico;
    Laudo laudo;
    EcgAnalys resultadoGlasgow;
    MinnesotaCode resultadoMinnessota;

    public CarregarModeloWeka(HistoricoClinico histroricoClinico, Laudo laudo, EcgAnalys resultadoGlasgow, MinnesotaCode resultadoMinnessota) {
        this.histroricoClinico = histroricoClinico;
        this.laudo = laudo;
        this.resultadoGlasgow = resultadoGlasgow;
        this.resultadoMinnessota = resultadoMinnessota;
    }

    public CarregarModeloWeka() {
    }

    public ModeloWeka carregarModelo(Exame exame, HistoricoClinico histroricoClinico, Laudo laudo, EcgAnalys resultadoGlasgow, MinnesotaCode resultadoMinnessota) {
        ModeloWeka modelo = new ModeloWeka();

//       PROFISSIONAL
        modelo.setProfissionalId(laudo.getId());
        modelo.setTempoLaudo(retornarTempoLaudo(laudo));

//       PACIENTE
        modelo.setIdade(retornarFaixaIdade(exame.getPaciente().getDatanascimento()));
        modelo.setSexo(retornarSexo(exame.getPaciente().getSexo()));
        modelo.setPressaoArterial(retornarFaixaPressao(histroricoClinico));

        modelo.setImc(retornarFaixaImc(histroricoClinico.getDADOSCLINICOS().getIMC()));

//       RESULTADOS
//        modelo.setMinessotaResult(resultadoMinnessota.getText());
        modelo.setGlasgowResult(resultadoGlasgow.getDescription());

//       HISTORICO
//        medicamentos
        modelo.setMedicamentos(retornarMedicamentos(histroricoClinico));
//        doencas
        modelo.setComorbidades(retornarComorbidades(histroricoClinico));
        modelo.setInvertigacaoDor(retornarInvestigacaoDor(histroricoClinico.getINVESTIGACAODADOR()));

        return modelo;

    }

    public String retornarTempoLaudo(Laudo laudo) {
        Calendar inicio = Calendar.getInstance();
        inicio.setTime(laudo.getDatainicio());
        Calendar fim = Calendar.getInstance();
        fim.setTime(laudo.getDatafim());

        Integer hora = fim.get(Calendar.HOUR_OF_DAY) - inicio.get(Calendar.HOUR_OF_DAY);
        Integer minuto = fim.get(Calendar.MINUTE) - inicio.get(Calendar.MINUTE);
        Integer segundos = fim.get(Calendar.SECOND) - inicio.get(Calendar.SECOND);
        Integer mili = fim.get(Calendar.MILLISECOND) - inicio.get(Calendar.MILLISECOND);

        Long result = (Long) fim.getTimeInMillis() - inicio.getTimeInMillis();
        if (result < 5000) {
            return "0 a 5s";
        } else if (result >= 5 * 1000 && result < 30 * 1000) {
            return "5 a 30s";
        } else if (result >= 30 * 1000 && result < 60 * 1000) {
            return "30s a 60s";
        } else if (result >= 60 * 1000 && result < 600 * 1000) {
            return "1min a 10min";
        } else if (result < 600 * 1000) {
            return "maior de 10min";

        }

        return "";
    }

    public String retornarFaixaPressao(HistoricoClinico historicoClinico) {
        String pa = historicoClinico.getDADOSCLINICOS().getPRESSAOARTERIAL();
        if (pa == null || pa.isEmpty()) {
            return "Nao informada";
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
            return "Nao informada";
        }
        
        String sistolica = pas[0];
        String diastolica = pas[1];

        String resultado = "Pressao: ";

        if (sistolica != null && !sistolica.isEmpty()) {
            Integer inter = Integer.valueOf(sistolica);
            if (inter < 110) {
                resultado += "110";
            } else if (inter >= 110 && inter < 130) {
                resultado += "110a130";

            } else if (inter >= 130) {
                resultado += "130";

            } else {
                return "Nao informada";
            }
        } else {
            return "Nao informada";
        }
        if (diastolica != null && !diastolica.isEmpty()) {
            Integer inter = Integer.valueOf(diastolica);
            if (inter < 70) {
                resultado += "-70";
            } else if (inter >= 70 && inter < 90) {
                resultado += "-70a90";

            } else if (inter >= 90) {
                resultado += "-90";

            } else {
                return "Nao informada";
            }
        } else {
            return "Nao informada";
        }
        return resultado;
    }

    public String retornarInvestigacaoDor(Investigacao inv) {

        return "nao";
    }

    public String retornarComorbidades(HistoricoClinico historicoClinico) {
        String resultado = "";
        if (historicoClinico.getCOMORBIDADESEFATORESEMRISCO().getDIABETESMELLITUS().equalsIgnoreCase("SIM")) {
            resultado += "DM; ";
        }
        if (historicoClinico.getCOMORBIDADESEFATORESEMRISCO().getDISLIPIDEMIA().equalsIgnoreCase("SIM")) {
            resultado += "Dislipidemia; ";
        }
        if (historicoClinico.getCOMORBIDADESEFATORESEMRISCO().getDOENCADECHAGAS().equalsIgnoreCase("SIM")) {
            resultado += "Chagas; ";
        }
        if (historicoClinico.getCOMORBIDADESEFATORESEMRISCO().getDOENCAPULMONARCRONICA().equalsIgnoreCase("SIM")) {
            resultado += "DPOC; ";
        }
        if (historicoClinico.getCOMORBIDADESEFATORESEMRISCO().getDOENCARENALCRONICA().equalsIgnoreCase("SIM")) {
            resultado += "DRC; ";
        }
        if (historicoClinico.getCOMORBIDADESEFATORESEMRISCO().getHIPERTENCAOARTERIAL().equalsIgnoreCase("SIM")) {
            resultado += "Hipertencao; ";
        }
        if (historicoClinico.getCOMORBIDADESEFATORESEMRISCO().getHISTORICOFAMILIARDOENCACORONARIANA().equalsIgnoreCase("SIM")) {
            resultado += "Historico familiar ; ";
        }
        if (historicoClinico.getCOMORBIDADESEFATORESEMRISCO().getINFARTOMIOCARDIOPREVIO().equalsIgnoreCase("SIM")) {
            resultado += "Infarto previo; ";
        }
        if (historicoClinico.getCOMORBIDADESEFATORESEMRISCO().getOBESIDADE().equalsIgnoreCase("SIM")) {
            resultado += "Obesidade; ";
        }
        if (historicoClinico.getCOMORBIDADESEFATORESEMRISCO().getREVASCULARIZACAMIOCARDICAPREVIA().equalsIgnoreCase("SIM")) {
            resultado += "Revascularizacao previa; ";
        }
        if (historicoClinico.getCOMORBIDADESEFATORESEMRISCO().getTABAGISMO().equalsIgnoreCase("SIM")) {
            resultado += "Tabagismo; ";
        }
        if (resultado.isEmpty()) {
            resultado += "Nao informado; ";
        }
        return resultado;

    }

    public String retornarMedicamentos(HistoricoClinico histroricoClinico) {
        String resultado = "";
        if (histroricoClinico.getMEDICAMENTOSEMUSO().getAMIODARONA().equalsIgnoreCase("SIM")) {
            resultado += "Amiodarona- ";
        }
        if (histroricoClinico.getMEDICAMENTOSEMUSO().getBETABLOQUEADORES().equalsIgnoreCase("SIM")) {
            resultado += "BetaBloqueadores- ";

        }
        if (histroricoClinico.getMEDICAMENTOSEMUSO().getBLOQUEADORESDECALCIO().equalsIgnoreCase("SIM")) {
            resultado += "Bloqueador calcio- ";

        }
        if (histroricoClinico.getMEDICAMENTOSEMUSO().getDIGITAL().equalsIgnoreCase("SIM")) {
            resultado += "Digital- ";

        }
        if (histroricoClinico.getMEDICAMENTOSEMUSO().getDIURETICOS().equalsIgnoreCase("SIM")) {
            resultado += "Diureticos- ";

        }
        if (histroricoClinico.getMEDICAMENTOSEMUSO().getINIBIDORESDAENZIMACONVERSORA().equalsIgnoreCase("SIM")) {
            resultado += "IEC- ";

        }
        if (histroricoClinico.getMEDICAMENTOSEMUSO().getOUTROS().equalsIgnoreCase("SIM")) {
            resultado += "Outros- ";

        }
        if (resultado.isEmpty()) {
            resultado += "Nenhum- ";

        }

        return resultado;
    }

    public String retornarFaixaImc(String imcStr) {
        Double imc = 0.0;
        if (imcStr != null && !imcStr.isEmpty()) {
            if (imcStr.contains(",")) {
                imcStr = imcStr.replace(",", ".");
            }
            imc = Double.valueOf(imcStr);
        }
        if (imc == 0) {
            return "Imc nao informado";
        } else if (imc < 20) {
            return "Imc menor 20";
        } else if (imc >= 20 && imc < 25) {
            return "Imc entre 20 e 25";
        } else if (imc >= 25) {
            return "Imc maior 25";
        }
        return "Imc nao informado";
    }

    public String retornarSexo(String sexo) {
        if (sexo.equalsIgnoreCase("M")) {
            return "Masculino";
        } else {
            return "Feminino";
        }
    }

    public String retornarFaixaIdade(Date data) {
        Integer idade = calcularIdade(data);

        if (idade < 20) {
            return "0 - 20 anos";
        } else if (idade >= 20 && idade < 30) {
            return "0 - 20 anos";
        } else if (idade >= 30 && idade < 40) {
            return "30 - 40 anos";
        } else if (idade >= 40 && idade < 50) {
            return "40 - 50 anos";
        } else if (idade >= 50 && idade < 60) {
            return "50 - 60 anos";
        } else if (idade >= 60 && idade < 70) {
            return "60 - 70 anos";
        } else if (idade >= 70 && idade < 80) {
            return "70 - 80 anos";
        } else if (idade >= 80 && idade < 90) {
            return "80 - 90 anos";
        } else if (idade >= 90) {
            return "Maior 90 anos";
        }

        return "";
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
