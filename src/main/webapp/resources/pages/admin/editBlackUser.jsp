<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hnodir
  Date: 19/02/23
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        Edit User
    </title>
    <link rel="stylesheet" href="/resources/css/admin/editUser.css">
    <jsp:include page="/resources/fragments/css.jsp"/>
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
<container class="d-flex  justify-content-around align-items-center">
<form class="col-8 mt-5" method="post">
    <div class="row">
        <label for="userRole" class="col-sm-2 col-form-label">Role : </label>
        <div class="col-sm-10">
            <select id="userRole" class="form-select" name="userRole" >
                <c:choose>
                    <c:when test="${user.getRole() == 'USER'}">
                        <option>USER</option>
                        <option>ADMIN</option>
                    </c:when>
                    <c:otherwise>
                        <option>ADMIN</option>
                        <option>USER</option>
                    </c:otherwise>
                </c:choose>
            </select>
        </div>
    </div>
    <div class="d-flex align-items-center">
        <label for="flexSwitchCheckChecked" class="col-sm-2 col-form-label">Block : </label>
        <div class="form-check form-switch">
                        <c:choose>
                            <c:when test="${user.getStatus() == 'BLOCKED'}">
                                <input class="form-check-input" name="userStatus" type="checkbox" role="switch" id="flexSwitchCheckChecked" checked>
                                <input class="form-check-input"  type="checkbox" role="switch" id="flexSwitchCheckDefault" hidden>
                            </c:when>
                            <c:otherwise>
                                <input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckChecked" checked hidden>
                                <input class="form-check-input" name="userStatus" type="checkbox" role="switch" id="flexSwitchCheckDefault">
                            </c:otherwise>
                        </c:choose>
        </div>
    </div>
    <div class="row">
            <legend class="col-form-label col-sm-2 pt-0" for="validationTextarea">Cause : </legend>
            <div class="col-sm-10">
                <textarea name="blockCause" class="form-control" id="validationTextarea" placeholder="Type here.."
                    <c:if test="${user.getStatus() != 'BLOCKED'}">
                        disabled
                    </c:if>><c:if test="${user.getStatus() == 'BLOCKED'}">${user.getBlockCause()}</c:if></textarea>
                <div class="invalid-feedback">
                    Enter a message in the textarea.
                </div>
            </div>
    </div>
    <div class="form-group row mt-3">
        <div class="col-sm-2" for="datetime">Block till : </div>
        <div class="col-sm-10">
            <input class="rounded border" style="padding: 6px 12px;" type="datetime-local"  id="datetime" name="blockTill"
            <c:choose>
                <c:when test="${user.getStatus() != 'BLOCKED'}">
                    disabled
                </c:when>
                <c:when test="${user.getStatus() == 'BLOCKED'}">
                    value="${user.getBlockedTill()}"
                </c:when>
            </c:choose>>
        </div>
    </div>
    <div class="form-group row mt-3">
        <div class="col-sm-11">
            <c:if test="${user_error != null}">
                <span class="small text-danger"><c:out value="${user_error}"></c:out></span>
            </c:if>
            <div class="float-end"><input type="text" hidden name="userId" value="${user.getId()}">
            <a href="/admin/users" type="button" class="btn btn-warning">CANCEL</a>
            <button type="submit" class="btn btn-primary">SAVE</button>
            </div>
        </div>
    </div>
</form>
</container>
<script>
    let element = document.getElementById("flexSwitchCheckDefault");
    let element1 = document.getElementById("flexSwitchCheckChecked");
    let textArea = document.getElementById("validationTextarea");
    let textAreaValue = textArea.value;
    let dateTime = document.getElementById("datetime");
    let dateTimeValue = dateTime.value;
    element.addEventListener("change", function (event) {
        if (event.target.checked) {
            console.log("checked 1");
            textArea.textContent=textAreaValue;
            dateTime.value = dateTimeValue;
            textArea.disabled = false;
            dateTime.disabled = false;
        } else {
            console.log("not checked 1");
            textArea.textContent="";
            dateTime.value = "";
            textArea.disabled = true;
            dateTime.disabled = true;
        }
    });
    element1.addEventListener("change", function (event) {
        if (event.target.checked) {
            console.log("checked 2");
            textArea.textContent=textAreaValue;
            dateTime.value = dateTimeValue;
            textArea.disabled = false;
            dateTime.disabled = false;
        } else {
            console.log("not checked 2");
            textArea.textContent="";
            dateTime.value = "";
            textArea.disabled = true;
            dateTime.disabled = true;
        }
    });
</script>
<jsp:include page="/resources/fragments/js.jsp"/>
</body>
</html>
