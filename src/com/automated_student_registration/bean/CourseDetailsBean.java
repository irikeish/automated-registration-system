package com.automated_student_registration.bean;

import java.io.Serializable;

public class CourseDetailsBean implements Serializable{
      private String course_name;
      private int duration;
      private String start_date;
      private int capacity;
      private String end_date;
      private String courseId; 
      private int fee;
      private String faculty;
   
	
      
      
      
      public CourseDetailsBean(String course_name, int duration, String start_date, int capacity, int fee,
			String faculty) {
		super();
		this.course_name = course_name;
		this.duration = duration;
		this.start_date = start_date;
		this.capacity = capacity;
		this.setFee(fee);
		this.setFaculty(faculty);
	}




	public String getCourseId() {
		return courseId;
	}




	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}


	

	public CourseDetailsBean(String courseId,String course_name, int duration,
			String start_date, int capacity, String end_date, 
			String faculty, int course_fee) {
		super();
		this.course_name = course_name;
		this.duration = duration;
		this.start_date = start_date;
		this.capacity = capacity;
		this.end_date = end_date;
		this.courseId = courseId;
		this.setFaculty(faculty);
		this.setFee(course_fee);
	}



	public CourseDetailsBean(String course_name, int duration, String start_date, int capacity, String end_date,
			String courseId) {
		super();
		this.course_name = course_name;
		this.duration = duration;
		this.start_date = start_date;
		this.capacity = capacity;
		this.end_date = end_date;
		this.courseId = courseId;
	}




	public CourseDetailsBean() {
		super();
	}




	public CourseDetailsBean(String course_name, int duration,
			String start_date, int capacity) {
		super();
		this.course_name = course_name;
		this.duration = duration;
		this.start_date = start_date;
		this.capacity = capacity;
	}




	public String getCourse_name() {
		return course_name;
	}




	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}




	public int getDuration() {
		return duration;
	}




	public void setDuration(int duration) {
		this.duration = duration;
	}




	public String getStart_date() {
		return start_date;
	}




	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}




	public int getCapacity() {
		return capacity;
	}




	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}




	public String getEnd_date() {
		return end_date;
	}




	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}




	public String getFaculty() {
		return faculty;
	}




	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}




	public int getFee() {
		return fee;
	}




	public void setFee(int fee) {
		this.fee = fee;
	}
      
      
      
	
 
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
   }
