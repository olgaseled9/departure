
<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Editing a flight</title>
</head>
<body>
<nav>
    <jsp:include page="header.jsp"/>
</nav>
<p>Editing a flight</p>
<form action="<%=request.getContextPath()%>/flight/add" method="POST">
    <div>
        <input type="hidden" name="flightId" value="${flightDto.flightId}">
    </div>
    <div>
        <p>Flight number</p>
        <input type="text" name="flightNumber" value="${fn:escapeXml(flightDto.flightNumber)}">
    </div>
    <div>
        <p>Airport</p>
        <select required name="airportId">
            <c:forEach var="airport" items="${airports}">
                <option
                        <c:if test="${airport.airportId eq flightDto.airportId}">selected</c:if>
                        value=${airport.airportId}>${airport.airportName}
                </option>
            </c:forEach>
        </select>
    </div>
    <div>
        <p>Country</p>
        <select required name="country">
            <c:forEach var="country" items="${countries}">
                <option
                        <c:if test="${country.name eq flightDto.country}">selected</c:if>
                        value="${country.name}">${country.name}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit">Save</button>
    <button type="button" onclick="goBack()">Cancel</button>
</form>
<script>
    function goBack() {
        window.history.back();
    }
</script>
</body>
</html>