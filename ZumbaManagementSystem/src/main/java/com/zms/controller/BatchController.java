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
import com.zms.service.BatchService;



/**
 * Servlet implementation class BatchController
 */
@WebServlet("/BatchController")
public class BatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	BatchService bs = new BatchService();
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
		
		//PrintWriter pw = response.getWriter();
		//List<Object[]> listofBP = bs.showBatchParticipant();
		//HttpSession hs = request.getSession();
		//hs.setAttribute("BPlist", listofBP);
		//response.sendRedirect("showBatchParticipant.jsp");
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
    
	}else if(operation.equals("update")) {
			
			int bid = Integer.parseInt(request.getParameter("bid"));
			String btime = request.getParameter("btime");
			Batch bat = new Batch();
			bat.setBid(bid);
			bat.setBtime(btime);
			BatchService bs = new BatchService();
			String result = bs.updateBatch(bat);
			pw.println(result);
			RequestDispatcher rd = request.getRequestDispatcher("updateBatch.jsp");
			rd.include(request, response);
			
	}else if(operation.equals("bshow")) {
			
			BatchService bs = new BatchService();
			List<Batch> listofBat = bs.showBatch();
			HttpSession hs = request.getSession();
			hs.setAttribute("obj", listofBat);
			//RequestDispatcher rd = request.getRequestDispatcher("displayBatch.jsp");
			response.sendRedirect("displayBatch.jsp");
			
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
