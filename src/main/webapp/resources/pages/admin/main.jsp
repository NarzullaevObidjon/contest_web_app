<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Vertical Card Slider</title>
    <jsp:include page="/resources/fragments/css.jsp"/>
    <jsp:include page="/views/main.jsp"/>
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>

<container class="d-flex  justify-content-around align-items-center">
    <div class="col-md-auto w-100 d-flex flex-column justify-content-around align-items-center">
        <a type="button" href="/admin/createcontest" class="w-100 m-2 btn btn-primary">Create Test</a>
        <a type="button" href="admin/users" class="w-100 m-2 btn btn-primary">Edit User</a>
        <a type="button" href="/admin/usersBlocked" class="w-100 m-2 btn btn-primary">Blocked Users</a>
    </div>
</container>
<jsp:include page="/resources/fragments/js.jsp"/>
</body>
</html>
