<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="entity.Student,java.util.List,entity.Paging"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Student> stus = (List<Student>)request.getAttribute("stus");
		Paging p = (Paging)request.getAttribute("p");
	%>
	<table>
		<tbody>
		<tr>
			<th>sno</th><th>sname</th><th>sclass</th><th>详细信息</th><th>删除</th>
		</tr>
		<%for(Student stu:stus){ %>
			<tr>
				<td><%=stu.getSno() %></td>
				<td><%=stu.getSname() %></td>
				<td><%=stu.getSemail() %></td>
				<td><a href="StudentToDetailServlet?sid=<%=stu.getSid()%>">详细信息</a></td>
				<td><a href="StudentDeleteServlet?sid=<%=stu.getSid()%>">删除</a></td>
			</tr>
		<%} %>
		</tbody>
	</table>
	<a href="StudentToAddServlet">新增</a>
	<%
		if(p.getCurrPage()>1){
	%>
	<a href="StudentsShowServlet?currentPage=1">首页</a>
	<a href="StudentsShowServlet?currentPage=<%=p.getCurrPage()-1%>">上一页</a>
	<%
		}
	%>
	
	<%
		if(p.getCurrPage()<p.getTotalPages()){
	%>
	<a href="StudentsShowServlet?currentPage=<%=p.getCurrPage()+1%>">下一页</a>
	<a href="StudentsShowServlet?currentPage=<%=p.getTotalPages()%>">尾页</a></br>
	<%
		}
	%>
	<form action="StudentsShowServlet" method="post">
		<input type="text" name="currentPage">
		<input type="submit" value="跳转">
	</form>
	
	共<%=p.getTotalPages() %>页,当前第<%=p.getCurrPage() %>页
</body>
</html>