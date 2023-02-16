<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>전체회원리스트</h3>
	<%-- 넘어온값들 = ${empList} --%>
	<c:forEach var="list" items="${empList}">
		ID:${list.empid}<br/>
		이름:${list.empname}<br/>
		비밀번호:${list.emppassword}<br/>
		급여:${list.empsal}<br/><hr/>	
	</c:forEach>
</body>
</html>