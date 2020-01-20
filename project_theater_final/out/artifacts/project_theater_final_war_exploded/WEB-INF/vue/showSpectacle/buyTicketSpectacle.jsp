<%@ page import="ejbEntity.spectacle" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>List spectacle</title>
    <link type="text/css" rel="stylesheet" href="CSS-Directory/formStyle.css" />
    <link type="text/css" rel="stylesheet" href="CSS-Directory/menu.css" />
    <link type="text/css" rel="stylesheet" href="CSS-Directory/tableStyle.css" />
</head>
<body>
<nav class="menu-list">
    <ul class="menu-list">
        <li class="menu-list"><a href="http://localhost:8080/project_theater_final_war_exploded/">Homepage</a></li>
        <li class="menu-list, active"><a href="http://localhost:8080/project_theater_final_war_exploded/listSpectacle">List spectacle</a></li>
        <li class="menu-list"><a href="http://localhost:8080/project_theater_final_war_exploded/connectRoomManager">Connect room manager</a></li>
    </ul>
</nav>
<%
    spectacle spectacle = (spectacle) request.getAttribute("spectacle");
    int nbPlaceAvailable = (int) request.getAttribute("nbPlaceAvailable");
    int nbPlacePrice55 = (int) request.getAttribute("nbPlacePrice55");
    int nbPlacePrice40 = (int) request.getAttribute("nbPlacePrice40");
    int nbPlacePrice20 = (int) request.getAttribute("nbPlacePrice20");
    out.println("Name : " + spectacle.getName() + "</br>category : " + spectacle.getCategory() + "</br>date :" + spectacle.getDate());
    out.println("<br/>Number places available : " + nbPlaceAvailable);
%>
<h1>Table of place available</h1>
<table class="rwd-table">
    <tr>
        <td class="title">Price in euros</td>
        <td class="title">Places available</td>
    </tr>
    <tr>
        <td>20</td>
        <td><% out.println(nbPlacePrice20); %></td>
    </tr>
    <tr>
        <td>40</td>
        <td><% out.println(nbPlacePrice40); %></td>
    </tr>
    <tr>
        <td>55</td>
        <td><% out.println(nbPlacePrice55); %></td>
    </tr>
</table>
<br/>

<div class="form-style-8">
    <form method="post" action="buy">
        <h2>Wow many places did you want ?</h2>
        <label for="price">Place category</label>
        <select name="price" id="price">
            <option value="20">20 euros</option>
            <option value="40">40 euros</option>
            <option value="55">55 euros</option>
        </select>
        <label for="place">Number of place</label>
        <input type="number" id="place" name="place" value="" size="20" maxlength="20" />
        <input type="submit" value="Acheter" class="sansLabel" />

        <p class="${empty buyTicketForm.error ? 'succes' : 'error'}">${buyTicketForm.result}</p>
    </form>
</div>
</body>
</html>