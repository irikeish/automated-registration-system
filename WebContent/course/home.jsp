<%@page import="java.net.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.automated_student_registration.dao.CourseDetailsDaoImp"%>
<%@page import="com.automated_student_registration.bean.CourseDetailsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>




<style>


table {
    width: 716px; /* 140px * 5 column + 16px scrollbar width */
    border-spacing: 0;
}


table , th ,td {

text-decoration-style:dashed;
    font-family:cursive;
    font-size: 18px;


}

/* tbody, thead tr { display: block; } */

tbody {
    height: 100px;
   /*  overflow-y: auto;
    overflow-x: hidden; */
}

tbody td, thead th {
    width: 240px;
}

thead th:last-child {
    width: 156px; /* 140px + 16px scrollbar width */
}

</style>		
		
<table style="width:100%">
	<thead><tr><th>Course ID</th><th>Course Name</th><th>Start Date</th><th>End Date</th><th>capacity</th></tr></thead>


<tbody>
<%

ArrayList<CourseDetailsBean> a= new CourseDetailsDaoImp().getDetails();

for(CourseDetailsBean bean:a){
	
	String id = bean.getCourseId();
%>


	<tr>
		<td><%=bean.getCourseId()%>
		</td><td><%=bean.getCourse_name() %></td>
		<td><%=bean.getStart_date() %></td>
		<td><%=bean.getEnd_date() %></td>
		<td><%=bean.getCapacity() %></td>
		<%-- <td><a href="updateCourse.jsp?cid<%=bean.getCourseId()%>">update</a></td> --%>
	<% 	
		String role=(String)session.getAttribute("role");
	System.out.println(role);
	if(role.equals("Admin")){
		
		%>
	
	
	
		
		<td id = "145"><a id="145" href="course/updateCourse.jsp?course_name=<%=URLEncoder.encode(bean.getCourseId(),"UTF-8")%>">update</a></td>
	
		<%} %>	
	</tr>

<%} %>

</tbody>
</table>









		
