<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
	<sf:form method="POST" action="${pageContext.request.contextPath}/docreate" modelAttribute="lecture">
		<p><span>Year: </span><sf:input type="text" path="years"/></p>
		<p><sf:errors path="years" /></p>
		<p><span>Semester: </span><sf:input type="text" path="semester"/></p>
		<p><sf:errors path="semester" /></p>
		<p><span>ClassCode: </span><sf:input type="text" path="class_code"/></p>
		<p><sf:errors path="class_code" /></p>
		<p><span>ClassName: </span><sf:input type="text" path="class_name"/></p>
		<p><sf:errors path="class_name" /></p>
		<p><span>Division: </span><sf:input type="text" path="division"/></p>
		<p><sf:errors path="division" /></p>
		<p><span>Grades: </span><sf:input type="text" path="grades"/></p>
		<p><sf:errors path="grades" /></p>
		<p><input type="submit" value="등록"/></p>
	</sf:form>

</body>
</html>