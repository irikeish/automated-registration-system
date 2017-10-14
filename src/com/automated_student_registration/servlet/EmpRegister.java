package com.automated_student_registration.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.automated_student_registration.bean.EmpBean;
import com.automated_student_registration.dao.EmpDao;
import com.automated_student_registration.dao.EmpDaoImp;

/**
 * Servlet implementation class EmpRegister
 */
@WebServlet("/EmpRegister")
public class EmpRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String fname = request.getParameter("fname");
		String mname = request.getParameter("mname");
		String lname = request.getParameter("lname");
		String pass= request.getParameter("pass");
		String ph_no = request.getParameter("ph_no");
		String email =  request.getParameter("email");
		String address =request.getParameter("address");
		String role = request.getParameter("role");

		EmpBean  bean = new EmpBean(fname.trim(),mname.trim(),lname.trim()
				,pass,role);
		bean.setAddress(address);
		bean.setEmail(email);
		bean.setPh_no(ph_no);
		RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
		EmpDao cd = new EmpDaoImp();
		String id  = cd.insert(bean);
		if(id!=null){
			request.setAttribute("msg", "employee register");
			response.getWriter().print("employee is register and is "+id);
		}

		else
		{
			response.getWriter().print("error "+id);
		}

		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
