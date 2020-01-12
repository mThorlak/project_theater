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
<%
    spectacle spectacle = (spectacle) request.getAttribute("spectacle");
    out.println(spectacle.toString());
%>
</ul>
</body>
</html>