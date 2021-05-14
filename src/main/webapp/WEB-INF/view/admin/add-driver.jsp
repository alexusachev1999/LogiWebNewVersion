<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Добавить водителя</title>
</head>
<body>
<form:form action="saveDriver" modelAttribute="driver">

    <form:hidden path="id"/>
    <form:hidden path="user"/>
    <form:hidden path="status"/>
    <form:hidden path="workType"/>

    <label>Имя</label>
    <form:input path="name"/>
    <form:errors path="name"/>
    <br/><br/>
    <label>Фамилия</label>
    <form:input path="surname"/>
    <form:errors path="surname"/>
    <br/><br/>
    <label>Номер телефона</label>
    <form:input path="phoneNumber"/>
    <form:errors path="phoneNumber"/>
    <br/><br/>
    <label>Текущий город</label>
    <form:select path="city">
        <c:forEach var="city" items="${cityList}">
            <form:option value="${city.name}"/>
        </c:forEach>
    </form:select>
    <form:errors path="city"/>
    <br/><br/>

    <input type="submit" value="OK">

</form:form>
</body>
</html>