/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodatamining;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import projetodatamining.dominio.entidades.ComercioExterior;
import projetodatamining.dominio.entidades.Municipio;

/**
 *
 * @author breno
 */
public class ConversorImportacao {

    private Municipio municipio;
    private ComercioExterior comercioExterior;
    private int contador;

    public ConversorImportacao() {
        municipio = new Municipio();
        comercioExterior = new ComercioExterior();
    }

    public void lerArquivo() {

        try {
            FileReader arq = new FileReader("importacao.csv");
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            while (linha != null) {
                System.out.printf("%s\n", linha);
                linha = lerArq.readLine(); // lê da segunda até a última linha
                carregarEntidades(linha);
            }

            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

        System.out.println();

    }

    private void carregarEntidades(String linha) {
        if (linha!=null&&!linha.isEmpty()&&!linha.contains("year,month,import_val")) {
            String[] vetor = linha.split(",");
            contador = 0;
            municipio = new Municipio();
            comercioExterior = new ComercioExterior();

            comercioExterior.setAno(retornarInteiro(vetor[contador]));
            comercioExterior.setMes(retornarString(vetor[contador]));
            //import_val
            comercioExterior.setValorImportacoes(retornarFloat(vetor[contador]));
            //export_val
            comercioExterior.setValorExportacoes(retornarFloat(vetor[contador]));
            //import_kg
            comercioExterior.setPesoImportacoes(retornarFloat(vetor[contador]));
            //export_kg
            comercioExterior.setPesoExportacoes(retornarFloat(vetor[contador]));
            //impor_val_growth
            comercioExterior.setCrescimentoNominalImportUmAno(retornarFloat(vetor[contador]));
            //impor_val_growth_5
            comercioExterior.setCrescimentoNominalImportCincoAnos(retornarFloat(vetor[contador]));
            //export_val_growth_
            comercioExterior.setCrescimentoNominalExportUmAno(retornarFloat(vetor[contador]));
            //export_val_growth_5
            comercioExterior.setCrescimentoNominalExportCincoAnos(retornarFloat(vetor[contador]));
            //wsdl_diversit
            comercioExterior.setDiversidadeDestino(retornarFloat(vetor[contador]));
            //wsdl_diversit_eff
            comercioExterior.setDiversidadeDestinoEfetiva(retornarFloat(vetor[contador]));
            //hs_diversit
            comercioExterior.setDiversidadeProdutos(retornarFloat(vetor[contador]));
            //hs_diversit_eff
            comercioExterior.setDiversidadeEfetivaProdutos(retornarFloat(vetor[contador]));
            //eci
            comercioExterior.setComplexidadeEconomica(retornarFloat(vetor[contador]));

            municipio.setIbge(retornarInteiro(vetor[contador+1]));

//            comercioExterior.setMunicipio(Integer.SIZE);
        }

    }

    private Float retornarFloat(String str) {
        contador++;
        if (str != null && !str.isEmpty() && !str.equalsIgnoreCase("none")) {
            return Float.valueOf(str);
        }
        return 0f;
    }

    private String retornarString(String str) {
        contador++;
        if (str != null && !str.isEmpty() && !str.equalsIgnoreCase("none")) {
//            return Integer.valueOf(str);
        }
        return str;

    }

    private Integer retornarInteiro(String str) {
        contador++;
        if (str != null && !str.isEmpty() && !str.equalsIgnoreCase("none")) {
            return Integer.valueOf(str);
        }
        return 0;
    }

}
