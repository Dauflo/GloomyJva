<%--
  Created by IntelliJ IDEA.
  User: alois
  Date: 17/04/2018
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gloomy</title>
</head>
<body>
<form method="post" action="/auth/updatepassword">
    Password :<br>
    <input type="password" name="password" required>
    <br>
    Confirmation :<br>
    <input type="password" name="confirmation" required>
    <br><br>
    <input type="submit" value="Update">
</form>
<a href="/auth/main">Main</a>
</body>
</html>
