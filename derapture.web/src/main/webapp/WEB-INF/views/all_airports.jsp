<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<html>
<head>
    <title>Airports</title>
    <link href="../../style.css" rel="stylesheet">
</head>
<body>
<nav>
    <jsp:include page="header.jsp"/>
</nav>
<div>
    <p>List of airports</p>
    <div>
        <form action="<%=request.getContextPath()%>/airport/add">
            <button type="submit">Add</button>
        </form>
    </div>
    <table>
        <tr>
            <th>Airport</th>
            <th>Country</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach var="airport" items="${airports}">
            <tr>
                <td>${fn:escapeXml(airport.airportName)}</td>
                <td>${fn:escapeXml(airport.country)}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/airport/update?id=${airport.airportId}">Update</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/airport/remove?id=${airport.airportId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
