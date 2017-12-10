<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이수 학점 조회</title>
<meta name="viewport"
	content="initial-scale=1.0; maximum-scale=1.0; width=device-width;">
	
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/table.css">

</head>
<body onload="getTotal()">
	<div class="table-title">
		<h3>${pageContext.request.userPrincipal.name}님의 이수 구분별 학점입니다</h3>
		<a href="${pageContext.request.contextPath}">홈으로 가기</a>
	</div>
	<table class="table-fill division-table">
		<thead>
			<tr>
				<c:forEach var="division" items="${divisions}">
					<th class="text-left"><c:out value="${division.division}"></c:out></th>
				</c:forEach>
					<th class="text-left">총 학점</th>
			</tr>
		</thead>
		<tbody class="table-hover">
			<tr>

				<c:forEach var="division" items="${divisions}">
					<td class="text-left"><c:out value="${division.totalgrades}"></c:out></td>
				</c:forEach>
					<td class="text-left" id="total-grades"></td>
			</tr>
		</tbody>
	</table>
	<script>
		function getTotal() {
			var totalGrade = 0;
			<c:forEach var="division" items="${divisions}">
				totalGrade += ${division.totalgrades};
			</c:forEach>
			console.log(totalGrade);
			document.getElementById("total-grades").innerHTML = totalGrade;
		}
	</script>
</body>
</html>