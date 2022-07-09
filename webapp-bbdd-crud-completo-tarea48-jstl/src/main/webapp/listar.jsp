<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>${titulo}</title>
</head>
<body>
    <h1>${titulo}</h1>
    <br>
    <p><a href="${pageContext.request.contextPath}/cursos/form">crear [+]</a></p>
    <form action="${pageContext.request.contextPath}/cursos/buscar" method="post">
        <input type="text" name="nombre">
        <input type="submit" value="Buscar">
    </form>
    <table>
        <tr>
            <th>id</th>
            <th>Nombre</th>
            <th>Instructor</th>
            <th>Duracion</th>
            <th>Editar</th>
            <th>Eliminar</th>

        </tr>

        <c:forEach items="${cursos}" var="curso">
            <tr>
                <th>${curso.idCurso}</th>
                <th>${curso.nombreCurso}</th>
                <th>${curso.nombreInstructor}</th>
                <th>${curso.duracion} hrs.</th>
                <th><a href="${pageContext.request.contextPath}/cursos/form?id=${curso.idCurso}">Editar</a></th>
                <th><a onclick="return confirm('esta seguro que desea eliminar?');"
                       href="${pageContext.request.contextPath}/cursos/eliminar?id=${curso.idCurso}">Eliminar</a></th>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
