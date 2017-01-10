/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySQLClasses;

import java.sql.Connection;

/**
 *
 * @author stanislav
 */
public class MySQLRequest {

    String SQLtext;
    TypeResult typeRsult;
    Object result;

    public MySQLRequest(String SQLtext, TypeResult typeRsult) {
        this.SQLtext = SQLtext;
        this.typeRsult = typeRsult;
        this.result = null;
    }

    public void execute() {
        Connection conn=null;
        
        try () {

        } catch () {

        }finaly
        {

        }

    }

}
