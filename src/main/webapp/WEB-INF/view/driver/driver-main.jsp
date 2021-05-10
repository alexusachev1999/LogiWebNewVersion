<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Меню водителя</title>
</head>
<body>
<h2>${driver.name} ${driver.surname}</h2>
<br/><br/>
<h2>Личный номер - ${driver.phoneNumber}</h2>
<br/><br/>
<table>
    <tr>
        <th>Имя водителя</th>
        <th>Личный номер</th>
    </tr>

    <c:forEach var="driver" items="${drivers}">
        <tr>
            <td>${driver.name} ${driver.surname}</td>
            <td>${driver.phoneNumber}</td>
        </tr>
    </c:forEach>
</table>
<br/><br/>

<h2>Рег. номер фуры: ${order.truck}</h2>
<br/><br/>

<h2>Номер заказа: ${order.number}</h2>
<br/><br/>

<h2>Список маршрутных точек</h2>
<c:forEach var="waypoint" items="${order.waypoints}">
    <h3>${waypoint.toString()}</h3>
    <br/>
</c:forEach>
<h2></h2>
</body>
</html>