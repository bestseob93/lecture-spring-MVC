<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
	<div class="container">
		<div class="section">
			<p>Hello World</p>
			<p>${pageContext.request.userPrincipal.name}님!</p>
		</div>
		<div class="section">
			<a href="${pageContext.request.contextPath}/semesterlectures">학기별 이수 학점 조회</a>
		</div>
		<div class="section">
			<a href="${pageContext.request.contextPath}/lectures">이수 구분별 학점 조회</a>
		</div>
		<div class="section">
			<a href="${pageContext.request.contextPath}/createlecture">수강 신청하기</a>
		</div>
		<div class="section">
			<a href="${pageContext.request.contextPath}/lectures">신청 내역 조회</a>
		</div>
	</div>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<a class="logout-btn" href="javascript:document.getElementById('logout').submit()"><i class="fa fa-sign-out"></i></a>
	</c:if>

	<form id="logout" action="<c:url value="/logout" />" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script src="https://use.fontawesome.com/861760522b.js"></script>
</body>
</html>