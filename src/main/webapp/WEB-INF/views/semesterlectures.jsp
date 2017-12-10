<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="initial-scale=1.0; maximum-scale=1.0; width=device-width;">
<title>학기별 이수 학점 조회</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/table.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />

</head>
<body>
	<div class="table-title">
		<h3>${pageContext.request.userPrincipal.name}님의 학기별 이수 학점입니다</h3>
		<a href="${pageContext.request.contextPath}">홈으로 가기</a>
	</div>
	<table class="table-fill">
		<thead>
			<tr>
				<th class="text-left">년도</th>
				<th class="text-left">학기</th>
				<th class="text-left">이수 학점</th>
				<th class="text-left">상세 보기</th>
			</tr>
		</thead>
		<tbody class="table-hover">
			<c:forEach var="lecture" varStatus="status" items="${lectures}">
				<tr>
					<td class="text-left"><c:out value="${lecture.years}"></c:out></td>
					<td class="text-left"><c:out value="${lecture.semester}"></c:out></td>
					<td class="text-left"><c:out value="${lecture.totalgrades}"></c:out></td>
					<td class="text-left link"><a href="${pageContext.request.contextPath}/semesterdetail?years=${lecture.years}&semester=${lecture.semester}">보기</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- jQuery -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>

	<!-- jQuery Modal -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>

</body>
</html>