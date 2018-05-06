<%--
  Created by IntelliJ IDEA.
  User: alois
  Date: 06/05/2018
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Gloomy</title>
</head>
<body>
    <h1><c:out value="${directory.getName()}"/></h1>
    <%-- DISPLAY FILE --%>
    <table>
        <c:forEach items="${files}" var="file">
            <tr>
                <td><c:out value="${file.getId()}"/></td>
                <td><c:out value="${file.getName()}"/></td>
                <td>
                    <form method="get" action="/auth/downloadfile">
                        <input type="hidden" value="${file.getId()}" name="id"/>
                        <input type="submit" value="Download"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
