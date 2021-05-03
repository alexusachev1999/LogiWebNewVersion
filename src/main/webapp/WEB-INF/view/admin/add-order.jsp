<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Добавить заказ</title>
</head>
<body>
<form:form action="saveOrder" modelAttribute="order">

    <c:url var="submitButton" value="/admin/saveOrder">
        <c:param name="orderId" value="${order.id}"/>
    </c:url>

    <form:hidden path="id"/>

    <label>Номер заказа</label>
    <form:input path="number"/>
    <form:errors path="number"/>
    <br/><br/>
    <label>Статус</label>
    <form:select path="status">
        <form:option value= "true" label="Выполнен"/>
        <form:option value="false" label="Невыполнен"/>
    </form:select>
    <br/><br/>
    <label>Добавить маршрутную точку</label>

    <input type="submit" value="OK" onclick="window.location='${submitButton}'">
</form:form>
</body>
</html>