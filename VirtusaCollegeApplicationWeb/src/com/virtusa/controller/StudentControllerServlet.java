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
import javax.servlet.http.HttpSession;

import com.virtusa.helper.FactoryStudentDB;
import com.virtusa.model.ClassScheduleModel;
import com.virtusa.model.ExamScheduleModel;
import com.virtusa.model.PlacementCalenderModel;
import com.virtusa.model.ResultsModel;
import com.virtusa.service.StudentService;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService studentService=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	this.studentService=FactoryStudentDB.createStudentService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		/*HttpSession session=request.getSession();
		String departmentName=(String) session.getAttribute("departmentname");
		System.out.println(departmentName);*/
		
		System.out.println("hello");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String departmentName= request.getParameter("departmentName");
		System.out.println(departmentName);
		String action=request.getParameter("action");
		if(action.contentEquals("viewclassschedule")) {
			 List<ClassScheduleModel> classScheduleModelList=studentService.retrieveClassSchedule(departmentName);
			
			request.setAttribute("classScheduleModelList",classScheduleModelList );
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("classschedule.jsp");
			dispatcher.forward(request,response);
		}
		if(action.contentEquals("viewexamschedule")) {
			 List<ExamScheduleModel> examScheduleModelList=studentService.retrieveExamSchedule(departmentName);
				request.setAttribute("examScheduleModelList",examScheduleModelList );
				RequestDispatcher dispatcher=
						request.getRequestDispatcher("examschedule.jsp");
				dispatcher.forward(request,response);
		}
		int studentId=Integer.parseInt(request.getParameter("studentId"));
		System.out.println(studentId);
		if(action.contentEquals("viewresults")) {
			 List<ResultsModel> resultsModelList=studentService.retrieveResults(studentId);
				request.setAttribute("resultsModelList",resultsModelList );
				RequestDispatcher dispatcher=
						request.getRequestDispatcher("results.jsp");
				dispatcher.forward(request,response);
		}
		if(action.contentEquals("viewplacementcalender")) {
			 List<PlacementCalenderModel> placementCalenderModelList=studentService.retrievePlacementCalender();
				request.setAttribute("placementCalenderModelList",placementCalenderModelList );
				RequestDispatcher dispatcher=
						request.getRequestDispatcher("placementcalender.jsp");
				dispatcher.forward(request,response);
		}
	}

}
