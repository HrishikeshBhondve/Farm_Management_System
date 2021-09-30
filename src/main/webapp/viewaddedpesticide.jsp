<%@page import="com.farm.utility.Validation"%>
<%@page import="com.farm.Bean.CropBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.farm.utility.DBConnect"%>
<%@page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.text.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header2.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	font-family: Arial;
}

* {
	box-sizing: border-box;
}

form.example input[type=text] {
	padding: 10px;
	font-size: 17px;
	border: 1px solid grey;
	float: left;
	width: 80%;
	background: #f1f1f1;
}

form.example button {
	float: left;
	width: 20%;
	padding: 10px;
	background: #2196F3;
	color: white;
	font-size: 17px;
	border: 1px solid grey;
	border-left: none;
	cursor: pointer;
}

form.example button:hover {
	background: #0b7dda;
}

form.example::after {
	content: "";
	clear: both;
	display: table;
}

/* table formatting */
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
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
	<br>
	<h1 align="center">All Pesticides Information</h1>
	<br>
	<div class="row">
		<div class="col-sm-1"></div>
		<div class="col-sm-10">
			<table>
				<tr>
					<th>ID</th>
					<th>Image</th>
					<th>Pesticide Name</th>
					<th>Pesticide Range</th>
					<th>Pesticide Description</th>
					<th>Action</th>
				</tr>
				<%
				int index = 1;
				Connection con = DBConnect.getConn();
				Statement statement = con.createStatement();
				String sql = "SELECT * from f_pesticide";
				ResultSet rs = statement.executeQuery(sql);

				while (rs.next())

				{
				%>

				<tr>
					<td><%=index++%></td>
					<td><img
						src="<%=Validation.getPath() + rs.getString("image")%>" width="115"
						height="128"/ ></td>

					<td><u style="color: red;"> <%=rs.getString(2)%></u></td>
					<td><%=rs.getString(3)%></td>
					<td><%=rs.getString(5)%></td>
					<td class="btn-group-vertical"><a href="editPesticide.jsp?id=<%=rs.getInt(1)%>"
						class="btn btn-primary">Edit Image</a> <a
						href="deletePesticide.jsp?id=<%=rs.getInt(1)%>"
						class="btn btn-danger">Delete</a></td>
				</tr>





				<%
				}
				%>
			</table>
		</div>
		<div class="col-sm-1"></div>
	</div>


	<div style="margin-top: 289px">
		<%@ include file="footer.jsp"%>
	</div>

</body>
</html>