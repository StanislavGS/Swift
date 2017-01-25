<%-- 
    Document   : newjsp_trash
    Created on : Jan 22, 2017, 12:11:51 PM
    Author     : stanislav
--%>

<%@page import="java.util.Enumeration"%>
<%@page import="education.*"%>
<%@page import="address.Address"%>
<%@page import="insurance.SocialInsuranceRecord"%>
<%@page import="wEBTools.CitizenWEBComposer"%>
<%@page import="java.util.Map"%>
<%@page import="java.time.LocalDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <%  Class.forName("com.mysql.jdbc.Driver");
            Map params = request.getParameterMap();
            StringBuffer currentURL = request.getRequestURL();
            String onlyPath = currentURL.substring(0, currentURL.lastIndexOf("/") + 1);
            CitizenWEBComposer webCitizen = (CitizenWEBComposer) session.getAttribute("webCitizen");
            boolean isError = false;
            String errMsg = "";
            if (webCitizen == null) {
                webCitizen = new CitizenWEBComposer(1);
                session.setAttribute("webCitizen", webCitizen);
            } else if (params.containsKey("getCitById")) {
                String[] idCit = (String[]) params.get("idCitizen");
                webCitizen = new CitizenWEBComposer(Integer.parseInt(idCit[0]));
                session.setAttribute("webCitizen", webCitizen);
            } else if (params.containsKey("checkCanUseSocBenefits")) {
                webCitizen.checkCanUseSocBenefits();
            } else if (params.containsKey("recordEducation")) {
                if (!webCitizen.addEducation(new String[]{
                    ((String[]) params.get("typeEducation"))[0],
                    ((String[]) params.get("istitutionName"))[0],
                    ((String[]) params.get("enrollmentDateYear"))[0],
                    ((String[]) params.get("enrollmentDateMonth"))[0],
                    ((String[]) params.get("enrollmentDateDay"))[0],
                    ((String[]) params.get("graduationDateYear"))[0],
                    ((String[]) params.get("graduationDateMonth"))[0],
                    ((String[]) params.get("graduationDateDay"))[0],
                    ((String[]) params.get("graduated"))[0],
                    ((String[]) params.get("finalGrade"))[0]})) {
                    isError = true;
                    errMsg = "Bad data for education";
                };
            } else if (params.containsKey("setNewSocInsRec")) {
                if (!webCitizen.addSIR(new String[]{
                    ((String[]) params.get("year"))[0],
                    ((String[]) params.get("month"))[0],
                    ((String[]) params.get("Amount"))[0]})) {
                    out.println("<input type=\"hidden\" name=\"error\" value=\"Bad data for insurance record\" />");
                    response.sendRedirect(currentURL.toString());
                    isError = true;
                    errMsg = "Bad data for insurance record";
                };
            } else if (params.containsKey("PrevoisSIR")) {
                webCitizen.prevoisSIR();
            } else if (params.containsKey("nextSIR")) {
                webCitizen.nextSIR();
            } else if (params.containsKey("goToSIR")) {
                String[] neIdSir = (String[]) params.get("goToSIRiD");
                webCitizen.goToSIR(Integer.parseInt(neIdSir[0]));
            }

            if (isError) {
                out.println(errMsg);
                out.println("<a href=\"" + currentURL + "\">Go back.</a>");
            } else {
                out.println(webCitizen.webComposer(request.getRequestURL().toString(),
                        onlyPath));
            };
        %>

    </body>

</html>

