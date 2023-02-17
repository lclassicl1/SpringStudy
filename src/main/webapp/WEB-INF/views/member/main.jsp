<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://t1.kakaocdn.net/kakao_js_sdk/${VERSION}/kakao.min.js"
  integrity="${INTEGRITY_VALUE}" crossorigin="anonymous"></script>
<title>Member</title>
</head>
<body>
	<h1>${main}</h1>
	<h2><a href="<%=request.getContextPath()%>/member/add">회원가입(절대경로)</a></h2>
	<h2><a href="member/add">회원가입(상대경로)</a></h2>
	<h2><a href="<%=request.getContextPath()%>/member/Info">특정ID회원검색</a></h2>
	<h2><a href="<%=request.getContextPath()%>/member/list">전체회원검색</a></h2>
</body>
</html>