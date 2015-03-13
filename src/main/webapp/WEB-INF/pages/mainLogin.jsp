<%--
  Created by IntelliJ IDEA.
  User: MUTHAKA
  Date: 1/30/2015
  Time: 12:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html >
<head>
  <meta charset="UTF-8" />
  <title>
    login
  </title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login.css" />
</head>
<body>
<c:url value="/j_spring_security_check" var="login"/>
<form method="post" action="${login}" name="loginForm">
  <h1>LOGIN</h1>
  <div class="inset">
    <c:if test="${not empty error}">
      <div class="alert alert-danger" id="error_alert"><i class="fa fa-ban"></i> ${error}</div>
    </c:if>
    <c:if test="${not empty message}">
      <div class="alert alert-success" id="message_alert"><i class="fa fa-check"></i> ${message}</div>
    </c:if>
    <p>
      <label >USER NAME</label>
      <input type="text" name="username" class="form-control" placeholder="username" id="username" required/>
    </p>
    <p>
      <label >PASSWORD</label>
      <input type="password" name="password" class="form-control" placeholder="password" id="password"/>
    </p>

  </div>
  <p class="p-container">
    <span>Forgot password ?</span>
    <input type="submit" name="Login" id="Login" value="Log In">
  </p>
</form>

</body>
</html>










