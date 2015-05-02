/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.teletransferencia.ftp;

import com.logs.CustomLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

/**
 *
 * @author weslley.carvalho
 */
public class FTP {

    private FTPClient ftp;
    private Logger log = CustomLogger.getLogger(FTP.class.getName());

    protected boolean activeMode;
    protected String HOST;
    protected int PORT;
    protected String USERNAME;
    protected String PASSWORD;
    protected String ROOT_FOLDER;
    protected String WORK_FOLDER;

    public FTP() {
        //comun
        this.USERNAME = "teste.ftp";
        this.WORK_FOLDER = "transferencia";

        //ftp servidor
        this.HOST = "150.164.192.90";
        this.PORT = 1024;
        this.PASSWORD = "dev@tele";
        this.ROOT_FOLDER = "/home/teste.ftp";

//ftp maquina weslley
//        this.HOST = "150.164.192.68";
//        this.PORT = 21;
//        this.PASSWORD = "123456";
//        this.ROOT_FOLDER = "/";
    }

    public FTP(String HOST, int PORT, String USERNAME, String PASSWORD, String ROOT_FOLDER, String WORK_FOLDER) {
        this.HOST = HOST;
        this.PORT = PORT;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
        this.ROOT_FOLDER = ROOT_FOLDER;
        this.WORK_FOLDER = WORK_FOLDER;
    }

    public void setActiveMode(boolean activeMode) {
        this.activeMode = activeMode;
    }

    public boolean connect() throws IOException {
        return this.getConnection() && this.validate();
    }

    public boolean validate() throws IOException {
        if (ftp != null) {
            return ftp.isAvailable() && ftp.isConnected();
        }
        return false;
    }

    public boolean sendFile(File file, String newName, String subFolders) {
        return setFTP(file, newName, subFolders, false, false);
    }

    public boolean sendFile(File file, String newName, boolean urgencia, boolean zipar) {
        return setFTP(file, newName, null, urgencia, zipar);
    }

    public boolean sendFile(File file, boolean urgencia, boolean zipar) {
        return setFTP(file, null, null, urgencia, zipar);
    }
    //<editor-fold defaultstate="collapsed" desc="metodo substituido">

//
//    protected boolean setFTP(File file, String newName, String subFolders) {
//        boolean enviado = false;
//        try {
//            InputStream stream = null;
//            FileOutputStream outStream = null;
//            int value = 0;
//            if (!activeMode) {
//                activeMode = (subFolders != null && !subFolders.isEmpty());
//            }
//            this.connect();
//
//            if (validate()) {
//                try {
//                    stream = new FileInputStream(file);
//                    boolean current_dir = false;
//                    String ftp_path = ftp.printWorkingDirectory();
//                    if (subFolders != null) {
//                        current_dir = ftp_path.contains(subFolders);
//                        if (!current_dir) {
//                            ftp.makeDirectory(subFolders);
//                            current_dir = ftp.changeWorkingDirectory(subFolders);
//                        }
//
//                    } else {
//                        if (WORK_FOLDER != null && !WORK_FOLDER.isEmpty()) {
//                            ftp.makeDirectory(WORK_FOLDER);
//                            current_dir = ftp.changeWorkingDirectory(WORK_FOLDER);
//                        }
//                        current_dir = true;
//                    }
//                    if (current_dir) {
//                        ftp_path = ftp.printWorkingDirectory();
//                        ftp.storeFile(newName + ".rar", stream);
//                        ftp.rename(newName + ".rar", newName);
//                        stream.close();
//                        enviado = true;
//                    }
//
//                } catch (IOException ex) {
//                    log.error(ex.getMessage(), ex);
//                } finally {
//                    if (stream != null) {
//                        stream.close();
//                    }
//                    if (outStream != null) {
//                        outStream.close();
//                    }
//                    this.disconnect();
//
//                }
//            }
//        } catch (IOException ex) {
//            log.error(ex.getMessage(), ex);
//        }
//        return enviado;
//    }
//</editor-fold>
    public boolean setFTP(File file, String newName, String subFolders, boolean urgencia, boolean zipar) {
        InputStream stream = null;
        File fileZip = null;
        int value = 0;
        String extention = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        if (zipar) {
            zipar = extention != null && !extention.equals("zip");
        }
        if (!activeMode) {
            activeMode = urgencia;
        }

        boolean enviado = false;

        try {
            this.connect();
            if (validate()) {
                // Verifica se vai ser zipado
                fileZip = zipar ? createZipFile(file, file.getName()) : file;
                // caso o arquivo nao exista
                // Renomeia o arquivo para envio
                String name = fileZip.getName();
                if (newName != null && !newName.isEmpty()) {
                    name = newName;
                }
                boolean current_dir = false;
                if (subFolders != null) {
                    current_dir = ftp.printWorkingDirectory().contains(subFolders);
                    if (!current_dir) {
                        ftp.makeDirectory(subFolders);
                        current_dir = ftp.changeWorkingDirectory(subFolders);
                    }
                } else {
                    if (WORK_FOLDER != null && !WORK_FOLDER.isEmpty()) {
                        ftp.makeDirectory(WORK_FOLDER);
                        current_dir = ftp.changeWorkingDirectory(WORK_FOLDER);
                    } else {
                        current_dir = true;
                    }
                }
                if (current_dir) {
                    if (urgencia) {
                        ftp.makeDirectory("Urgencia");
                        ftp.changeWorkingDirectory("Urgencia");
                    }
                    // verifica se o arquivo ja existe no servidor
                    if (ftp.listNames() != null) {
                        for (String f : ftp.listNames()) {
                            if (f.equals(fileZip.getName())) {
                                value = 1;
                                break;
                            }
                        }
                    }
                    if (value != 1) {
//                        ftp.deleteFile(fileZip.getName().replace(".zip", ".rar"));
                        stream = new FileInputStream(fileZip);
                        if (ftp.storeFile(name + ".temp", stream)) {
                            ftp.rename(name + ".temp", name);
                            enviado = true;
                        }
                        stream.close();
                    }
                    if (zipar) {
                        fileZip.deleteOnExit();
                    }
                }

            }

        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
        } finally {
            try {
                if (ftp != null) {
                    if (stream != null) {
                        stream.close();
                    }
                    this.disconnect();
                }
            } catch (IOException ex) {
                log.error(ex.getMessage(), ex);
            }
        }
        return enviado;
    }

