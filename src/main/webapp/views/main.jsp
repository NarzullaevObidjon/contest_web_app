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
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
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
                <li class="nav-item dropdown bl">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        Register
                    </a>
                    <ul class="dropdown-menu">
                        <li class="nav-item">
                            <a class="nav-link" href="/auth/login" style="color: black">Login</a>
                        </li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/auth/signup" style="color: black">Sign Up</a>
                        </li>
                    </ul>
                    </c:if>
                    <c:if test="${username!=null}">
                <li class="nav-item dropdown bl">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        Logged in
                    </a>
                    <ul class="dropdown-menu">
                        <li class="nav-item">
                            <a class="nav-link" href="/profile/${username}" style="color: black">Profile</a>
                        </li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/auth/logout" style="color: black">Log Out</a>
                        </li>
                    </ul>
                    </c:if>
            </ul>
            <form class="d-flex" role="search" action="/profile">
                <input name="profile" class="form-control me-2" type="search" placeholder="Jump to ..."
                       aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </nav>
</header>
<jsp:include page="/resources/fragments/js.jsp"></jsp:include>
</body>
</html>