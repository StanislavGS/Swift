<%-- 
    Document   : index
    Created on : 17.12.2016, 22:46:54
    Author     : Stanislav Stanislavov
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%//@page import="JDBCTools.JDBCGetData"%>
<%@page import="java.sql.SQLException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String[] st = {"","","",""};

            Class.forName("com.mysql.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/swift_citizen_registrations",
                    "root", "");
                    Statement statement = connection.createStatement();
                    ) {
                int strId = Integer.parseInt(request.getParameter("citizenId"));
                ResultSet resultset = statement.executeQuery(
                        "SELECT * FROM `people` WHERE `id`="+strId+";");
                if (resultset.next()) {
                st[0]= resultset.getString("first_name");
                st[1]= resultset.getString("last_name");
                st[2]= resultset.getDate("birth_date").toString();
                st[3]= "";//rs.getString("proffession");                
            }
                //JDBCGetData.getData(strId,st);
        %><ul type="circle">
            <%for (int idx = 0; idx < st.length; idx++) {
                    out.println("<li>" + st[idx] + "</li>");
                }
            %>
        </ul>

        <%
            } catch (SQLException ex) {
                out.println("Connection error!");
                out.println("Please contact admin.");
                /*while (ex != null) {
                    out.println(ex.getSQLState());
                    out.println(ex.getMessage());
                    out.println(ex.getErrorCode());
                    ex = ex.getNextException();
                }*/
            }
        %>

    </body>
</html>
