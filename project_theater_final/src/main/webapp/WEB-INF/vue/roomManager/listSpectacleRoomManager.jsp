<%@ page import="ejbEntity.spectacle" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>List spectacle</title>
    <link type="text/css" rel="stylesheet" href="CSS-Directory/menu.css" />
    <link type="text/css" rel="stylesheet" href="CSS-Directory/listStyle.css" />
</head>
<body>
<h1>List spectacle : </h1>
<ol class="rounded-list">
    <%
        List<spectacle> spectacles = (List<spectacle>) request.getAttribute("spectacles");
        for (spectacle eachSpectacle : spectacles) {
            out.println("<li> <a href=\"http://localhost:8080/project_theater_final_war_exploded/listPlaceBought?spectacle=" + eachSpectacle.getIdSpectacle() + "\">"
                    + "Name : " + eachSpectacle.getName()
                    + ", category : " + eachSpectacle.getCategory()
                    + ", date : " + eachSpectacle.getDate() + "</a> </li>");
        }
    %>
</ol>

</body>
</html>