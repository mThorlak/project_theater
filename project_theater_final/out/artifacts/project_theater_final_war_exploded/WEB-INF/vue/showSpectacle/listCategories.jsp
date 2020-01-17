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
<h1>List spectacle : </h1>
<ul>
    <li><a href="http://localhost:8080/project_theater_final_war_exploded/listSpectacle"> List all spectacle </a></li>
    <li><a href="http://localhost:8080/project_theater_final_war_exploded/listCategories"> Lister all categories </a></li>
    <li><a href="http://localhost:8080/project_theater_final_war_exploded/listDates"> Lister all dates </a></li>
</ul>
        <%
            List<spectacle> categories = (List<spectacle>) request.getAttribute("categories");
            for (int i = 0; i < categories.size(); i++) {
                out.println("<li> <a href=\"http://localhost:8080/project_theater_final_war_exploded/listSpectacleByCategory?category=" + categories.get(i) + "\">" + categories.get(i) + "</a> </li>");
            }
        %>

</body>
</html>