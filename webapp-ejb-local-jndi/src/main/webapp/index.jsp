<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hola mundo ejb!</title>
</head>
<body>
<h2>Hola mundo ejb!</h2>
<h3>${saludo}</h3>
<h3>${saludo2}</h3>
<ul>
<c:forEach items="${listado}" var="prod">
    <li>${prod.nombre}</li>
</c:forEach>
</ul>
</body>
</html>