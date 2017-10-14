package com.automated_student_registration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.automated_student_registration.bean.CourseBean;
import com.automated_student_registration.bean.StudentBean;
import com.automated_student_registration.utility.DbUtil;

public class CourseDaoImp implements CourseDao {

	
	
	
	static PreparedStatement PS=null;
	static Connection CONN=DbUtil.getConnect();
	static  String SQL=null;
	static ResultSet RS=null;
	
	
	
	public boolean insert(CourseBean bean) {
		
		
		
        boolean Sid=false;
		
		SQL="insert into course(cid,sid,faculty) values(?,?,?)";
		try {
			PS=CONN.prepareStatement(SQL);
		
		    PS.setString(1, bean.getCid());
		    PS.setString(2, bean.getSid());
		    PS.setString(3, bean.getFaculty());
		    
		    

			if(PS.executeUpdate()>0)
			
			Sid = true;
			
			
		    
		    
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		// TODO Auto-generated method stub
		return Sid;
	}



	@Override
	public boolean deleteCourse(String cid, String sid) {
		boolean flag=false;
	      SQL="delete from course where cid=?,sid=?";
			try {
				PreparedStatement PS=CONN.prepareStatement(SQL);
				
				PS.setString(1,cid );
				PS.setString(2,sid );

			int x =PS.executeUpdate();
				
				if(x>0)
					flag=true;
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		return flag;
	}



	@Override
	public boolean deleteCourseBySid(String sid) {
	
		boolean flag=false;
	      SQL="delete from course where sid=?";
			try {
				PreparedStatement PS=CONN.prepareStatement(SQL);
				PS.setString(1,sid);

			int x =PS.executeUpdate();
				
				if(x>0)
					flag=true;
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		return flag;
		
	}

}
