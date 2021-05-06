<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Список фур</title>
</head>
<body>
<table>
    <tr>
        <th>Регистрационный номер</th>
        <th>Смена водителя (ч.)</th>
        <th>Вместимость</th>
        <th>Текущий город</th>
        <th>Состояние</th>
        <th>Обновить</th>
        <th>Удалить</th>
    </tr>
    <C:forEach var="truck" items="${trucks}">

        <c:url var="updateButton" value="/admin/updateTruck">
            <c:param name="truckId" value="${truck.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/admin/deleteTruck">
            <c:param name="truckId" value="${truck.id}"/>
        </c:url>
        <tr>
            <td>${truck.registrationNumber}</td>
            <td>${truck.driverShiftDuration}</td>
            <td>${truck.capacity}</td>
            <td>${truck.city.name}</td>
            <td><c:if test="${truck.state == false}">Неисправна</c:if>
                <c:if test="${truck.state == true}">Исправна</c:if></td>
            <td><input type="button" value="Обновить" onclick="window.location.href='${updateButton}'"/></td>
            <td><input type="button" value="Удалить" onclick="window.location.href='${deleteButton}'"/></td>
        </tr>
    </C:forEach>
</table>
<input type="button" value="Добавить фуру" onclick="window.location.href='addTruck'">
</body>
</html>