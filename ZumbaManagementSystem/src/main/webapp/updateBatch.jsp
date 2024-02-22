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
	<select name="btime">
	<option value="7am">7am</option>
	<option value="8am">8am</option>
	<option value="9am">9am</option>
	<option value="7pm">7pm</option>
	<option value="8pm">8pm</option>
	<option value="9pm">9pm</option>
	</select><br/><br/>
	<input type="submit" value="update Batch Time"/>
	<input type="reset" value="reset"/>
</form>
<br/>
<a href="index.html">Back</a>
</body>
</html>