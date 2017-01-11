/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySQLClasses;

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

    
    public void execute() {

        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);) {
            switch (typeStatement) {
                case : TypeStatement.callable.
                    CallableStatement statement = con.prepareCall(SQLtext);
                    statement.setInt("p_film_id", 1);
                    statement.setInt("p_store_id", 1);
                    statement.registerOutParameter("p_film_count", Types.INTEGER);
                    statement.executeQuery(this.SQLtext);
                    break;
                case :
                    TypeStatement.prepared PreparedStatement statement = con.prepareStatement(this.SQLtext);
                    statement.setString(1, arg);
                    ResultSet rs = statement.executeQuery();
                case :
                    TypeStatement.execute Statement statement = con.createStatement();
                    ResultSet rs = statement.execute(this.SQLtext);
                case :
                    TypeStatement.executeQuery Statement statement = con.createStatement();
                    ResultSet rs = statement.execute(this.SQLtext);
            }
        } catch (SQLException ex) {

        }finaly
        {

        }

    }

}
