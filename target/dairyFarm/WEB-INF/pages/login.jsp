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
<html class="bg-black">
<head>
  <meta charset="UTF-8" content="">
  <title>CHMS | Sign In</title>
  <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
  <%--Adding the system favicon--%>
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" type="image/x-icon"/>
  <!-- bootstrap 3.0.2 -->
  <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
  <!-- font Awesome -->
  <link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
  <!-- Theme style -->
  <link href="${pageContext.request.contextPath}/resources/css/chms.css" rel="stylesheet" type="text/css"/>

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <!-- jQuery 2.0.2 -->
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js" type="text/javascript"></script>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js" type="text/javascript"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js" type="text/javascript"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/chms/loginValidation.js"></script>
  <script type="text/javascript">
    window.setTimeout(function () {
      $("#error_alert").fadeTo(500, 0).slideUp(500, function () {
        $(this).remove();
      });
    }, 2500);
  </script>
  <script type="text/javascript">
    window.setTimeout(function () {
      $("#message_alert").fadeTo(500, 0).slideUp(500, function () {
        $(this).remove();
      });
    }, 2500);
  </script>
</head>
<body class="bg-black" onload='document.loginForm.staffUsername.focus();'>

<div class="form-box" id="login-box">
  <div class="header">ACK St.Martin's | System Login</div>
  <form method="post" action="<c:url value='j_spring_security_check' />" name="loginForm">
    <div class="body bg-gray">
      <br>
      <c:if test="${not empty error}">
        <div class="alert alert-danger" id="error_alert"><i class="fa fa-ban"></i> ${error}</div>
      </c:if>
      <c:if test="${not empty message}">
        <div class="alert alert-success" id="message_alert"><i class="fa fa-check"></i> ${message}</div>
      </c:if>
      <div class="form-group">
        <input type="text" name="staffUsername" class="form-control" placeholder="Username" id="staffUsernamee"/>
      </div>
      <div class="form-group">
        <input type="password" name="staffPassword" class="form-control" placeholder="Password" id="staffPassword"/>
      </div>
      <br/>
    </div>
    <div class="footer">
      <button type="submit" class="btn bg-light-blue btn-block" name="Login" id="Login">Sign me in</button>
      <p class="text-center">Copyrights &copy; 2015 ChMs | Designed &amp; Maintained by : <a rel="nofollow"
                                                                                             href="http://www.api-crafttech.com"
                                                                                             target="_blank">Api-Craft
        Technology</a></p>
    </div>
  </form>
</div>


<!-- Bootstrap -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>
