<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Creation</title>
    <link type="text/css" rel="stylesheet" href="CSS-Directory/formStyle.css" />
    <link type="text/css" rel="stylesheet" href="CSS-Directory/menu.css" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300' rel='stylesheet' type='text/css'>
</head>
<body>
<nav class="menu-list">
    <ul class="menu-list">
        <li class="menu-list"><a href="http://localhost:8080/project_theater_final_war_exploded/">Homepage</a></li>
        <li class="menu-list"><a href="http://localhost:8080/project_theater_final_war_exploded/listSpectacle">List spectacle</a></li>
        <li class="menu-list, active"><a href="http://localhost:8080/project_theater_final_war_exploded/createRoomManager">Create roomManager</a></li>
        <li class="menu-list"><a href="http://localhost:8080/project_theater_final_war_exploded/connectRoomManager">Connect room manager</a></li>
    </ul>
</nav>
<div class="form-style-8">
    <form method="post" action="createRoomManager">
        <h2>Création gestionnaire de salle</h2>

        <label for="name">Nom <span class="requis"></span></label>
        <input type="text" id="name" name="name" value="" size="20" maxlength="60" />
        <br />

        <label for="password">Mot de passe <span class="requis"></span></label>
        <input type="password" id="password" name="password" value="" size="20" maxlength="60" />
        <br />

        <input type="submit" value="Créer" class="sansLabel" />
        <br />

        <p class="${empty createRoomManagerForm.error ? 'succes' : 'error'}">${createRoomManagerForm.result}</p>
    </form>
</div>
</body>
</html>