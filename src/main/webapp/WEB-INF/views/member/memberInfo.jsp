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
	<h1>${member.id}의 상세정보</h1>
	
	<c:if test="${!empty member}">
		<table border="1">
			<tr>
				<td>id</td><td>비번</td><td>이름</td><td>성별</td><td>가입일</td>
			</tr>
			<tr>
				<td>${member.id}</td><td>${member.pw}</td><td>${member.name}</td><td>${member.gender}</td><td>${member.regdate}</td>
			</tr>
			<tr>
				<td colspan="5">
					<span><a href="<%=request.getContextPath()%>/member/update?id=${member.id}">회원정보수정</a></span>
				</td>
			</tr>		
		</table>
	</c:if>
	
</body>
</html>