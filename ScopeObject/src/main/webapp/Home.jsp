<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
//Object obj = request.getAttribute("obj");
Object obj = session.getAttribute("obj");
String name = (String)obj;
out.println("<br/> In JSP Page");
out.println("Name is "+name);
%>
</body>
</html>