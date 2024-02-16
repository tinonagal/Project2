<%@page import="java.util.Iterator"%>
<%@page import="com.zms.bean.Participant"%>
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
<h2>Participant Details</h2>
<table border="1">
	<tr>
		<th>PID</th>
		<th>Name</th>
		<th>Email</th>
		<th>Phone</th>
		<th>BID</th>
	</tr>
	<%
	Object obj = session.getAttribute("obj");
	List<Participant> listofPar = (List<Participant>)obj;
	Iterator<Participant> li = listofPar.iterator();
	while(li.hasNext()){
		Participant par = li.next();
		%>
		<tr>
			<td><%=par.getPid() %></td>
			<td><%=par.getName() %></td>
			<td><%=par.getEmail() %></td>
			<td><%=par.getPhone() %></td>
			<td><%=par.getBid() %></td>
			
		</tr>
		<%
	}
	%>

</table>
<br/>
<a href="index.html">Back</a>
</body>
</html>