<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>Delete Participant</h4>
<form action="ParticipantController" method="post">
<input type="hidden" name="operation" value="delete">
	<label>PID</label>
	<input type="number" name="pid"/><br/>
	<input type="submit" value="delete participant"/>
	<input type="reset" value="reset"/>
</form>
<br/>
<a href="index.html">Back</a>
</body>
</html>