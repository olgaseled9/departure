<%@ page import="by.seledtsovaos.departure.repository.model.CountryValue" %>
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
<form action="<%=request.getContextPath()%>/airport/add" method="POST">
    <div>
        <input type="hidden" name="airportId" value="${airportDto.airportId}">
    </div>
    <div>
        <p>Airport</p>
        <input type="text" name="airportName" value="${fn:escapeXml(airportDto.airportName)}">
    </div>
    <div>
        <p>Country</p>
        <select required name="country">
            <c:forEach var="country" items="${countries}">
                <option
                        <c:if test="${airportDto.country.name() eq country.name}">selected</c:if>
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