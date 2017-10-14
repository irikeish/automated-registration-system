package com.automated_student_registration.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.automated_student_registration.bean.StudentBean;
import com.automated_student_registration.utility.DbUtil;



public class StudentDaoImp implements StudentDao {
	
	static PreparedStatement PS=null;
	static Connection CONN=DbUtil.getConnect();
	static  String SQL=null;
	static ResultSet RS=null;
	

	@Override
	public String insert(StudentBean bean) {
			String studentId=null;
			
			
			SQL="insert into student(email,ph_no,fname,mname,lname,gender,address) values(?,?,?,?,?,?,?)";
		
		     try {
				PS=CONN.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS);
				
				PS.setString(1, bean.getEmail());
				PS.setString(2, bean.getPhone_no());
				PS.setString(3, bean.getFname());
				PS.setString(4, bean.getMname());
				PS.setString(5, bean.getLname());
				PS.setString(6, bean.getGender());
				PS.setString(7, bean.getAddress());
				
				System.out.println("value to be inserted in student table ");
				
				if(PS.executeUpdate()>0)
					RS=PS.getGeneratedKeys();
				if(RS.next())
				{
					System.out.println("inserted");
					 studentId = "s"+RS.getInt(1);
				}
		     } catch (SQLException e) {
				e.printStackTrace();
			}
		     System.out.println("not inserted");

		return studentId;
	}


	@Override
	public StudentBean getDetailById(String s) {
		StudentBean bean = null;
		SQL="select sid,email,name,ph_no ,address from studentView where sid=?";
		try {
			PS=CONN.prepareStatement(SQL);
			PS.setString(1,s);
			RS=PS.executeQuery();
		
			if(RS.next())
			{
				bean = new StudentBean(RS.getString("sid"),
						RS.getString("email"),RS.getString("name"),RS.getString("ph_no"),RS.getString("address"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}


	@Override
	public ArrayList<StudentBean> getDetails() {
		ArrayList<StudentBean> a = new ArrayList<StudentBean>();
		SQL="select sid,email,name,ph_no from studentView";
		
		 try {
				PS = CONN.prepareStatement(SQL);
				RS = PS.executeQuery();
				while(RS.next())
				{
					StudentBean bean= new StudentBean(RS.getString("sid"),
							RS.getString("email"),RS.getString("name"),RS.getString("ph_no"), null);
					a.add(bean);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return a;
	}


	@Override
	public boolean deleteStudent(String sid) {
		
		boolean flag=false;
		
      SQL="delete from Student where sid=?";
		try {
			PreparedStatement PS=CONN.prepareStatement(SQL);
			
			PS.setString(1,sid);

			int x=PS.executeUpdate();
			
			if(x>0)
				flag=true;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return flag;
	}


	@Override
	public boolean updateStudent(StudentBean bean) {
		boolean flag=false;
		
		SQL="update student set email=?,ph_no=?,address=? where sid=? ";
		try {
			PS=CONN.prepareStatement(SQL);
			PS.setString(1, bean.getEmail());
			PS.setString(2, bean.getPhone_no());
			PS.setString(3,bean.getAddress());
			PS.setString(4, bean.getStudentId());
			
			if(PS.executeUpdate()>0)
				flag=true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		return flag;
	}


}
