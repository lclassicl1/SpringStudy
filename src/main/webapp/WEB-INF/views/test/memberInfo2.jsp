<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>member</h3><br/>
	<h1>${addMember}</h1><br/>
	모델:${member}<br/>
	id:${member.id}<br/>
	거주지:${member.city}<br/>
	성별:${member.sex}<br/>
	
	<c:forEach var="hobby" items="${member.hobby}" varStatus="status">
	${status.index}:${hobby},
	</c:forEach>
	
	<table border="1">
		<!-- <thead>
			<tr>
				<th></th><th>count</th><th>current</th><th>isFirst?</th><th>isLast?</th>
			</tr>	
		</thead> -->
		<tbody>
				<c:forEach var="hobby" items="${member.hobby}" varStatus="status">
			<tr>
				<td>${status.index}</td>
				<td>${status.count}번째</td>
				<td>${status.current}</td>
				<td>${status.first}</td>
				<td>${status.last}</td>
				<td>&nbsp;</td>
			</tr>
				</c:forEach>
		</tbody>
	</table>
	
</body>
</html>