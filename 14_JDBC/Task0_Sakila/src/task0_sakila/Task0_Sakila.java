package task0_sakila;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class Task0_Sakila {

    final static String DBMS_CONN_STRING = "localhost:3306/sakila";
    final static String DBMS_USERNAME = "root";
    final static String DBMS_PASSWORD = "";

    public static void main(String[] args) {
        
        try{
            int newFilmID=fillSomeData();
            
            //subcondition a)
            int newActorID=insertActor("Morgan", "Freeman");
            
            //subcondition b)
            insertActorInFilm(newActorID, newFilmID);
            
           //subcondition c)
            insertActorInFilm(insertActor("Bruce", "Willis"), newFilmID);
            
        }catch(SQLException ex) {

            
            // SQLException is actually a linked list of Exceptions
             while (ex != null) {
                System.out.println(ex.getSQLState());
                System.out.println(ex.getMessage());
                System.out.println(ex.getErrorCode());
                ex = ex.getNextException();
            }

        }
        
        

    }

    private static int insertActor(String firstName, String lastName) throws SQLException {
        int newID;
        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
                CallableStatement statement = con.prepareCall("{call insert_actor(?, ?, ?)}")) {

            String actorFirstName = "", actorLastName = "";
            statement.setString("new_actor_first_name", actorFirstName);
            statement.setString("new_actor_last_name", actorFirstName);
            statement.registerOutParameter("new_id", Types.INTEGER);

            statement.executeQuery();
            newID = statement.getInt("new_id");

        } catch (SQLException ex) {

            throw ex;
            // SQLException is actually a linked list of Exceptions
            /* while (ex != null) {
                System.out.println(ex.getSQLState());
                System.out.println(ex.getMessage());
                System.out.println(ex.getErrorCode());
                ex = ex.getNextException();
            }*/

        }
        return newID;
    }

    private static void insertActorInFilm(int actorID, int filmID) throws SQLException {
        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
                Statement statement = con.createStatement()) {

            statement.executeQuery(
                        "INSERT INTO `sakila`.`film_actor` (actor_id,film_id) "
                        + "VALUES ("+actorID+","+filmID+");");           

        } catch (SQLException ex) {
            throw ex;

        }
    }
    
    
    private static int fillSomeData() throws SQLException {
        int filmID;
        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
                Statement statement = con.createStatement()) {

            statement.executeQuery(
                        "INSERT INTO `sakila`.`film` (`title`,`description`,`release_year`," +
"`language_id`,`original_language_id`,`length`,`special_features`) "
                        + "VALUES ('film1','descr','2016','German','English',125,'Trailers');");   
            
            
            ResultSet rs = statement.executeQuery(
                        "SELECT film_id FROM WHERE `title`='film1'; ");

            rs.next();
            filmID=rs.getInt("film_id");          


        } catch (SQLException ex) {
            throw ex;

        }
        return filmID;
    }
}
