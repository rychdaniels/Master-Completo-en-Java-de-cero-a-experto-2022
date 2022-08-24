<jsp:include page="layout/header.jsp" />

<h3>${title}</h3>

<ul class="list-group">
    <li class="list-group-item active">Menu de opciones</li>
    <li class="list-group-item"><a href="${pageContext.request.contextPath}/productos">mostrar productos html</a></li>
    <li class="list-group-item"><a href="${pageContext.request.contextPath}/login.html">login</a></li>
    <li class="list-group-item"><a href="${pageContext.request.contextPath}/logout">logout</a></li>
    <li class="list-group-item"><a href="${pageContext.request.contextPath}/carro/ver">ver carro</a></li>
</ul>

<jsp:include page="layout/footer.jsp" />
