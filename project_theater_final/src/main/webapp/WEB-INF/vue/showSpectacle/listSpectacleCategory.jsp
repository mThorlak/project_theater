<%@ page import="ejbEntity.spectacle" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>List spectacle</title>
    <link type="text/css" rel="stylesheet" href="" />
</head>
<body>
<h1>List spectacle : </h1>
<%
    List<spectacle> spectacles = (List<spectacle>) request.getAttribute("spectacles");
    for (spectacle eachSpectacle : spectacles) {
        out.println("<li> <a href=\"http://localhost:8080/project_theater_final_war_exploded/buy?spectacle=" + eachSpectacle.getIdSpectacle() + "\">" + eachSpectacle.toString() + "</a> </li>");
    }
%>

</body>
</html>