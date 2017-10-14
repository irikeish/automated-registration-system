package com.automated_student_registration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.automated_student_registration.bean.CourseDetailsBean;
import com.automated_student_registration.bean.StudentBean;
import com.automated_student_registration.utility.DbUtil;

public class CourseDetailsDaoImp implements CourseDetailsDao {
	static PreparedStatement PS=null;
	static Connection CONN=DbUtil.getConnect();
	static  String SQL=null;
	static ResultSet RS=null;

	@Override
	public ArrayList<CourseDetailsBean> getDetails() {
		
		ArrayList<CourseDetailsBean> a = new ArrayList<CourseDetailsBean>();
		SQL="select cid,course_name,duration,start_date,end_date,capacity,faculty,course_fee from course_details";
		
		 try{
				PS = CONN.prepareStatement(SQL);
				RS = PS.executeQuery();
				while(RS.next())
				{
				  CourseDetailsBean bean= new CourseDetailsBean(RS.getString("cid"),RS.getString("course_name"),
						  RS.getInt("duration"),RS.getString("start_date"),
							RS.getInt("capacity"),RS.getString("end_date"),RS.getString("faculty"),RS.getInt("course_fee"));
					a.add(bean);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return a;
	
	}
	
	@Override
	public ArrayList<CourseDetailsBean> getDetailsByName(String name) {

		ArrayList<CourseDetailsBean> a = new ArrayList<CourseDetailsBean>();
		SQL="select cid,course_name,duration,course_fee,start_date,end_date,capacity,faculty from course_details where course_name=?";
		
		 try{
				PS = CONN.prepareStatement(SQL);
				PS.setString(1, name);
				RS = PS.executeQuery();
				while(RS.next())
				{
					CourseDetailsBean bean= new CourseDetailsBean(RS.getString("cid"),RS.getString("course_name"),
							RS.getInt("duration"),RS.getString("start_date"),
							RS.getInt("capacity"),RS.getString("end_date"),RS.getString("faculty"),RS.getInt("course_fee"));
					a.add(bean);
				} 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return a;
	
	}

	
	public String insert(CourseDetailsBean bean) {
           String courseId=null;
		
		    SQL="insert into course_details(course_name,duration,start_date,capacity,course_fee,faculty) values(?,?,?,?,?,?)";
		
		    try {
				PS=CONN.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS);
				
				PS.setString(1, bean.getCourse_name());
				PS.setInt(2, bean.getDuration());
				PS.setString(3, bean.getStart_date());
				PS.setInt(4, bean.getCapacity());
				PS.setInt(5, bean.getFee());
				PS.setString(6,bean.getFaculty());
				
				
				
				
				if(PS.executeUpdate()>0)
					RS=PS.getGeneratedKeys();
				if(RS.next())
				{
					 courseId = "c"+RS.getInt(1);
				
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		
		
		
		return courseId;
	}

	public boolean updateCourse(CourseDetailsBean bean) {
		boolean flag=false;
		

		SQL="update course_details  set capacity=?,course_fee=? where cid=? ";
		try {
			PS=CONN.prepareStatement(SQL);
			PS.setInt(1, bean.getCapacity());
			PS.setString(3, bean.getCourseId());
			PS.setInt(2, bean.getFee());
			
			if(PS.executeUpdate()>0)
				flag=true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return flag;
	}

	@Override
	public CourseDetailsBean getDetailById(String id) {
		CourseDetailsBean b = null;
		
		SQL="select cid,course_name,duration,course_fee,start_date,end_date,capacity,faculty from course_details where cid=?";
		
		 try{
				PS = CONN.prepareStatement(SQL);
				PS.setString(1, id);
				RS = PS.executeQuery();
				if(RS.next())
				{
					b= new CourseDetailsBean(RS.getString("cid"),RS.getString("course_name"),
							RS.getInt("duration"),RS.getString("start_date"),
							RS.getInt("capacity"),RS.getString("end_date"),RS.getString("faculty"),RS.getInt("course_fee"));
				
				} 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			return b;
	}

	@Override
	public ArrayList<String> getDistinctCourse() {

		ArrayList<String> a = new ArrayList<String>();
		SQL="select distinct(course_name) as name from course_details";
		
		 try{
				PS = CONN.prepareStatement(SQL);
				RS = PS.executeQuery();
				while(RS.next())
				{
					a.add(RS.getString(1));
				} 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return a;	
		
		
		
	
	}

}
