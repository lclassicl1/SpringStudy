<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입폼</h1>
	<form:form  modelAttribute="newMember" method="post" action="./add">
		<p>아이디 : <form:input path="id"  name="id"/> 
		<p>비밀번호 : <form:password path="pw"/>
		<p>이름:<form:input path="name" name="name"/>
		<p>성별 : <form:radiobutton path="gender"  value="남" id="genderM"/><label for="genderM">남성</label> 
				<form:radiobutton path="gender"  value="여" id="genderF"/><label for="genderF">여성</label></p>
		<p>가입일:<form:input path="regdate" name="regdate"/></p>
		<p><input type="submit" value="가입하기"/> 
			<input type="reset"  value="다시쓰기"/></p>
	</form:form>
</body>
</html>