    /**
     *
     * @param fileFtp
     * @param localFile
     * @param useSubFolders
     * @return
     */
    public boolean receiveFile(String fileFtp, String localFile, String... useSubFolders) {
        if (fileFtp == null || fileFtp.isEmpty()) {
            return false;
        }
        FileOutputStream outStream = null;
        boolean recebido = false;
        try {
            this.connect();
            if (validate()) {
                boolean find_dir = false;
                if (useSubFolders != null) {
                    for (String string : useSubFolders) {
                        ftp.makeDirectory(string);
                        find_dir = ftp.changeWorkingDirectory(string);
                    }
                } else {
                    find_dir = ftp.changeWorkingDirectory(WORK_FOLDER) || ftp.printWorkingDirectory().contains(WORK_FOLDER);
                }
                if (find_dir) {
                    outStream = new FileOutputStream(localFile);
                    //get the file from the remote system
                    if (ftp.retrieveFile(fileFtp, outStream)) {
                        //close output stream
                        outStream.close();
                        recebido = true;
                    } else {
                        outStream.close();
                        new File(localFile).delete();
                        recebido = false;
                    }
                    this.disconnect();
                }
            }
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
        }

        return recebido;
    }

    /**
     *
     * @param file
     * @param zipName
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    private File createZipFile(File file, String zipName) throws FileNotFoundException, IOException {
        if (file.getName().substring(file.getName().lastIndexOf(".") + 1).equalsIgnoreCase(".zip")) {
            return file;
        }
        InputStream stream = new FileInputStream(file);
        ZipOutputStream outStream = null;
        File fileZip = new File(file.getParent() + "/" + zipName.substring(0, zipName.lastIndexOf(".")) + ".zip");

        if (!fileZip.exists()) {
            outStream = new ZipOutputStream(new FileOutputStream(fileZip));
            outStream.putNextEntry(new ZipEntry(file.getName()));

            byte[] buffer = new byte[1024];
            int len;

            while ((len = stream.read(buffer)) > 0) {
                outStream.write(buffer, 0, len);
            }

            outStream.closeEntry();
            outStream.flush();
            outStream.close();
            return fileZip;
        }
        return null;
    }

    public File createZipFile(String zipName, File... files) throws FileNotFoundException, IOException {
        if (files == null || files.length == 0 || zipName == null) {
            return null;
        }
        // Verifica se o arquivo possui extensao zip
        if (!zipName.contains(".zip")) {
            zipName = zipName.concat(".zip");
        }
        // Verifica se o zip existe e renomeia para criar um novo
        for (int i = 0;; i++) {
            if (!new File(zipName).exists()) {
                break;
            } else {
                zipName = i + "_" + zipName;
            }
        }
        InputStream stream = null;
        FileOutputStream output = new FileOutputStream(zipName);
        ZipOutputStream outStream = new ZipOutputStream(output);
        int len;
        for (File file : files) {
            if (file.exists()) {
                len = 0;
                stream = new FileInputStream(file);
                outStream.putNextEntry(new ZipEntry(file.getName()));
                byte[] buffer = new byte[1024];
                while ((len = stream.read(buffer)) > 0) {
                    outStream.write(buffer, 0, len);
                }
                outStream.closeEntry();
                outStream.flush();
            }
        }
        outStream.close();
        return new File(zipName);
    }

    private boolean getConnection() throws IOException {
        if (this.validate()) {
            return true;
        }
        final UtSocketFactory utSocketFactory = new UtSocketFactory();
        utSocketFactory.setConnectTimeout(5000);

        ftp = new FTPClient();
        ftp.setSocketFactory(utSocketFactory);

        ftp.connect(HOST, PORT);

        if (FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
            ftp.login(USERNAME, PASSWORD);
            ftp.changeWorkingDirectory(ROOT_FOLDER);
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            if (activeMode) {
                ftp.enterLocalActiveMode();
            } else {
                ftp.enterLocalPassiveMode();
            }
            ftp.setCharset(Charset.forName("utf8"));
            return true;
        } else {
            return false;
        }
    }

    private void disconnect() throws IOException {
        if (ftp != null) {
            ftp.logout();
            ftp.disconnect();
        }
    }

    /**
     *
     * @return
     */
    public String[] getParamsFolders() {
        return getParamsFromFile("ecg.ini", "file-path", "error-path", "city", "extentions");
    }

    /**
     *
     * @return
     */
    public String[] getConnectionFTPData() {
        return getParamsFromFile("connection.ini", "ftp-host", "port-number");
    }

    public String[] getParamsFromFile(String file, String... params) {
        String[] result = null;
        Reader reader = null;
        Properties prop = null;
        try {
            reader = new FileReader(new File(file));
            prop = new Properties();
            prop.load(reader);

            result = new String[params.length];
            for (int i = 0; i < params.length; i++) {
                result[0] = prop.getProperty(params[i]);
            }
        } catch (FileNotFoundException ex) {
            log.error(ex.getMessage(), ex);
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                log.error(ex.getMessage(), ex);
            }
            prop = null;
            reader = null;
        }
        return result;
    }

}
