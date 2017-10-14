package com.automated_student_registration.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.automated_student_registration.bean.CourseBean;
import com.automated_student_registration.bean.StudentBean;
import com.automated_student_registration.dao.CourseDao;
import com.automated_student_registration.dao.CourseDaoImp;
import com.automated_student_registration.dao.StudentDao;
import com.automated_student_registration.dao.StudentDaoImp;
import com.automated_student_registration.utility.DbUtil;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private static Connection CONN=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */


	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		
		CONN=DbUtil.getConnect();		
	
		super.init();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		DbUtil.closeConnection();
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String method = request.getParameter("method");
		String sid = request.getParameter("sid");
		String msg=null;
		if(method.equals("delete")){		
			StudentDao sdao=new StudentDaoImp();
			CourseDao cdao = new CourseDaoImp();
			if(cdao.deleteCourseBySid(sid)&&sdao.deleteStudent(sid))
				msg="student deleted successfully";
			System.out.println("on delete request");
		}
		else
		{
			
			StudentBean sb = new StudentBean();
			sb.setAddress(request.getParameter("address"));
			sb.setEmail(request.getParameter("email"));
			sb.setPhone_no(request.getParameter("ph_no"));
			sb.setStudentId(request.getParameter("sid"));
			
			StudentDao sdao = new StudentDaoImp();
			sdao.updateStudent(sb);
			/*CourseBean cb = new CourseBean();
			cb.setCid(request.getParameter("course"));
			Connection conn = DbUtil.getConnect();
			*/
			
			System.out.println("on update request");
		}
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/student/manageStudent.jsp");
		request.setAttribute("msg", msg);
		rd.forward(request, response);
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath()).append(method).append(sid);
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
