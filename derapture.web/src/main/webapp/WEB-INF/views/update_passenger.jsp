<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Editing an airport</title>
    <link href="../../style.css" rel="stylesheet">
</head>
<body>
<nav>
    <jsp:include page="header.jsp"/>
</nav>
<p>Editing a airport</p>
<form action="<%=request.getContextPath()%>/passenger/add" method="POST">
    <div>
        <input type="hidden" name="passengerId" value="${passengerDto.passengerId}">
    </div>
    <div>
        <p>Lastname</p>
        <input type="text" name="lastname" value="${fn:escapeXml(passengerDto.lastname)}">
    </div>
    <div>
        <p>Firstname</p>
        <input type="text" name="firstname" value="${fn:escapeXml(passengerDto.firstname)}">
    </div>
    <div>
        <p>Patronymic</p>
        <input type="text" name="patronymic" value="${fn:escapeXml(passengerDto.patronymic)}">
    </div>
    <div>
        <p>Flight</p>
        <select required name="flightId">
            <c:forEach var="flight" items="${flights}">
                <option
                        <c:if test="${flight.flightId eq passengerDto.flightId}">selected</c:if>
                        value="${flight.flightId}">${flight.flightNumber}</option>
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