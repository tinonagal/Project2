package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String emailid = request.getParameter("emailid");
		String password = request.getParameter("password");
		RequestDispatcher rd1 = request.getRequestDispatcher("signup.html");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zumba_data","root","Shitball$447");
			PreparedStatement pstmt = con.prepareStatement("insert into login values(?,?)");
			pstmt.setString(1, emailid);
			pstmt.setString(2, password);
			int res = pstmt.executeUpdate();
			if(res>0) {
				pw.println("account created successfully");
				rd1.include(request, response);
			}
		}catch (Exception e) {
			pw.println("account creation not successfull"+e.getMessage());
			rd1.include(request, response);
		}
		response.setContentType("text/html");
	}

}
