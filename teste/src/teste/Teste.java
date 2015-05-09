/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author breno
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        File arquivo = new File("teste.txt");

        try {
             arquivo.listFiles();

            if (!arquivo.exists()) {
//cria um arquivo (vazio)
                arquivo.createNewFile();
            }

//caso seja um diretório, é possível listar seus arquivos e diretórios
            File[] arquivos = arquivo.listFiles();

//escreve no arquivo
            FileWriter fw = new FileWriter(arquivo, true);

            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Texto a ser escrito no txt");

            bw.newLine();

            bw.close();
            fw.close();

//faz a leitura do arquivo
            FileReader fr = new FileReader(arquivo);

            BufferedReader br = new BufferedReader(fr);

//equanto houver mais linhas
            while (br.ready()) {
//lê a proxima linha
                String linha = br.readLine();

//faz algo com a linha
                System.out.println(linha);
            }

            br.close();
            fr.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
