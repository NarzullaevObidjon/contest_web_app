<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
    <title>Vertical Card Slider</title>
    <jsp:include page="/resources/fragments/css.jsp"/>
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand">JAVABat</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="http://localhost:8080">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/contests">Contests</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/contest-live">Live Contest</a>
                </li>
                <c:if test="${username==null}">
                    <li class="nav-item">
                        <a class="nav-link" href="http://localhost:8080/auth/login?next=http://localhost:8080">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="http://localhost:8080/auth/signup">Sign Up</a>
                    </li>
                </c:if>
                <c:if test="${username!=null}">
                    <li class="nav-item">
                        <a class="nav-link"href="http://localhost:8080/auth/logout">Log Out</a>
                    </li>
                </c:if>
            </ul>
        </div>
    </nav>
</header>

<container class="d-flex  justify-content-around align-items-center">
    <div class="col-md-auto w-100 d-flex flex-column justify-content-around align-items-center">
        <a type="button" class="w-100 m-2 btn btn-primary">Create Test</a>
        <a type="button" href="admin/users" class="w-100 m-2 btn btn-primary">Edit User</a>
        <a type="button" href="/admin/usersBlocked" class="w-100 m-2 btn btn-primary">Blocked Users</a>
    </div>
</container>
<jsp:include page="/resources/fragments/js.jsp"/>
</body>
</html>
