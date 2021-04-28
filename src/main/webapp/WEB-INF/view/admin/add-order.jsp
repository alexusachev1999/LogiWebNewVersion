<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Добавить фуру</title>
</head>
<body>
<form:form action="saveOrder" modelAttribute="order">
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
    <%--    <label>Фура</label>--%>
<%--    <form:select path="truck">--%>
<%--        <c:forEach var="truck" items="${trucks}">--%>
<%--            <form:option value="${truck.registrationNumber}"/>--%>
<%--        </c:forEach>--%>
<%--    </form:select>--%>
<%--    <br/><br/>--%>
<%--    <label>Водители</label>--%>
<%--    <c:forEach var="driver" items="${drivers}">--%>
<%--        <form:checkbox path="drivers" value="${driver.id}" label="${driver.name} ${driver.surname}"/>--%>
<%--    </c:forEach>--%>
<%--    <br/><br/>--%>
    <input type="submit" value="OK">
</form:form>
</body>
</html>