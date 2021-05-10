<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Добавить пользователя</title>
</head>
<body>

<h2>Задайте логин и пароль</h2>
<form:form action="saveUser" modelAttribute="user">
    <label>Логин</label>
    <form:input path="username"/>
    <br/><br/>

    <label>Пароль</label>
    <form:input path="password"/>
    <br/><br/>

    <label>Статус</label>
    <form:select path="enabled">
        <form:option value= "true" label="Действующий"/>
        <form:option value="false" label="Заблокирован"/>
    </form:select>

    <label>Роль</label>
    <form:select path="userRole">
        <form:option value="ROLE_ADMIN" label="Администратор"/>
        <form:option value="ROLE_DRIVER" label="Водитель"/>
    </form:select>
    <br/><br/>

    <input type="submit" value="OK">
</form:form>

</body>
</html>