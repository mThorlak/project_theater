<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Creation</title>
    <link type="text/css" rel="stylesheet" href="" />
</head>
<body>
<form method="post" action="createPestacle">
    <fieldset>
        <legend>Création d'un pestacle</legend>
        <p>Vous pouvez créer un pestacle via ce formulaire.</p>

        <label for="name">Nom du pestacle <span class="requis">*</span></label>
        <input type="text" id="name" name="name" value="" size="20" maxlength="60" />
        <br />

        <label for="category">Catégorie <span class="requis">*</span></label>
        <input type="text" id="category" name="category" value="" size="20" maxlength="60" />
        <br />

        <label for="date">Date <span class="requis">*</span></label>
        <input type="text" id="date" name="date" value="" size="20" maxlength="60" />
        <br />

        <input type="submit" value="Créer" class="sansLabel" />
        <br />

        <p class="${empty formPestacle.error ? 'succes' : 'error'}">${formPestacle.result}</p>

    </fieldset>
</form>
</body>
</html>