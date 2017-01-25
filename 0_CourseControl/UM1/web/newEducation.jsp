<%-- 
    Document   : newEducation
    Created on : Jan 20, 2017, 10:36:36 PM
    Author     : stanislav
--%>

<%@page import="wEBTools.CitizenWEBComposer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="userInfo.jsp" method="POST">
            <% if (session.getAttribute("webCitizen") != null) {
                    CitizenWEBComposer webCitizen = (CitizenWEBComposer) session.getAttribute("webCitizen");
                }%>
            <table border="1">
                <tbody>
                    <tr>
                        <td>type</td>
                        <td><select name="typeEducation">
                                <option>Primary</option>
                                <option>Secondary</option>
                                <option>Bachelor</option>
                                <option>Master</option>
                                <option>Doctorate</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td>Institution name</td>
                        <td><input type="text" name="istitutionName" value="" /></td>
                    </tr>
                    <tr>
                        <td>Enrollment date</td>
                        <td><input type="text" name="enrollmentDateYear" value="" style=" width: 25px;" />
                            <select name="enrollmentDateMonth">
                            <% for(int i=1;i<=12;i++){
                                out.println("<option>"+i+"</option>");
                            }%>
                                </select>
                             <select name="enrollmentDateDay">
                            <% for(int i=1;i<=31;i++){
                                out.println("<option>"+i+"</option>");
                            }%>
                                </select>   
                        </td>
                    </tr>
                    <tr>
                        <td>Graduation date</td>
                        <td><input type="text" name="graduationDateYear" value="" style=" width: 25px;"/>
                            <select name="graduationDateMonth">
                            <% for(int i=1;i<=12;i++){
                                out.println("<option>"+i+"</option>");
                            }%>
                                </select>
                             <select name="graduationDateDay">
                            <% for(int i=1;i<=31;i++){
                                out.println("<option>"+i+"</option>");
                            }%>
                        </td>                        
                    </tr>
                    <tr>
                        <td>Graduated</td>
                        <td><input type="checkbox" name="graduated" value="OFF" /></td>
                    </tr>
                    <tr>
                        <td>Final grade</td>
                        <td><input type="text" name="finalGrade" value="0" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="record" name="recordEducation" />
        </form>
    </body>
</html>
