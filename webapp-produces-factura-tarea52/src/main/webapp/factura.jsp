<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${title}</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <div class="mt-5 mb-5">
        <h3>${title}</h3>
    </div>
    <table class="table table-striped mt-5 mb-5">
        <tr style="font-weight: bold">
            <th >Factura No.</th>
            <th>Descripci&oacute;n</th>
            <th>Cliente</th>
        </tr>
        <tr>
            <th>${factura.numeroFactura}</th>
            <th>${factura.descripcion}</th>
            <th>${factura.cliente.nombre} ${factura.cliente.apellidos}</th>
        </tr>
    </table>

    <table class="table table-striped">
            <tr>
                <th>Producto</th>
                <th>Precio</th>
                <th>Cantidad</th>
                <th>Total</th>

            </tr>

            <c:forEach items="${factura.lineaFacturas}" var="linea" >
                <tr>
                    <th>${linea.nombreProducto}</th>
                    <th>$ ${linea.precio}.00</th>
                    <th>${linea.cantidad} pzas.</th>
                    <th>$${linea.importePorArticulo}</th>
                </tr>
            </c:forEach>

        <tr>
            <th></th>
            <th></th>
            <th>Total</th>
            <th>$${factura.importeTotal}</th>
        </tr>

        </table>
    </div>
</body>
</html>
