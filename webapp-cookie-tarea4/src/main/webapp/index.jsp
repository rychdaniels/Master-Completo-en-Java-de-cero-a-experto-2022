<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cambia color</title>
</head>
<body>
    <h3 style="color: ${cookie.color.getValue()}">Tarea 4: cambiar el color de los textos</h3>
    <p style="color: ${cookie.color.getValue()}">Parrafo que cambia de color</p>
    <form action="/webapp-cookie-tarea4/cambiar-color" method="get">

        <select name="color" id="color">
            <option value="blue">Azul</option>
            <option value="red">Rojo</option>
            <option value="green">Verde</option>
            <option value="aqua">Aqua</option>
            <option value="BlueViolet">Violeta</option>
            <option value="Gray">Gris</option>
            <option value="Cyan">Cyan</option>
        </select>
        <button type="submit">Cambiar</button>
    </form>
</body>
</html>