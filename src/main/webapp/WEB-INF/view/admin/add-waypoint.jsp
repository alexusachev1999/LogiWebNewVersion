<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Добавить маршрутную точку</title>
</head>
<body>

<form:form action="saveWaypoint" modelAttribute="waypoint">

    <form:hidden path="id"/>
    <form:hidden path="cargo"/>

    <label>Груз: ${waypoint.cargo}</label>
    <br/><br/>
    <label>Город загрузки</label>
    <form:select path="cityLoading">
        <c:forEach var="city" items="${cities}">
            <form:option value="${city.name}"/>
        </c:forEach>
    </form:select>
    <br/><br/>
    <label>Город выгрузки</label>
    <form:select path="cityUnloading">
        <c:forEach var="city" items="${cities}">
            <form:option value="${city.name}"/>
        </c:forEach>
    </form:select>
    <br/><br/>
    <input type="submit" value="OK">
</form:form>
</body>
</html>