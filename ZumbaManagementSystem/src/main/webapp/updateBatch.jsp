<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>Update Batch Time</h4>
<form action="BatchController" method="post">
<input type="hidden" name="operation" value="update">
	<label>BID</label>
	<input type="number" name="bid"/><br/>
	<label>Batch Time</label>
	<input type="text" name="btime"/><br/>
	<input type="submit" value="update Batch Time"/>
	<input type="reset" value="reset"/>
</form>
<br/>
<a href="index.html">Back</a>
</body>
</html>