<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>멤버리스트</h1>
	<c:forEach var="mem" items="${member}">
		id:${mem.id}<br/>
		비밀번호:${mem.pw}<br/>
		지역:${mem.city}<br/>
		성별:${mem.sex}<br/>
		<hr/>
	</c:forEach>
</body>
</html>