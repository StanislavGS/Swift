/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

import java.sql.SQLException;

/**
 *
 * @author stanislav
 */
public class DALException extends SQLException{
    String dALmessage;
    Exception ex;

    public DALException(String message, Exception ex) {
        this.dALmessage = message;
        this.ex = ex;
    }

    public String getdALmessage() {
        return dALmessage;
    }
    
    
}
