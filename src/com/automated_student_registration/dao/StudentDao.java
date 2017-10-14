package com.automated_student_registration.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.automated_student_registration.bean.StudentBean;


public interface StudentDao {
	
	 public String insert (StudentBean bean);
	 public StudentBean getDetailById(String s);
	 public ArrayList<StudentBean> getDetails();
	 public boolean deleteStudent(String id);
	 public boolean updateStudent(StudentBean bean);

}
