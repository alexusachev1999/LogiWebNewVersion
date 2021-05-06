<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Добавить груз</title>
</head>
<body>
<form:form action="saveCargo" modelAttribute="cargo">

    <form:hidden path="id"/>

    <label>Номер груза</label>
    <form:input path="number"/>
    <form:errors path="number"/>
    <br/><br/>
    <label>Наименование</label>
    <form:input path="name"/>
    <form:errors path="name"/>
    <br/><br/>
    <label>Масса (в кг)</label>
    <form:input path="weight"/>
    <form:errors path="weight"/>
    <br/><br/>
    <label>Статус</label>
    <form:select path="status">
        <form:option value="Подготовлен" label="Подготовлен"/>
        <form:option value="Отгружен" label="Отгружен"/>
        <form:option value="Доставлен" label="Доставлен"/>
    </form:select>
    <br/><br/>
    <input type="submit" value="OK">
</form:form>
</body>
</html>