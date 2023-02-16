<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>userFRM</h3>
	<form name='userFRM' id='userFRM' method='get' action='<%=request.getContextPath()%>/requestMethod9'>
		이름:<input type='text' name='name' id='name'/>
		이메일:<input type='text' name='email' id='email'/>
		나이:<input type='text' name='age' id='age'/>
		성별:<input type='radio' name='gender' id='genderM' value='남'/><label for='genderM'>남</label>
		<input type='radio' name='gender' id='genderF' value='여'/><label for='genderF'>여</label>
		취미:
		<input type='checkbox' name='hobby' value='baseball'/>야구
		<input type='checkbox' name='hobby' value='soccer'/> 축구
		<input type='checkbox' name='hobby' value='sleep'/>잠
		<input type='checkbox' name='hobby' value='game'/>겜
		<input type='submit' value='전송'/>
	</form>
</body>
</html>