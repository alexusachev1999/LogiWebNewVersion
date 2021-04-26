<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Добавить водителя</title>
</head>
<body>
<form:form action="saveDriver" modelAttribute="driver">

    <form:hidden path="id"/>

    <label>Имя</label>
    <form:input path="name"/>
    <br/><br/>
    <label>Фамилия</label>
    <form:input path="surname"/>
    <br/><br/>
    <label>Номер телефона</label>
    <form:input path="phoneNumber"/>
    <br/><br/>
    <input type="submit" value="OK">
</form:form>
</body>
</html>