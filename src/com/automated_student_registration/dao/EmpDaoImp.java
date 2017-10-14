package com.automated_student_registration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.automated_student_registration.bean.EmpBean;
import com.automated_student_registration.bean.StudentBean;
import com.automated_student_registration.utility.DbUtil;


public class EmpDaoImp implements EmpDao{

	
	
	static PreparedStatement PS=null;
	static Connection CONN=DbUtil.getConnect();
	static  String SQL=null;
	static ResultSet RS=null;
	
	@Override
	public String insert(EmpBean bean) {
		
		String EmpId=null;
		
		SQL="insert into emp(fname,mname,lname,pass,designation,address,email,ph_no) values(?,?,?,?,?,?,?,?)";
		try {
			PS=CONN.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS);
		
		    PS.setString(1, bean.getFname());
		    PS.setString(2, bean.getMname());
		    PS.setString(3, bean.getLname());
		    PS.setString(4, bean.getPass());
		    PS.setString(5, bean.getDesignation());
		    PS.setString(6, bean.getAddress());
		    PS.setString(7, bean.getEmail());
		    PS.setString(8, bean.getPh_no());

			if(PS.executeUpdate()>0)
				RS=PS.getGeneratedKeys();
			if(RS.next())
			{
				EmpId  = "e"+RS.getInt(1);
			}
			
		    
		    
		    
		
		
		
		
		
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		// TODO Auto-generated method stub
		return EmpId;
	}

	@Override
	public EmpBean getDetailById(String s) {
		
		EmpBean bean=null;
		
		SQL="select eid,concat(fname,' ',mname,' ',lname) as name, pass,designation,email,ph_no from emp  where eid=?";
		try {
			PS=CONN.prepareStatement(SQL);
			PS.setString(1, s);	
			RS=PS.executeQuery();
			
			if(RS.next())
			{
				bean = new EmpBean();
				bean.setEid(RS.getString(1));
				bean.setName(RS.getString(2));
				bean.setPass(RS.getString(3));
				bean.setEmail(RS.getString(5));
				bean.setPh_no(RS.getString(6));
				bean.setDesignation(RS.getString(4));
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return bean;
	}

	@Override
	public boolean deleteEmp(int id) {
	
		boolean flag=false;
		
	      SQL="delete from emp where id=?";
			try {
				PreparedStatement PS=CONN.prepareStatement("SQL");
				
				PS.setInt(1, id);

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
	public boolean updateEmp(EmpBean bean) {
		boolean flag=false;
		
		
		SQL="update emp set fname=?,mname=?,lname=?,designation=? where eid=? ";
		try {
			PS=CONN.prepareStatement(SQL);
			;
			PS.setString(1, bean.getFname());
			PS.setString(1, bean.getMname());
			PS.setString(1, bean.getLname());
			PS.setString(1, bean.getDesignation());
			PS.setString(1, bean.getEid());
			
			if(PS.executeUpdate()>0)
				flag=true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	       return flag;
	
		}
	

	public ArrayList<EmpBean> getDetailCouncilor() {
		
		ArrayList<EmpBean> a = new ArrayList<EmpBean>();
		
		SQL="select eid,concat(fname,' ',mname,' ',lname) as name, pass,designation,email,ph_no from emp where designation='councilor'";
		try {
			PS=CONN.prepareStatement(SQL);
			
			RS=PS.executeQuery();
			
			while(RS.next())
			{
				EmpBean bean = new EmpBean();
				bean.setEid(RS.getString(1));
				bean.setName(RS.getString(2));
				bean.setPass(RS.getString(3));
				bean.setEmail(RS.getString(5));
				bean.setPh_no(RS.getString(6));
				bean.setDesignation(RS.getString(4));
				System.out.println(bean.getName());
		
				
			
			a.add(bean);
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return a;
	}

	@Override
	public ArrayList<EmpBean> getDetailFaculty() {
		ArrayList<EmpBean> a = new ArrayList<EmpBean>();
		
		
		
		SQL="select eid,concat(fname,' ',mname,' ',lname) as name, pass,designation,email,ph_no,address from emp where designation='faculty'";
		try {
			PS=CONN.prepareStatement(SQL);
			
			RS=PS.executeQuery();
			
			while(RS.next())
			{
				EmpBean bean = new EmpBean();
				bean = new EmpBean();
				bean.setEid(RS.getString(1));
				bean.setName(RS.getString("name"));
				bean.setPass(RS.getString(3));
				bean.setEmail(RS.getString(5));
				bean.setPh_no(RS.getString(6));
				bean.setDesignation(RS.getString(4));
				System.out.println(bean.getName());
				a.add(bean);
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public boolean validateCouncilor(String id, String pass) {
		
		
		try {
			
			String stmt="select * from emp where eid=? and pass=?";
			PreparedStatement ps=CONN.prepareStatement(stmt);
			ps.setString(1, id);
			ps.setString(2, pass);
			return(ps.executeQuery().next());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean validateAdmin(String id, String pass) {
		// TODO Auto-generated method stub
		return(id.equals("admin") && pass.equals("admin"));
	}
}
