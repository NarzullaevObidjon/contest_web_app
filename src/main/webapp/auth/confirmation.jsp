<%--
  Created by IntelliJ IDEA.
  User: tulaev
  Date: 18/02/23
  Time: 09:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Confirmation</title>
    <style>
        body {
            background-color: #f1f1f1;
        }

        form {
            margin: 100px auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            width: 50%;
            max-width: 600px;
            background-color: #fff;
        }

        h1 {
            font-size: 32px;
            margin-bottom: 20px;
            text-align: center;
            color: #0077b6;
        }

        input[type="text"] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            box-sizing: border-box;
            border: 2px solid #0077b6;
            border-radius: 4px;
        }

        button[type="submit"] {
            background-color: #0077b6;
            color: #fff;
            padding: 12px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }

        button[type="submit"]:hover {
            background-color: #005073;
        }
    </style>
</head>
<body>
<form method="post" action="/auth/signup?email=${email}">
    <h3>Verification code sent to ${email}</h3>
    <label for="code">Verification Code:</label>
    <input type="text" name="code" id="code">
    <button type="submit">Send</button>
</form>
</body>
</html>
