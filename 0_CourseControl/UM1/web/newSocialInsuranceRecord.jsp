<%-- 
    Document   : newSocialInsuranceRecord
    Created on : Jan 20, 2017, 10:37:30 PM
    Author     : stanislav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="setSocialInsuranceRecord" action="userInfo.jsp"><table border="1">
                    <thead>
                        <tr>
                            <th>name</th>
                            <th>value</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Year</td>
                            <td><input type="text" name="year" value="" style=" width: 50px;" /></td>
                        </tr>
                        <tr>
                            <td>Month</td>
                            <td><select name="month">
                            <% for(int i=1;i<=12;i++){
                                out.println("<option>"+i+"</option>");
                            }%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Amount</td>
                            <td><input type="text" name="Amount" value="" style=" width: 50px;" /></td>
                        </tr>
                    </tbody>
                </table>
                <input type="submit" value="setNewSocInsRec" name="setNewSocInsRec" />
            </form>
    </body>
</html>
