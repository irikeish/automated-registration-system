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
<title>new course</title>

</head>



             <style>
/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
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
.modal {
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
}

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


/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
    .cancelbtn, .signupbtn {
       width: 100%;
    }
}
</style>     
      

    
    
    
    
    

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
        


<body>



     <%
     

		String user = (String)session.getAttribute("useridkey");
		if(user==null)
		{
			response.sendRedirect("index.jsp");
		}

     
     
     %>     
<!--  course creation  form --->



<div id="id01" class="modal sfont">
  <form class="modal-content animate" action="../course/courseDetail.jsp" method="post">
    <div class="container">
    Course Name:   <input type="text" placeholder="course name" name="cname" required><br><br>
    Start Date  :   <input type="date" placeholder=" yyyy-mm-dd" name="sdate" ><br><br>
    Capacity   :  <input type="number" placeholder="capacity" name="capacity" required><br><br>
    Duration   :  <input type="number" placeholder="duration in days" name="duration" required><br><br>
     Course fee:<input type="number" placeholder="course fee" name="fee" required><br><br>
     faculty: <select name="faculty">
      
      <%
      	
     
      
      	
      EmpDao edi = new EmpDaoImp();
      ArrayList<EmpBean> a = edi.getDetailFaculty();
      
      for(EmpBean bean:a ){
      
      		
      		
      
      		
      
      
      
      	
      
      %>
        
     
          	<option><%=bean.getEid() %></option>
          			
          <%} %>
       
    				 </select><br>
        <a href="../councilor.jsp">Cancel</a>
        <button type="submit" class="signupbtn btn btn-primary">confirm course</button>
      </div>
    </div>
  </form>
</div>
         



</body>
</html>