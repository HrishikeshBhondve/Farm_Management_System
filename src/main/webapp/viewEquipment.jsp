<%@page import="com.farm.utility.Validation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.farm.utility.DBConnect"%>
<%@page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.text.*"%>

<%@include file="userheader.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
	
</script>
<title>Insert title here</title>
<style>
table, th, td, tr {
	border: 2px solid black;
	font-family: verdana;
	border-style: solid;
	border-color: green;
}

.wrapper {
	text-align: center;
}

.button {
	position: absolute;
	top: 50%;
}
/* css for search */
/* * {
  box-sizing: border-box;
}*/
#search {
	background-image: url('/css/searchicon.png');
	background-position: 10px 12px;
	background-repeat: no-repeat;
	width: 20%;
	font-size: 16px;
	padding: 12px 20px 12px 40px;
	border: 2px solid #ddd;
	margin-bottom: 12px;
	margin-left: 520px;
}
</style>
</head>
<body>
	<br>


	<br>
	<h1 align="center">All Types of Equipment</h1>
	<div class="search_box">
		<form action="" id="form2">
			<div>
				<h6 style="margin-left: 100px;">
					<input type="text" id="search"><br>
					</h5>
					<div class="wrapper">
						<input type="button" id="submit_form" onclick="checkInput()"
							value="Search" class="btn btn-primary">
					</div>
			</div>
		</form>
	</div>
	<br>
	<div class="row">
		<div class="col-sm-1"></div>
		<div class="col-sm-10">
			<div class="table-responsive">
				<table class="table table-hover " id="myTable">
					<%
					Connection con = DBConnect.getConn();
					Statement statement = con.createStatement();
					String sql = "SELECT * from f_equipment";
					ResultSet rs = statement.executeQuery(sql);

					while (rs.next())

					{
					%>

					<tr id="geeks">
						<td><img
							src="<%=Validation.getPath() + rs.getString("image")%>"
							width="115" height="128"/ ></td>

						<td><strong><u style="color: red;"> <%=rs.getString(2)%></u></strong><br>
							<strong>Equipment Range: </strong><%=rs.getString(3)%><br>
							Equipment Description :<%=rs.getString(4)%></td>
						<td><center class="btn-group-vertical">
								<button type="button" class="btn btn-success">Buy Now</button>
								<button type="button" class="btn btn-warning">Add to
									Cart</button>
							</center></td>
					</tr>






					<%
					}
					%>
				</table>
			</div>
		</div>
		<div class="col-sm-1"></div>
	</div>

	<div style="margin-top: 289px">
		<%@ include file="footer.jsp"%>
	</div>


	<!--END SEARCH BOX -->
	<script>
		function checkInput() {
			var query = document.getElementById('search').value;
			window.find(query);
			return true;
		}
	</script>

</body>
</html>