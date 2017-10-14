<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
    
   
<%@page import="com.automated_student_registration.bean.CourseDetailsBean"%>
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
    
    
    
      <title>yifyRegistrar</title>
    
  </head>


  <style>


   
	.sfont{
	
	  	text-decoration-style:dashed;
    	font-size: 18px;
	}
      
      

       
/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}



 
  
 .link_l:hover,.link_l:focus{
	cursor: pointer;
}
  
  
 

/* Float cancel and signup buttons and add an equal width */
.cancelbtn,.signupbtn {float:left;width:50%}

/* Add padding to container elements */
.container {
    padding: 16px;
}




 .sfont{
    color:rebeccapurple;
    margin: 1px 1px 1px 1px;
    padding: px;
    letter-spacing: normal;
    border-style: groove;
    border-radius: 12px;
    border-spacing: inherit;
}
  

/* The Modal (background) */


/* Modal Content/Box */
.modal-content {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid #888;
    width: 80%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
    position: absolute;
    right: 35px;
    top: 15px;
    font-size: 40px;
    font-weight: bold;
}



.close:hover,
.close:focus {
    color: red;
    cursor: pointer;
}

/* Clear floats */
.clearfix::after {
    content: "";
    clear: both;
    display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
    .cancelbtn, .signupbtn {
       width: 100%;
    }
}





.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    padding-top: 100px;
}</style>

  <body>
  
  
  
  <%
  
  
  		String user = (String)session.getAttribute("useridkey");

  		if(user==null)
  		{
  			response.sendRedirect("index.jsp");
  		}
  
  %>
  
  
  
  
    <!--[if lt IE 7]>
    <p class="chromeframe">You are using an<strong>outdated</strong>browser. Please<a href="http://browsehappy.com/">upgrade your browser</a>or<a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a>to improve your experience.</p>
    <![endif]-->
    <header id="main-header" role="banner">
      <div id="header-top" class="wrapper">
        <div id="logo">
        </div>
        <!-- This should link to your organization's home page-->
        <h1><a id="site-name" href="index.jsp" title="">welcome ......councilor</a></h1>
      </div>
    </header>        
      <a href="#primary-nav" class="menu-button">Menu</a>
    
    <div id="content" role="main" class="wrapper clearfix sidebar-navigation">
      <!-- Breadcrumb-->
      <ul class="breadcrumb">
        <li>
          <div class="dropdown"><a href="" data-toggle="dropdown" class="home dropdown-toggle needsclick"><i class="fa fa-home fa-lg"></i><span class="visuallyhidden">Home</span><i class="fa fa-caret-down"></i></a>
            <ul class="dropdown-menu">
              <li><a href="index.jsp">Home</a></li>
            </ul><i class="divider fa fa-angle-right"></i>
          </div>
        </li>
        <li class="active">nothing</li>
      </ul>
      <h1>welcome</h1>
      
			<%
        
        		if(request.getAttribute("msg")!=null)
        		{
        
        
        %>
    		<p><%=request.getAttribute("msg") %>
      				<%
      				
        					} %>
     
      <p><%=user %></p>
      
      
	 <%
      
      	String title=request.getParameter("name");
      	System.out.println("request from admin for "+title+" details");
      	if(title!=null){
      		
      		
      				if(title.equals("course")){
      		
			      	out.print("<h1>course:<h1>");
			
			      	
		%>
			 
			 		<a href="course/createCourse.jsp">create new course</a>
			 		
			      <%@ include file="course/home.jsp" %>
			      
			      
			      			<%} }%>
			   
       
      <nav role="navigation" class="sidebar sfont">
        <ul>
          <li><a class=".link_l" href="Course">courses</a></li>
          <li ><a class=".link_l" href="student/manageStudent.jsp">students</a></li>
       	<li class="link_l" ><a  onclick="document.getElementById('id01').style.display='block'" style="width:auto;">register Student</a></li>  
        </ul>
      </nav>
    </div>
    <div class="nav-container">
      <!-- Primary Nav-->
      <nav id="primary-nav" role="navigation">
         <ul>
          <li align="right"> <a  href="#" class="single current " title="profile_name">/a></li>
          <li align ="right" ><a href="SignOut" class="single current" title="logout">logout</a></li>
         </ul>

      </nav>
         </div>
    <footer id="page-footer" role="contentinfo">
        <div id="footer-bottom">

<!--  

sign up form
-->
<div id="id01" class="modal sfont">
  <span onclick="document.getElementById('id01').style.display='none'" class="close btn" title="Close">×</span>
  <form class="modal-content animate" action="StudentRegister" method="post">
    <div class="container">
     Name first Name: <input type="text" placeholder="first name" name="fname" required>
      Name middle Name:<input type="text" placeholder="middle name" name="lname" >
    Name Last Name:  <input type="text" placeholder="last name" name="mname" required>
     Email: <input type="email" placeholder="email" name="email" required>
     Password: <input type="num" placeholder="phone no" name="ph_no" required>
        
        
         <select aria-label="gender" name="gender">
                <option value="m">male</option><option value="f">female</option><option value="o">other</option>
            </select>  
           
            course: <select name="course">
              	 <%
        
       				 CourseDetailsDao c =new CourseDetailsDaoImp(); 
    					ArrayList<CourseDetailsBean> a= c.getDetails();
    					for(CourseDetailsBean bean : a)
    					{
    							if(bean.getCapacity()>0){
    								
    							
       			%> 
      <option value=<%=bean.getCourseId() %>><%=bean.getCourse_name() %></option>  
      <%} 
      }%> 
 
     </select>
      <input type="text" placeholder="address" name="address" required>
      <div class="clearfix">
        <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn btn btn-danger">Cancel</button>
        <button type="submit" class="signupbtn btn btn-primary">register student</button>
      </div>
    </div>
  </form>
</div>



        
      </div>
    </footer>
  </body>
  



<script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>

  
  
  
</html>