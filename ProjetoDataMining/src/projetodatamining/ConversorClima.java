/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodatamining;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.print.attribute.standard.Sides;
import projetodatamining.dominio.entidades.DadosClimaticos;
import projetodatamining.dominio.entidades.EstacaoMeteorologica;

/**
 *
 * @author breno
 */
public class ConversorClima {

    EstacaoMeteorologica estacaoMeteorologica;
    private List<DadosClimaticos> listaDadosClimaticos;
    DadosClimaticos dadosClimaticos;
    SimpleDateFormat sdf;
    int posicaoDados;

    public ConversorClima() {
        init();
    }

    public void init() {
        estacaoMeteorologica = new EstacaoMeteorologica();
        dadosClimaticos = new DadosClimaticos();
        listaDadosClimaticos = new ArrayList();
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        posicaoDados = 0;
    }

    public void lerArquivo() {

        try {
            FileReader arq = new FileReader("DadosEstacoesClimaticasMinas.txt");
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            while (linha != null) {
                System.out.printf("%s\n", linha);
                linha = lerArq.readLine(); // lê da segunda até a última linha
                carregarObjetoEstacao(linha);
            }

            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

        System.out.println();

    }

    private void carregarObjetoEstacao(String linha) {

        if (linha == null || linha.isEmpty() || linha.contains("-----------") || linha.contains("BDMEP - INMET")) {

        } else if (linha.contains("(OMM:")) {
            String[] quebra = linha.split(":");
            String aux = quebra[1];
            if (aux != null && !aux.isEmpty()) {
                aux = aux.replace("(", "");
                aux = aux.replace("OMM", "");
            }
            estacaoMeteorologica.setNome(aux);
            aux = quebra[2];
            if (aux != null && !aux.isEmpty()) {
                aux = aux.replace(")", "");
                aux = aux.trim();

            }
            estacaoMeteorologica.setId(Long.valueOf(aux));
        } else if (linha.contains("Latitude")) {
            String[] quebra = linha.split(":");
            estacaoMeteorologica.setLatitude(quebra[quebra.length - 1].trim());
        } else if (linha.contains("Longitude")) {
            String[] quebra = linha.split(":");
            estacaoMeteorologica.setLongitude(quebra[quebra.length - 1].trim());
        } else if (linha.contains("Altitude")) {
            String[] quebra = linha.split(":");
            estacaoMeteorologica.setAltitude(quebra[quebra.length - 1].trim());
        } else if (estacaoMeteorologica.getId() != null && linha.contains(String.valueOf(estacaoMeteorologica.getId()))) {
            String[] quebra = linha.split(";");
            if (quebra.length > 18) {

                dadosClimaticos.setId_estacao(Long.valueOf(quebra[posicaoDados]));
                posicaoDados++;
                dadosClimaticos.setDataLeitura(quebra[posicaoDados] + " " + quebra[posicaoDados + 1]);
                posicaoDados++;
                dadosClimaticos.setDirecaoVento(retornarDado(quebra[posicaoDados]));
                dadosClimaticos.setVelocidadeVentoMedia(retornarDado(quebra[posicaoDados]));
                dadosClimaticos.setVelocidadeVentoMaximaMedia(retornarDado(quebra[posicaoDados]));
                dadosClimaticos.setEvaporacaoPiche(retornarDado(quebra[posicaoDados]));
                dadosClimaticos.setEvapoBHPotencial(retornarDado(quebra[posicaoDados]));
                dadosClimaticos.setEvapoBHReal(retornarDado(quebra[posicaoDados]));
                dadosClimaticos.setInsolacaoTotal(retornarDado(quebra[posicaoDados]));
                dadosClimaticos.setNebulosidadeMedia(retornarDado(quebra[posicaoDados]));
                dadosClimaticos.setNumDiasPrecipitacao(retornarDado(quebra[posicaoDados]));
                dadosClimaticos.setPrecipitacaoTotal(retornarDado(quebra[posicaoDados]));
                dadosClimaticos.setPressaoNivelMarMedia(retornarDado(quebra[posicaoDados]));
                dadosClimaticos.setPressaoMedia(retornarDado(quebra[posicaoDados]));
                dadosClimaticos.setTempMaximaMedia(retornarDado(quebra[posicaoDados]));
                dadosClimaticos.setTempCompensadaMedia(retornarDado(quebra[posicaoDados]));
                dadosClimaticos.setTempMinimaMedia(retornarDado(quebra[posicaoDados]));
                dadosClimaticos.setUmidadeRelativaMedia(retornarDado(quebra[posicaoDados]));
                dadosClimaticos.setVisibilidadeMedia(retornarDado(quebra[quebra.length - 1]));
                listaDadosClimaticos.add(dadosClimaticos);
                dadosClimaticos = new DadosClimaticos();
                posicaoDados = 0;
            }
        } else if (linha.contains("***")) {
            System.out.println("Troca de estacao");
            init();

        }
    }

    public Float retornarDado(String str) {
        posicaoDados++;
        if (str == null || str.isEmpty()) {
            return 0f;
        } else {
            return Float.valueOf(str);
        }
    }

}
