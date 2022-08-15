<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<html>
<head>
    <title>Flights</title>
    <link href="../../style.css" rel="stylesheet">
</head>
<body>
<nav>
    <jsp:include page="header.jsp"/>
</nav>
<div>
    <p>List of flights</p>
    <div>
        <form action="<%=request.getContextPath()%>/flight/add">
            <button type="submit">Add</button>
        </form>
    </div>
    <table>
        <tr>
            <th>Flight number</th>
            <th>Airport</th>
            <th>Country</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach var="flight" items="${flights}">
            <tr>
                <td>${fn:escapeXml(flight.flightNumber)}</td>
                <td>
                    <c:forEach var="airport" items="${airports}">
                        <c:if test="${flight.airportId eq airport.airportId}">${fn:escapeXml(airport.airportName)}</c:if>
                    </c:forEach>
                </td>
                <td>${fn:escapeXml(flight.country)}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/flight/update?id=${flight.flightId}">Update</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/flight/remove?id=${flight.flightId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
