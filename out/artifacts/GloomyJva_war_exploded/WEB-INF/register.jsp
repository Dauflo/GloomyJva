<%--
  Created by IntelliJ IDEA.
  User: alois
  Date: 16/04/2018
  Time: 00:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form method="post" action="register">
    Prenom :<br>
    <input type="text" name="firstname" required>
    <br>
    Nom :<br>
    <input type="text" name="lastname" required>
    <br>
    Nom d'utilisateur :<br>
    <input type="text" name="username" required>
    <br>
    Mot de passe :<br>
    <input type="password" name="password" required>
    <br>
    Confiramtion du mot de passe :<br>
    <input type="password" name="passwordConf" required>
    <br>
    Email :<br>
    <input type="email" name="email" required>
    <br><br>
    <input type="submit" value="Register">
</form>
</body>
</html>
