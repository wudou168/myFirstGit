<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="UserRegistServlet" method="post">
		<table>
			<tr><td>姓名：</td><td><input type="text" name="uname"></td></tr>
			<tr><td>密码:</td><td><input type="password" name="upassword"></td></tr>
			<tr><td>爱好:</td><td><input type="checkbox" name="uinterests" value="篮球">
			<input type="checkbox" name="uinterests" value="足球">
			<input type="checkbox" name="uinterests" value="游泳"></td></tr>
			<tr><td><input type="submit" value="注册"></td></tr>
		</table>
	</form>
</body>
</html>