<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Меню администратора</title>
</head>
<body>
<input type="button" value="Водители" onclick="window.location.href='admin/drivers'">
<input type="button" value="Фуры" onclick="window.location.href='admin/trucks'">
<input type="button" value="Заказы" onclick="window.location.href='admin/orders'">
<input type="button" value="Маршрутные точки" onclick="window.location.href='admin/waypoints'">
<input type="button" value="Грузы" onclick="window.location.href='admin/cargoes'">
</body>
</html>