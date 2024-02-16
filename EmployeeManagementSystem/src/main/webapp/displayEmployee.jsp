<%@page import="java.util.Iterator"%>
<%@page import="com.ems.bean.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Employee Details</h2>
<table border="1">
	<tr>
		<th>Id</th>
		<th>Name></th>
		<th>Salary</th>
	</tr>
	<%
		Object obj = session.getAttribute("obj");
		List<Employee> listOfEmp =(List<Employee>)obj;
		Iterator<Employee> li = listOfEmp.iterator();
		while(li.hasNext()){
			Employee emp = li.next();
			%>
			<tr>
				<td><%=emp.getId() %></td>
				<td><%=emp.getName() %></td>
				<td><%=emp.getSalary() %></td>
			</tr>	
			<% 
		}
	%>


</table>
<br/>
<a href="index.html">Back</a>
</body>
</html>