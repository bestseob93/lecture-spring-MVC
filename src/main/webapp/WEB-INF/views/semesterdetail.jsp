<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이번 학기 정</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/table.css" />
</head>
<body>

	<div class="table-title">
		<h3>상세과목</h3>
		<a href="${pageContext.request.contextPath}">홈으로 가기</a>
	</div>
	<table class="table-fill">
		<thead>
			<tr>
				<th class="text-left">년도</th>
				<th class="text-left">학기</th>
				<th class="text-left">과목 코드</th>
				<th class="text-left">과목명</th>
				<th class="text-left">이수 구분</th>
				<th class="text-left">학점</th>
			</tr>
		</thead>
		<tbody class="table-hover">
			<c:forEach var="lecture" items="${results}">
				<tr>
					<td class="text-left"><c:out value="${lecture.years}"></c:out></td>
					<td class="text-left"><c:out value="${lecture.semester}"></c:out></td>
					<td class="text-left"><c:out value="${lecture.class_code}"></c:out></td>
					<td class="text-left"><c:out value="${lecture.class_name}"></c:out></td>
					<td class="text-left"><c:out value="${lecture.division}"></c:out></td>
					<td class="text-left"><c:out value="${lecture.grades}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>