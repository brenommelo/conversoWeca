/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.commons;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author paulo.gomes
 */
public class ZipUtil {

    /**
     * Descompacta
     *
     * @param file
     * @param pathDest
     * @return
     * @throws IOException
     */
    public boolean unZip(final File file, String pathDest) throws IOException {
        boolean retorno = false;
        if (!file.exists() || !isZip(file.getName())) {
            return false;
        }
        File destino = new File(pathDest);
        if (!destino.exists()) {
            destino.mkdirs();
        }

        //get the zip file content
        ZipInputStream zis
                = new ZipInputStream(new FileInputStream(file));
        OutputStream outStream = null;
        String fileName = "";

        //Descompacta os arquivos da pasta e deleta o zip
        ZipEntry entry = zis.getNextEntry();
        File temp = null;
        while (entry != null) {
            fileName = entry.getName();
            temp = new File(destino + File.separator + fileName);
            if (!temp.exists() && (!temp.getName().contains(".") || temp.getName().lastIndexOf(".") < 0)) {
                temp.mkdirs();
            } else {            //if (temp.isFile()) {
                outStream = new BufferedOutputStream(new FileOutputStream(destino.getAbsoluteFile() + File.separator + fileName));
                byte[] buffer = new byte[1024];
                int len;
                while ((len = zis.read(buffer)) >= 0) {
                    outStream.write(buffer, 0, len);
                }
                outStream.close();
            }
            entry = zis.getNextEntry();
            retorno = true;
        }

        if (outStream != null) {
            outStream.close();
        }

        return retorno;
    }

    /**
     * Compacta o arquivo passado como parametro usando o nome passado para o
     * arquivo de saida.
     *
     * @param file Arquivo a ser compactado
     * @param zipName Nome de saida do arquivo, caso nao informado, sera usado o
     * mesmo nome do arquivo
     * @return Arquivo zip criado ou null em caso de erro.
     * @throws FileNotFoundException
     * @throws IOException
     */
    private File createZipFile(String zipName, File file) throws FileNotFoundException, IOException {
        // Verifica se o arquivo ja e um zip, e se for, retorna o mesmo
        if (file == null) {
            return null;
        } else if (file.getName().substring(file.getName().lastIndexOf(".") + 1).equalsIgnoreCase(".zip")) {
            return file;
        }
        zipName = (zipName == null) ? formatZipName(file.getName()) : formatZipName(zipName);
        return createZipFile(zipName, file, null);
    }

    /**
     * Compacta os arquivos passados como parametro usando o nome passado para o
     * arquivo de saida.
     *
     * @param zipName Nome do arquivo de saida
     * @param files Arquivos a serem compactados
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public File createZipFile(String zipName, File... files) throws FileNotFoundException, IOException {
        if (files == null || files.length == 0 || zipName == null) {
            return null;
        }
        // Verifica se o arquivo possui extensao zip
        zipName = formatZipName(zipName);

        // Verifica se o zip existe e renomeia para criar um novo
        String tempName = zipName;
        for (int i = 0;; i++) {
            if (!new File(tempName).exists()) {
                break;
            } else {
                tempName = i + "_" + zipName;
            }
        }
//        String path = files[0].getParent().concat(File.separator);
//        zipName = path.concat(tempName);
        InputStream stream = null;
        FileOutputStream output = new FileOutputStream(zipName);
        ZipOutputStream outStream = new ZipOutputStream(output);
        int len;
        for (File file : files) {
            if (file != null && file.exists() && file.isFile()) {
                len = 0;
                stream = new FileInputStream(file);
                outStream.putNextEntry(new ZipEntry(file.getName()));
                byte[] buffer = new byte[1024];
                while ((len = stream.read(buffer)) > 0) {
                    outStream.write(buffer, 0, len);
                }
                outStream.closeEntry();
                outStream.flush();
                stream.close();
            }
        }
        outStream.close();
        output.close();
        return new File(zipName);
    }

    /**
     * Formata o nome passado como parametro para zip
     *
     * @param zipName
     * @return
     */
    protected String formatZipName(String zipName) {
        if (!zipName.endsWith(".zip")) {
            if (zipName.lastIndexOf(".") > 0) {
                zipName = zipName.substring(0, zipName.lastIndexOf("."));
            }
            zipName = zipName.concat(".zip");
        }
        return zipName;
    }

    public List<String> arquivos(File file) throws FileNotFoundException, IOException {
        List<String> nomes = null;
        if (file != null && file.exists()) {
            if (isZip(file.getName())) {
                nomes = new ArrayList();
                FileInputStream filIn = new FileInputStream(file);
                ZipInputStream zipIn = new ZipInputStream(filIn);
                ZipEntry zip = zipIn.getNextEntry();
                while (zip != null) {
                    nomes.add(zip.getName());
                    zip = zipIn.getNextEntry();
                }
                filIn.close();
                zipIn.close();
            }
            return nomes;
        } else {
            return nomes;
        }
    }

