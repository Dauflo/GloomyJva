<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 28/05/2018
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html>
<head>
    <title>open file</title>
</head>
<body>
<img src="${tempFile}" alt="">
<frameset cols="50%,50%">
<frame name="frame1" src="${tempfile}">
</frameset>
</body>
</html>
