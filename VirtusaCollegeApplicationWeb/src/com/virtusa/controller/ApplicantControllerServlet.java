package com.virtusa.controller;

import java.io.Console;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.converter.DateConverter;
import com.virtusa.helper.FactoryApplicantService;
import com.virtusa.model.ApplicantModel;
import com.virtusa.service.ApplicantService;
import com.virtusa.validation.ApplicantModelValidator;

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
		
		/*String action=request.getParameter("action");
	
		if(action.contentEquals("loadadmissionsform")) {
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
	}*/
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       // String action=request.getParameter("action");
     //   System.out.println(action);
      //  if(action.contentEquals("loadadmissionsform")) {
        	
        	//int applicantId=Integer.parseInt(request.getParameter("applicantId"));
        	
        	String firstName=request.getParameter("firstName");
        	String lastName=request.getParameter("lastName");
        	String email=request.getParameter("email");
        	String phoneNumber=request.getParameter("phoneNumber");
        	double tenthPercentage=Double.parseDouble(request.getParameter("tenthPercentage"));
        	double interPercentage=Double.parseDouble(request.getParameter("interPercentage"));
        	String aadharNumber=request.getParameter("aadharNumber");
        	String dob=request.getParameter("dateOfBirth");

        	LocalDate dateOfBirth=DateConverter.convertLocaleDate("dob", "-");

        	String departmentName=request.getParameter("departmentName");
        	
        	ApplicantModelValidator validator=new ApplicantModelValidator();
        	boolean validFirstName=validator.validString(firstName);
        	boolean validLastName=validator.validString(lastName);
        	boolean validEmail=validator.validEmail(email);
        	boolean emailExist=validator.emailExists(email);
    		
          
        	if(!validFirstName || !validLastName || !validEmail || emailExist) {
        		
        		  
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
        		
        	}else {
        		ApplicantModel applicantModel=new ApplicantModel();
        		applicantModel.setFirstName(firstName);
        		applicantModel.setLastName(lastName);
        		applicantModel.setEmail(email);
        		applicantModel.setPhoneNumber(phoneNumber);
        		applicantModel.setTenthPercentage(tenthPercentage);
        		applicantModel.setInterPercentage(interPercentage);
        		applicantModel.setAadharNumber(aadharNumber);
        		applicantModel.setDateOfBirth(dateOfBirth);
        		applicantModel.setDepartmentName(departmentName);
        		
        		String outcome=applicantService.storeApplicantService(applicantModel);
        		if(outcome.contentEquals("success")) {
        			 RequestDispatcher dispatcher=
        	    				request.getRequestDispatcher("ApplicationSuccessful.jsp");
        			 request.setAttribute("applicantModel", applicantModel);
           			 request.setAttribute("operation", "Registration was Successful");

        	    		dispatcher.forward(request,response);
        		}else {
        			 RequestDispatcher dispatcher=
        	    				request.getRequestDispatcher("ApplicationSuccessful.jsp");
           			 request.setAttribute("operation", "Application Unsuccessful");

        	    		dispatcher.forward(request,response);
        		}
        		
        		
        	}


        	
        }	
	}
//}
