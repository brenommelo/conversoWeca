/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.teletransferencia.ftp;

import java.io.File;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author paulo.gomes
 */
public class FTPTest {

    FTP instance;

    public FTPTest() {
//        instance = new FTP("150.164.192.68", 21, "telessaude", "123456", "", "");
        instance = new FTP();
    }

    /**
     * Test of validate method, of class FTP.
     */
    @Test
    public void testValidate() throws Exception {
        System.out.println("validate");
        boolean expResult = true;
        instance.connect();
        boolean result = instance.validate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFTP method, of class FTP.
     */
//    @Test
    public void testSetFTPNaoApagarLocal() {
        System.out.println("testSetFTPNaoApagarLocal");
        File file = new File("C:\\temp\\upload\\2014_06_20_Abaete_JoaoDaSilva_1725_MG.XML");
        String newName = "2014_06_20_Abaete_JoaoDaSilva_1725_MG.XML";
        boolean expResult = true;
        boolean result = instance.sendFile(file, newName, "ecg");
        assertEquals(expResult, result);
    }

    /**
     * Test of setFTP method, of class FTP.
     */
//    @Test
    public void testSetFTPApagarLocalESubfolders() {
        System.out.println("testSetFTPApagarLocalESubfolders");
        File file = new File("C:\\temp\\upload\\teste.txt");
        String newName = "teste.txt";
        boolean expResult = true;
        boolean result = instance.sendFile(file, newName, "transferencia");
        assertEquals(expResult, result);
    }

    /**
     * Test of setFTP method, of class FTP.
     */
//    @Test
    public void testSetFTPEnviarUrgencia() {
        System.out.println("SetFTPEnviarUrgencia");
        File file = new File("C:\\temp\\upload\\teste.txt");
        String extention = "txt";
        boolean urgencia = true;
        boolean zipar = true;
        boolean expResult = true;
        boolean result = instance.sendFile(file, urgencia, zipar);
        assertEquals(expResult, result);
    }

//    @Test
    public void testBaixarArquivo() throws Exception {
        System.out.println("BaixarArquivo");
        boolean expResult = false;
        instance.connect();
        boolean result = instance.receiveFile("test4_.zip", "C:\\temp\\upload\\test4_.zip", (String[]) null);
        assertEquals(expResult, result);
    }

    /**
     * Test of setFTP method, of class FTP.
     */
    @Test
    public void testSetFTPEnviaLaudo() {
        System.out.println("testSetFTPEnviaLaudo");
        File file = new File("C:\\temp\\upload\\upload.zip");
        boolean expResult = true;
//        instance.setActiveMode(true);
//        boolean result = instance.sendFile(file, file.getName(), "laudos");
        boolean result2 = instance.sendFile(new File("C:\\temp\\upload\\test4_.zip"), "teste4.zip", "laudos");
        assertTrue(expResult);
    }

//    @Test
    public void testCriarZipVariosArquivos() throws IOException {
        String[] arquivosNome = new String[]{"C:\\temp\\upload\\exporta_glpi.php",
            "C:\\temp\\upload\\BPMN2_0_Poster_PT.pdf",
            "C:\\temp\\upload\\laudo.xml"};
        File[] files = new File[arquivosNome.length];
        for (int i = 0; i < files.length; i++) {
            files[i] = new File(arquivosNome[i]);
        }
        File zip = instance.createZipFile("teste.zip", files);
        assertTrue(zip != null && zip.exists());
    }

}
