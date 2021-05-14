<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Изменить рабочий статус</title>
</head>
<body>
<h2>Водитель: ${driver.name} ${driver.surname}</h2>
<form:form action="saveNewWorkTimeStatus" modelAttribute="driver">

    <form:hidden path="id"/>
    <form:hidden path="name"/>
    <form:hidden path="surname"/>
    <form:hidden path="workedHours"/>
    <form:hidden path="city"/>
    <form:hidden path="truck"/>
    <form:hidden path="user"/>
    <form:hidden path="status"/>

    <label>Изменить рабочий статус</label>
    <form:select path="workType">
        <form:option value="true" label="Заступил в смену"/>
        <form:option value="false" label="Окончил смену"/>
    </form:select>

    <input type="submit" value="OK">
</form:form>
</body>
</html>