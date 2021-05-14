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

<h2>Задайте логин и пароль для водителя</h2>

<form:form action="saveUserForNewDriver" modelAttribute="user">
    <form:hidden path="enabled"/>
    <form:hidden path="userRole"/>


    <label>Логин</label>
    <form:input path="username"/>
    <br/><br/>

    <label>Пароль</label>
    <form:input path="password"/>
    <br/><br/>
    <input type="submit" value="OK">
</form:form>
</body>
</html>