package com.automated_student_registration.dao;



import com.automated_student_registration.bean.CourseBean;


public interface CourseDao {

	 public boolean insert (CourseBean bean);
	 public boolean deleteCourse(String cid,String sid);
	public boolean  deleteCourseBySid(String sid);
	 

}
