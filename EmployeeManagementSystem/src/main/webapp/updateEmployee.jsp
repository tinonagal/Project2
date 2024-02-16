<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Update Employee Salary</h2>
<form action="EmployeeController" method="post">
<input type="hidden" name="operation" value="update">
<label>Id</label>
<input type="number" name="id"/><br/>
<label>Salary</label>
<input type="number" name="salary"/><br/>
<input type="submit" value="update employee salary"/>
<input type="submit" value="reset"/>
</form>
<br/>
<a href="index.html">Back</a>
</body>
</html>