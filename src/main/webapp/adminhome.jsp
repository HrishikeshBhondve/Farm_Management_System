<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.farm.utility.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@include file="header2.jsp" %>
  <%@ page import="com.farm.Bean.*" %>
  <jsp:useBean id="custBean" class="com.farm.Bean.CustomerBean" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 80%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 10px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
/* body {
  background-image: url(images/Lost-crop.jpg);
  background-repeat: no-repeat;
  background-size: cover;
} */
</style>


</head>
<body>
<div class="card text-center">
<div class="card-header" style=" font-family: sans-serif; color: #8bc34a;">
    Welcome To Farm Management System
  </div>
<br>
<!-- <h1 align="center">Admin Profile</h1> -->

<div class="row">
  <div class="col-sm-1"></div>
  <div class="col-sm-10"><%
Connection con=DBConnect.getConn();
Statement st=con.createStatement();
String str="SELECT * FROM F_USER WHERE ROLEID=1";
ResultSet rs=st.executeQuery(str);
while(rs.next())
{%>
	<h1 align="center">My Profile</h1>
		<table align="center" class="table">
  <tr>
  <td>Name</td><td><%=rs.getString(2) %></td></tr>
  <tr><td>UserName</td><td><%=rs.getString(3) %></td></tr>
  <tr><td>Mobile</td><td><%=rs.getString(4) %></td></tr>
  <tr><td>Password</td><td><%=rs.getString(5) %></td></tr>
  <tr><td>EMail</td><td><%=rs.getString(6) %></td></tr>
  <tr><td>City</td><td><%=rs.getString(7) %></td></tr>
  <tr><td>State</td><td><%=rs.getString(8) %></td></tr>
  <tr><td>Address</td><td><%=rs.getString(9) %></td></tr>
  

<%}

%>

</table></div>
  <div class="col-sm-1"></div>
</div>




<%-- <div style="margin-top: 289px">
<%@ include file="footer.jsp" %>
</div> --%></div>
</body>

</html>