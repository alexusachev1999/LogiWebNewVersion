<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Изменить статус груза</title>
</head>
<body>
<h2>Груз: ${cargo.name}</h2>
<form:form action="saveNewCargoStatus" modelAttribute="cargo">

    <form:hidden path="id"/>
    <form:hidden path="number"/>
    <form:hidden path="name"/>
    <form:hidden path="weight"/>

        <form:select path="status">
            <form:option value="Отгружен" label="Загрузил"/>
            <form:option value="Доставлен" label="Выгрузил"/>
        </form:select>
    <input type="submit" value="OK">
</form:form>
</body>
</html>