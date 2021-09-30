<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.farm.utility.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.farm.Bean.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="userheader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 80%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
<div class="card text-center">
<div class="card-header" style=" font-family: sans-serif; color: #8bc34a;">
    Welcome To Farm Management System
  </div>
  
<%
if(session.getAttribute("user")!=null)
{
	String uname=(String)session.getAttribute("user");
	Connection con=DBConnect.getConn();
	Statement st=con.createStatement();
	String sql="SELECT * FROM F_USER WHERE USERNAME='"+uname+"'";
	ResultSet rs=st.executeQuery(sql);
	while(rs.next())
	{%>
	<h1 align="center">My Profile</h1>
		<table align="center">
		<tr><td>Name</td><td><%=rs.getString(2) %></td></tr>
		<tr><td>Username</td><td><%=rs.getString(3) %></td></tr>
		<tr><td>Mobile Number</td><td><%=rs.getString(4) %></td></tr>
		<tr><td>Password</td><td><%=rs.getString(5) %></td></tr>
		<tr><td>EMail</td><td><%=rs.getString(6) %></td></tr>
		<tr><td>City</td><td><%=rs.getString(7) %></td></tr>
		<tr><td>State</td><td><%=rs.getString(8) %></td></tr>
		<tr><td>Address</td><td><%=rs.getString(9) %></td></tr>
		
		
		</table>
	<% }
}


%>
</div>
</body>
</html>