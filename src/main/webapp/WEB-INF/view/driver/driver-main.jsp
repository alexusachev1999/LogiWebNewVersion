<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Меню водителя</title>
</head>
<body>
<input type="button" value="Водители" onclick="window.location.href='driver/drivers'">
<input type="button" value="Фуры" onclick="window.location.href='driver/trucks'">
<input type="button" value="Заказы" onclick="window.location.href='driver/orders'">
<input type="button" value="Маршрутные точки" onclick="window.location.href='driver/waypoints'">
<input type="button" value="Грузы" onclick="window.location.href='driver/cargoes'">
</body>
</html>