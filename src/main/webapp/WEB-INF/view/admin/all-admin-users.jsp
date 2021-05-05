<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Список пользователей</title>
</head>
<body>
<table>
    <tr>
        <th>Логин</th>
        <th>Пароль</th>
        <th>Роль</th>
        <th>Статус</th>
        <th>Обновить</th>
        <th>Удалить</th>
    </tr>
    <C:forEach var="user" items="${users}">

        <c:url var="updateButton" value="/admin/updateUser">
            <c:param name="userLogin" value="${user.login}"/>
        </c:url>

        <c:url var="deleteButton" value="/admin/deleteUser">
            <c:param name="userLogin" value="${user.login}"/>
        </c:url>
        <tr>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.authority}</td>
            <td>${user.enabled}</td>
            <td><input type="button" value="Обновить" onclick="window.location.href='${updateButton}'"/></td>
            <td><input type="button" value="Удалить" onclick="window.location.href='${deleteButton}'"/></td>
        </tr>
    </C:forEach>
</table>
<input type="button" value="Добавить пользователя" onclick="window.location.href='addUser'">
</body>
</html>