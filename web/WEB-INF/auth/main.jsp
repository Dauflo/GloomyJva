<%--
  Created by IntelliJ IDEA.
  User: alois
  Date: 16/04/2018
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Gloomy</title>
</head>
<body>
<div>
    Main page <c:out value="${user.getFirstname()}"></c:out><br><br>
    <%-- UPLOAD FILE --%>
    <form method="post" action="/auth/uploadfile" enctype="multipart/form-data">
        My file<br>
        <input type="file" name="file" size="50">
        <br>
        <select name="category">
            <option value="0">No directory</option>
            <c:forEach items="${directories}" var="directory">
                <option value="${directory.getId()}"><c:out value="${directory.getName()}"/></option>
            </c:forEach>
        </select><br>
        <input type="hidden" value="0" name="currentDirID"/>
        <input type="submit" value="Upload">
    </form>
    <%-- ADD DIRECTORY --%>
    <form method="post" action="/auth/addDirectory">
        Directory:<br>
        <input type="text" name="directory" required>
        <br><br>
        <input type="hidden" value="0" name="rootDirId">
        <input type="submit" value="Add directory">
    </form>
    <a href="/logout">Logout</a>
    <c:if test="${!user.isGoogleFacebookUser()}">
        <a href="/auth/gloomyauth/updateprofil">Update Profil</a><br>
    </c:if>
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
                </td><br>
                    <%-- UPDATE FILE NAME --%>
                <td>
                    <form method="post" action="/auth/updatefilename">
                        <input type="text" name="newName" required/>
                        <input type="hidden" value="${file.getId()}" name="id"/>
                        <input type="submit" value="Update name"/>
                    </form>
                </td>
                    <%-- DELETE FILE --%>
                <td>
                    <form method="post" action="/auth/deletefile">
                        <input type="hidden" value="${file.getId()}" name="id"/>
                        <input type="submit" value="Delete"/>
                    </form>
                </td><br>
            </tr>
        </c:forEach>
    </table><br>
    <%-- DISPLAY DIRECTORY --%>
    <table>
        <c:forEach items="${directories}" var="directory">
            <tr>
                <td><c:out value="${directory.getName()}"/></td>
                <td>
                    <form method="post" action="/auth/directorydetail">
                        <input type="hidden" value="${directory.getId()}" name="id">
                        <input type="submit" value="See">
                    </form>
                </td>
                <td>
                    <form method="post" action="/auth/deletedir">
                        <input type="hidden" value="${directory.getId()}" name="id">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
