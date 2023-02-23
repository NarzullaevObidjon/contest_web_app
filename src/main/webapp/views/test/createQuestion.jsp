<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question create</title>
    <jsp:include page="/resources/fragments/css.jsp"/>
    <style>
        body {
            background-color: #555555;
            font-family: Arial, Helvetica, sans-serif;
        }

        h1 {
            text-align: center;
            color: #4CAF50;
        }

        form {
            background-color: #333333 !important;
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px #ccc;
        }

        label {
            color: #3e8e41;
        !important;
            font-size: 18px;
            font-weight: bold;
            display: block;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<h1>Question Creation</h1>
<form method="post">
    <h1>${curr}/${quescount}</h1>
    <div class="input-group input-group-sm mb-3">
        <input required placeholder="e.g What is OOP?" name="question" id="question" type="text" class="form-control"
               aria-label="Sizing example input"
               aria-describedby="inputGroup-sizing-sm">
    </div>
    <input name="anscount" value="${anscount}" hidden="hidden">
    <input name="quescount" value="${quescount}" hidden="hidden">
    <input name="number" value="${number}" hidden="hidden">
    <input name="curr" value="${curr}" hidden="hidden">
    <table class="table table-sm table-borderless table-striped">
        <tbody>
        <c:forEach begin="1" end="${anscount}" var="i">
            <tr>
                <td>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="correct" id="correct-${i}"
                               value="${i}">
                        <label for="correct-${i}">
                            <div class="input-group input-group-sm mb-3">
                                <input required placeholder="e.g It's Object Oriented Programming man!"
                                       name="answer-${i}" id="answer" type="text" class="form-control"
                                       aria-label="Sizing example input"
                                       aria-describedby="inputGroup-sizing-sm">
                            </div>
                        </label>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <a href="/admin" class="btn btn-danger">Cancel</a>
        <c:if test="${curr==quescount}">
            <button class="btn btn-success">Finish</button>
        </c:if>
        <c:if test="${curr!=quescount}">
            <button class="btn btn-success">Next</button>
        </c:if>
    </div>
</form>
</body>
</html>
