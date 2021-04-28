<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Список водителей</title>
</head>
<body>
<table>
    <tr>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Номер телефона</th>
        <th>Отработано часов</th>
        <th>Статус</th>
        <th>Текущий город</th>
        <th>Текущая фура</th>
        <th>Обновить</th>
        <th>Удалить</th>
    </tr>
    <C:forEach var="driver" items="${drivers}">

        <c:url var="updateButton" value="/admin/updateDriver">
            <c:param name="driverId" value="${driver.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/admin/deleteDriver">
            <c:param name="driverId" value="${driver.id}"/>
        </c:url>
        <tr>
            <td>${driver.name}</td>
            <td>${driver.surname}</td>
            <td>${driver.phoneNumber}</td>
            <td>${driver.workedHours}</td>
            <td>${driver.status}</td>
            <td>${driver.city.name}</td>
            <td>${driver.truck.registrationNumber}</td>
            <td><input type="button" value="Обновить" onclick="window.location.href='${updateButton}'"/></td>
            <td><input type="button" value="Удалить" onclick="window.location.href='${deleteButton}'"/></td>
        </tr>
    </C:forEach>
</table>
<input type="button" value="Добавить водителя" onclick="window.location.href='addDriver'">
</body>
</html>