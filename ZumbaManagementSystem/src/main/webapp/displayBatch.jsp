<%@page import="com.zms.bean.Batch"%>
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
<h2>Batch Details</h2>
<form action="BatchController" method="post">
<input type="hidden" name="operation" value="bshow">
<table border="1">
	<tr>
		<th>BID</th>
		<th>Batch Type</th>
		<th>Batch Time</th>
		
	</tr>
	<%
	Object obj = session.getAttribute("obj");
	List<Batch> list = (List<Batch>)obj;
	Iterator<Batch> li = list.iterator();
	while(li.hasNext()){
		Batch bat = li.next();
		%>
		<tr>
			<td><%=bat.getBid() %></td>
			<td><%=bat.getBtype() %></td>
			<td><%=bat.getBtime() %></td>
			
		</tr>
		<%
	}
	%>
	

</table>
</form>
<br/>
<a href="index.html">Back</a>
</body>
</html>