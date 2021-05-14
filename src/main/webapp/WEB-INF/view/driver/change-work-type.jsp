<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Изменить тип работы</title>
</head>
<body>
<h2>Водитель: ${driver.name} ${driver.surname}</h2>
<form:form action="saveNewWorkType" modelAttribute="driver">

    <form:hidden path="id"/>
    <form:hidden path="name"/>
    <form:hidden path="surname"/>
    <form:hidden path="workedHours"/>
    <form:hidden path="city"/>
    <form:hidden path="truck"/>
    <form:hidden path="user"/>

    <label>Изменить тип работ</label>
    <form:select path="status">
        <form:option value="За рулём" label="За рулём"/>
        <form:option value="Второй водитель" label="Второй водитель"/>
        <form:option value="П-р работы" label="Погрузочно-разгрузочные работы"/>
        <form:option value="Отдых" label="Отдых"/>
    </form:select>

    <input type="submit" value="OK">
</form:form>
</body>
</html>