<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" importr="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!String email,password; %>
<%
email = request.getParameter("email");
password = request.getParameter("password");
//RequestDispatcher rd1 = request.getRequestDispatcher("Home.jsp");
//RequestDispatcher rd2 = request.getRequestDispatcher("login.jsp");

if(email.equals("tinonagal@gmail.com")&& password.equals("12345")){
	out.println("Login successful");
	//rd1.forward(request, response);
	%>
	<jsp:forward page="Home.jsp"></jsp:forward>
	<%
}else {
	out.println("Enter correct login details");
	//rd2.include(request, response);
	%>
	<jsp:include page="login.jsp"></jsp:include>
	<%
}
response.setContentType("text/html");
%>
</body>
</html>