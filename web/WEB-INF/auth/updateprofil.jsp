<%--
  Created by IntelliJ IDEA.
  User: alois
  Date: 16/04/2018
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Gloomy</title>
</head>
<body>
<form method="post" action="/auth/updateprofil">
    Prenom :<br>
    <input type="text" name="firstname" value="<c:out value="${user.getFirstname()}"></c:out>" required>
    <br>
    Nom :<br>
    <input type="text" name="lastname" value="<c:out value="${user.getLastname()}"></c:out>" required>
    <br>
    Email :<br>
    <input type="email" name="email" value="<c:out value="${user.getEmail()}"></c:out>" required>
    <br><br>
    <input type="submit" value="Register">
</form>
</body>
</html>
