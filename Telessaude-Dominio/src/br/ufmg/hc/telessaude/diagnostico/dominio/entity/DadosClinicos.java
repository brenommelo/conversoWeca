/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.entity;

import com.utilidades.StringUtils;
import br.ufmg.hc.telessaude.telediagnostico.xmlfactory.estrutura.DADOCLINICO;
import br.ufmg.hc.telessaude.telediagnostico.xmlfactory.estrutura.GRUPO;
import br.ufmg.hc.telessaude.telediagnostico.xmlfactory.estrutura.HISTORICOCLINICO;
import br.ufmg.hc.telessaude.telediagnostico.xmlfactory.estruturaantiga.HistoricoClinico;
import br.ufmg.hc.telessaude.telediagnostico.xmlfactory.gerador.XMLFactory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author william.carvalho
 */
public class DadosClinicos {

    private String Descricao;

    private String Valor;

    public DadosClinicos(String Descricao, String Valor) {
        this.Descricao = Descricao;
        this.Valor = Valor;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }

    private static void adicionaDadoClinico(List<DadosClinicos> grupo, List<DadosClinicos> dadosClinicos) {
        List<DadosClinicos> aux = new ArrayList();
        for (DadosClinicos dados : grupo) {
            if (dados.getValor() != null && !dados.getValor().trim().isEmpty() && !dados.getValor().replace("Ã", "A").equals("NAO")) {
                aux.add(dados);
            }
        }

        if (aux.size() > 1) {
            dadosClinicos.addAll(aux);
        }
    }

    private static String converteValorDADOCLINICO(String valor) {
        if (valor.equals("TRUE")) {
            valor = "SIM";
        }
        return valor;
    }

