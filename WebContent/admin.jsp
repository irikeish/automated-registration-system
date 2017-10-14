<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@page import="java.net.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.automated_student_registration.dao.*"%>

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
    <title>yifyAdmin</title>
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
  
   
<style>






/* Dropdown Button */
.dropbtn {
    background-color: #4CAF50;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
    cursor: pointer;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
    position: relative;
    display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {background-color: #f1f1f1}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
    display: block;
}

/* Change the background color of the dropdown button when the dropdown content is shown */
.dropdown:hover .dropbtn {
    background-color: #3e8e41;
}




	.sfont{
	
	  	text-decoration-style:dashed;
    	font-size: 18px;
	}
      
      
</style>
  
  
  <body>
    <!--[if lt IE 7]>
    <p class="chromeframe">You are using an<strong>outdated</strong>browser. Please<a href="http://browsehappy.com/">upgrade your browser</a>or<a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a>to improve your experience.</p>
    <![endif]-->
    <header id="main-header" role="banner">
      <div id="header-top" class="wrapper">
        <div id="logo">
        </div>
        <!-- This should link to your organization's home page-->
        <h1><a id="site-name" href="#" title="">welcome ......admin</a></h1>
      </div>
    </header>

        
      <a href="#primary-nav" class="menu-button">Menu</a>
    
    <div id="content" role="main" class="wrapper clearfix sidebar-navigation">
      <!-- Breadcrumb-->
      <ul class="breadcrumb">
        <li>
          <div class="dropdown"><a href="" data-toggle="dropdown" class="home dropdown-toggle needsclick"><i class="fa fa-home fa-lg"></i><span class="visuallyhidden">Home</span><i class="fa fa-caret-down"></i></a>
            <ul class="dropdown-menu">
              <li><a href="admin.jsp">Home</a></li>
            </ul><i class="divider fa fa-angle-right"></i>
          </div>
        </li>
        <li class="active">nothing</li>
      </ul>      
      
      <%
      
      		String user = (String)session.getAttribute("useridkey");
      		if(user==null)
      		{
      			response.sendRedirect("index.jsp");
      		}
      
      %>
       
          
 		<p>welcome <%=user %></p>
 		
 		
 		<p>welcome to the online registration system</p>
 		
 		
 		<%
        
        		if(request.getAttribute("msg")!=null)
        		{
        
        
        %>
    		<p><%=request.getAttribute("msg") %>
      				<%
      				
        					} %>
 		
      
      
      <%
      
      	String title=request.getParameter("name");
      	String type=request.getParameter("role");
      	System.out.println("request from admin for "+title+" details");
      	if(title!=null){
      		
      		
      				if(title.equals("course")){
      		
			      	out.print("<h1>course:<h1>");
			
			      	
		%>
			 
			 		<a href="course/createCourse.jsp">create new course</a>
			 		
			      <%@ include file="course/home.jsp" %>
			      
			      
			      			<%} %>
			      			
			      		<%
			      		
			      		if(title.equals("councilor")){
			      			
			      			System.out.println(type);
			      			out.print("<h1>employee:<h1>");			      		
			      		
			      		%>	
			      		
			      		
			      		<a href="councilor/createEmp.jsp">register new employee</a><br>
			      		<a href="admin.jsp?name=councilor&role=faculty">faculty</a><br>
			      		<a href="admin.jsp?name=councilor&role=councilor">councilor</a>
			      		
			      		<% 
			      		if(type!=null&&type.equals("faculty") ){
			      			
			      		%>
    		
			      			<%@ include file="councilor/facultyDetail.jsp" %>
			      		<%}
			      		else if(type!=null&&type.equals("councilor"))
			      		{
			      			
										      		
			      		%>
			      			<%@ include file="councilor/councilorDetail.jsp" %>
			      			
			      			
			      		<% }%>	
			      			
			      			
			    <%}
			      		}%>
			     
			   
      		
      		
     		
         
   
    
      
      
      
      
      <nav role="navigation" class="sidebar sfont">
        <ul class = "list">
          <li><a href="admin.jsp?name=councilor">employee</a></li>
          <li><a href="student/manageStudent.jsp">Student</a></li>
          <li><a href="Course">courses</a></li>
        </ul>
      </nav>
    </div>
    
    
    
    
   
    
    
    
    
    
    
    
    
    <div class="nav-container">
      <!-- Primary Nav-->
      <nav id="primary-nav" role="navigation">
        <ul class = "invisible"><li> <a href="#" class="single current">coursesbshdbus</a></li></ul>
        <ul class = "invisible"><li> <a href="#" class="single current">courydusbhdsbbses</a></li></ul>
        <ul class = "invisible"><li> <a href="#" class="single current">codsuyydurses</a></li></ul>
        <ul class = "invisible"><li> <a href="#" class="single current">coursedsyuyubsds</a></li></ul>
        
         <ul>
          <li align ="right"> <a  href="#" class="single current " title="profile_name"  ></a></li>
         </ul>

         <ul>
          <li align ="right" ><a href="SignOut" class="single current">logout</a></li>
         </ul>

      </nav>
         </div>
         
         
         
         
         
         
         
         
         
         
         
         
         
    <footer id="page-footer" role="contentinfo">
        <div id="footer-bottom">
        
      </div>
    </footer>

    
  </body>
</html>