<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<html>
<head>
    <title>Passengers</title>
    <link href="../../style.css" rel="stylesheet">
</head>
<body>
<nav>
    <jsp:include page="header.jsp"/>
</nav>
<div>
    <p>List of passengers</p>
    <div>
        <form action="<%=request.getContextPath()%>/passenger/add">
            <button type="submit">Add</button>
        </form>
    </div>
    <table>
        <tr>
            <th>Lastname</th>
            <th>Firstname</th>
            <th>Patronymic</th>
            <th>Flight</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach var="passenger" items="${passengers}">
            <tr>
                <td>${fn:escapeXml(passenger.lastname)}</td>
                <td>${fn:escapeXml(passenger.firstname)}</td>
                <td>${fn:escapeXml(passenger.patronymic)}</td>
                <td>
                    <c:forEach var="flight" items="${flights}">
                        <c:if test="${flight.flightId eq passenger.flightId}">${fn:escapeXml(flight.flightNumber)}</c:if>
                    </c:forEach>
                </td>
                <td>
                <a href="${pageContext.request.contextPath}/passenger/update?id=${passenger.passengerId}">Update</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/passenger/remove?id=${passenger.passengerId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
