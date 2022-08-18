<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>${update}${create}</title>
    <link rel="stylesheet" href="resources/main1.css">
</head>
<body>
<div class="main">
    <div class="header">
        <div class="logo">
            <div class="logo_text">
                <h1><a href="/main">${update}${create} </a></h1>
            </div>
        </div>
    </div>
    <div class="site_content">
        <div class="content">
            <h2>${update}${create}</h2>
            <c:if test="${not empty error}">
                <c:forEach var="error" items="${error}">
                        <h4>${error}</h4>
                </c:forEach>
            </c:if>

            <form action="/updateSensor" method="post">
                <input type="hidden" name="id" value="${ID}">
                <input type="text"  name="title" placeholder="Name*" value="${requestScope.sensor.title}"/>*
                <input type="text"  name="model" placeholder="Model*" value="${requestScope.sensor.model}"/>*
                <input type="text"  name="rangeFrom" placeholder="Range From*" value="${requestScope.sensor.fromTo.from}"/>*
                <input type="text"  name="rangeTo" placeholder="Range To*" value="${requestScope.sensor.fromTo.to}"/>*
                <select name="type">
                    <option selected disabled>Выберите тип*</option>
                    <c:forEach var="type" items="${type}">
                    <option>${type.type}</option>
                    </c:forEach>
                </select>
                <select name="unit">
                    <option selected disabled>Выберите тип</option>
                    <c:forEach var="unit" items="${unit}">
                        <option>${unit.unit}</option>
                    </c:forEach>
                </select>
                <input type="text"  name="location" placeholder="Location" value="${requestScope.sensor.location}"/>
                <textarea name="description" placeholder="Description"></textarea>
                <input class="but" type="submit" value="Отправить">
            </form>

        </div>
    </div>
</div>
</body>
</html>