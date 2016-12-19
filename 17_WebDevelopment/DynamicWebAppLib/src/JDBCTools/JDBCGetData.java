package JDBCTools;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCGetData {

    public static void getData(int citizenId,String[] st) throws SQLException {
//public static void main(String[] args) {
//        int citizenId=12;
    
        final String DBMS_CONN_STRING = "jdbc:mysql://localhost:3306/swift_citizen_registrations";
        final String DBMS_USERNAME = "root";
        final String DBMS_PASSWORD = "";

        //String[] st=new String[4];
        try (
                Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
                Statement statement = con.createStatement();
                ResultSet rs = statement.executeQuery(
                        "SELECT * FROM `people` WHERE `id`="+citizenId+";")) {

            
            if (rs.next()) {
                st[0]= rs.getString("first_name");
                st[1]= rs.getString("last_name");
                st[2]= rs.getDate("birth_date").toString();
                st[3]= "";//rs.getString("proffession");                
            }
            

        } catch (SQLException ex) {
            throw ex;
            // SQLException is actually a linked list of Exceptions
            /*while (ex != null) {
                System.out.println(ex.getSQLState());
                System.out.println(ex.getMessage());
                System.out.println(ex.getErrorCode());
                ex = ex.getNextException();
            }*/

        }
        //return st;
    }
}
