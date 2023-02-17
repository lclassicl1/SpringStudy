<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function requestPost() {
	
	}
</script>
</head>
<body>
	<h1>전체회원목록조회페이지</h1>
	<c:if test="${!empty member}">
		<table border="1">
		<tr>
			<td>id</td><td>비번</td><td>이름</td><td>성별</td><td>가입일</td>
		</tr>
		<c:forEach items="${member}" var="list">
		<tr>
			<td><a href="<%=request.getContextPath()%>/member/Info?id=${list.id}" onclick="requestPost();">${list.id}</a></td><td>${list.pw}</td><td>${list.name}</td><td>${list.gender}</td><td>${list.regdate}</td>
		</tr>	
		</c:forEach>
		</table>			
	</c:if>
</body>
</html>