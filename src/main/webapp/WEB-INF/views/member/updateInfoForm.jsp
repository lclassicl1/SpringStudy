<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보 수정 페이지</h1>
	회원정보 수정할 아이디:${id}
	<form action="<%=request.getContextPath()%>/member/update?id=${id}" method="post">
	<table border="1">
			<tr>
				<td>id</td><td>${id}
			</tr>
			<tr>
				<td>수정할 이름</td><td><input type="text" name="name" id="name"/>
			</tr>
			<tr>
				<td>수정할비밀번호</td><td><input type="text" name="pw" id="pw"/>
			</tr>
			<tr>
				<td colspan="5">
					<span><input type="submit" value="수정하기"/></span>
				</td>
			</tr>		
		</table>
	</form>	
</body>
</html>