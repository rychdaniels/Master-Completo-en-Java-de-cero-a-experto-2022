
<%@ page contentType="text/html;charset=UTF-8" language="java"
        import="java.util.*, org.rraya.apiservlet.webapp.bbdd.tarea10.modelos.*"%>

<%
    List<Curso> cursos = (List<Curso>) request.getAttribute("cursos");
    String titulo = (String) request.getAttribute("titulo");
%>
<html>
<head>
    <title><%=titulo%></title>
</head>
<body>
    <h1><%=titulo%></h1>
    <br>
    <p><a href="<%=request.getContextPath()%>/cursos/form">crear [+]</a></p>
    <form action="<%=request.getContextPath()%>/cursos/buscar" method="post">
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

        <%for(Curso curso: cursos ) {%>
        <tr>
            <th><%=curso.getIdCurso()%></th>
            <th><%=curso.getNombreCurso()%></th>
            <th><%=curso.getNombreInstructor()%></th>
            <th><%=curso.getDuracion()%> hrs.</th>
            <th><a href="/cursos/form?id=<%=curso.getIdCurso()%>">Editar</a></th>
            <th><a onclick="return confirm('esta seguro que desea eliminar?');"
                   href="<%=request.getContextPath()%>/cursos/eliminar?id=<%=curso.getIdCurso()%>">Eliminar</a></th>
        </tr>
        <%}%>

    </table>
</body>
</html>
