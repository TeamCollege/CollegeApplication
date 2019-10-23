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

import com.virtusa.helper.FactoryAlumniService;
import com.virtusa.model.AlumniModel;
import com.virtusa.service.AlumniService;
import com.virtusa.validation.AlumniModelValidator;

/**
 * Servlet implementation class AlumniControllerServlet
 */
@WebServlet("/loadregistrationform")
public class AlumniControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AlumniService alumniService=null;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlumniControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	this.alumniService=FactoryAlumniService.createAlumniService();
    	
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action=request.getParameter("action");
		if(action.contentEquals("view")) {
			List<AlumniModel> alumniModelList=alumniService. retrieveAlumni();
		request.setAttribute("alumniModelList", alumniModelList);
		
		if(!alumniModelList.isEmpty()) {
			
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("alumnidetails.jsp");
			dispatcher.forward(request,response);
		}else {
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("noalumnidetails.jsp");
			dispatcher.forward(request,response);
		}
		}
		}

		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String action=request.getParameter("action");
        if(action.contentEquals("loadform")) {
        	
        	int alumniId=Integer.parseInt(request.getParameter("alumniId"));
        	
        	String firstName=request.getParameter("firstName");
        	String lastName=request.getParameter("lastName");
        	String email=request.getParameter("email");
        	
        	String phoneNumber=request.getParameter("phoneNumber");
        	String gender=request.getParameter("gender");
        	String presentStatus=request.getParameter("presentStatus");
        	int yearOfCompletion=Integer.parseInt(request.getParameter("gender"));

        	AlumniModelValidator validator=new AlumniModelValidator();
        	
        	boolean validFirstName=validator.validString(firstName);
        	boolean validLastName=validator.validString(lastName);
        	boolean validEmail=validator.validEmail(email);
        	boolean validPhoneNumber=validator.validPhone(phoneNumber);
        	boolean validGender=validator.validGender(gender);
        	boolean validPresentStatus=validator.validPresentStatus(presentStatus);
        	boolean validNumber=validator.validNumber(yearOfCompletion);
        	boolean emailExist=validator.emailExist(email);
        	
        	
        	if(validFirstName || !validLastName || !validEmail ||  emailExist) {
        		
      		  
                if(!validFirstName) {
            		request.setAttribute("firstnameerror", "First Name not valid");
                }
                if(!validLastName) {
            		request.setAttribute("lastnameerror",  "Last Name not valid");
                }
                if(!validEmail) {
            		request.setAttribute("emailerror",  "Email not valid");

                }
                if(emailExist) {
            		request.setAttribute("emailexisterror",  "Email already exist");

              }
                if(!validGender) {
            		request.setAttribute("error",  "Gender not valid");

                }
                if(!validPresentStatus) {
            		request.setAttribute("error",  " not valid");

                }
                
        	}else {
        		AlumniModel alumniModel=new AlumniModel();
        		alumniModel.setAlumniId(alumniId);
        		alumniModel.setFirstName(firstName);
        		alumniModel.setLastName(lastName);
        		alumniModel.setEmail(email);
        		alumniModel.setPhoneNumber(phoneNumber);
        		alumniModel.setGender(gender);
        		alumniModel.setPresentStatus(presentStatus);
        		alumniModel.setYearOfCompletition(yearOfCompletion);
        		
        		String outcome=alumniService.registerAlumni(alumniModel);
        		if(outcome.contentEquals("success")) {
        			 RequestDispatcher dispatcher=
        	    				request.getRequestDispatcher("AlumniSuccess.jsp");
        			 request.setAttribute("alumniModel",alumniModel);
           			 request.setAttribute("operation", "Below Alumni record Registration was Successfully");

        	    		dispatcher.forward(request,response);
        		}else {
        			 RequestDispatcher dispatcher=
        	    				request.getRequestDispatcher("ALumniFail.jsp");
           			 request.setAttribute("operation", "Alumni Registration Failed");

        	    		dispatcher.forward(request,response);
        		}
        		
        		
        	}


        	
        }
                
	}

}
