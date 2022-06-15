<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nombre en sesion</title>
</head>
<body>
    <h3>Nombre en sesion</h3>

    <p>Hola <%=session.getAttribute("nombre") != null? session.getAttribute("nombre"): "anónimo"%>, bienvenido a la tarea5.</p>

    <form action="/webapp-session-tarea5/guardar-session" method="post">

        <div>
            <label for="nombre">Nombre</label>
            <input type="text" placeholder="Nombre" name="nombre" id="nombre">
        </div>

        <div><button type="submit">Guardar</button></div>
    </form>

</body>
</html>
