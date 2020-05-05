<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="entity.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Student stu = (Student) request.getAttribute("stu");
	%>
	<form action="StudentUpdateServlet" method="post">
		sid:<input type="text" readonly="readonly" name="sid" value="<%=stu.getSid()%>"></br>
		sno:<input type="text" name="sno" value="<%=stu.getSno()%>"></br>
		sname:<input type="text" name="sname" value="<%=stu.getSname()%>"></br>
		semail<input type="text" name="semail" value="<%=stu.getSemail()%>"></br>
		sphone_number<input type="text" name="sphone_number" value="<%=stu.getSphone_number()%>"></br> 
		sclass<input type="text"name="sclass" value="<%=stu.getSclass()%>"></br>
		<input type="submit" value="修改">
	</form>
</body>
</html>