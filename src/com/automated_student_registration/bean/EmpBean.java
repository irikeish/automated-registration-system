package com.automated_student_registration.bean;

import java.io.Serializable;

public class EmpBean implements Serializable {



	private String eid;
	   private String fname;
       private String mname;
       private String lname;
       private String designation;
       private String name;
       private String pass;
       private String ph_no;
       private String address;
       private String email;
	  
       
       
       public EmpBean() {
		super();
	}



	
       
       
       
       
       public EmpBean(String eid,String name, String pass, String designation,String email,String ph_no,String address) {
		super();
		this.eid=eid;
		this.designation = designation;
		this.name = name;
		this.pass = pass;
	}



	public EmpBean(String fname, String mname, String lname,
			String pass,String designation) {
		super();
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.designation = designation;
		this.pass=pass;
		
	}



	public String getFname() {
		return fname;
	}



	public void setFname(String fname) {
		this.fname = fname;
	}



	public String getMname() {
		return mname;
	}



	public void setMname(String mname) {
		this.mname = mname;
	}



	public String getLname() {
		return lname;
	}



	public void setLname(String lname) {
		this.lname = lname;
	}



	public String getDesignation() {
		return designation;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
	}


	
	
    public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}


    public String getEid() {
		return eid;
	}



	public void setEid(String eid) {
		this.eid = eid;
	}
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}








	public String getEmail() {
		return email;
	}








	public void setEmail(String email) {
		this.email = email;
	}








	public String getAddress() {
		return address;
	}








	public void setAddress(String address) {
		this.address = address;
	}








	public String getPh_no() {
		return ph_no;
	}








	public void setPh_no(String ph_no) {
		this.ph_no = ph_no;
	}
	
	
	
	
	

       
       
       
       
       








}
