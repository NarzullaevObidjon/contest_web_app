<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 14/02/2023
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vertical Card Slider</title>
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/mainAdminStyle.css" rel="stylesheet">
</head>
<body>
<header class="d-flex flex-wrap justify-content-around fixed-top bg-light align-items-center bg-light">
    <div class="d-flex col-md-3 p-2">Java</div>

    <div class="d-flex col-md-3 p-2">
        <button type="button" class="btn btn-outline-primary me-2">Login</button>
        <button type="button" class="btn btn-primary">Sign-up</button>
    </div>
</header>
<div class="d-flex  justify-content-around align-items-center">
    <div class="col-md-auto w-100 d-flex flex-column justify-content-around align-items-center">
        <a href="/views/admin/createTest.jsp" type="button" class="w-100 m-2 btn btn-primary">Create Test</a>
        <a href="/views/admin/editUser.jsp" type="button" class="w-100 m-2 btn btn-primary">Edit User</a>
        <a href="/views/admin/blockUsers.jsp" type="button" class="w-100 m-2 btn btn-primary">Blocked Users</a>
    </div>
</div>


</body>
</html>
