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

<h1>${driver.name} ${driver.surname}</h1>

<h2>Личный номер: ${driver.phoneNumber}</h2>

<c:if test="${isDriverListEmpty == true}">
    Нет соводителей
</c:if>

<c:if test="${isDriverListEmpty == false}">
    <table>
        <caption>Со-водители</caption>
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
</c:if>

<c:if test="${isDriverHasOrder == false}">
    <h2>Нет текущего заказа</h2>
</c:if>

<c:if test="${isDriverHasOrder == true}">
    <h2>Рег. номер фуры: ${order.truck}</h2>

    <h2>Номер заказа: ${order.number}</h2>

    <h2>Список маршрутных точек:</h2>
    <ul>
        <c:forEach var="waypoint" items="${order.waypoints}">

            <c:url var="changeCargoButton" value="/driver/changeCargoStatus">
                <c:param name="waypointId" value="${waypoint.id}"/>
            </c:url>

            <li>
                Груз: ${waypoint.cargo}
                <br/>
                Статус груза: ${waypoint.cargoStatus}
                <input type="button" value="Изменить статус груза"
                       onclick="window.location.href = '${changeCargoButton}'">
                <br/>
                Город погрузки: ${waypoint.cityLoading}
                <br/>
                Город выгрузки: ${waypoint.cityUnloading}
            </li>

            <br/>
        </c:forEach>
    </ul>
</c:if>

<h3>
    Текущий рабочий статус:
    <c:if test="${driver.workType == true}"> Заступил в смену</c:if>
    <c:if test="${driver.workType == false}"> Окончил смену</c:if>
</h3>
<input type="button" value="Изменить рабочий статус" onclick="window.location.href = '/driver/changeWorkTimeStatus'">
<br/>
<br/>
<h3>
    Текущий тип работ: ${driver.status}
</h3>
<input type="button" value="Изменить тип работы" onclick="window.location.href = '/driver/changeWorkType'">
</body>
</html>