package com.virtusa.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtusa.helper.FactoryLoginDB;
import com.virtusa.model.LoginModel;
import com.virtusa.service.LoginService;



/**
 * Servlet implementation class AuthorizationController
 */
@WebServlet("/login")
public class LoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginModel loginModel=null;
	private LoginService loginService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		this.loginService=FactoryLoginDB.createLoginService();
		this.loginModel=new LoginModel();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().println("servlet get");
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
	
		loginModel.setUserId(username);
		loginModel.setPassword(password);
		
		request.setAttribute("username",username);
		HttpSession session = request.getSession();
        session.setAttribute("username",username);
				String outcome=null;
				try {
					 outcome=loginService.userAuthenticationService(loginModel);
					//System.out.print("value="+outcome);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(outcome.contentEquals("ADMIN")){
					
					RequestDispatcher dispatcher=
							request.getRequestDispatcher("admin.jsp");
					dispatcher.include(request,response);
					
				}
				else if(outcome.contentEquals("STUDENT")){
					RequestDispatcher dispatcher=
							request.getRequestDispatcher("student.jsp");
					dispatcher.forward(request,response);
				}
				else if(outcome.contentEquals("FACULTY")){
					RequestDispatcher dispatcher=
							request.getRequestDispatcher("Faculty.jsp");
					dispatcher.forward(request,response);
				}
				else if(outcome.contentEquals("ALUMNI")){
					RequestDispatcher dispatcher=
							request.getRequestDispatcher("Alumni.html");
					dispatcher.forward(request,response);
				}

				else {
					RequestDispatcher dispatcher=
							request.getRequestDispatcher("error.html");
					dispatcher.forward(request,response);
				}		
		}
	}
	


