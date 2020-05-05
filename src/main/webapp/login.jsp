<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="UserLoginServlet" method="post">
		<table>
			<tr><td>姓名：</td><td><input type="text" name="uname"></td></tr>
			<tr><td>密码:</td><td><input type="password" name="upassword"></td></tr>
			<tr><td><input type="submit" value="登录"></td></tr>
		</table>
	</form>
	<button onclick="window.location.href='ToUserRegistSevlet'">注册</button>
</body>
</html>