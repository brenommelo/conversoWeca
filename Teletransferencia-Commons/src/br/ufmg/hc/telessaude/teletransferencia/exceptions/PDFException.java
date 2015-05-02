/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.teletransferencia.exceptions;

import com.logs.CustomLogger;
import org.apache.log4j.Logger;

/**
 *
 * @author igor.santos
 */
public class PDFException extends Exception {

    private static final Logger LOG = CustomLogger.getLogger(PDFException.class);

    /**
     * 
     * @param message
     * @param cause 
     */
    public PDFException(String message, Throwable cause) {
        super(message, cause);
        getLogger(message, cause);
    }

    /**
     * 
     * @param msg 
     */
    public PDFException(String msg) {
        super(msg);
        getLogger(msg, this);
    }

    /**
     * 
     * @param msg
     * @param thrwbl 
     */
    private static void getLogger(String msg, Throwable thrwbl) {
        try {
            if (thrwbl != null) {
                LOG.error(msg, thrwbl);
            } else {
                LOG.error(msg);
            }
        } catch (Throwable ex) {
        }
    }
}
