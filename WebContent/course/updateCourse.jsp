<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <%@page import="java.util.ArrayList"%>
<%@page import="com.automated_student_registration.dao.CourseDetailsDaoImp"%>
<%@page import="com.automated_student_registration.bean.CourseDetailsBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <!-- <![endif]-->
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, , initial-scale=1">
    <title>update course</title>
    <!-- Place favicon.ico and apple-touch-icon.png in the root directory-->
    <link rel="shortcut icon" href="../favicon.ico">
    <!-- Styles-->
    <link rel="stylesheet" href="//cloud.typography.com/75214/688502/css/fonts.css">
    <link rel="stylesheet" href="../css/header.css">
    <!-- Modernizr for SVG image fallbacks. If you use your own build, make sure it has SVG test-->
    <script src="..js/modernizr.js"></script>
  </head>
  <body>
    <!--[if lt IE 7]>
    <p class="chromeframe">You are using an<strong>outdated</strong>browser. Please<a href="http://browsehappy.com/">upgrade your browser</a>or<a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a>to improve your experience.</p>
    <![endif]-->
    <header id="main-header" role="banner">
      <div id="header-top" class="wrapper">
        <div id="logo">
        </div>
     	<h1><a id="site-name" href="#" title="">update course</a></h1>
      </div>
    </header>
    
    
   <%
   
   
   

		String user = (String)session.getAttribute("useridkey");
		if(user==null)
		{
			response.sendRedirect("index.jsp");
		}

      	
      	if(request.getParameter("course_name")!=null)
      	{
			System.out.println("in course home page   "+request.getParameter("course_name"));
			CourseDetailsBean bean= new CourseDetailsDaoImp().getDetailById(request.getParameter("course_name"));

		%>
		
		
	
 <div class="text-center wrapper" id="content" role="main" class="wrapper clearfix sidebar-navigation">
 
<form class="text-center wrapper" action="../Course?method=update" method="post">

Course Id:<input type="text" name="cid" value="<%=bean.getCourseId()%>" readonly><br><br>
Course Name:<input type="text" name="cname" value="<%=bean.getCourse_name()%>" readonly><br><br>
Course StartDate:<input type="text" name="sDate" value="<%=bean.getStart_date()%>" readonly><br><br>
Course EndDate:<input type="text" name="eDate" value="<%=bean.getEnd_date()%>" readonly><br><br>
Course Capacity:<input type="number" name="ccap" value="<%=bean.getCapacity()%>"><br><br>
course fee:<input type="number" name = "fee" value="<%=bean.getFee() %>"><br><br>

<input type="submit" value="Update">
<a href="../Course">cancel</a>





</form>

<%}
		%>
		
		
</div>
    
    
    




</body>
</html>
