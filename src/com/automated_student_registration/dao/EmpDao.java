package com.automated_student_registration.dao;

import java.util.ArrayList;

import com.automated_student_registration.bean.EmpBean;
import com.automated_student_registration.bean.StudentBean;

public interface EmpDao {
	
	
	public String insert(EmpBean bean);
	public EmpBean getDetailById(String s);
	 public boolean deleteEmp(int id);
	 public boolean updateEmp(EmpBean bean);
     public ArrayList<EmpBean>  getDetailCouncilor();
     public ArrayList<EmpBean>  getDetailFaculty();
     public boolean validateCouncilor(String id,String pass);
     public boolean validateAdmin(String id,String pass);
}
