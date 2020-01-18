<%@ page import="java.util.List" %>
<%@ page import="ejbEntity.place" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>List spectacle</title>
    <link type="text/css" rel="stylesheet" href="" />
</head>
<body>
<%--<ul>
    <li><a href="http://localhost:8080/project_theater_final_war_exploded/listSpectacle"> List all spectacle </a></li>
    <li><a href="http://localhost:8080/project_theater_final_war_exploded/listCategories"> Lister all categories </a></li>
    <li><a href="http://localhost:8080/project_theater_final_war_exploded/listDates"> Lister all dates </a></li>
</ul>--%>
<h1>Overview :</h1>
<%
    int nbPlaceBought = (int) request.getAttribute("nbPlaceBought");
    int nbPlaceAvailable = (int) request.getAttribute("nbPlaceAvailable");
    int totalReservation = (int) request.getAttribute("totalReservation");
    out.println("Number of place bought : " + nbPlaceBought);
    out.println("- Number of place available : " + nbPlaceAvailable);
    out.println("- CA actual for the spectacle : " + totalReservation + " euros");
%>
<h1>Places bought :</h1>
<ul>
    <%
        List<place> placesBought = (List<place>) request.getAttribute("placesBought");
        for (place eachPlace : placesBought) {
            out.println("<li>N° place :" + eachPlace.getNumPlace() + ", price : " + eachPlace.getPrice() +"</li>");
        }
    %>
</ul>
<h1>Places available :</h1>
<ul>
    <%
        List<place> placesAvailable = (List<place>) request.getAttribute("placesAvailable");
        for (place eachPlace : placesAvailable) {
            out.println("<li>N° place :" + eachPlace.getNumPlace() + ", price : " + eachPlace.getPrice() +"</li>");
        }
    %>
</ul>
</body>
</html>