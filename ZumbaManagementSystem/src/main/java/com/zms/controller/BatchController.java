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
 * Servlet implementation class BatchController
 */
@WebServlet("/BatchController")
public class BatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BatchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		BatchService bs = new BatchService();
		List<Batch> listofBat = bs.showBatch();
		HttpSession hs = request.getSession();
		hs.setAttribute("obj", listofBat);
		response.sendRedirect("displayBatch.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		String operation = request.getParameter("operation");
		
		if(operation.equals("bstore")) {
		
			int bid = Integer.parseInt(request.getParameter("bid"));
			String btype = request.getParameter("btype");
			String btime = request.getParameter("btime");
			
		
			Batch bat = new Batch();
			bat.setBid(bid);
			bat.setBtype(btype);
			bat.setBtime(btime);
			
			
		
			BatchService bs = new BatchService();
			String result = bs.storeBatch(bat);
			pw.println(result);
			response.setContentType("text/html");
			RequestDispatcher rd = request.getRequestDispatcher("addBatch.jsp");
			rd.include(request, response);
			
	}else if(operation.equals("bdelete")) {
		
		int bid = Integer.parseInt(request.getParameter("bid"));
		BatchService bs = new BatchService();
		String result = bs.deleteBatch(bid);
		pw.println(result);
		
		RequestDispatcher rd = request.getRequestDispatcher("deleteBatch.jsp");
		rd.include(request, response);
		
		
	
	}else {
		
		pw.println("Wrong operation");
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		rd.include(request, response);	
	}
	response.setContentType("text/html");
	}

}
