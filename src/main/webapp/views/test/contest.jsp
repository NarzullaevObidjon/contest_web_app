<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Contest ${test.getNumber()}</title>
    <jsp:include page="/resources/fragments/css.jsp"></jsp:include>
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
<div style="padding-bottom: 10px"><h1 style="text-align: center">Test - ${test.getNumber()}</h1></div>
<div class="center shadow">
    <div class="center shadow" style=" border-color: #997404; background-color: #fffb99;  width: 100%; padding-bottom: 30px">
        <table class="table tab-content" style="width:100%">
            <tr>
                <th>Test:</th>
                <td>${test.getTitle()}</td>
            </tr>
            <tr>
                <th>Questions :</th>
                <td>${test.getQuestionCount()}</td>
            </tr>
            <tr>
                <th>Time :</th>
                <td>${test.parseDate()}</td>
            </tr>
            <tr>
                <th>Given time :</th>
                <td>${test.getPrettyInterval()}</td>
            </tr>
        </table>
    </div>
    <h1 style="text-align: center; padding: 10px">Questions </h1>
    <c:forEach begin="1" end="${questions.size()}" var="i">
        <div class="table-responsive shadow" style="padding: 10px">
            <table class="table table-bordered table-sm table-striped">
                <thead>
                <tr>
                    <th scope="col">
                        <c:if test="${-1 != questions.get(i - 1).getPhotoDocumentId().getId()}">
                                <img src="${questions.get(i-1).getPathById()}" width="200px" height="200px">
                            <p>${i} ) ${questions.get(i-1).getQuestion()}</p>
                        </c:if>
                        <c:if test="${-1 == questions.get(i - 1).getPhotoDocumentId().getId()}">
                            <p>${i} ) ${questions.get(i-1).getQuestion()}</p>
                        </c:if>
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        <table class="table table-sm table-borderless table-striped">
                            <tbody>
                            <c:forEach
                                    items="${questions.get(i-1).getAnswersArray(questions.get(i-1).getAnswers())}"
                                    var="answer">
                                <tr>
                                    <td>
                                        <c:if test="${1!=questions.get(i-1).getCorrectAnswerIndex()}">
                                            <p style="background-color: #0f5132">${answer}</p>
                                        </c:if>
                                        <c:if test="${1==questions.get(i-1).getCorrectAnswerIndex()}">
                                            ${answer}
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </c:forEach>
</div>
<jsp:include page="/resources/fragments/js.jsp"></jsp:include>
</body>
</html>
