<%@page import="com.zms.service.BatchService"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.zms.bean.Batch"%>
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
<h4>Add Participant</h4>
<form action="ParticipantController" method="post">
<input type="hidden" name="operation" value="store"><br/>
	<label>Name</label>
	<input type="text" name="name"/><br/>
	<label>Email</label>
	<input type="text" name="email"/><br/>
	<label>Phone</label>
	<input type="text" name="phone"/><br/>
	<label>Age</label>
	<input type="number" name="age"/><br/>
	<label>Choose Batch ID & Time</label>
	<select name="bid">
	<option>-Select Batch-</option>
	<% 
	BatchService bs = new BatchService();
	List<Batch> listoBat = bs.showBatch();
	HttpSession hs = request.getSession();
	hs.setAttribute("listofBat", listoBat);
	Object obj = session.getAttribute("listofBat");
	List<Batch> listofBat = (List<Batch>)obj;
	Iterator<Batch> li = listofBat.iterator();
	while(li.hasNext()){
		Batch bb = li.next();
		%>
		<option value="<%=bb.getBid() %>"><%=bb.getBid() %> - <%=bb.getBtime() %></option>
		<%
	}
	%>
	</select><br/><br/>
	<input type="submit" value="store participant"/>
	<input type="reset" value="reset"/>
</form>
<br/>
<a href="index.html">Back</a>
</body>
</html>