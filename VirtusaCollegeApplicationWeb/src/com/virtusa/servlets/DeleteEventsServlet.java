package com.virtusa.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.helper.FactoryAdminService;
import com.virtusa.service.AdminService;
import com.virtusa.service.AdminServiceImpl;

/**
 * Servlet implementation class DeleteEventsServlet
 */
@WebServlet("/DeleteEventsServlet")
public class DeleteEventsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminServiceImpl adminServiceImpl;
	AdminService adminService;
	FactoryAdminService factoryAdminService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEventsServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		int id =	Integer.parseInt(request.getParameter("event_Id"));
		
		boolean result = factoryAdminService.createAdminService().deleteEventsService(id);
		if(result==true)
		 {
			// System.out.print("<p>Data Added Successfully!!!!!!");
			 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Succesfully.jsp");
		 }
		 else
		 {
			 //System.out.print("<p>Data Added Successfully!!!!!!");
			 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Unsuccesfull.html");
		 }
		doGet(request, response);
	}

}
