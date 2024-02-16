<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>Update Participant Batch ID</h4>
<form action="ParticipantController" method="post">
<input type="hidden" name="operation" value="update">
	<label>PID</label>
	<input type="number" name="pid"/><br/>
	<label>BID</label>
	<input type="number" name="bid"/><br/>
	<input type="submit" value="update participant"/>
	<input type="reset" value="reset"/>
</form>
<br/>
<a href="index.html">Back</a>
</body>
</html>