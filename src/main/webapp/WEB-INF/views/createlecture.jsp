<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수강 신청 하기</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/create.css">
<meta name="viewport" content="initial-scale=1.0; maximum-scale=1.0; width=device-width;">
</head>
<body>
	<div class="wrapper">
		<sf:form class="create" method="POST" action="${pageContext.request.contextPath}/docreate" modelAttribute="lecture">
			<p class="title">2018-1학기 수강 신청하기</p>
			<sf:input type="text" placeholder="years" path='years' />
			<div class="error-msg">
				<sf:errors path="years" />
			</div>
			<sf:input type="text" placeholder="semester" path='semester' />
			<div class="error-msg">
				<sf:errors path="semester" />
			</div>
			<sf:input type="text" placeholder="classCode" path='class_code' />
			<div class="error-msg">
				<sf:errors path="class_code" />
			</div>
			<sf:input type="text" placeholder="className" path='class_name' />
			<div class="error-msg">
				<sf:errors path="class_name" />
			</div>
			<sf:input type="text" placeholder="division" path='division' />
			<div class="error-msg">
				<sf:errors path="division" />
			</div>
			<sf:input type="text" placeholder="grades" path='grades' />
			<div class="error-msg">
				<sf:errors path="grades" />
			</div>
			<sf:input type="hidden" path="username" value="${pageContext.request.userPrincipal.name}"/>
			<button type="submit">등록</button>
		</sf:form>
	</div>

</body>
</html>