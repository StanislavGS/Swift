/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySQLClasses;

import Exceptions.DALException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

/**
 *
 * @author stanislav
 */
public class MySQLRequest {

    final String DBMS_CONN_STRING = "jdbc:mysql://localhost:3306/citizen_insurance"
            + "?useUnicode=true&characterEncoding=utf-8";
    final String DBMS_USERNAME = "root";
    final String DBMS_PASSWORD = "llIIB+Yfr";
    String SQLtext;
    TypeStatement typeStatement;
    TypeResult typeRsult;
    private Object result;

    public MySQLRequest(String SQLtext, TypeStatement typeStatement, TypeResult typeRsult) {
        this.SQLtext = SQLtext;
        this.typeStatement = typeStatement;
        this.typeRsult = typeRsult;
        this.result = null;
    }

    public void setSQLtext(String SQLtext) {
        this.SQLtext = SQLtext;
    }

    public Object getResult() {
        return result;
    }
    
    public void execute() throws SQLException {
        CallableStatement cStatement = null;
        PreparedStatement pStatement = null;
        Statement statement = null;
        ResultSet rs = null;

        if (this.typeStatement==TypeStatement.execute && this.typeRsult!=TypeResult.Boolean && 
                this.typeRsult!=TypeResult.Void){
            throw new IllegalArgumentException();
        }
        
        //Connection con =DriverManager.getConnection(DBMS_CONN_STRING+"?user=" +DBMS_USERNAME+"&password="+DBMS_PASSWORD+
        //        "&useUnicode=true&characterEncoding=UTF-8");
        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);) {
            String qwr=new String(this.SQLtext.getBytes(Charset.forName("UTF-8")));
            switch (typeStatement) {
                case callable:
                    cStatement = con.prepareCall(SQLtext);
                    cStatement.setInt("p_film_id", 1);
                    cStatement.setInt("p_store_id", 1);
                    cStatement.registerOutParameter("p_film_count", Types.INTEGER);
                    cStatement.executeQuery(qwr);
                    break;
                case prepared:
                    pStatement = con.prepareStatement(qwr);
                    pStatement.setString(1, "xxxxxxx");
                    rs = pStatement.executeQuery();
                    break;
                case execute:
                    statement = con.createStatement();
                    Boolean boo = statement.execute(qwr);
                    this.result = boo;
                    break;
                case executeQuery:
                    statement = con.createStatement();                    
                    rs = statement.executeQuery(qwr);
                    if (typeRsult==TypeResult.numRows){
                        this.result=(int) 0;
                        if (rs.last()){
                            this.result=(int) rs.getRow();
                        }
                            
                    }else{
                        
                    }
            }
        } catch (SQLException  ex) {
            throw ex;
        } finally      {
            if (cStatement != null) {
                cStatement.close();
            }
            if (pStatement != null) {
                pStatement.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (rs != null) {
                rs.close();
            }
        }

    }

}
