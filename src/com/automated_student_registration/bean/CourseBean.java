package com.automated_student_registration.bean;

import java.io.Serializable;

public class CourseBean implements Serializable{
	private String cid;
	private String sid;
	private String faculty;
	
	
	public CourseBean() {
		super();
	}


	public CourseBean(String cid, String sid, String faculty) {
		super();
		this.cid = cid;
		this.sid = sid;
		this.faculty = faculty;
	}


	public String getCid() {
		return cid;
	}


	public void setCid(String cid) {
		this.cid = cid;
	}


	public String getSid() {
		return sid;
	}


	public void setSid(String sid) {
		this.sid = sid;
	}


	public String getFaculty() {
		return faculty;
	}


	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	
	
	
	
	
	

}
