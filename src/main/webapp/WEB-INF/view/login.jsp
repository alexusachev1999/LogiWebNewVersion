<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Страница входа</title>
</head>
<body>
<h2>Для входа на сайт введите логин и пароль</h2>
<form method="post" action="/login">
    <label>Логин</label>
    <input type="text" value="login" name="login"/>
    <br/>
    <label>Пароль</label>
    <input type="password" value="password" name="password"/>
    <br/>
    <button type="submit" value="ОК"/>
</form>
</body>
</html>