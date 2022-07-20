<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="layout/header.jsp" />

<h3>${title}</h3>

<form action="${pageContext.request.contextPath}/login" method="post">
  <div class="row my-2">
    <label for="username" class="form-label">Username</label>
    <div>
      <input type="text" name="username" id="username" class="form-control">
    </div>
  </div>
  <div class="row my-2">
    <label for="password" class="form-label">Password</label>
    <div>
      <input type="password" name="password" id="password" class="form-control">
    </div>
  </div>
  <div class="row my-2">
    <input type="submit" value="Login" class="btn btn-primary">
  </div>
</form>

<jsp:include page="layout/footer.jsp" />
