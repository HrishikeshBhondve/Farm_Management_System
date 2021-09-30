<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	background-image: url(images/Registerbackground.jpg);
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<br>

	<div class="card text-center">
		<div class="card-header">Welcome</div>
		<div class="card-body">
			<h1 class="card-title">Welcome to Farm Management System</h1>
			<p class="card-text" style="font-size: 200%;">"The Farm is more
				than land and crops.It's our family heritage and future"</p>
			<p class="card-text">Come & see the Information of
				Crops,Pesticide, and Equipments</p>
			<a href="LoginCtrl" class="btn btn-primary"><span
				class="fa fa-sign-in" aria-hidden="true"> Please Log in</span></a>
		</div>
	</div>





	<div style="margin-top: 289px">
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>
