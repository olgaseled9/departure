<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Editing a flight</title>
    <link href="../../style.css" rel="stylesheet">
</head>
<body>
<nav>
    <jsp:include page="header.jsp"/>
</nav>
<p>Editing a flight</p>
<form:form action="/flight/add" method="post" modelAttribute="flightDto">
    <div>
        <input type="hidden" name="flightId" value="${flightDto.flightId}">
    </div>
    <div>
        <p>Flight number</p>
        <form:input path="flightNumber"/>
        <form:errors path="flightNumber"/>
    </div>
    <div>
        <p>Airport</p>
        <form:select path="airportId">
            <c:forEach var="airport" items="${airports}">
                <option
                        value=${airport.airportId}>${airport.airportName}
                </option>
            </c:forEach>
        </form:select>
    </div>
    <div>
        <p>Country</p>
        <form:select path="country">
            <c:forEach var="country" items="${countries}">
                <form:option
                        value="${country.name}">${country.name}
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