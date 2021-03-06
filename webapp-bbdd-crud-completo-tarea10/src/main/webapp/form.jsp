
<%@ page contentType="text/html;charset=UTF-8" language="java"
import="java.util.*,org.rraya.apiservlet.webapp.bbdd.tarea10.modelos.*"%>
<%Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");
Curso curso = (Curso) request.getAttribute("curso");%>
<html>
<head>
    <title>Formulario Cursos</title>
</head>
<body>
    <h1>Formulario Cursos</h1>

    <form action="<%=request.getContextPath()%>/cursos/form" method="post" autocomplete="off">
        <div>
            <label for="nombre">Nombre del curso</label>
            <div>
                <input type="text" id="nombre" name="nombre"
                       value="<%=curso.getNombreCurso() != null ? curso.getNombreCurso() : ""%>"
                >
            </div>
            <%if(errores != null && errores.containsKey("nombre")){%>
            <div style="color:red;">
                <%=errores.get("nombre")%>
            </div>
            <%}%>
        </div>
        <div>
            <label for="instructor">Nombre del instructor</label>
            <div>
                <input type="text" id="instructor" name="instructor"
                       value="<%=curso.getNombreInstructor() != null ? curso.getNombreInstructor() : ""%>"
                >
            </div>
            <%if(errores != null && errores.containsKey("instructor")){%>
            <div style="color:red;">
                <%=errores.get("instructor")%>
            </div>
            <%}%>
        </div>
        <div>
            <label for="duracion">Duraci&oacute;n del curso</label>
            <div>
                <input type="text" id="duracion" name="duracion" value="<%=curso.getDuracion() != null ? curso.getDuracion() : ""%>">
            </div>
            <%if(errores != null){%>
            <div style="color:red;">
                <%if(errores.containsKey("duracion")){%>
                    <%=errores.get("duracion")%>
                <%}%>
                <%if(errores.containsKey("duracionTiempo")){%>
                    <%=errores.get("duracionTiempo")%>
                <%}%>
            </div>
            <%}%>
        </div>
        <div>
            <label for="descripcion">Descripci&oacute;n</label>
            <div>
                <textarea type="text" id="descripcion" name="descripcion">
                    <%=curso.getDescripcionCurso() != null ? curso.getDescripcionCurso().trim() : ""%>
                </textarea>
            </div>
            <%if(errores != null && errores.containsKey("descripcion")){%>
            <div style="color:red;">
                <%=errores.get("descripcion")%>
            </div>
            <%}%>
        </div>

        <div><input type="submit" value="<%=(curso.getIdCurso()!=null && curso.getIdCurso()>0)? "Guardar": "Crear"%>"></div>
        <input type="hidden" name="id" value="<%=curso.getIdCurso()%>">
    </form>
</body>
</html>
