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
<%
    spectacle spectacle = (spectacle) request.getAttribute("spectacle");
    int nbPlaceAvailable = (int) request.getAttribute("nbPlaceAvailable");
    int nbPlacePrice55 = (int) request.getAttribute("nbPlacePrice55");
    int nbPlacePrice40 = (int) request.getAttribute("nbPlacePrice40");
    int nbPlacePrice20 = (int) request.getAttribute("nbPlacePrice20");
    out.println("Nom : " + spectacle.getName() + ", category : " + spectacle.getCategory() + ", date :" + spectacle.getDate());
    out.println("<br/>Number places available : " + nbPlaceAvailable);
%>
<table>
    <tr>
        <td>Price in euros</td>
        <td>Places available</td>
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
<h1>Combien de place voulez vous acheter ? </h1>
<form method="post" action="buy">
    <fieldset>
        <label for="price"></label>
        <select name="price" id="price">
            <option value="20">20 euros</option>
            <option value="40">40 euros</option>
            <option value="55">55 euros</option>
        </select>
        <label for="place">Nombre de place</label>
        <input type="number" id="place" name="place" value="" size="20" maxlength="20" />
        <input type="submit" value="Acheter" class="sansLabel" />

        <p class="${empty buyTicketForm.error ? 'succes' : 'error'}">${buyTicketForm.result}</p>
    </fieldset>
</form>
</body>
</html>