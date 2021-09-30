<%@page import="com.farm.utility.Validation"%>
<%@page import="com.farm.Model.InsecDAO"%>
<%@page import="com.farm.Bean.InsecticideBean"%>
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

</style>
</head>
<body>
<%
String id=request.getParameter("id");
InsecticideBean bean=InsecDAO.getRecordById(Integer.parseInt(id));

%>
<form action="InsecCtrl" method="post" enctype="multipart/form-data">
<input type="hidden" name="id" value="<%=bean.getId()%>">
<br><br>
<table align="center" cellpadding="8px" cellspacing="8px" border="2" style="font-family: sans-serif;">
<tr>
<td><strong>Insecticide Name</strong></td>
<td><input type="text" name="cname" value="<%=bean.getIname()%>" disabled="disabled"></td>
</tr>

<tr>
<td><strong>Insecticide Range</strong></td>
<td><input type="text" name="cmonth" value="<%=bean.getIrange()%>" ></td>
</tr>

<tr>
<td><strong>Insecticide Description</strong></td>
<td><textarea rows="3" cols="35"  name="cdesc" disabled="disabled"><%=bean.getIdesc()%></textarea> </td>
</tr>

<tr>
<td><strong>Insecticide Image</strong></td>
<td><input type="file" name="image" required></td></tr>

<tr><td></td><td>
<button type="submit" class="btn btn-primary" value="Edit" name="Action">Edit Insecticide</button>
							&nbsp;&nbsp;&nbsp;
							
							
							<span   style="color: red;  font-style: inherit;"><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span>
							</td>
							
							
							
</tr>

</table>

</div>

</form>

</body>
</html>