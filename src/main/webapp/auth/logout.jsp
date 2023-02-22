<%--
  Created by IntelliJ IDEA.
  User: hphphp
  Date: 2/22/2023
  Time: 1:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Home Page</title>
  <jsp:include page="/resources/fragments/css.jsp"/>
</head>
<body>

<div class="container mt-5">
  <div class="row">
    <div class="col-md-6 offset-3">
      <h1>Logout</h1>
      <form action="/auth/logout" method="post">
        <div class="alert alert-danger">
          Are you sure sing out ?
        </div>
        <button type="submit" class="btn btn-danger">Yes</button>
        <a href="/book/list" class="btn btn-warning">Back</a>
      </form>
    </div>
  </div>
</div>

<jsp:include page="/resources/fragments/js.jsp"/>
</body>
</html>
</html>
