<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	haha
	<%
		String uname = (String)request.getAttribute("uname");
		out.println("欢迎您："+uname);
	%>
	
</body>
</html>