<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Contest Live</title>
    <jsp:include page="/resources/fragments/css.jsp"></jsp:include>
    <style>
        .center {
            margin: auto;
            width: 50%;
            border: 3px #997404;
            padding: 20px;
            border-radius: 10px;
        }
    </style>
</head>
<body style="background-color:aquamarine">
<div class="center shadow">
    <div class="card" style="width: 100%">
        <h5 class="card-header">${curr} - question</h5>
        <div class="card-body">
            <h5 class="card-title">${question.getQuestion()}</h5>
            <form method="post">
                <input name="curr" id="curr" value="${curr}" hidden="hidden">
                <table class="table table-sm table-borderless table-striped">
                    <tbody>
                    <c:set var="answers" value="${question.getAnswersArray(question.getAnswers())}"/>
                    <c:forEach begin="1" end="${answers.size()}" var="i">
                        <tr>
                            <td>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="answer" id="answer-${i}"
                                           value="${i}">
                                    <label class="form-check-label" for="answer-${i}">
                                            ${answers.get(i-1)}
                                    </label>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <c:if test="${prev!=0}">
                    <button type="submit" class="btn btn-primary" name="prev" value="${prev}">prev</button>
                </c:if>
                <c:if test="${next-1==count}">
                    <button type="submit" class="btn btn-success">finish</button>
                </c:if>
                <c:if test="${next-1!=count}">
                    <button type="submit" class="btn btn-primary" name="next" value="${next}">next</button>
                </c:if>
            </form>
        </div>
    </div>
</div>
<jsp:include page="/resources/fragments/js.jsp"></jsp:include>
</body>
</html>
