<%--
  Created by IntelliJ IDEA.
  User: Muhammadjon
  Date: 21.02.2023
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${user.getUsername()}</title>
    <jsp:include page="/resources/fragments/css.jsp"/>

    <style>
        /* Import Font Dancing Script */
        @import url(https://fonts.googleapis.com/css?family=Dancing+Script);

        * {
            margin: 0;
        }

        body {
            background-color: #e8f5ff;
            font-family: Arial;
            overflow-y:scroll;
            position:relative;
        }

        /* NavbarTop */
        .navbar-top {
            background-color: #fff;
            color: #333;
            box-shadow: 0px 4px 8px 0px grey;
            height: 70px;
        }

        .title {
            font-family: 'Dancing Script', cursive;
            padding-top: 15px;
            position: absolute;
            left: 45%;
        }

        .navbar-top ul {
            float: right;
            list-style-type: none;
            margin: 0;
            overflow: hidden;
            padding: 18px 50px 0 40px;
        }

        .navbar-top ul li {
            float: left;
        }

        .navbar-top ul li a {
            color: #333;
            padding: 14px 16px;
            text-align: center;
            text-decoration: none;
        }

        .icon-count {
            background-color: #ff0000;
            color: #fff;
            float: right;
            font-size: 11px;
            left: -25px;
            padding: 2px;
            position: relative;
        }

        /* End */

        /* Sidenav */
        .sidenav {
            background-color: #fff;
            background-attachment: fixed;
            color: #333;
            border-bottom-right-radius: 25px;
            height: 86%;
            left: 0;
            overflow-x: hidden;
            padding-top: 20px;
            position: absolute;
            top: 70px;
            width: 250px;
        }

        .profile {
            margin-bottom: 20px;
            margin-top: -12px;
            text-align: center;
        }

        .profile img {
            border-radius: 50%;
            box-shadow: 0px 0px 5px 1px grey;
        }

        .name {
            font-size: 20px;
            font-weight: bold;
            padding-top: 20px;
        }

        .job {
            font-size: 16px;
            font-weight: bold;
            padding-top: 10px;
        }

        .url, hr {
            text-align: center;
        }

        .url hr {
            margin-left: 20%;
            width: 60%;
        }

        .url a {
            color: #818181;
            display: block;
            font-size: 20px;
            margin: 10px 0;
            padding: 6px 8px;
            text-decoration: none;
        }

        .url a:hover, .url .active {
            background-color: #e8f5ff;
            border-radius: 28px;
            color: #000;
            margin-left: 14%;
            width: 65%;
        }

        /* End */

        /* Main */
        .main {
            margin-top: 2%;
            margin-left: 29%;
            font-size: 28px;
            padding: 0 10px;
            width: 58%;
            /*height: 1000px;*/
        }

        .main h2 {
            color: #333;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            font-size: 24px;
            margin-bottom: 10px;
        }

        .main .card {
            background-color: #fff;
            border-radius: 18px;
            box-shadow: 1px 1px 8px 0 grey;
            height: auto;
            margin-bottom: 20px;
            padding: 20px 0 20px 50px;
        }

        .main .card table {
            border: none;
            height: auto;
            font-size: 16px;
            width: 80%;
        }

        .edit {
            position: absolute;
            color: #e7e7e8;
            right: 14%;
        }

        .social-media {
            text-align: center;
            width: 90%;
        }

        .social-media span {
            margin: 0 10px;
        }

        .fa-facebook:hover {
            color: #4267b3 !important;
        }

        .fa-twitter:hover {
            color: #1da1f2 !important;
        }

        .fa-instagram:hover {
            color: #ce2b94 !important;
        }

        .fa-invision:hover {
            color: #f83263 !important;
        }

        .fa-github:hover {
            color: #161414 !important;
        }

        .fa-whatsapp:hover {
            color: #25d366 !important;
        }

        .fa-snapchat:hover {
            color: #fffb01 !important;
        }

        /* End */
    </style>
</head>
<body>
<!-- Navbar top -->
<div class="navbar-top">
    <div class="title">
        <h1>Profile</h1>
    </div>

    <!-- Navbar -->
    <ul>
        <li>
            <a>
                <i class="fa fa-envelope fa-2x"></i>
            </a>
        </li>
        <li>
            <a>
                <i class="fa fa-bell fa-2x"></i>
            </a>
        </li>
        <li>
            <a>
                <i class="fa fa-sign-out-alt fa-2x"></i>
            </a>
        </li>
    </ul>
    <!-- End -->
</div>
<!-- End -->

<!-- Sidenav -->
<div class="sidenav">
    <div class="profile">
        <img src="/resources/images/ava.png" alt="" width="100" height="100">

        <div class="name">
            ${user.getUsername()}
        </div>
        <div class="job">
            ${user.getFirstName()} ${user.getLastName()}
        </div>
    </div>

    <div class="sidenav-url">
        <div class="url">
            <a class="active">Profile</a>
            <hr align="center">
        </div>
        <c:if test="${user.getUsername().equals(username1)}">
            <div class="url">
                <a href="/profile/update/${user.getUsername()}">Update</a>
                <hr align="center">
            </div>
        </c:if>
    </div>
</div>
<!-- End -->

<!-- Main -->
<div class="main">
    <h2>IDENTITY</h2>
    <div class="card">
        <div class="card-body">
            <i class="fa fa-pen fa-xs edit"></i>
            <table>
                <tbody>
                <tr>
                    <td>Username</td>
                    <td>:</td>
                    <td>${user.getUsername()}</td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td>:</td>
                    <td>${user.getFirstName()}</td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td>:</td>
                    <td>${user.getLastName()}</td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td>:</td>
                    <td>${user.getEmail()}</td>
                </tr>
                <tr>
                    <td>Country</td>
                    <td>:</td>
                    <td>${user.getCountry()}</td>
                </tr>
                <tr>
                    <td>Points</td>
                    <td>:</td>
                    <td>${user.getPoints()}</td>
                </tr>
                <tr>
                    <td>Created At</td>
                    <td>:</td>
                    <td>${user.parseDate()}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>




    <c:if test="${user.getUsername().equals(username1)}">
    <h2>Tests</h2>
    <div class="card">
        <div class="row">
            <div class="col-md-10 offset-1">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Test Title</th>
                        <th scope="col">Test Number</th>
                        <th scope="col">Test Start Time</th>
                        <th scope="col">Points</th>
                        <th scope="col">Interval</th>
                        <th scope="col">More</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${user.rr()}" var="test">
                        <tr>
                            <td>${test.getTest().getId()}</td>
                            <td>${test.getTest().getTitle()}</td>
                            <td>${test.getTest().getNumber()}</td>
                            <td>${test.getTest().parseDate()}</td>
                            <td>${test.getPoints()}</td>
                            <td>${Math.round(test.getInterval()/60000)} min${Math.round(test.getInterval()/1000)} sec</td>
                            <td><a href="/contest/${test.getTest().getId()}">More</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</c:if>
<jsp:include page="/resources/fragments/js.jsp"/>

</body>
</html>
