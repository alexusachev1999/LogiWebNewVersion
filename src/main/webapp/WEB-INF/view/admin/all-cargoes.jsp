<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Список грузов</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<body>
<table class="table table-bordered table-dark">
    <thead>
    <tr>
        <th scope="col">Номер</th>
        <th scope="col">Наименование</th>
        <th scope="col">Масса</th>
        <th scope="col">Статус</th>
        <th scope="col">Обновить</th>
        <th scope="col">Удалить</th>
    </tr>
    </thead>
    <tbody>
    <C:forEach var="cargo" items="${cargoes}">

        <c:url var="updateButton" value="/admin/updateCargo">
            <c:param name="cargoId" value="${cargo.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/admin/deleteCargo">
            <c:param name="cargoId" value="${cargo.id}"/>
        </c:url>
        <tr>
            <td>${cargo.number}</td>
            <td>${cargo.name}</td>
            <td>${cargo.weight}</td>
            <td>${cargo.status}</td>
            <td><input type="button" value="Обновить" onclick="window.location.href='${updateButton}'"/></td>
            <td><input type="button" value="Удалить" onclick="window.location.href='${deleteButton}'"/></td>
        </tr>
    </C:forEach>
    </tbody>
</table>
<input type="button" value="Добавить груз" onclick="window.location.href='addCargo'">
<br/><br/>

<input type="button" value="Вернуться в главное меню" onclick="window.location.href='/admin'">
</body>
</html>