<%-- 
    Document   : newjsp
    Created on : Jan 10, 2017, 3:24:59 PM
    Author     : Stanislav Stanislavov
--%>

<%@page import="java.time.LocalDateTime"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!<% out.print(LocalDateTime.now().toString());             %></h1>
        

        <table border="1">
           <thead>
                <tr>
                    <th colspan="2">Person details</th>
                    <th colspan="2">Address</th>
                    <th colspan="2">Education<br/>
                        <table border="1">
                            <tbody>
                                <tr>
                                    <td><input type="submit" value="education Back" name="educationBack" /></td>
                                    <td>5 of 6</td>
                                    <td><input type="submit" value="education Forward" name="educationForrward" /></td>
                                </tr>
                            </tbody>
                        </table>

                    </th>
                    <th colspan="2">Insurance records</th>                    
                </tr>
                </thead>
                 <tbody>
                <tr>
                    <td>first name:</td>
                    <td></td>
                    <td>country:</td>
                    <td></td>
                    <td>type education:</td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>second name:</td>
                    <td></td>
                    <td>city:</td>
                    <td></td>
                    <td>institution name:</td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>last name:</td>
                    <td></td>
                    <td>municipality:</td>
                    <td></td>
                    <td>enrollment date:</td>
                    <td></td>
                    <td></td>
                    <td></td>                    
                </tr>
                <tr>
                    <td>height:</td>
                    <td></td>
                    <td>street:</td>
                    <td></td>
                    <td>graduation date:</td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>birth date:</td>
                    <td></td>
                    <td>postal code:</td>
                    <td></td>
                    <td>graduated:</td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>gender:</td>
                    <td></td>
                    <td>number:</td>
                    <td></td>
                    <td>final grade:</td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td>floor:</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>                
                <tr>
                    <td></td>
                    <td></td>
                    <td>apartment:</td>
                    <td></td>
                    <td colspan="2"><input type="submit" value="new Education" name="newEducation" /></td>
                    <td colspan="2"><input type="submit" value="new Insurance Record" name="newRecord" /></td>
                    
                </tr>
            </tbody>
        </table>

        
    </body>
</html>
