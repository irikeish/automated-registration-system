<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    
   <%@page import="com.automated_student_registration.dao.CourseDetailsDaoImp"%>
  <%@page import="java.util.*"%>
  <%@page import="com.automated_student_registration.dao.CourseDetailsDao"%>
  <%@page import="com.automated_student_registration.bean.CourseDetailsBean"%>
  <%@page import="com.automated_student_registration.dao.EmpDaoImp"%>
  <%@page import="com.automated_student_registration.dao.EmpDao"%>
   <%@page import="com.automated_student_registration.bean.EmpBean"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>course details</title>
</head>
<body>




<%

	String user = (String)session.getAttribute("useridkey");
	if(user==null)
	{
		response.sendRedirect("index.jsp");
	}

String cname = request.getParameter("cname");
String sdate = request.getParameter("sdate");
String capacity = request.getParameter("capacity");
String fee = request.getParameter("fee");
String faculty = request.getParameter("faculty");
String duration = request.getParameter("duration");

/* out.print(sdate);
out.print(cname);
out.print(capacity);
out.print(fee);
out.print(faculty); */

CourseDetailsBean  bean = new CourseDetailsBean(cname.trim(),Integer.parseInt(duration),sdate.trim()
		,Integer.parseInt(capacity),Integer.parseInt(fee),faculty);

CourseDetailsDao cd = new CourseDetailsDaoImp();
String id  = cd.insert(bean);
if(id!=null){
	out.print("course is created and is "+id);
	
}

else
{
	out.print("error");
}

%>

<a href="../admin.jsp">back</a>


</body>
</html>