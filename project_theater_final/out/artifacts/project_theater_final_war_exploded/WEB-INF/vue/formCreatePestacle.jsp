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
        <li class="menu-list"><a href="http://localhost:8080/project_theater_final_war_exploded/listSpectacleRoomManager">List all spectacle, room manager vue</a></li>
        <li class="menu-list, active"><a href="http://localhost:8080/project_theater_final_war_exploded/createPestacle">Create Spectacle</a></li>
    </ul>
</nav>
<div class="form-style-8">
    <form method="post" action="createPestacle">
        <h2>Create a spectacle</h2>

        <label for="name">Spectacle name<span class="requis">*</span></label>
        <input type="text" id="name" name="name" value="" size="20" maxlength="60" />
        <br />

        <label for="category">Category <span class="requis">*</span></label>
        <input type="text" id="category" name="category" value="" size="20" maxlength="60" />
        <br />

        <label for="date">Date <span class="requis">*</span></label>
        <input type="text" id="date" name="date" value="" size="20" maxlength="60" />
        <br />

        <input type="submit" value="Create" class="sansLabel" />
        <br />

        <p class="${empty formPestacle.error ? 'succes' : 'error'}">${formPestacle.result}</p>

    </form>
</div>
</body>
</html>