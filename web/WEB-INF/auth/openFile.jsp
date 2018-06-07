<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
<div>
    <p>Simple preview</p>
</div>
<div>
    <pre><c:out value="${content}"/></pre>
</div>
</body>
</html>