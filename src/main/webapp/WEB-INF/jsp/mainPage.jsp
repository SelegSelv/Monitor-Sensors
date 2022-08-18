<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Вход</title>
    <link rel="stylesheet" href="resources/main1.css">
</head>
<body>
 <div class="main">
    <div class="header">
        <div class="logo">
            <div class="logo_text">
                <h1><a href="/main">Датчики</a> </h1>
            </div>
        </div>
    </div>
     <div class="site_content">
         <div class="sidebar_container">
             <div class="sidebar">
                 <h2>Поиск</h2>
                 <form method="post" action="/searchLine" id="search_form">
                     <input type="search" name="searchField" placeholder="ваш запрос"/>
                     <input type="submit" class="btn" value="найти"/>
                 </form>
             </div>

             <div class="sidebar">
                 <h2>Выход из аккаунта</h2>
                 <form action="/logout" method="post">
                     <input type="submit" class="btn" value="выйти"/>
                 </form>
             </div>
         </div>
         <h2>Username: ${admin}${name}</h2>
         <div class="contentM">
             <c:if test="${not empty admin}">
                 <c:url var="addButton" value="/updateSensor">
                     <c:param name="sensorId" value="0"></c:param>
                 </c:url>
             <input type="submit" class="btn" value="Добавить"
                    onclick="window.location.href='${addButton}'"/>
             </c:if>
             <input type="hidden" name="search" value="${search}"/>

             <table>
                 <tr>
                     <th>Name</th>
                     <th>Model</th>
                     <th>Range from</th>
                     <th>Range to</th>
                     <th>Type</th>
                     <th>Unit</th>
                     <th>Location</th>
                     <c:if test="${not empty admin}">
                     <th>Редактировать</th>
                     <th>Удалить</th>
                     </c:if>
                 </tr>

                 <c:forEach var="sensor" items="${allSensors}">
                     <tr>
                         <td>${sensor.title}</td>
                         <td>${sensor.model}</td>
                         <td>${sensor.fromTo.from}</td>
                         <td>${sensor.fromTo.to}</td>
                         <td>${sensor.type}</td>
                         <td>${sensor.unit}</td>
                         <td>${sensor.location}</td>
                         <c:if test="${not empty admin}">
                         <c:url var="updateButton" value="/updateSensor">
                             <c:param name="sensorId" value="${sensor.id}"></c:param>
                         </c:url>
                         <c:url var="deleteButton" value="/deleteSensor">
                             <c:param name="sensorId" value="${sensor.id}"></c:param>
                         </c:url>

                             <td><input type="submit" class="btn" value="Редактировать"
                                    onclick="window.location.href='${updateButton}'"/>
                             </td>
                             <td>
                             <input type="submit" class="btn" value="Удалить"
                                    onclick="window.location.href='${deleteButton}'"/>
                             </td>
                         </c:if>
                     </tr>
                 </c:forEach>
             </table>

         </div>
     </div>
 </div>
</body>
</html>