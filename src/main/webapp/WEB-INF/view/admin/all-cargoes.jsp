<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Список грузов</title>
</head>
<body>
<table>
    <tr>
        <th>Номер</th>
        <th>Наименование</th>
        <th>Масса</th>
        <th>Статус</th>
        <th>Обновить</th>
        <th>Удалить</th>
    </tr>
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
</table>
<input type="button" value="Добавить груз" onclick="window.location.href='addCargo'">
</body>
</html>