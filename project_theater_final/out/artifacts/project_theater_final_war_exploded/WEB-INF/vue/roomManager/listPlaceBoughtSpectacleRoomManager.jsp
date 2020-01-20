<%@ page import="java.util.List" %>
<%@ page import="ejbEntity.place" %>
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
        <li class="menu-list, active"><a href="http://localhost:8080/project_theater_final_war_exploded/listSpectacleRoomManager">List all spectacle, room manager vue</a></li>
        <li class="menu-list"><a href="http://localhost:8080/project_theater_final_war_exploded/createPestacle">Create Spectacle</a></li>
    </ul>
</nav>
<h2>Overview :</h2>
<%
    int nbPlaceBought = (int) request.getAttribute("nbPlaceBought");
    int nbPlaceAvailable = (int) request.getAttribute("nbPlaceAvailable");
    int totalReservation = (int) request.getAttribute("totalReservation");
    out.println("Number of place bought : " + nbPlaceBought);
    out.println("</br>Number of place available : " + nbPlaceAvailable);
    out.println("</br>CA actual for the spectacle : " + totalReservation + " euros");
%>
<h2>Places bought :</h2>
<ol class="rectangle-list">
    <%
        List<place> placesBought = (List<place>) request.getAttribute("placesBought");
        for (place eachPlace : placesBought) {
            out.println("<li> <a href=\" \"> Number place : " + eachPlace.getNumPlace() + ", price : " + eachPlace.getPrice() +" </a></li>");
        }
    %>
</ol>
<h2>Places available :</h2>
<ol class="rounded-list">
    <%
        List<place> placesAvailable = (List<place>) request.getAttribute("placesAvailable");
        for (place eachPlace : placesAvailable) {
            out.println("<li> <a href=\" \"> Number place : " + eachPlace.getNumPlace() + ", price : " + eachPlace.getPrice() +" </a></li>");
        }
    %>
</ol>
</body>
</html>