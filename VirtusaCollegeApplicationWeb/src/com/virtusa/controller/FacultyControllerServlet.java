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

import com.virtusa.helper.FactoryFacultyService;
import com.virtusa.helper.FactoryStudentDB;
import com.virtusa.model.ClassScheduleModel;
import com.virtusa.model.ExamScheduleModel;
import com.virtusa.model.StaffMeetingModel;
import com.virtusa.service.FacultyService;

/**
 * Servlet implementation class FacultyControllerServlet
 */
@WebServlet("/FacultyControllerServlet")
public class FacultyControllerServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L; 
	private FacultyService facultyService = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */ 
    public FacultyControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	this.facultyService=FactoryFacultyService.createFacultyService();
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
		//doGet(request, response);
		
		String departmentName= request.getParameter("departmentName");
		System.out.println(departmentName);
		String action=request.getParameter("action");
		if(action.contentEquals("viewclassschedule")) {
			 List<ClassScheduleModel> classScheduleModelList=facultyService.retreiveClassSchedule(departmentName);
			
			request.setAttribute("classScheduleModelList",classScheduleModelList );
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("classschedulefaculty.jsp");
			dispatcher.forward(request,response);
		}
		
		if(action.contentEquals("viewstaffmeeting")) {
			 List<StaffMeetingModel> staffMeetingModelList=facultyService.handleRetrieveStaffMeeting(departmentName);
				request.setAttribute("staffMeetingModelList",staffMeetingModelList );
				RequestDispatcher dispatcher=
						request.getRequestDispatcher("staffmeeting.jsp");
				dispatcher.forward(request,response);
		}
		
		if(action.contentEquals("viewexamschedule")) {
			 List<ExamScheduleModel> examScheduleModelList=facultyService.handleRetrieveExamintionSchedule(departmentName);
				request.setAttribute("examScheduleModelList",examScheduleModelList );
				RequestDispatcher dispatcher=
						request.getRequestDispatcher("examschedule.jsp");
				dispatcher.forward(request,response);
		}
	}

}
