<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Добавить заказ</title>
</head>
<body>
<h2>Заказ №${order.number}</h2>
<form:form action="saveOrder" modelAttribute="order">

    <c:url var="submitButton" value="/admin/saveOrder">
        <c:param name="orderId" value="${order.id}"/>
    </c:url>

    <label>Список маршрутных точек</label>
    <br>

    <c:forEach var="waypoint" items="${waypoints}">
            <form:checkbox path="waypoints" value="${waypoint.id}" label="${waypoint.toString()}"/>
        <br/>
    </c:forEach>
    <br/>
    <input type="submit" value="Добавить маршрутные точки" onclick="window.location='${submitButton}'">
</form:form>

</body>
</html>