<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
	background-image: url(images/Registerbackground.jpg);
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login Page</title>
</head>
<body>
	<main class="d-flex align-items-center primary-background"
		style="height:80vh">
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-header text-center">
						<span class="fa fa-user-plus fa-3x" style="color: gray;"></span> <br>
						<p>Login</p>
						<span style="color: #00e676; font-style: inherit;"><%=(request.getAttribute("ermsg") == null) ? "" : request.getAttribute("ermsg")%></span>
						<span style="color: #00e676; font-style: inherit;"><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span>
					</div>
					<div class="card-body">
						<form action="LoginCtrl" method="post">

							<div class="form-group">
								<label for="exampleInputEmail1">Username</label> <input
									type="text" class="form-control" name="uname"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter Username" required>

							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" name="pass" class="form-control"
									id="exampleInputPassword1" placeholder="Password">
							</div>

							<button type="submit" class="btn btn-success" name="Action"
								value="Login">Login</button>
							&nbsp;&nbsp;&nbsp; <a href="CustomerCtrl" class="btn btn-primary">Sign
								up</a>
						</form>
					</div>
				</div>





			</div>



		</div>





	</div>



	</main>



	<div style="margin-top: 289px">
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>