<%--
  Created by IntelliJ IDEA.
  User: Muhammadjon
  Date: 23.02.2023
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        @import url(https://fonts.googleapis.com/css?family=Open+Sans:300,400,700);

        body {
            font-family: 'Open Sans', sans-serif;
            font-weight: 300;
            line-height: 1.42em;
            color:#A7A1AE;
            background-color:#1F2739;
        }

        h1 {
            font-size:3em;
            font-weight: 300;
            line-height:1em;
            text-align: center;
            color: #4DC3FA;
        }

        h2 {
            font-size:1em;
            font-weight: 300;
            text-align: center;
            display: block;
            line-height:1em;
            padding-bottom: 2em;
            color: #FB667A;
        }

        h2 a {
            font-weight: 700;
            text-transform: uppercase;
            color: #FB667A;
            text-decoration: none;
        }

        td a{
            text-decoration: none;
            font-weight: normal;
            font-size: 1em;
            color: whitesmoke;
        }
        .blue { color: #185875; }
        .yellow { color: #FFF842; }

        .container th h1 {
            font-weight: bold;
            font-size: 1em;
            text-align: left;
            color: #185875;
        }

        .container td {
            font-weight: normal;
            font-size: 1em;
            -webkit-box-shadow: 0 2px 2px -2px #0E1119;
            -moz-box-shadow: 0 2px 2px -2px #0E1119;
            box-shadow: 0 2px 2px -2px #0E1119;
        }

        .container {
            text-align: left;
            overflow: hidden;
            width: 80%;
            margin: 0 auto;
            display: table;
            padding: 0 0 8em 0;
        }

        .container td, .container th {
            padding-bottom: 2%;
            padding-top: 2%;
            padding-left:2%;
        }

        /* Background-color of the odd rows */
        .container tr:nth-child(odd) {
            background-color: #323C50;
        }

        /* Background-color of the even rows */
        .container tr:nth-child(even) {
            background-color: #2C3446;
        }

        .container th {
            background-color: #1F2739;
        }

        .container td:first-child { color: #FB667A; }

        .container tr:hover {
            background-color: #464A52;
            -webkit-box-shadow: 0 6px 6px -6px #0E1119;
            -moz-box-shadow: 0 6px 6px -6px #0E1119;
            box-shadow: 0 6px 6px -6px #0E1119;
        }

        .container td:hover {
            background-color: #FFF842;
            color: #403E10;
            font-weight: bold;

            box-shadow: #7F7C21 -1px 1px, #7F7C21 2px 2px, #7F7C21 3px 3px, #7F7C21 -4px 4px, #7F7C21 -5px 5px, #7F7C21 -6px 6px;
            transform: translate3d(6px, -6px, 0);

            transition-delay: 0s;
            transition-duration: 0.4s;
            transition-property: all;
            transition-timing-function: linear;
        }

        @media (max-width: 800px) {
            .container td:nth-child(4),
            .container th:nth-child(4) { display: none; }
        }
    </style>
    <title>Contests</title>
</head>
<body>
<h1><span class="blue">&lt;</span>All<span class="blue">&gt;</span> <pan class="yellow">Contests</pan></h1>

<table class="container">
    <thead>
    <tr>
        <th><h1>Title</h1></th>
        <th><h1>Started Time</h1></th>
        <th><h1>Creator</h1></th>
        <th><h1>Total Questions</h1></th>
        <th><h1>Total Time</h1></th>
        <th><h1>More Information</h1></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="test" items="${tests}">
    <tr>
        <td>${test.getTitle()}</td>
        <td>${test.parseDate()}</td>
        <td>${UserDAO.get().findByID(test.getCreator_id()).getUsername()}</td>
        <td>${test.getQuestionCount()}</td>
        <td>${Math.round(test.getInterval()/60000)} min${Math.round(test.getInterval()/1000)} sec</td>
        <td><a href="/contest/${test.getId()}">More</a></td>
    </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
