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
                <h1><a href="/main">Вход</a> </h1>
             </div>
         </div>
     </div>
      <div class="site_content">
        <div class="content">
            <c:if test="${not empty error}">

                    <h4>${error}</h4>

            </c:if>
          <form method="post" action="/login" id="login">
              <input type="text" name="username" placeholder="имя"/>
              <input type="password" name="password" placeholder="пароль"/>
              <input type="submit" class="btn" value="вход"/>
          </form>
        </div>
      </div>
  </div>
</body>
</html>