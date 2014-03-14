/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package humble.runtime;

/**
 *
 * @author nickpeck
 */
public class HumbleRuntimeException extends Exception {
    
    public HumbleRuntimeException(Exception e) {
        super("Uncaught Humble Runtime Exception : " + e.toString());
    }

}
