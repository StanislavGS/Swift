/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySQLClasses;

import Exceptions.DALException;
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

    final String DBMS_CONN_STRING = "jdbc:mysql://192.168.164.3:3306/sakila";
    final String DBMS_USERNAME = "root";
    final String DBMS_PASSWORD = "swift12345";
    String SQLtext;
    TypeStatement typeStatement;
    TypeResult typeRsult;
    Object result;

    public MySQLRequest(String SQLtext, TypeStatement typeStatement, TypeResult typeRsult) {
        this.SQLtext = SQLtext;
        this.typeStatement = typeStatement;
        this.typeRsult = typeRsult;
        this.result = null;
    }

    public void execute() throws SQLException {
        CallableStatement cStatement = null;
        PreparedStatement pStatement = null;
        Statement statement = null;
        ResultSet rs = null;

        if (this.typeStatement==TypeStatement.execute && this.typeRsult!=TypeResult.Boolean && this.typeRsult!=TypeResult.Void){
            throw new IllegalArgumentException();
        }
        
        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);) {
            switch (typeStatement) {
                case callable:
                    cStatement = con.prepareCall(SQLtext);
                    cStatement.setInt("p_film_id", 1);
                    cStatement.setInt("p_store_id", 1);
                    cStatement.registerOutParameter("p_film_count", Types.INTEGER);
                    cStatement.executeQuery(this.SQLtext);
                    break;
                case prepared:
                    pStatement = con.prepareStatement(this.SQLtext);
                    pStatement.setString(1, "xxxxxxx");
                    rs = pStatement.executeQuery();
                case execute:
                    statement = con.createStatement();
                    Boolean boo = statement.execute(this.SQLtext);
                    this.result = boo;
                case executeQuery:
                    statement = con.createStatement();
                    rs = statement.executeQuery(this.SQLtext);
            }
        } catch (SQLException ex) {
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
