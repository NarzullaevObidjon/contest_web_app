<%--
  Created by IntelliJ IDEA.
  User: hnodir
  Date: 16/02/23
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vertical Card Slider</title>
    <jsp:include page="/fragments/css.jsp"/>
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>

<header class="d-flex flex-wrap justify-content-around fixed-top bg-light align-items-center bg-light">
    <div class="d-flex col-md-3 p-2">Java</div>

    <div class="d-flex col-md-3 p-2">
        <button type="button" class="btn btn-outline-primary me-2">Login</button>
        <button type="button" class="btn btn-primary">Sign-up</button>
    </div>
</header>

<container class="d-flex  justify-content-around align-items-center">
    <div class="col-md-auto w-100 d-flex flex-column justify-content-around align-items-center">
        <a type="button" class="w-100 m-2 btn btn-primary">Create Test</a>
        <a type="button" href="admin/users" class="w-100 m-2 btn btn-primary">Edit User</a>
        <a type="button" href="/admin/usersBlocked" class="w-100 m-2 btn btn-primary">Blocked Users</a>
    </div>
</container>
</body>
<jsp:include page="/fragments/js.jsp"/>
</html>
