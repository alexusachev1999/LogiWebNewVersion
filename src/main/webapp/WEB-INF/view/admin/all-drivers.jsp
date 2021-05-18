<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Список водителей</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


<body>
<table class="table table-striped table-dark">
    <thead>
    <tr>
        <th scope="col">Логин</th>
        <th scope="col">Имя</th>
        <th scope="col">Фамилия</th>
        <th scope="col">Номер телефона</th>
        <th scope="col">Отработано часов</th>
        <th scope="col">Статус</th>
        <th scope="col">Текущий город</th>
        <th scope="col">Текущая фура</th>
        <th scope="col">Обновить</th>
        <th scope="col">Удалить</th>
    </tr>
    </thead>
    <tbody>
    <C:forEach var="driver" items="${drivers}">

        <c:url var="updateButton" value="/admin/updateDriver">
            <c:param name="driverId" value="${driver.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/admin/deleteDriver">
            <c:param name="driverId" value="${driver.id}"/>
        </c:url>
        <tr>
            <td>${driver.user}</td>
            <td>${driver.name}</td>
            <td>${driver.surname}</td>
            <td>${driver.phoneNumber}</td>
            <td>${driver.workedHours}</td>
            <td>${driver.status}</td>
            <td>${driver.city}</td>
            <td>
                <c:if test="${driver.truck == null}">
                    <c:out value="Нет фуры"/>
                </c:if>
                <c:if test="${!driver.truck.equals(null)}">
                    <c:out value="${driver.truck}"/>
                </c:if>
            </td>
            <td><input type="button" value="Обновить" onclick="window.location.href='${updateButton}'"/></td>
            <td><input type="button" value="Удалить" onclick="window.location.href='${deleteButton}'"/></td>
        </tr>
    </C:forEach>
    </tbody>
</table>
<input type="button" value="Добавить водителя" onclick="window.location.href='addUserForNewDriver'">
<br/><br/>

<input type="button" value="Вернуться в главное меню" onclick="window.location.href='/admin'">
</body>
</html>