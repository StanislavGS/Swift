/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesLogic;

/**
 *
 * @author stanislav
 */
public class DataReadException extends Exception{
    String reason;
    Exception ex;

    public DataReadException(String reason, Exception ex) {
        this.reason = reason;
        this.ex = ex;
    }
    
}
