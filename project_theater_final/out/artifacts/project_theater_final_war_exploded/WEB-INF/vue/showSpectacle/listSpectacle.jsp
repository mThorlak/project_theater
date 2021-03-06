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
        <li class="menu-list"><a href="http://localhost:8080/project_theater_final_war_exploded/connectRoomManager">Connect room manager</a></li>
    </ul>
</nav>
<h2>Sort type</h2>
<ol class="rectangle-list">
    <li><a href="http://localhost:8080/project_theater_final_war_exploded/listSpectacle"> List all spectacle </a></li>
    <li><a href="http://localhost:8080/project_theater_final_war_exploded/listCategories"> Lister all categories </a></li>
    <li><a href="http://localhost:8080/project_theater_final_war_exploded/listDates"> Lister all dates </a></li>
</ol>

<h2>List of spectacle</h2>
<ol class="rounded-list">
<%
    List<spectacle> spectacles = (List<spectacle>) request.getAttribute("spectacles");
    for (spectacle eachSpectacle : spectacles) {
        out.println("<li> <a href=\"http://localhost:8080/project_theater_final_war_exploded/buy?spectacle=" + eachSpectacle.getIdSpectacle() + "\">"
                + "Name : " + eachSpectacle.getName()
                + ", category : " + eachSpectacle.getCategory()
                + ", date : " + eachSpectacle.getDate() + "</a> </li>");
    }
%>
</ol>

</body>
</html>