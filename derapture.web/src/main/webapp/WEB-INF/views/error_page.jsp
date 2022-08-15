<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="../../style.css" rel="stylesheet">
</head>
<body>
<h1>Error Page</h1>
<p>Application has encountered an error.</p>
<a href="<%=request.getContextPath()%>/">Home page</a>
<!--
    Failed URL: ${url}
    Exception:  ${exception}
        <c:forEach  items="${exception.stackTrace}" var="ste">    ${ste}
    </c:forEach>
  -->
</body>
</html>
