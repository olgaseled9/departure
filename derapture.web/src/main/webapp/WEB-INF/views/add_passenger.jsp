<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Editing a passenger</title>
    <link href="../../style.css" rel="stylesheet">
</head>
<body>
<nav>
    <jsp:include page="header.jsp"/>
</nav>
<p>Editing a passenger</p>
<form:form action="/passenger/add" method="post" modelAttribute="passengerDto">
    <div>
        <input type="hidden" name="passengerId" value="${passengerDto.passengerId}">
    </div>
    <div>
        <p>Lastname</p>
        <form:input path="lastname"/>
        <form:errors path="lastname"/>
    </div>
    <div>
        <p>Firstname</p>
        <form:input path="firstname"/>
        <form:errors path="firstname"/>
    </div>
    <div>
        <p>Patronymic</p>
        <form:input path="patronymic"/>
        <form:errors path="patronymic"/>
    </div>
    <div>
        <p>Flight</p>
        <form:select path="flightId">
            <c:forEach var="flight" items="${flights}">
                <form:option
                        value="${flight.flightId}">${fn:escapeXml(flight.flightNumber)}
                </form:option>
            </c:forEach>
        </form:select>
    </div>
    <button type="submit">Save</button>
    <button type="button" onclick="goBack()">Cancel</button>
</form:form>
<script>
    function goBack() {
        window.history.back();
    }
</script>
</body>
</html>