    public static List<DadosClinicos> preencherDadosClinicos(Exame exame) throws Exception {

        List<DadosClinicos> dadosClinicos = new ArrayList();

        if (exame.getHistoricosClinicos() != null && exame.getHistoricosClinicos().size() > 0) {
            dadosClinicos.add(new DadosClinicos("DADOS BÁSICOS ____________________________________________________________________________________________________________",
                    "____________________________________________________________________________________________________________"));
            dadosClinicos.add(new DadosClinicos("       PRIORIDADE", exame.getPrioridade().getNome()));
            dadosClinicos.add(new DadosClinicos("       PONTO REMOTO", exame.getPontoRemoto().getNome()));
            dadosClinicos.add(new DadosClinicos("       MUNICÍPIO", exame.getPontoRemoto().getEndereco().getCidade().getNome()));
            dadosClinicos.add(new DadosClinicos("       DATA / HORA REALIZAÇÃO EXAME", StringUtils.format(exame.getDatarealizacao(), StringUtils.DD_MM_YYYY_HH_MM_SS)));

            dadosClinicos.add(new DadosClinicos("PACIENTE ____________________________________________________________________________________________________________",
                    "____________________________________________________________________________________________________________"));
            dadosClinicos.add(new DadosClinicos("    NOME", exame.getPaciente().getNome()));
            dadosClinicos.add(new DadosClinicos("    DATA NASCIMENTO", StringUtils.formatDate(exame.getPaciente().getDatanascimento())));
            dadosClinicos.add(new DadosClinicos("    SEXO", String.valueOf(exame.getPaciente().getSexo())));
            if (exame.getPaciente().getRegistroclinico() != null) {
                dadosClinicos.add(new DadosClinicos("    REGISTRO CLINICO", exame.getPaciente().getRegistroclinico()));
            }

            long versaoModeloHistoricoClinico = exame.getHistoricosClinicos().get(0).getModeloHistoricoClinico().getId();
            if (versaoModeloHistoricoClinico == 1) {
                HistoricoClinico historico = new XMLFactory<HistoricoClinico>().gerarHistoricoClinicoXMLAntigo(exame.getHistoricosClinicos().get(0).getConteudo(), "UTF-8");
                dadosClinicos.add(new DadosClinicos("HISTÓRICO CLINICO ____________________________________________________________________________________________________________",
                        "____________________________________________________________________________________________________________"));
                List<DadosClinicos> aux = new ArrayList();
                aux.add(new DadosClinicos("DADOS CLINICOS", "____________________________________________________________________________________________________________"));
                aux.add(new DadosClinicos("   Pressão Arterial", historico.getDADOSCLINICOS().getPRESSAOARTERIAL()));
                aux.add(new DadosClinicos("   Altura", historico.getDADOSCLINICOS().getALTURA()));
                aux.add(new DadosClinicos("   Peso", historico.getDADOSCLINICOS().getPESO()));
                aux.add(new DadosClinicos("   IMC", historico.getDADOSCLINICOS().getIMC()));
                aux.add(new DadosClinicos("   Observações", historico.getDADOSCLINICOS().getOBSERVACOES()));
                adicionaDadoClinico(aux, dadosClinicos);

                if (historico.getSOLICITANTE() != null) {
                    aux = new ArrayList();
                    aux.add(new DadosClinicos("SOLICITANTE", "____________________________________________________________________________________________________________"));
                    aux.add(new DadosClinicos("   Nome", historico.getSOLICITANTE().getNOME()));
                    aux.add(new DadosClinicos("   CRM", historico.getSOLICITANTE().getCRM()));
                    aux.add(new DadosClinicos("   Função", historico.getSOLICITANTE().getFUNCAO()));
                    adicionaDadoClinico(aux, dadosClinicos);
                }

                aux = new ArrayList();
                aux.add(new DadosClinicos("MEDICAMENTOS EM USO", "____________________________________________________________________________________________________________"));
                aux.add(new DadosClinicos("   DIURETICOS", historico.getMEDICAMENTOSEMUSO().getDIURETICOS()));
                aux.add(new DadosClinicos("   DIGITAL", historico.getMEDICAMENTOSEMUSO().getDIGITAL()));
                aux.add(new DadosClinicos("   BETABLOQUEADORES", historico.getMEDICAMENTOSEMUSO().getBETABLOQUEADORES()));
                aux.add(new DadosClinicos("   INIBIDORES DA ENZIMA CONVERSORA", historico.getMEDICAMENTOSEMUSO().getINIBIDORESDAENZIMACONVERSORA()));
                aux.add(new DadosClinicos("   AMIODARONA", historico.getMEDICAMENTOSEMUSO().getAMIODARONA()));
                aux.add(new DadosClinicos("   BLOQUEADORES DE CALCIO", historico.getMEDICAMENTOSEMUSO().getBLOQUEADORESDECALCIO()));
                aux.add(new DadosClinicos("   OUTROS", historico.getMEDICAMENTOSEMUSO().getOUTROS()));
                adicionaDadoClinico(aux, dadosClinicos);

                aux = new ArrayList();
                aux.add(new DadosClinicos("COMORBIDADES E FATORES DE RISCO", "____________________________________________________________________________________________________________"));
                aux.add(new DadosClinicos("   Hispertenção Arterial", historico.getCOMORBIDADESEFATORESEMRISCO().getHIPERTENCAOARTERIAL()));
                aux.add(new DadosClinicos("   Doença de Chagas", historico.getCOMORBIDADESEFATORESEMRISCO().getDOENCADECHAGAS()));
                aux.add(new DadosClinicos("   Obesidade", historico.getCOMORBIDADESEFATORESEMRISCO().getOBESIDADE()));
                aux.add(new DadosClinicos("   Diabetes Mellitus", historico.getCOMORBIDADESEFATORESEMRISCO().getDIABETESMELLITUS()));
                aux.add(new DadosClinicos("   Tabagismo", historico.getCOMORBIDADESEFATORESEMRISCO().getTABAGISMO()));
                aux.add(new DadosClinicos("   Revascularização Miocardia Prévia", historico.getCOMORBIDADESEFATORESEMRISCO().getREVASCULARIZACAMIOCARDICAPREVIA()));
                aux.add(new DadosClinicos("   Histórico Familiar de Doença Coronariana", historico.getCOMORBIDADESEFATORESEMRISCO().getHISTORICOFAMILIARDOENCACORONARIANA()));
                aux.add(new DadosClinicos("   Infarto Miocardio Prévio", historico.getCOMORBIDADESEFATORESEMRISCO().getINFARTOMIOCARDIOPREVIO()));
                aux.add(new DadosClinicos("   Dislipidemia", historico.getCOMORBIDADESEFATORESEMRISCO().getDISLIPIDEMIA()));
                aux.add(new DadosClinicos("   Doença Renal Crônica", historico.getCOMORBIDADESEFATORESEMRISCO().getDOENCARENALCRONICA()));
                aux.add(new DadosClinicos("   Doença Pulmonar Crônica", historico.getCOMORBIDADESEFATORESEMRISCO().getDOENCAPULMONARCRONICA()));
                adicionaDadoClinico(aux, dadosClinicos);

                dadosClinicos.add(new DadosClinicos("HIPÓTESE DIAGNOSTICA", "____________________________________________________________________________________________________________"));

                aux = new ArrayList();
                aux.add(new DadosClinicos("   DOR CARDIACA ISQUEMICA", "............................................................................................................................................................................................"));
                aux.add(new DadosClinicos("      Infarto", historico.getHIPOTESEDIAGNOSTICA().getDORCARDIACAISQUEMICA().getINFARTO()));
                aux.add(new DadosClinicos("      Angina Instável", historico.getHIPOTESEDIAGNOSTICA().getDORCARDIACAISQUEMICA().getANGINAINSTAVEL()));
                aux.add(new DadosClinicos("      Angina Estável", historico.getHIPOTESEDIAGNOSTICA().getDORCARDIACAISQUEMICA().getANGINAESTAVEL()));
                adicionaDadoClinico(aux, dadosClinicos);

                aux = new ArrayList();
                aux.add(new DadosClinicos("   DOR CARDIACA NÃO ISQUEMICA", "............................................................................................................................................................................................"));
                aux.add(new DadosClinicos("      Miocardite", historico.getHIPOTESEDIAGNOSTICA().getDORCARDIACANAOISQUEMICA().getMIOCARDITE()));
                aux.add(new DadosClinicos("      Pericardite", historico.getHIPOTESEDIAGNOSTICA().getDORCARDIACANAOISQUEMICA().getPERICARDITE()));
                aux.add(new DadosClinicos("      Doença Valvular", historico.getHIPOTESEDIAGNOSTICA().getDORCARDIACANAOISQUEMICA().getDOENCAVALVULAR()));
                aux.add(new DadosClinicos("      Outro", historico.getHIPOTESEDIAGNOSTICA().getDORCARDIACANAOISQUEMICA().getOUTRO()));
                adicionaDadoClinico(aux, dadosClinicos);

                aux = new ArrayList();
                aux.add(new DadosClinicos("   DOR NÃO CARDIACA", "............................................................................................................................................................................................"));
                aux.add(new DadosClinicos("      Aorta", historico.getHIPOTESEDIAGNOSTICA().getDORNAOCARDIACA().getAORTA()));
                aux.add(new DadosClinicos("      Medialino", historico.getHIPOTESEDIAGNOSTICA().getDORNAOCARDIACA().getMEDIALINO()));
                aux.add(new DadosClinicos("      Músculo Esqueletico", historico.getHIPOTESEDIAGNOSTICA().getDORNAOCARDIACA().getMUSCULOESQUELETICO()));
                aux.add(new DadosClinicos("      Somatização", historico.getHIPOTESEDIAGNOSTICA().getDORNAOCARDIACA().getSOMATIZACAO()));
                aux.add(new DadosClinicos("      Cutanea", historico.getHIPOTESEDIAGNOSTICA().getDORNAOCARDIACA().getCUTANEA()));
                aux.add(new DadosClinicos("      Pulmonar", historico.getHIPOTESEDIAGNOSTICA().getDORNAOCARDIACA().getPULMONAR()));
                aux.add(new DadosClinicos("      Gastro Intestinal", historico.getHIPOTESEDIAGNOSTICA().getDORNAOCARDIACA().getGASTROINTESTINAL()));
                adicionaDadoClinico(aux, dadosClinicos);

                aux = new ArrayList();
                aux.add(new DadosClinicos("   MOTIVO EXAME SEM DOR", "............................................................................................................................................................................................"));
                aux.add(new DadosClinicos("      Aorta", historico.getHIPOTESEDIAGNOSTICA().getMOTIVOEXAMESEMDOR().getAORTA()));
                aux.add(new DadosClinicos("      Medialino", historico.getHIPOTESEDIAGNOSTICA().getMOTIVOEXAMESEMDOR().getMEDIALINO()));
                aux.add(new DadosClinicos("      Músculo Esqueletico", historico.getHIPOTESEDIAGNOSTICA().getMOTIVOEXAMESEMDOR().getMUSCULOESQUELETICO()));
                aux.add(new DadosClinicos("      Somatização", historico.getHIPOTESEDIAGNOSTICA().getMOTIVOEXAMESEMDOR().getSOMATIZACAO()));
                aux.add(new DadosClinicos("      Cutanea", historico.getHIPOTESEDIAGNOSTICA().getMOTIVOEXAMESEMDOR().getCUTANEA()));
                aux.add(new DadosClinicos("      Pulmonar", historico.getHIPOTESEDIAGNOSTICA().getMOTIVOEXAMESEMDOR().getPULMONAR()));
                aux.add(new DadosClinicos("      Gastro Intestinal", historico.getHIPOTESEDIAGNOSTICA().getMOTIVOEXAMESEMDOR().getGASTROINTESTINAL()));
                adicionaDadoClinico(aux, dadosClinicos);

            } else if (versaoModeloHistoricoClinico == 2) {
                XMLFactory<HISTORICOCLINICO> xmlDadosClinicos = new XMLFactory<HISTORICOCLINICO>();
                HISTORICOCLINICO historico = xmlDadosClinicos.gerarEstrutura(exame.getHistoricosClinicos().get(0).getConteudo(), "UTF-8");
                if (historico.getDADOSCLINICOS() != null && historico.getDADOSCLINICOS().size() > 0) {
                    dadosClinicos.add(new DadosClinicos("HISTÓRICO CLINICO .............................................................................................................................................................................................................................................................................................",
                            "............................................................................................................................................................................................................................................................................................."));
                    // Lista utilizada para filtrar os dados e grupos que sao validos (Contem mais de um item com valor TRUE)
                    List<DadosClinicos> dadosClinicosValidos = new ArrayList();
                    // Lista de dados ja verificados
                    List<DADOCLINICO> dadosClinicosUsados = new ArrayList();
                    for (GRUPO grupo : historico.getGRUPOS()) {
                        dadosClinicosValidos.add(new DadosClinicos("   " + grupo.getDESCRICAO().toUpperCase() + " .............................................................................................................................................................................................................................................................................................",
                                "............................................................................................................................................................................................................................................................................................."));
                        // Mantem a lista de dados usados sempre vazia a cada iteracao.
                        dadosClinicosUsados.clear();
                        for (DADOCLINICO dadoclinico : historico.getDADOSCLINICOS()) {
                            if (grupo.getID().equals(dadoclinico.getGRUPO_ID())) {
                                if (!dadoclinico.getVALOR().equals("FALSE") && !dadoclinico.getVALOR().trim().isEmpty()) {
                                    dadosClinicosValidos.add(
                                            new DadosClinicos("       " + dadoclinico.getDESCRICAO().toUpperCase(),
                                                    converteValorDADOCLINICO(dadoclinico.getVALOR())));
                                }
                                // armazena os dados ja usados
                                dadosClinicosUsados.add(dadoclinico);
                            }
                        }
                        // Tentativa de diminuir a quantidade de iteracoes no loop acima
                        // Removendo os dados ja verificados
                        historico.getDADOSCLINICOS().removeAll(dadosClinicosUsados);
                        // Caso exista mais de um item na lista (GRUPO + DADOCLINICO)
                        // o mesmo é inserido em dadosClinicos
                        if (dadosClinicosValidos.size() > 1) {
                            dadosClinicos.addAll(dadosClinicosValidos);
                        }
                        dadosClinicosValidos.clear();
                    }
                }
            }
        }
        return dadosClinicos;
    }
}
