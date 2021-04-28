<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Список водителей</title>
</head>
<body>
<h2>Список водителей заказа № ${}</h2>
<table>
    <tr>
        <th>Номер заказа</th>
        <th>Статус</th>
        <th>Список маршрутных точек</th>
        <th>Фура</th>
        <th>Список водителей</th>
        <th>Обновить</th>
        <th>Удалить</th>
    </tr>
    <C:forEach var="order" items="${orders}">

        <c:url var="updateButton" value="/admin/updateOrder">
            <c:param name="orderId" value="${order.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/admin/deleteOrder">
            <c:param name="orderId" value="${order.id}"/>
        </c:url>

        <c:url var="detailButton" value="/admin/order/detail">
            <c:param name="orderId" value="${order.id}"/>
        </c:url>

        <c:url var="driverButton" value="/admin/order/drivers">
            <c:param name="orderId" value="${order.id}"/>
        </c:url>

        <tr>
            <td>${order.number}</td>
            <td><c:if test="${order.status == false}">Невыполнен</c:if>
                <c:if test="${order.status == true}">Выполнен</c:if></td>
            <td>
                <ul>
                    <c:forEach var="waypoint" items="${order.waypoints}">
                        <li>${waypoint.cargo} ${waypoint.city}</li>
                    </c:forEach>
                </ul>
            </td>
            <td>${order.truck.registrationNumber}</td>
            <td><input type="button" value="Список водителей" onclick="window.location.href='${driverButton}'"/></td>
            <td><input type="button" value="Обновить" onclick="window.location.href='${updateButton}'"/></td>
            <td><input type="button" value="Удалить" onclick="window.location.href='${deleteButton}'"/></td>
        </tr>
    </C:forEach>
</table>
<input type="button" value="Добавить заказ" onclick="window.location.href='addOrder'">
</body>
</html>