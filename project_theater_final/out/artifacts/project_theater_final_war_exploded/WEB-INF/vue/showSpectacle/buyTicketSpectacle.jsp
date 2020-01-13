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
    out.println(spectacle.toString());
%>
Combien de place voulez vous acheter ?
<form method="post" action="buy">
    <fieldset>
        <label for="place">Nombre de place</label>
        <input type="number" id="place" name="place" value="" size="20" maxlength="20" />
        <input type="submit" value="Acheter" class="sansLabel" />

        <p class="${empty buyTicketForm.error ? 'succes' : 'error'}">${buyTicketForm.result}</p>
    </fieldset>
</form>
</body>
</html>