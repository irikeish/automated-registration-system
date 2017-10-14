
<%@page import="com.automated_student_registration.bean.CourseDetailsBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    import="com.automated_student_registration.dao.*"

    
    %>
    
    <%@ page import="java.net.*" %>
    
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7]> <html lang="en" class="no-js oldie lt-ie9 lt-ie8 lt-ie7"><![endif]-->
<!--[if IE 7]>    <html lang="en" class="no-js oldie lt-ie9 lt-ie8"><![endif]-->
<!--[if IE 8]>    <html lang="en" class="no-js oldie lt-ie9"><![endif]-->
<!--[if gt IE 8]><!-->
<html lang="en" class="no-js">
  <!-- <![endif]-->
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>yify</title>
    <meta name="description" content="Description about your department.">
    <meta name="author" content="Your Department Name">
    <meta name="keywords" content="keyword 1, keyword 2, keyword 3">
    <meta name="viewport" content="width=device-width, , initial-scale=1">
    <!-- Place favicon.ico and apple-touch-icon.png in the root directory-->
    <link rel="shortcut icon" href="favicon.ico">
    <!-- Styles-->
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/responsive.css" media="all and (min-width:16em)">
    <!-- Scripts loaded via script loader. See notes in init.js file.-->
    <script src="js/modernizr.js"></script>
 
    <script src="js/init.js"></script>
  </head>
  <body>
    <!--[if lt IE 7]>
    <p class="chromeframe">You are using an<strong>outdated</strong>browser. Please<a href="http://browsehappy.com/">upgrade your browser</a>or<a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a>to improve your experience.</p>
    <![endif]-->
    <header id="main-header" role="banner">
      <div id="header-top" class="wrapper">
        <div id="logo">
        </div>
        <!-- This should link to your organization's home page-->
        <h1><a id="site-name" href="index.jsp" title="we are happy to teach you">Automated Student Registration System</a></h1>
          <form action="SignIn" method="post" align="right">
            <input  class = "sfont" type="text" required placeholder="username" name="uname">
            <input  class = "sfont"  type="password" required placeholder="pass" name="pass">
            <select  class = "sfont"  name="role" title="choose role">
                <option>Councilor</option>
                <option>Admin</option>
            </select>
            <input  type="submit"  class="sign-in button sfont  btn-info  " value="sign in">
          </form>
    
      </div>
    </header>
        
      <a href="#primary-nav" class="menu-button">Menu</a>
    
    <div id="content" role="main" class="wrapper clearfix sidebar-navigation">
      <!-- Breadcrumb-->
      <p>we are happy to teach you.</p>
      <ul class="breadcrumb">
        <li>
          <div class="dropdown"><a href="" data-toggle="dropdown" class="home dropdown-toggle needsclick"><i class="fa fa-home fa-lg"></i><span class="visuallyhidden">Home</span><i class="fa fa-caret-down"></i></a>
            <ul class="dropdown-menu">
              <li><a href="index.jsp">home</a></li>
            </ul><i class="divider fa fa-angle-right"></i>
          </div>
        </li>
      </ul> 
    
     
     
     
        <%
        
        
        String role=(String)session.getAttribute("role");
        System.out.println(role);
        if(role!=null)
        	response.sendRedirect(role);
        	if(session.getAttribute("invalid")!=null)
        	{
        		
        
        %>
        <p class="text-error text-right">invalid credentials enter valid user pass to login.</p>
        <%
        	session.invalidate();
        	}
        %>
        
        
        	
 		<%
        
        		if(request.getAttribute("msg")!=null)
        		{
        
        
        %>
    		<p><%=request.getAttribute("msg") %>
      				<%
      				
        		} %>
    
      
      <%
      	
      	if(request.getParameter("course_name")!=null)
      	{
			System.out.println("in course home page   "+request.getParameter("course_name"));
			ArrayList<CourseDetailsBean> a= new CourseDetailsDaoImp().getDetailsByName(request.getParameter("course_name"));
			for(CourseDetailsBean bean:a)
			{
				
			
		%>
		
		<h1><%=bean.getCourse_name() %>:</h1>
		<p>course id :<%=bean.getCourseId() %></p>
		<p>course start on :<%=bean.getStart_date() %></p>
		<p>Course ending on :<%=bean.getEnd_date() %></p>
		<p>fees :<%=bean.getFee() %></p>
		<%-- <p>faculty:<%= new EmpDaoImp().getDetailById(bean.getFaculty()).getName()%></p> --%>
		
		
		
		<% if(bean.getCapacity()>0)
				out.println("<h1>few seat available apply soon</h1>");
			else
				out.println("<h1>seat full contact to admin </h1>");
		%>
			
			
		<%}%>
	<%}%>

      <nav  role="navigation" class="sidebar">
        <ul>    
        </ul>
      </nav>
    </div>
    <div class="nav-container" >
      <!-- Primary Nav-->
      <nav id="primary-nav" role="navigation">
        <ul>
          <li ><a class="dropnbtn" href="">courses>:</a>
            <div class="sub">
                
              	 <%
        			
       				 CourseDetailsDao c =new CourseDetailsDaoImp(); 
    					ArrayList<String> a= new CourseDetailsDaoImp().getDistinctCourse();
    					for(String s : a)
    					{
    							    
       			%> 
              	
                <li><a href="?course_name=<%=URLEncoder.encode(s,"UTF-8")%>"><%= s%></a></li>
                <%} %>
            </div>
          </li>
        </ul>
      </nav>
  </div>

    <footer id="page-footer" role="contentinfo">
        <div id="footer-bottom">
       
      </div>
    </footer>
  </body>
  
  
  
  
  <style>
  
  .sfont{
    color:rebeccapurple;
    margin: 1px 1px 1px 1px;
    padding: px;
    letter-spacing: normal;
    border-style: groove;
    border-radius: 12px;
    border-spacing: inherit;
}
  
  </style>
  
  
</html>