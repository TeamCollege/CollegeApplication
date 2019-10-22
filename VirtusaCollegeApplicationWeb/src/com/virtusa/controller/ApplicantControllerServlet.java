package com.virtusa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.entities.Applicant;
import com.virtusa.model.ApplicantModel;
import com.virtusa.service.ApplicantServiceImpl;

/**
 * Servlet implementation class ApplicantControllerServlet
 */
@WebServlet("/ApplicantControllerServlet")
public class ApplicantControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(ApplicantController.class);

    /**
     * Default constructor. 
     */
    public ApplicantControllerServlet() {
    	super();
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicantModel applicantModel=new ApplicantModel();
		PrintWriter out=null;
		try {
			out = response.getWriter();
			applicantModel.setFirstName(request.getParameter("firstName"));
			applicantModel.setLastName(request.getParameter("lastName"));
			applicantModel.setPhoneNumber(request.getParameter("phoneNumber"));
			applicantModel.setDateOfBirth(request.getParameter("dateOfBirth"));
			applicantModel.setEmail(request.getParameter("email"));
			applicantModel.setTenthPercentage(Integer.parseInt(request.getParameter("tenthPrecentage")));
			applicantModel.setInterPercentage(Integer.parseInt(request.getParameter("interPrecentage")));
			ApplicantServiceImpl applicantServiceImpl = new ApplicantServiceImpl();
			String result = applicantServiceImpl.storeApplicantService(applicantModel);
			if(result.contentEquals("success")) {
				out.println("Application Sucessfully Submitted");
				out.println("Your Application Number is: "+request.getParameter("applicationNumber"));
			}
			} catch (ParseException | NumberFormatException e) {
				logger.info(e);
			}
	}

}
