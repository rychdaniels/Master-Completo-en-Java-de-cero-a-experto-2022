<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Formulario Cursos</title>
</head>
<body>
    <h1>Formulario Cursos</h1>

    <form action="${pageContext.request.contextPath}/cursos/form" method="post" autocomplete="off">
        <div>
            <label for="nombre">Nombre del curso</label>
            <div>
                <input type="text" id="nombre" name="nombre"
                       value="${curso.nombreCurso != null ? curso.nombreCurso : ""}"
                />
            </div>
            <c:if test="${errores != null && errores.containsKey('nombre')}">
            <div style="color:red;">
                ${errores.nombre}
            </div>
        </c:if>
        </div>
        <div>
            <label for="instructor">Nombre del instructor</label>
            <div>
                <input type="text" id="instructor" name="instructor"
                       value="${curso.nombreInstructor != null ? curso.nombreInstructor : ""}"
                />
            </div>
            <c:if test="${errores != null && errores.containsKey('instructor')}">
            <div style="color:red;">
                ${errores.instructor}
            </div>
            </c:if>
        </div>
        <div>
            <label for="duracion">Duraci&oacute;n del curso</label>
            <div>
                <input type="text" id="duracion"
                       name="duracion"
                       value="${curso.duracion != null ? curso.duracion : ""}">
            </div>
            <c:if test="${errores != null}">
                <div style="color:red;">
                    <c:if test="${errores.containsKey('duracion')}">
                        ${errores.duracion}
                    </c:if>
                    <c:if test="${errores.containsKey('duracionTiempo')}">
                        ${errores.duracionTiempo}
                    </c:if>
                </div>
            </c:if>
        </div>
        <div>
            <label for="descripcion">Descripci&oacute;n</label>
            <div>
                <textarea type="text" id="descripcion" name="descripcion">
                    ${curso.descripcionCurso != null ? curso.descripcionCurso : ""}
                </textarea>
            </div>
            <c:if test="${errores != null && errores.containsKey('descripcion')}">
            <div style="color:red;">
                ${errores.descripcion}
            </div>
            </c:if>
        </div>

        <div>
            <input type="submit"
                   value="${(curso.idCurso != null && curso.idCurso>0) ? 'Guardar': 'Crear'}"
            />
        </div>
        <input type="hidden" name="id" value="${curso.idCurso}">
    </form>
</body>
</html>
