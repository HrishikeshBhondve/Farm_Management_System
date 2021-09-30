<%@page import="com.farm.utility.Validation"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.farm.utility.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.farm.Model.CropDAO"%>
<%@page import="com.farm.Bean.CropBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header2.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
img {
  border-radius: 50%;
}
input[type=file]
{
color: transparent;
}
</style>
</head>
<body>
<%
String id=request.getParameter("id");
CropBean bean=CropDAO.getRecordById(Integer.parseInt(id));
Connection con=DBConnect.getConn();
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("SELECT * FROM F_CROPS WHERE ID='"+id+"'");
if(rs.next())
{
	String image=rs.getString(4);
%>
<form action="CropCtrl" method="post" enctype="multipart/form-data">
<input type="hidden" name="id" value="<%=bean.getId()%>">
<br><br>
<table align="center" cellpadding="8px" cellspacing="8px" border="2" style="font-family: sans-serif;">
<tr>
<td><strong>Crop Name</strong></td>
<td><input type="text" name="cname" value="<%=bean.getCrop_name()%>" disabled="disabled"></td>
</tr>

<tr>
<td><strong>Crop Month</strong></td>
<td><input type="text" name="cmonth" value="<%=bean.getStart_month()%>-<%=bean.getEnd_month()%>" disabled="disabled"></td>
</tr>

<tr>
<td><strong>Crop Description</strong></td>
<td><textarea rows="3" cols="35"  name="cdesc"  disabled="disabled"><%=bean.getCrop_desc()%></textarea> </td>
</tr>

<tr>
<td><strong>Crop Image</strong></td>
<td><input type="file" id="file" name="image" required></td></tr>

<tr><td></td><td>
<button type="submit" class="btn btn-primary" value="Edit" name="Action">Edit Crops</button>
							&nbsp;&nbsp;&nbsp;
							
							
							<span   style="color: red;  font-style: inherit;"><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span>
							</td>
							
							
							
</tr>

</table>

</div>

</form>
<%}
%>
</body>
</html>