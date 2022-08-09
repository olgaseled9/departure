<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<html>
<head>
    <title>Flights</title>
</head>
<body>
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
                <td class="table-value">${fn:escapeXml(flight.flightNumber)}</td>
                <td class="table-value">${fn:escapeXml(flight.airport)}</td>
                <td class="table-value">${fn:escapeXml(flight.country)}</td>
                <td>
                    <a href="/flight/add/(id=${flight.flightId})">Update</a>
                </td>
                <td>
                    <a href="/flight/remove/(id=${flight.flightId})">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
