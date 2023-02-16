<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 스프링 form태그를 사용하기위해서는 태그라이브러리 지시어로 선언이 되어있어야한다 -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>userFRM2-@스프링 form태그 예제</h3>
	<!-- 요청주소 /reqMethod12 get방식일때 입력form을 출력
	요청주소 /reqMethod12 post방식일때  입력form에서 submit 처리 -->
	<sp:form id="userFRM" modelAttribute="userDTO" method="post" action="<%=request.getContextPath()%>/reqMethod12">
		이름:<sp:input path='name' id='name'/> <!-- input type text는 input으로 처리 -->
		이메일:<sp:input path='email' id='email'/>
		나이:<sp:input path='age' id='age'/>
		성별:<sp:radiobutton path="gender" id='genderM' value='남'/><label for='genderM'>남</label> <!-- radio는 radiobutton으로 처리 -->
			<sp:radiobutton path="gender" id='genderF' value='여'/><label for='genderF'>여</label>
		취미:
			<sp:checkbox path="hobby" value='baseball'/>야구 <!-- checkbox는 checkbox로 처리 -->
			<sp:checkbox path="hobby" value='soccer'/> 축구
			<sp:checkbox path="hobby" value='sleep'/>잠
			<sp:checkbox path="hobby" value='game'/>겜
		<input type='submit' value='전송'/>
	</sp:form>
</body>
</html>