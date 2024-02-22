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

import com.zms.bean.Batch;
import com.zms.bean.Participant;
import com.zms.service.BatchService;
import com.zms.service.ParticipantService;

/**
 * Servlet implementation class ParticipantController
 */
@WebServlet("/ParticipantController")
public class ParticipantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ParticipantService ps = new ParticipantService();
	BatchService bs = new BatchService();
	
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
		List<Participant> listoPar = ps.showParticipants();
		HttpSession hs = request.getSession();
		hs.setAttribute("obj", listoPar);
		response.sendRedirect("displayParticipant.jsp");
		
		// PrintWriter pw = response.getWriter();
		// List<Batch> listoBat = bs.showBatch();
		// HttpSession hs = request.getSession();
		// hs.setAttribute("listofBat", listoBat);
		// response.sendRedirect("addParticipant.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String operation = request.getParameter("operation");
		
		List<Batch> listoBat = bs.showBatch();
		HttpSession hs = request.getSession();
		hs.setAttribute("listofBat", listoBat);

		if(operation.equals("store")) {
			
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			int age = Integer.parseInt(request.getParameter("age"));
			int bid = Integer.parseInt(request.getParameter("bid"));
			Participant par = new Participant();
			
			par.setName(name);
			par.setEmail(email);
			par.setPhone(phone);
			par.setAge(age);
			par.setBid(bid);
			
			String result = ps.storeParticipant(par);
			pw.println(result);
			RequestDispatcher rd = request.getRequestDispatcher("addParticipant.jsp");
			rd.include(request, response);
			
		}else if (operation.equals("pshow")){
			
			ParticipantService ps = new ParticipantService();
			List<Participant> listoPar = ps.showParticipants();
			//HttpSession hs = request.getSession();
			hs.setAttribute("obj", listoPar);
			RequestDispatcher rd = request.getRequestDispatcher("displayParticipant.jsp");
			rd.include(request, response);
		}
		
		response.setContentType("text/html");
	}
}
