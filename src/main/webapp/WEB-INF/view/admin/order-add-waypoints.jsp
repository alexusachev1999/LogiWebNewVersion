<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Добавить маршрутные точки в заказ</title>
</head>
<body>

<h2>Добавьте маршрутные точки в заказ №${order.number}</h2>

<form:form modelAttribute="order" action="saveWaypoints">

    <form:checkboxes path="waypoints" items="${waypoints}"/>
    <br/>
    <input type="submit" value="OK"/>
</form:form>

</body>
</html>