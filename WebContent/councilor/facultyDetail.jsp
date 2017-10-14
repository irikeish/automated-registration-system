



<%@page import="java.net.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.automated_student_registration.dao.*"%>
<%@page import="com.automated_student_registration.bean.*"%>
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
	<thead><tr><th>Id</th><th>Name</th><th>email</th><th>ph_no</th><th>pass</th><th>Role</th></tr></thead>


<tbody>
<%

ArrayList<EmpBean> a= new EmpDaoImp().getDetailFaculty();

for(EmpBean bean:a){
	
	String id = bean.getEid();
%>


	<tr>
		<td><%=bean.getEid()%>
		</td><td><%=bean.getName()%></td>
		<td><%=bean.getEmail() %></td>
		<td><%=bean.getPh_no() %></td>
		<td><%=bean.getPass() %></td>
		<td><%=bean.getDesignation() %></td>
	
	</tr>

<%} %>

</tbody>
</table>









		
