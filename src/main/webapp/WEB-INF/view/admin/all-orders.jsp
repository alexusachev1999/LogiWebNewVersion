<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Список заказов</title>
</head>
<body>
<table>
    <tr>
        <th>Номер заказа</th>
        <th>Статус</th>
        <th>Список маршрутных точек</th>
        <th>Фура</th>
        <th>Список водителей</th>
        <th>Удалить</th>
    </tr>
    <C:forEach var="order" items="${orders}">

        <c:url var="updateButton" value="/admin/updateOrder">
            <c:param name="orderId" value="${order.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/admin/deleteOrder">
            <c:param name="orderId" value="${order.id}"/>
        </c:url>

        <tr>
            <td>${order.number}</td>
            <td><c:if test="${order.status == false}">Невыполнен</c:if>
                <c:if test="${order.status == true}">Выполнен</c:if></td>
            <td>
                    <c:forEach var="waypoint" items="${order.waypoints}">
                        <h3>${waypoint.cargo} ${waypoint.cityLoading}</h3>
                        <h3>${waypoint.cargo} ${waypoint.cityUnloading}</h3>
                    </c:forEach>
            </td>
            <td>${order.truck}</td>
            <td>
                <c:forEach var="driver" items="${order.drivers}">
                    <h3>${driver.name} ${driver.surname}</h3>
                </c:forEach>
            </td>
            <td><input type="button" value="Удалить" onclick="window.location.href='${deleteButton}'"/></td>
        </tr>
    </C:forEach>
</table>
<input type="button" value="Добавить заказ" onclick="window.location.href='addOrder'">
<br/><br/>

<input type="button" value="Вернуться в главное меню" onclick="window.location.href='/admin'">
</body>
</html>