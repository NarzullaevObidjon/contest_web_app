
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Registration Form</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f8f8f8;
    }
    h1 {
      text-align: center;
      margin-top: 50px;
    }
    form {
      width: 400px;
      margin: 0 auto;
      background-color: #fff;
      padding: 40px;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0,0,0,0.2);
    }
    label {
      display: block;
      margin-bottom: 10px;
    }
    input[type="email"] {
      width: 100%;
      padding: 10px;
      border: none;
      border-bottom: 2px solid #ccc;
      margin-bottom: 20px;
      font-size: 16px;
      color: #555;
    }
    button {
      display: block;
      background-color: #4CAF50;
      color: #fff;
      padding: 10px 20px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      font-size: 16px;
    }
    button:hover {
      background-color: #3e8e41;
    }
  </style>
</head>
<body>
<h1>Registration Form</h1>
<form method="post" >
  <label for="email">Email:</label>
  <input type="email" name="email" id="email" required>
  <button>
    Send code
  </button>
</form>
</body>
</html>
