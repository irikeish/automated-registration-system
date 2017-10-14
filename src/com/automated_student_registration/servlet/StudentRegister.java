package com.automated_student_registration.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.automated_student_registration.bean.CourseBean;
import com.automated_student_registration.bean.CourseDetailsBean;
import com.automated_student_registration.bean.StudentBean;
import com.automated_student_registration.dao.CourseDao;
import com.automated_student_registration.dao.CourseDaoImp;
import com.automated_student_registration.dao.CourseDetailsDao;
import com.automated_student_registration.dao.CourseDetailsDaoImp;
import com.automated_student_registration.dao.StudentDao;
import com.automated_student_registration.dao.StudentDaoImp;
import com.automated_student_registration.utility.DbUtil;

/**
 * Servlet implementation class StudentRegister
 */
@WebServlet("/StudentRegister")
public class StudentRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("in student register servlet");
		String cid = null;
		cid=request.getParameter("course");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		StudentBean sb = new StudentBean();
		sb.setAddress(request.getParameter("address").trim());
		sb.setFname(request.getParameter("fname").trim());
		sb.setLname(request.getParameter("lname").trim());
		sb.setMname(request.getParameter("mname").trim());
		sb.setPhone_no(request.getParameter("ph_no").trim());
		sb.setEmail(request.getParameter("email").trim());
		sb.setGender(request.getParameter("gender").trim());	
		StudentDao sdao = new StudentDaoImp();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from student where email=? and ph_no=?");
			ps.setString(1, sb.getEmail());
			ps.setString(2, sb.getPhone_no());
			ResultSet rs = ps.executeQuery();
			if(!rs.next())
			{
				CourseDetailsDao cddao = new CourseDetailsDaoImp();
				
				CourseDetailsBean cdb = cddao.getDetailById(cid);
				CourseBean cb = new CourseBean();
				cb.setCid(cdb.getCourseId());
				cb.setFaculty(cdb.getFaculty());
				
				CourseDao cdao = new CourseDaoImp();
				
				String sid = sdao.insert(sb);
				if(sid!=null)
					response.getWriter().append("   student register in course:").append(request.getParameter("course")+" with id").append(sid)
					;
				cb.setSid(sid);
				if(cdao.insert(cb))
				{
					String s = " student register with id "+sid;
					response.sendRedirect("councilor.jsp?msg="+URLEncoder.encode(s,"UTF-8"));
						response.getWriter().append("  student is added to the course");
				}
				
				
			}
			
			else
			{
				String s = " student is alredy register add new course for user";
				response.sendRedirect("councilor.jsp?msg="+URLEncoder.encode(s,"UTF-8"));
				response.getWriter().append("student is already register please add new course for user");
		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		
	}
		
	@Override
	public void init() throws ServletException {
		
		conn = DbUtil.getConnect();	
		
		
		super.init();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
