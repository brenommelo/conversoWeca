/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.commons;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Properties;

/**
 *
 * @author weslley.matos
 */
public class PropertyUtils {

    /**
     *
     * @param file
     * @return
     */
    public static Properties getProperties(final Files file) {
        return getProperties(new File(file.getFileName()));
    }

    public static Properties getProperties(final File file) {
        Properties props = null;

        try (Reader reader = new FileReader(file)) {
            props = new Properties();
            props.load(reader);
            reader.close();

        } catch (Exception ex) {

        }
        return props;
    }
}
