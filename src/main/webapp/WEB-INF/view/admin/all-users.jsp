<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
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
        <th>Роль</th>
        <th>Статус</th>
        <th>Удалить</th>
    </tr>
    <C:forEach var="user" items="${users}">

        <c:url var="deleteButton" value="/admin/deleteUser">
            <c:param name="userName" value="${user.username}"/>
        </c:url>
        <tr>
            <td>${user.username}</td>
            <td>
                <c:if test="${user.userRole.get(0).role.equals('ROLE_ADMIN')}">
                    <c:out value="Администратор"/>
                </c:if>
                <c:if test="${user.userRole.get(0).role.equals('ROLE_DRIVER')}">
                    <c:out value="Водитель"/>
                </c:if>
                    </td>
            <td>
                <c:if test="${user.enabled == true}">
                    <c:out value="Действующий"/>
                </c:if>
                <c:if test="${user.enabled == false}">
                    <c:out value="Заблокирован"/>
                </c:if>
            </td>
            <td><input type="button" value="Удалить" onclick="window.location.href='${deleteButton}'"/></td>
        </tr>
    </C:forEach>
</table>
<input type="button" value="Добавить пользователя" onclick="window.location.href='addUser'">
<br/><br/>

<input type="button" value="Вернуться в главное меню" onclick="window.location.href='/admin'">
</body>
</html>