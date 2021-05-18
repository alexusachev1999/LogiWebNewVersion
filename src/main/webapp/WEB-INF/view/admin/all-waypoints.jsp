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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<body>
<table class="table table-bordered table-dark">
    <thead>
    <tr>
        <th scope="col">Груз</th>
        <th scope="col">Город погрузки</th>
        <th scope="col">Город разгрузки</th>
        <th scope="col">Обновить</th>
        <th scope="col">Удалить</th>
    </tr>
    </thead>
    <tbody>
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
    </tbody>
</table>
<br/>
<input type="button" value="Вернуться в главное меню" onclick="window.location.href='/admin'">
</body>
</html>
