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
<input type="hidden" name="operation" value="store">
	<label>PID</label>
	<input type="number" name="pid"/><br/>
	<label>Name</label>
	<input type="text" name="name"/><br/>
	<label>Email</label>
	<input type="text" name="email"/><br/>
	<label>Phone</label>
	<input type="text" name="phone"/><br/>
	<label>BID</label>
	<input type="number" name="bid"/><br/>
	<input type="submit" value="store participant"/>
	<input type="reset" value="reset"/>
</form>
<br/>
<a href="index.html">Back</a>
</body>
</html>