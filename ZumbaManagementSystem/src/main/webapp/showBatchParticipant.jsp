<%@page import="java.util.Iterator"%>
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
<h3>Batch and Participant List</h3>
<table border="1">
	<tr>
		<th>PID</th>
		<th>Name</th>
		<th>Email</th>
		<th>Phone</th>
		<th>Age</th>
		<th>Batch Type</th>
		<th>Batch Time</th>
		<th>Batch ID</th>
	</tr>
	<%
	Object obj = session.getAttribute("BPlist");
	List<Object[]> list = (List<Object[]>)obj;
	Iterator<Object[]> li = list.iterator();
	while(li.hasNext()){
		Object bp[]=li.next();
		%>
		<tr>
			<td><%=bp[0] %></td>
			<td><%=bp[1] %></td>
			<td><%=bp[2] %></td>
			<td><%=bp[3] %></td>
			<td><%=bp[4] %></td>
			<td><%=bp[5] %></td>
			<td><%=bp[6] %></td>
			<td><%=bp[7] %></td>
		</tr>
		<%
	}
	%>
</table>
<br/>
<a href="index.html">Back</a>
</body>
</html>