<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contest create</title>
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
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px #ccc;
        }

        label {
            color: #3e8e41;!important;
            font-size: 18px;
            font-weight: bold;
            display: block;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<h1>Test Creation</h1>
<form method="post">
    <div class="input-group input-group-sm mb-3">
        <label for="title">Title : </label>
        <input required name="title" id="title" type="text" class="form-control" aria-label="Sizing example input"
               aria-describedby="inputGroup-sizing-sm">
    </div>
    <div class="input-group input-group-sm mb-3">
        <label for="quescount">Questions count : </label>
        <input required name="quescount" id="quescount" type="number" class="form-control"
               aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
    </div>
    <div class="input-group input-group-sm mb-3">
        <label for="number">Test number : </label>
        <input readonly="true" value="${number}" name="number" id="number" type="number" class="form-control"
               aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
    </div>
    <div class="input-group input-group-sm mb-3">
        <label for="anscount">Answers count : </label>
        <input required value="4" name="anscount" id="anscount" type="number" class="form-control"
               aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
    </div>

    <div class="input-group input-group-sm mb-3">
        <label for="start">Start time : </label>
        <input required name="start" id="start" type="datetime-local" class="form-control"
               aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
    </div>
    <div class="input-group input-group-sm mb-3">
        <label for="end">End time : </label>
        <input required name="end" id="end" type="datetime-local" class="form-control" aria-label="Sizing example input"
               aria-describedby="inputGroup-sizing-sm">
    </div>
    <div class="input-group input-group-sm mb-3">
        <label for="interval">Interval(seconds) : </label>
        <input required name="interval" id="interval" type="number" class="form-control"
               aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
    </div>
    <div>
        <a href="/admin" class="btn btn-danger">Cancel</a>
        <button class="btn btn-success">Create</button>
    </div>
</form>
</body>
</html>
