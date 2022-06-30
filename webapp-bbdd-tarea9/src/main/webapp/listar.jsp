
<%@ page contentType="text/html;charset=UTF-8" language="java"
        import="java.util.*, org.rraya.apiservlet.webapp.bbdd.tarea9.modelos.*"%>

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
        </tr>

        <%for(Curso curso: cursos ) {%>
        <tr>
            <th><%=curso.getIdCurso()%></th>
            <th><%=curso.getNombreCurso()%></th>
            <th><%=curso.getNombreInstructor()%></th>
            <th><%=curso.getDuracion()%> hrs.</th>
        </tr>
        <%}%>

    </table>
</body>
</html>
