<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main menu</title>
    <jsp:include page="/resources/fragments/css.jsp"></jsp:include>
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
                <li class="nav-item">
                    <a class="nav-link" href="/profile/${username}">Profile</a>
                </li>
            </ul>
        </div>
    </nav>
</header>
<jsp:include page="/resources/fragments/js.jsp"></jsp:include>
</body>
</html>