<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!doctype html>
<html>
<head>
<title>Добро пожаловать</title>
</head>


<body onload='document.loginForm.username.focus();'>

	<h1>Грузоперевозки "Logi Web"</h1>

	<div id="login-box">

		<h3>Введите логин и пароль</h3>

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form name='loginForm'
			action="<c:url value='/login' />" method='POST'>

			<table>
				<tr>
					<td>Логин:</td>
					<td><input type='text' name='username'></td>
				</tr>
				<tr>
					<td>Пароль:</td>
					<td><input type='password' name='password' /></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit"
						value="Войти" /></td>
				</tr>
			</table>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

		</form>
	</div>

</body>
</html>