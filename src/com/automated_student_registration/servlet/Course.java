package com.automated_student_registration.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.automated_student_registration.bean.CourseDetailsBean;
import com.automated_student_registration.dao.CourseDetailsDao;
import com.automated_student_registration.dao.CourseDetailsDaoImp;

/**
 * Servlet implementation class Course
 */
@WebServlet("/Course")
public class Course extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Course() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String page=null;
		String msg = null;
		String name_val="course";
		String method = request.getParameter("method");
		String role = (String)session.getAttribute("role");
		if(role.equals("Admin"))
		{
			if(method!=null && method.equals("update")) {
				
				CourseDetailsBean bean = new CourseDetailsBean();
				bean.setCapacity(Integer.parseInt(request.getParameter("ccap")));
				bean.setFee(Integer.parseInt(request.getParameter("fee")));
				bean.setCourseId(request.getParameter("cid"));
				CourseDetailsDao cdao = new CourseDetailsDaoImp();
				RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
				if(cdao.updateCourse(bean))
				{
					
				msg = "course updated successfully";
				request.setAttribute("msg", msg);
				rd.forward(request, response);
				}
			
				
				
			}
		page="admin.jsp?name="+name_val;
		}
		else
			page="councilor.jsp?name="+name_val;
		RequestDispatcher rd=request.getRequestDispatcher(page);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		rd.forward(request, response);
		
	/*	RequestDispatcher rd=request.getRequestDispatcher("/");
		rd.forward(request, response);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
