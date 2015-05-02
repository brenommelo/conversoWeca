/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversorbdweka.utilidades;


/**
 *
 * @author igor.santos
 */
public class DAOException extends Exception {

    public DAOException(String msg, Throwable thrwbl) {
        super(msg, thrwbl);
        getLogger(msg, thrwbl);
    }

    public DAOException(String msg) {
        super(msg);
        getLogger(msg, this);
    }

    private static void getLogger(String msg, Throwable thrwbl) {
        try {
            if (thrwbl != null) {
                CustomLogger.getLogger(DAOException.class).error(msg, thrwbl);
            } else {
                CustomLogger.getLogger(DAOException.class).error(msg);
            }
        } catch (Throwable ex) {
        }
    }
}
