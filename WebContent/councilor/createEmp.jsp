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



          
<!--  course creation  form --->



<div id="id01" class="modal sfont">
  <form class="modal-content animate" action="../EmpRegister" method="post">
    <div class="container">
 Enter First Name:     <input type="text" placeholder="first name" name="fname" required>
      Enter Middle Name: <input type="text" placeholder="middle name" name="mname" >
      Enter Last Name:<input type="text" placeholder="last name" name="lname" >
      Address:<input type="text" placeholder="address" name="address" ><br>
     Email::<input type="" placeholder="email" name="email" ><br>
     ph.no::<input type="text" placeholder="ph_no" name="ph_no" >
      Password :<input type="password" placeholder="password" name="pass" >
 
          role: <select name="role">
     
						<option>faculty</option>
						<option>councilor</option>       
    				 </select><br>
        <a href="../admin.jsp">Cancel</button>
        <button type="submit" class="signupbtn btn btn-primary">submit</button>
      </div>
    </div>
  </form>
</div>
         



</body>
</html>