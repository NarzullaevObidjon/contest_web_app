<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hnodir
  Date: 16/02/23
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        Edit User
    </title>
    <link rel="stylesheet" href="/resources/css/admin/users.css">
    <jsp:include page="/resources/fragments/css.jsp"/>
    <script src="jquery-3.6.3.min.js"></script>
</head>
<body>
<nav class="navbar bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand">Java</a>
        <div class="d-flex col-md-3 p-2">
            <button type="button" class="btn btn-outline-primary me-2">Login</button>
            <button type="button" class="btn btn-primary">Sign-up</button>
        </div>
    </div>
</nav>
<container class="d-flex justify-content-around align-items-center">
    <c:if test="${user_error != null}">
        <span class="small text-danger"><c:out value="${user_error}"></c:out></span>
    </c:if>
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Username</th>
        <th scope="col">Status</th>
        <th scope="col">Role</th>
        <th scope="col">Edit</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user" varStatus="status">
    <tr>
        <th scope="row">${status.index+1}</th>
        <td>${user.getUsername()}</td>
        <td><button type="button" class="btn btn-secondary" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="${user.getBlockCause()}">${user.getStatus()}</button></td>
        <td>
            ${user.getRole()}
<%--            <c:choose>--%>
<%--                <c:when test="${user.getRole() == 'ADMIN'}}">--%>
<%--                    --%>
<%--                </c:when>--%>
<%--                <c:otherwise>--%>
<%--                    <label class="switch">--%>
<%--                        <input type="checkbox">--%>
<%--                        <span class="slider round"></span>--%>
<%--                    </label>--%>
<%--                </c:otherwise>--%>
<%--            </c:choose>--%>
        </td>
        <td>
            <a href="/admin/usersBlocked/edit?userId=<c:out value="${user.getId()}"/>"><img src="/resources/images/edit_icon.png" width="25px" height="25px"></a>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</container>
<jsp:include page="/resources/fragments/js.jsp"/>
</body>
</html>