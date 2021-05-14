<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Список маршрутных точек</title>
</head>
<body>
<table>
    <tr>
        <th>Груз</th>
        <th>Город погрузки</th>
        <th>Город разгрузки</th>
        <th>Обновить</th>
        <th>Удалить</th>
    </tr>
    <C:forEach var="waypoint" items="${waypoints}">

        <c:url var="updateButton" value="/admin/updateWaypoint">
            <c:param name="waypointId" value="${waypoint.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/admin/deleteWaypoint">
            <c:param name="waypointId" value="${waypoint.id}"/>
        </c:url>

        <tr>
            <td>${waypoint.cargo}</td>
            <td>${waypoint.cityLoading}</td>
            <td>${waypoint.cityUnloading}</td>
            <td><input type="button" value="Обновить" onclick="window.location.href='${updateButton}'"/></td>
            <td><input type="button" value="Удалить" onclick="window.location.href='${deleteButton}'"/></td>
        </tr>
    </C:forEach>
</table>
<input type="button" value="Добавить точку" onclick="window.location.href='addWaypoint'">
<br/><br/>

<input type="button" value="Вернуться в главное меню" onclick="window.location.href='/admin'">
</body>
</html>
