package com.zms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zms.bean.Participant;
import com.zms.service.ParticipantService;

/**
 * Servlet implementation class ParticipantController
 */
@WebServlet("/ParticipantController")
public class ParticipantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParticipantController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		ParticipantService ps = new ParticipantService();
		List<Participant> listofPar = ps.showParticipants();
		HttpSession hs = request.getSession();
		hs.setAttribute("obj", listofPar);
		response.sendRedirect("displayParticipant.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		String operation = request.getParameter("operation");
		
		if(operation.equals("store")) {
		
			int pid = Integer.parseInt(request.getParameter("pid"));
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			int bid = Integer.parseInt(request.getParameter("bid"));
		
			Participant par = new Participant();
			par.setPid(pid);
			par.setName(name);
			par.setEmail(email);
			par.setPhone(phone);
			par.setBid(bid);
		
			ParticipantService ps = new ParticipantService();
			String result = ps.storeParticipant(par);
			pw.println(result);
			response.setContentType("text/html");
			RequestDispatcher rd = request.getRequestDispatcher("addParticipant.jsp");
			rd.include(request, response);
			
		}else if(operation.equals("update")) {
			
			int pid = Integer.parseInt(request.getParameter("pid"));
			int bid = Integer.parseInt(request.getParameter("bid"));
			Participant par = new Participant();
			par.setPid(pid);
			par.setBid(bid);
			ParticipantService ps = new ParticipantService();
			String result = ps.updateParticipantBatch(par);
			pw.println(result);
			RequestDispatcher rd = request.getRequestDispatcher("updateParticipantBatch.jsp");
			rd.include(request, response);
			
			
		}else if(operation.equals("delete")) {
			
			int pid = Integer.parseInt(request.getParameter("pid"));
			ParticipantService ps = new ParticipantService();
			String result = ps.deleteParticipant(pid);
			pw.println(result);
			RequestDispatcher rd = request.getRequestDispatcher("deleteParticipant.jsp");
			rd.include(request, response);
			
			
		}else {
			pw.println("Wrong operation");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);	
		}
		response.setContentType("text/html");
	}

}
