<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

String url = <%=request.getRequestURI() %>
String queryS = <%=request.getQueryString() %>

<%-- 넘어온 객체
${serverTime}
${userid}
${age}
${gender} --%>
<P>  The time on the server is ${serverTime}. </P>
<p> id = ${userid} </p>
<p> age = ${age}</p>
<p> gender = ${gender}
</body>
</html>