    /**
     * Metodo que recebe um arquivo zip a ser utilizado, o newFile e a
     * referencia ao arquivo a ser sobrescrito, caso override seja false o
     * arquivo e apenas deletado.
     *
     * @param file_zip Arquivo zip a ser trabalhado
     * @param newFile Novo arquivo a ser sobrescrito
     * @param override true para sobrescrever ou false apenas para deletar o
     * arquivo.
     * @return
     * @throws IOException
     */
    private boolean overrideFile(File file_zip, File newFile, boolean override) throws IOException {
        boolean deletado = false;
        if (file_zip != null && file_zip.exists()) {
            if (file_zip.getName().toLowerCase().endsWith(".zip")) {
                FileInputStream filIn = new FileInputStream(file_zip);
                ZipInputStream zipIn = new ZipInputStream(filIn);

                String temp_name = file_zip.getAbsoluteFile() + ".temp";
                FileOutputStream filOut = new FileOutputStream(temp_name);
                ZipOutputStream zipOut = new ZipOutputStream(filOut);

                ZipEntry zip = zipIn.getNextEntry();
                while (zip != null) {
                    if (!zip.getName().equalsIgnoreCase(newFile.getName())) {
                        zipOut.putNextEntry(zip);
                        zipOut.flush();
                    } else {
                        if (override) {
                            int len = 0;
                            FileInputStream stream = new FileInputStream(newFile);
                            zipOut.putNextEntry(new ZipEntry(newFile.getName()));
                            byte[] buffer = new byte[1024];
                            while ((len = stream.read(buffer)) > 0) {
                                zipOut.write(buffer, 0, len);
                            }
                            zipOut.closeEntry();
                            zipOut.flush();
                            stream.close();
                        }
                    }
                    zip = zipIn.getNextEntry();
                }
                zipOut.close();
                filOut.close();
                filIn.close();
                zipIn.close();
                file_zip.delete();
                deletado = new File(temp_name).renameTo(new File(file_zip.getAbsolutePath()));
            }
        }
        return deletado;
    }

    /**
     * Caso encontre o arquivo o mesmo e deletado.
     *
     * @param file
     * @param nomeArquivo
     * @return
     * @throws IOException
     */
    public boolean deleteFile(File file, String nomeArquivo) throws IOException {
        return overrideFile(file, new File(nomeArquivo), false);
    }

    /**
     * Caso o arquivo seja encontrado o mesmo e sobrescrito
     *
     * @param file_zip
     * @param newFile
     * @return
     * @throws IOException
     */
    public boolean overrideFile(File file_zip, File newFile) throws IOException {
        return overrideFile(file_zip, newFile, true);
    }

    public boolean insertFile(File file_zip, File newFile) throws IOException {
        boolean inserido = false;
//        if (file_zip != null && file_zip.exists()) {
//            if (file_zip.getName().toLowerCase().endsWith(".zip")) {
//                FileOutputStream filOut = new FileOutputStream(file_zip);
//                ZipOutputStream zipOut = new ZipOutputStream(filOut);
//                
//                ZipFile zipF = new ZipFile(file_zip);
//
//                int len = 0;
//                FileInputStream stream = new FileInputStream(newFile);
//                zipOut.putNextEntry(new ZipEntry(newFile.getName()));
//                byte[] buffer = new byte[1024];
//                while ((len = stream.read(buffer)) > 0) {
//                    zipOut.write(buffer, 0, len);
//                }
//                zipOut.closeEntry();
//                zipOut.flush();
//                stream.close();
//
//                zipOut.close();
//                filOut.close();
//                inserido = true;
//            }
//        }
        return inserido;
    }

    private boolean isZip(String filename) {
        return filename != null && filename.toLowerCase().endsWith(".zip");
    }

    public void teste(String file) throws IOException {
        Map<String, String> zip_properties = new HashMap<>();
        /* We want to read an existing ZIP File, so we set this to False */
        zip_properties.put("create", "false");
        /* Specify the encoding as UTF -8 */
        zip_properties.put("encoding", "UTF-8");
        /* Specify the path to the ZIP File that you want to read as a File System */
        URI zip_disk = URI.create(file);
        /* Create ZIP file System */
        try (FileSystem zipfs = FileSystems.newFileSystem(zip_disk, zip_properties)) {
            /* Create a Path in ZIP File */
            Path ZipFilePath = zipfs.getPath("TESTER.zip");
            /* Path where the file to be added resides */
            Path addNewFile = Paths.get("C:/temp/TESTER.zip");
            /* Append file to ZIP File */
            Files.copy(addNewFile, ZipFilePath);
        }
    }
}
