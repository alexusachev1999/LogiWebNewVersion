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
	<h1>Статус 403 - Доступ запрещён</h1>

	<c:choose>
		<c:when test="${empty username}">
			<h2>Упс... У вас нет прав для этой страницы :(((</h2>
		</c:when>
		<c:otherwise>
			<h2>Пользователь : ${username} <br/>Упс... У вас нет прав для этой страницы :(((</h2>
		</c:otherwise>
	</c:choose>

</body>
</html>