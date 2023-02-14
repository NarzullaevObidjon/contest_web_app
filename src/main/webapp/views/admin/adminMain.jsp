<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 14/02/2023
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vertical Card Slider</title>
    <link rel="stylesheet" href="Style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
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
        <button type="button" class="w-100 m-2 btn btn-primary">Create Test</button>
        <button type="button" class="w-100 m-2 btn btn-primary">Edit User</button>
        <button type="button" class="w-100 m-2 btn btn-primary">Blocked Users</button>
    </div>
</container>
</body>
</html>
