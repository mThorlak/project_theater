<%@ page import="theater_forms.connexionRoomManagerForm" %>
<%@ page import="java.io.IOException" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Connexion</title>
    <link type="text/css" rel="stylesheet" href="" />
</head>
<body>
<form method="post" action="connectRoomManager">
    <fieldset>
        <legend>Connexion Room Manager</legend>
        <p>Vous pouvez vous connecter via ce formulaire.</p>

        <label for="name">Identifiant <span class="requis">*</span></label>
        <input type="text" id="name" name="name" value="" size="20" maxlength="60" />
<%--        <span class="error">${formConnexionRoomManager.error['id']}</span>--%>
        <br />

        <label for="password">Mot de passe <span class="requis">*</span></label>
        <input type="password" id="password" name="password" value="" size="20" maxlength="20" />
        <br />

        <input type="submit" value="Connexion" class="sansLabel" />
        <br />

      <p class="${empty formConnexionRoomManager.errors ? 'succes' : 'error'}">${formConnexionRoomManager.result}</p>
        <%-- Vérification de la présence d'un objet utilisateur en session --%>
        <c:if test="${!empty sessionScope.roomManager}">
            <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
            <p class="succes">You're connected with the name : ${sessionScope.roomManager.name}</p>
        </c:if>
        <%
            try {
                connexionRoomManagerForm formConnexionRoomManager = (connexionRoomManagerForm) request.getAttribute("formConnexionRoomManager");
                if (formConnexionRoomManager != null)
                    if (formConnexionRoomManager.getErrors().isEmpty()) {
                        out.println("<li><a href=\"http://localhost:8080/project_theater_final_war_exploded/listSpectacleRoomManager\">List all pestacle, Room Manager tools</a></li>");
                    }
            } catch (IOException e) {
                e.printStackTrace();
            }

        %>
    </fieldset>
</form>
</body>
</html>