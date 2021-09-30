<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>

body {
  background-image: url(images/Lost-crop.jpg);
  background-repeat: no-repeat;
  background-size: cover;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="userheader.jsp" %>
</head>
<body>
<%


%>
<form action="ChangepasswordCtrl" method="post">
<br><br>
<table class="" style="width:25 %; font-family: sans-serif;" align="center">
<center><span style="color: red; font-style: inherit; font-weight: bold;"><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span>
</center>
<tr>
<td><strong style="color: red;">Enter New Password</strong></td>
<td><input type="password" name="npwd" required></td></tr>

<tr>
<td><strong style="color: red;"	>Enter Confirm Password</strong></td>
<td><input type="password" name="cpwd" required></td></tr>
<center><span style="color: red; font-style: inherit;"><strong><%=(request.getAttribute("pass") == null) ? "" : request.getAttribute("pass")%></strong></span>
 </center>
<tr>
<td><input type="text" name="t2" hidden="yes" value="<%out.println(session.getAttribute("user"));%>"></td><br><br><br>
<tr><td></td><td><input type="submit" name="Action" value="Change Password" class="btn btn-primary"></td></tr>

</tr>

</table>



</form>

<div style="margin-top: 321px">
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>