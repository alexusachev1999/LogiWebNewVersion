<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Выбрать фуру для выполнения заказа</title>
</head>
<body>
<h2>Заказ №${order.number}</h2>
<form:form action="/admin/order/saveTruck" modelAttribute="order">

    <form:hidden path="number"/>
    <form:hidden path="drivers"/>
    <form:hidden path="waypoints"/>
    <form:hidden path="id"/>
    <form:hidden path="status"/>

    <label>Список доступных фур</label>
    <form:select path="truck">
        <c:forEach var="truck" items="${trucks}">
            <form:option value="${truck.registrationNumber}"/>
        </c:forEach>
    </form:select>
    <br/>

    <input type="submit" value="Выбрать фуру"/>
</form:form>

</body>
</html>