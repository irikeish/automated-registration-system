<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.automated_student_registration.utility.*"%>
    
<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>manage student</title>
</head>

<%!



%>
<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

tr:hover{background-color:#f5f5f5}
</style>
</head>



<body>
<h1>all students are</h1>


<%

String user = (String)session.getAttribute("useridkey");
	if(user==null)
	{
		//out.print("please login");
		String path = request.getContextPath();
		response.sendRedirect(path+"/index.jsp");
		
	}

%>



		
<table align="center" style="width:100%">
	<thead><tr><th>ID</th><th>name</th><th>mail</th><th>phno</th><th>gender</th><th>address</th><th>courses</th></tr></thead>
	
	
	<%
	
	String pathUpdate=request.getContextPath()+"/student/studentUpdateForm.jsp?";
	String pathDelete=request.getContextPath()+"/StudentServlet?method=delete";
	
	try{
	Connection conn= DbUtil.getConnect();
	PreparedStatement ps=null;
	ResultSet rs=null;
	ResultSet rc=null;
	ps= conn.prepareStatement("select sid,name,email,ph_no,gender,address from studentView");
	rs = ps.executeQuery();
	while(rs.next()){
		String sid=rs.getString(1);
	%>


<tbody>

	<tr>
		<td><%=sid %></td>
		<td><%=rs.getString(2) %></td>
		<td><%=rs.getString(3) %></td>
		<td><%=rs.getString(4) %></td>
		<td><%=rs.getString(5) %></td>
		<td><%=rs.getString(6) %></td>
		<td>
		
		
		<%
			ps=conn.prepareStatement("select course_name from courseView where sid=?");
			ps.setString(1, sid);

			rc=ps.executeQuery();
			while(rc.next()){
		%>
			<ul>
			<li><%=rc.getString(1) %></li>
			</ul>
			
		<%} %>		</td>
		<td><a href="<%=pathUpdate %>sid=<%=rs.getString(1)%>">update</a></td>
		<td><a href="<%=pathDelete %>&sid=<%=rs.getString(1)%>&method=>">delete</a></td>
	
	</tr>
	
	</tbody>
	
	
<%} 
	
	
}catch (SQLException e) {

	out.print("sorry");
	e.printStackTrace();
}

String path=request.getContextPath()+"/index.jsp";

%>



</table>

<a href="<%=path%>">back</a>


</body>
</html>