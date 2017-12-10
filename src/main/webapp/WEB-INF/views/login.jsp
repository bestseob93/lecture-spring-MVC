<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="initial-scale=1.0; maximum-scale=1.0; width=device-width;">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login.css">
</head>
<body onload='document.f.username.focus();'>
	<div class="wrapper">
		<form class="login" name='f' action="<c:url value="/login"/>"
			method='POST'>
			<p class="title">Log in</p>
			<input type="text" placeholder="Username" autofocus name='username' />
			<i class="fa fa-user"></i>
			<input type="password" placeholder="Password" name='password' />
			<i class="fa fa-key"></i>
			<c:if test="${not empty logoutMsg}">
				<div class="logout-msg">
					<p>${logoutMsg}</p>
				</div>
			</c:if>
			<c:if test="${not empty errorMsg}">
				<div class="error-msg">
					<p>${errorMsg}</p>
				</div>
			</c:if>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<button type="submit">
				<i class="spinner"></i> <span class="state">Log in</span>
			</button>
		</form>
	</div>
	<script src="https://use.fontawesome.com/861760522b.js"></script>
</body>
</html>