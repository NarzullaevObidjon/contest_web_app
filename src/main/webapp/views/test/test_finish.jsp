<%--
  Created by IntelliJ IDEA.
  User: hphphp
  Date: 2/21/2023
  Time: 6:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Results</title>
    <jsp:include page="/fragments/css.jsp"></jsp:include>
    <style>
        .table-nostriped tbody tr:nth-of-type(odd) {
            background-color: transparent !important;
        }

        .center {
            margin: auto;
            width: 50%;
            border: 3px #997404;
            padding: 20px;
            border-radius: 10px;
        }
    </style>
</head>
<body>
<div style="padding-bottom: 10px"><h1 style="text-align: center">Result</h1></div>
<div class="center shadow">
    <div class="center shadow"
         style=" border-color: #997404; background-color: #fffb99;  width: 100%; padding-bottom: 30px">
        <table class="table tab-content" style="width:100%">
            <tr>
                <th>Test:</th>
                <td>${test.getTitle()}</td>
            </tr>
            <tr>
                <th>Time :</th>
                <td>${interval}</td>
            </tr>
            <tr>
                <th>Result :</th>
                <td>${points}/${test.getQuestions().size()}</td>
            </tr>
        </table>
    </div>
    <div>
        <a class="btn btn-success" href="/">Home</a>
    </div>
</div>
<jsp:include page="/fragments/js.jsp"></jsp:include>
</body>
</html>
