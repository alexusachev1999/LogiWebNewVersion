<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Добавить фуру</title>
</head>
<body>
<form:form action="saveTruck" modelAttribute="truck">

    <form:hidden path="id"/>

    <label>Регистрационный номер</label>
    <form:input path="registrationNumber"/>
    <form:errors path="registrationNumber"/>
    <br/><br/>
    <label>Смена водителя (ч.)</label>
    <form:input path="driverShiftDuration"/>
    <form:errors path="driverShiftDuration"/>
    <br/><br/>
    <label>Вместимость (т.) </label>
    <form:input path="capacity"/>
    <form:errors path="capacity"/>
    <br/><br/>
    <label>Текущий город</label>
    <form:select path="city">
        <c:forEach var="city" items="${cityList}">
            <form:option value="${city.name}"/>
        </c:forEach>
    </form:select>
    <br/><br/>
    <label>Состояние</label>
    <form:select path="state">
        <form:option value= "true" label="Исправна"/>
        <form:option value="false" label="Неисправна"/>
    </form:select>
    <br/><br/>
    <input type="submit" value="OK">
</form:form>
</body>
</html>