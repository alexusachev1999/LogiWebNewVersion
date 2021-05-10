<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Добавить водителя(ей) к заказу</title>
</head>
<body>

<h2>Заказ №${order.number}</h2>
<form:form action="/admin/order/saveDrivers" modelAttribute="order">

    <form:hidden path="number"/>
    <form:hidden path="truck"/>
    <form:hidden path="waypoints"/>
    <form:hidden path="id"/>
    <form:hidden path="status"/>

    <label>Список доступных водителей</label>
    <br/>
    <c:forEach var="driver" items="${drivers}">
        <form:checkbox path="drivers" value="${driver.id}" label="${driver.name}"/>
        <br/>
    </c:forEach>

    <input type="submit" value="Выбрать водителя(ей)"/>
</form:form>

</body>
</html>