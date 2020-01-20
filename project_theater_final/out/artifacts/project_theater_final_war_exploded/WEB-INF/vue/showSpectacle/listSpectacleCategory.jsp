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
<nav class="menu-list">
    <ul class="menu-list">
        <li class="menu-list"><a href="http://localhost:8080/project_theater_final_war_exploded/">Homepage</a></li>
        <li class="menu-list, active"><a href="http://localhost:8080/project_theater_final_war_exploded/listSpectacle">List spectacle</a></li>
        <li class="menu-list"><a href="http://localhost:8080/project_theater_final_war_exploded/createRoomManager">Create roomManager</a></li>
        <li class="menu-list"><a href="http://localhost:8080/project_theater_final_war_exploded/connectRoomManager">Connect room manager</a></li>
    </ul>
</nav>
<h2>Sort type</h2>
<ol class="rectangle-list">
    <li><a href="http://localhost:8080/project_theater_final_war_exploded/listSpectacle"> List all spectacle </a></li>
    <li><a href="http://localhost:8080/project_theater_final_war_exploded/listCategories"> Lister all categories </a></li>
    <li><a href="http://localhost:8080/project_theater_final_war_exploded/listDates"> Lister all dates </a></li>
</ol>
<%
    List<spectacle> spectacles = (List<spectacle>) request.getAttribute("spectacles");
    out.println("<h2>List spectacle for category : " + spectacles.get(0).getCategory() + "</h2>");
    for (spectacle eachSpectacle : spectacles) {
        out.println("<li> <a href=\"http://localhost:8080/project_theater_final_war_exploded/buy?spectacle=" + eachSpectacle.getIdSpectacle() + "\">" + eachSpectacle.toString() + "</a> </li>");
    }
%>

</body>
</html>