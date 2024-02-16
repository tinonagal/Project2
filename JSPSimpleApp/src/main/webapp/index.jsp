<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to HTML Page</h2>
<%!int c=80,d=30,difference; %>
<% 
	int a=10;
	int b=400;
	int sum=a+b;
	
	System.out.println("Welcome to JSP message on console");
	out.println("welcome to JSP");
	out.println("<br/>");
	out.println("The difference is "+difference);
	out.println("<br/>");
	out.println("The sum is "+sum);
	out.println("<br/>");
	out.println("<font color=red>Sum is "+sum+"</font>");
%>
<hr/>
<%
out.println("Second part");
%>
</body>
</html>