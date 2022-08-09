<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Editing a passenger</title>
</head>
<body>
<p>Editing a passenger</p>
<form action="<%=request.getContextPath()%>/passenger/add" method="POST">
    <div>
        <input type="hidden" name="id" value="${passengerDto.passengerId}">
    </div>
    <div>
        <p>Lastname</p>
        <input type="text" value="${fn:escapeXml(passengerDto.lastname)}">
    </div>
    <div>
        <p>Firstname</p>
        <input type="text" value="${fn:escapeXml(passengerDto.firstname)}">
    </div>
    <div>
        <p>Patronymic</p>
        <input type="text" value="${fn:escapeXml(passengerDto.patronymic)}">
    </div>
    <div>
        <p>Flight</p>
        <select required name="flight">
            <c:forEach var="flight" items="${flights}">
                <option
                        value="${flight}">${flight.flightNumber}
                </option>
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