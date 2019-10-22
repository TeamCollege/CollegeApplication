package com.virtusa.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.helper.FactoryApplicantService;
import com.virtusa.model.ApplicantModel;
import com.virtusa.service.ApplicantService;

/**
 * Servlet implementation class ApplicantControllerServlet
 */
@WebServlet("/ApplicantControllerServlet")
public class ApplicantControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicantService applicantService=null;

    /**
     * Default constructor. 
     */
    public ApplicantControllerServlet() {
    	super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	this.applicantService=FactoryApplicantService.createApplicantService();
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action.contentEquals("view")) {
		List<ApplicantModel> applicantModelList=applicantService.retrieveApplicants();
		request.setAttribute("applicantModelList", applicantModelList);
		
		if(!applicantModelList.isEmpty()) {
			
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("ApplicationSuccessful.jsp");
			dispatcher.forward(request,response);
		}else {
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("ApplicationUnsuccessful.jsp");
			dispatcher.forward(request,response);
		}
	}
}
}
