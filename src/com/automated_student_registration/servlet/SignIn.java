package com.automated_student_registration.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.automated_student_registration.dao.EmpDao;
import com.automated_student_registration.dao.EmpDaoImp;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String role = request.getParameter("role");
		String page = "index.jsp";
		System.out.println(role);
		EmpDao edao =new EmpDaoImp();
		HttpSession session = request.getSession(true);
		if(role.equalsIgnoreCase("councilor")&&edao.validateCouncilor(request.getParameter("uname"), request.getParameter("pass")))
		{
			page="councilor.jsp";
			
			
			session.setAttribute("useridkey",request.getParameter("uname") );
			session.setAttribute("role","Councilor" );	
		}
		else if(role.equalsIgnoreCase("admin")&&edao.validateAdmin(request.getParameter("uname"), request.getParameter("pass")))
		{
			page="admin.jsp";
			session = request.getSession(true);
			session.setAttribute("useridkey",request.getParameter("uname") );
			session.setAttribute("role","Admin" );
		}
		else
			session.setAttribute("invalid", "true");
		response.sendRedirect(page);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
