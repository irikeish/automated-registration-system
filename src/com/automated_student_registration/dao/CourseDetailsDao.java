package com.automated_student_registration.dao;

import java.util.ArrayList;

import com.automated_student_registration.bean.CourseDetailsBean;
import com.automated_student_registration.bean.EmpBean;
import com.automated_student_registration.bean.StudentBean;

public interface CourseDetailsDao {
	
	public String insert(CourseDetailsBean bean);
	public ArrayList<CourseDetailsBean> getDetails();
	public ArrayList<CourseDetailsBean> getDetailsByName(String name);
	public boolean updateCourse(CourseDetailsBean bean);
	public CourseDetailsBean getDetailById(String id);
	public ArrayList<String> getDistinctCourse();

}
