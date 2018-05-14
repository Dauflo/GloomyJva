<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Ticket</title>
</head>
<body>
    <form action="<%= application.getContextPath() %>" method="post">
        <input type="text" name="title" value="${title}">
        <textarea name="content" cols="30" rows="10">${content}</textarea>
        <input type="submit" value="Submit">
    </form>


</body>
</html>
