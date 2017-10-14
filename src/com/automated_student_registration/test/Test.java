package com.automated_student_registration.test;

import com.automated_student_registration.dao.CourseDao;
import com.automated_student_registration.dao.CourseDaoImp;
import com.automated_student_registration.dao.StudentDao;
import com.automated_student_registration.dao.StudentDaoImp;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		StudentDao sdao=new StudentDaoImp();
		CourseDao cdao = new CourseDaoImp();
		if(sdao.deleteStudent("s1"))
		System.out.println("on delete request");

	}

}
