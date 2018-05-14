<%--
  Created by IntelliJ IDEA.
  User: alois
  Date: 14/05/2018
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Share Dir</title>
</head>
<body>
<h1><c:out value="${directory.getName()}"/></h1>
<%-- DISPLAY FILE --%>
<table>
    <c:forEach items="${files}" var="file">
        <tr>
            <td><c:out value="${file.getId()}"/></td>
            <td><c:out value="${file.getName()}"/></td>
                <%-- DOWNLOAD FILE --%>
            <td>
                <form method="get" action="/auth/downloadfile">
                    <input type="hidden" value="${file.getId()}" name="id"/>
                    <input type="submit" value="Download"/>
                </form>
            </td>
            <br>
        </tr>
    </c:forEach>
</table><br>
<%-- DISPLAY DIRECTORY --%>
<table>
    <c:forEach items="${directories}" var="subDirectory">
        <tr>
            <td><c:out value="${subDirectory.getName()}"/></td>
            <td>
                    <%-- CHANGE ACTION --%>
                <form method="post" action="/auth/sharesubdirdetail">
                    <input type="hidden" value="${subDirectory.getId()}" name="id">
                    <input type="submit" value="See">
                </form>
            </td>
        </tr>
    </c:forEach>
</table><br>
</body>
</html>
