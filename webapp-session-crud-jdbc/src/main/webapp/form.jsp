<%@page contentType="text/html" pageEncoding="UTF-8"
import="java.util.*,java.time.format.*,org.aguzman.apiservlet.webapp.headers.models.*"%>
<%
List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");
Producto producto = (Producto) request.getAttribute("producto");
String fecha = producto.getFechaRegistro() != null?
producto.getFechaRegistro().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")): "";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario productos</title>
</head>
<body>
<h1>Formulario productos</h1>
<form action="<%=request.getContextPath()%>/productos/form" method="post">
    <div>
        <label for="nombre">Nombre</label>
        <div>
            <input type="text" name="nombre" id="nombre" value="<%=producto.getNombre() != null? producto.getNombre(): ""%>">
        </div>
        <% if(errores != null && errores.containsKey("nombre")){%>
             <div style="color:red;"><%=errores.get("nombre")%></div>
        <% } %>
    </div>

    <div>
        <label for="precio">Precio</label>
        <div>
            <input type="number" name="precio" id="precio" value="<%=producto.getPrecio()!=0? producto.getPrecio():""%>">
        </div>
        <% if(errores != null && errores.containsKey("precio")){%>
                     <div style="color:red;"><%=errores.get("precio")%></div>
                <% } %>
    </div>

    <div>
        <label for="sku">Sku</label>
        <div>
            <input type="text" name="sku" id="sku" value="<%=producto.getSku()!=null? producto.getSku():""%>">
        </div>
        <% if(errores != null && errores.containsKey("sku")){%>
                     <div style="color:red;"><%=errores.get("sku")%></div>
                <% } %>
    </div>

    <div>
        <label for="fecha_registro">Fecha Registro</label>
        <div>
            <input type="date" name="fecha_registro" id="fecha_registro" value="<%=fecha%>">
        </div>
        <% if(errores != null && errores.containsKey("fecha_registro")){%>
                     <div style="color:red;"><%=errores.get("fecha_registro")%></div>
                <% } %>
    </div>

    <div>
        <label for="categoria">Categoria</label>
        <div>
            <select name="categoria" id="categoria">
                <option value="">--- seleccionar ---</option>
                <% for(Categoria c: categorias){%>
                <option value="<%=c.getId()%>" <%=c.getId().equals(producto.getCategoria().getId())? "selected": ""%>><%=c.getNombre()%></option>
                <%}%>
            </select>
        </div>
        <% if(errores != null && errores.containsKey("categoria")){%>
                     <div style="color:red;"><%=errores.get("categoria")%></div>
                <% } %>
    </div>

    <div><input type="submit" value="<%=(producto.getId()!=null && producto.getId()>0)? "Editar": "Crear"%>"></div>
    <input type="hidden" name="id" value="<%=producto.getId()%>">
</form>
</body>
</html>