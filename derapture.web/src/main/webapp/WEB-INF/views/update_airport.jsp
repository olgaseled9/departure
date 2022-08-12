<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<p>Editing a airport</p>
<form:form action="/airport/add" method="post" modelAttribute="airportDto">
    <div>
        <input type="hidden" name="airportId" value="${airportDto.airportId}">
    </div>
    <div>
        <p>Airport</p>
        <form:input path="airportName"/>
        <form:errors path="airportName"/>
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