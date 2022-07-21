<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="layout/header.jsp" />
<h3>${title}</h3>
<form action="${pageContext.request.contextPath}/cursos/form" method="post" autocomplete="off">
    <div class="row mb-2">
        <label class="col-form-label col-sm-2"  for="nombre">Nombre del curso</label>
        <div class="col-sm-4">
            <input class="form-control" type="text" id="nombre" name="nombre"
                   value="${curso.nombreCurso != null ? curso.nombreCurso : ""}"
            />
        </div>
        <c:if test="${errores != null && errores.containsKey('nombre')}">
            <div style="color:red;">
                ${errores.nombre}
            </div>
        </c:if>
    </div>
    <div class="row mb-2">
        <label class="col-form-label col-sm-2" for="instructor">Nombre del instructor</label>
        <div class="col-sm-4">
            <input class="form-control" type="text" id="instructor" name="instructor"
                   value="${curso.nombreInstructor != null ? curso.nombreInstructor : ""}"
            />
        </div>
        <c:if test="${errores != null && errores.containsKey('instructor')}">
        <div style="color:red;">
            ${errores.instructor}
        </div>
        </c:if>
    </div>
    <div class="row mb-2">
        <label class="col-form-label col-sm-2" for="duracion">Duraci&oacute;n del curso</label>
        <div class="col-sm-4">
            <input class="form-control" type="text" id="duracion"
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
    <div class="row mb-2">
        <label class="col-form-label col-sm-2" for="descripcion">Descripci&oacute;n</label>
        <div>
            <textarea class="form-control" type="text" id="descripcion" name="descripcion" style="resize: none;">
                ${curso.descripcionCurso != null ? curso.descripcionCurso : ""}
            </textarea>
        </div>
        <c:if test="${errores != null && errores.containsKey('descripcion')}">
        <div style="color:red;">
            ${errores.descripcion}
        </div>
        </c:if>
    </div>

    <div class="col-sm-4">
        <input class="btn btn-primary"  type="submit"
               value="${(curso.idCurso != null && curso.idCurso>0) ? 'Guardar': 'Crear'}"
        />
    </div>
    <input type="hidden" name="id" value="${curso.idCurso}">
</form>

<jsp:include page="layout/footer.jsp"/>