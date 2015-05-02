/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logs;

import java.io.File;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 *
 * @author paulo.gomes
 */
public class CustomLogger extends Logger{

    public CustomLogger(String name) {
        super(name);
        BasicConfigurator.configure();
        final File logDir = new File("logs");
        if (!logDir.exists()) {
            logDir.mkdir();
        }
    }
}
