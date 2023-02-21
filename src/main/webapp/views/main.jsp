<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="/fragments/css.jsp"></jsp:include>
    <style>
        img.profile{
            clip-path: circle();
        }
    </style>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand">JAVABat</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="http://localhost:8080">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/contests">Contests</a>
                </li>
                <c:if test="${username.equals(\"\")}">
                    <li class="nav-item">
                        <a class="nav-link" href="http://localhost:8080/auth/login?next=http://localhost:8080">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="http://localhost:8080/auth/signUp">Sign Up</a>
                    </li>
                </c:if>
                <c:if test="${username!=null}">
                    <img class="profile" src="${photo_path}" height="30" width="30" loading="lazy">
                </c:if>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
</header>
<div>

</div>
<footer>
</footer>
<jsp:include page="/fragments/js.jsp"></jsp:include>
</body>
</html>