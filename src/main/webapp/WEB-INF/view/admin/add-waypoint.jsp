<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Добавить маршрутную точку</title>
</head>
<body>

<form:form action="saveWaypoint" modelAttribute="waypoint">

    <form:hidden path="id"/>

    <label>Груз</label>
    <form:select path="cargo" name = "cargoName">
        <form:options items="${cargoes}"></form:options>
    </form:select>
    <br/><br/>
    <label>Город</label>
    <form:select path="city">
        <c:forEach var="city" items="${cities}">
            <form:option value="${city.name}"/>
        </c:forEach>
    </form:select>
    <br/><br/>
    <label>Тип</label>
    <form:select path="type">
        <form:option value= "true" label="Загрузка"/>
        <form:option value="false" label="Выгрузка"/>
    </form:select>
    <br/><br/>
    <input type="submit" value="OK">
</form:form>
</body>
</html>