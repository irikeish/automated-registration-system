package com.automated_student_registration.bean;

import java.io.Serializable;

public class StudentBean implements Serializable  {
	private String name;
	private String studentId;
	private String email;
	private String phone_no;
	private String fname;
	private String mname;
	private String lname;
	private String gender;
	private String address;
	
	public StudentBean() {
		super();
	}
	
	
	
	









	public StudentBean(String studentId, String email, String phone_no,
			String fname, String mname, String lname,String address) {
		super();
		this.studentId = studentId;
		this.email = email;
		this.phone_no = phone_no;
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.address=address;
	}




	public StudentBean(String  studentId, String email, String name,String phone_no,String address) {
		
		this.studentId = studentId;
		this.email = email;
		this.phone_no = phone_no;
		this.name=name;
		this.address=address;
	}




	public String getStudentId() {
		return studentId;
	}




	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPhone_no() {
		return phone_no;
	}




	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
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




	public String getName() {
		return name;
	}




	public void setName() {
		this.name = this.fname+" "+this.mname+" "+this.lname;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}













	public String getGender() {
		return gender;
	}













	public void setGender(String gender) {
		this.gender = gender;
	}









	
	
	
	
	

}
