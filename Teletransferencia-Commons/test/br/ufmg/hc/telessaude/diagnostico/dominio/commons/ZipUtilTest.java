/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.commons;

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author paulo.gomes
 */
public class ZipUtilTest {

    ZipUtil instance;

    public ZipUtilTest() {
        instance = new ZipUtil();
    }

    /**
     * Test of createZipFile method, of class ZipUtil.
     */
//    @Test
    public void testCreateZipManyFile() throws Exception {
        System.out.println("createZipFile");
        String zipName = "upload.zip";
        File[] files = new File[]{new File("C:\\temp\\upload\\teste.txt"), new File("C:\\temp\\upload\\laudo.xml")};
        File result = instance.createZipFile(zipName, files);
        assertNotNull(result);
//        result.delete();
    }

    /**
     * Test of createZipFile method, of class ZipUtil.
     */
//    @Test
    public void testCreateZipFile() throws Exception {
        System.out.println("createZipFile");
        String zipName = "teste";
        File file = new File("C:\\temp\\upload\\teste.txt");
        File result = instance.createZipFile(zipName, file);
        assertNotNull(result);
        result.delete();
    }

    /**
     * Test of formatZipName method, of class ZipUtil.
     */
//    @Test
    public void testFormatZipName() {
        System.out.println("formatZipName");
        String zipName = "teste";
        String expResult = "teste.zip";
        String result = instance.formatZipName(zipName);
        assertEquals(expResult, result);
    }

//    @Test
    public void testContarArquivoDentroZip() throws Exception {
        File[] files = new File[]{new File("C:\\temp\\upload\\teste.txt"), new File("C:\\temp\\upload\\laudo.xml")};
        File result = instance.createZipFile("contar", files);
        assertTrue(result != null && instance.arquivos(result).size() > 0);
        result.delete();
    }

//    @Test
    public void testDeletarArquivoDentroZip() throws Exception {
        File[] files = new File[]{new File("C:\\temp\\upload\\teste.txt"), new File("C:\\temp\\upload\\laudo.xml")};
        File result = instance.createZipFile("contar", files);
        assertTrue(result != null && instance.deleteFile(result, "teste.txt"));
        result.delete();
    }

//    @Test
    public void testSobrescreverArquivoDentroZip() throws Exception {
        assertTrue(instance.overrideFile(new File("C:\\temp\\upload\\upload.zip"), new File("C:\\temp\\upload\\teste.txt")));
    }

//    @Test
    public void testInserirArquivoDentroZip() throws Exception {
        File[] files = new File[]{new File("C:\\temp\\upload\\teste.txt"), new File("C:\\temp\\upload\\laudo.xml")};
        File result = instance.createZipFile("contar", files);
        assertTrue(result != null && instance.insertFile(result, new File("C:\\temp\\upload\\exporta_glpi.php")));
//        result.delete();
    }
    @Test
    public void testUnZip() throws Exception {
        boolean result = instance.unZip(new File("C:\\temp\\upload\\Paciente-Fúlânça%.zip"), new File("C:\\temp\\upload\\temp_zip").getAbsolutePath());
        assertTrue(result);
//        result.delete();
    }

}
