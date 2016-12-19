<%-- 
    Document   : index
    Created on : 19.12.2016, 20:19:48
    Author     : Stanislav Stanislavov
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="JDBCTools.JDBCGetData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String[] st = {"", "", "", ""};

            Class.forName("com.mysql.jdbc.Driver");
            int strId = Integer.parseInt(request.getParameter("citizenId"));
            try {
                JDBCGetData.getData(strId, st);

        %><ul type="circle">
            <%for (int idx = 0; idx < st.length; idx++) {
                    out.println("<li>" + st[idx] + "</li>");
                }
            %>
        </ul>

        <%
                }catch (SQLException ex) {
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
