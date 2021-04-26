<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Тег META, атрибут charset</title>
</head>
<body>
<h2>Для входа на сайт введите логин и пароль</h2>

<input type="button" value="Для администраторов" onclick="window.location.href = 'admin-main'">
<input type="button" value="Для водителей" onclick="window.location.href = 'driver-main'">
</body>
</html>