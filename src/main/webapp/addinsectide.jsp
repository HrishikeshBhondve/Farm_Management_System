<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header2.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Insecticide</title>
<style>
body {
  background-image: url(images/Lost-crop.jpg);
  background-repeat: no-repeat;
  background-size: cover;
}
</style>
</head>
<body>
<main class="d-flex align-items-center primary-background"
		style="height:100vh">
	<div class="container">
		<div class="row">
			<div class="col-md-8 offset-md-1">
				<div class="card">
					<div class="card-header text-center">
						 <br>
						<p>Add Insecticides</p>
						<span style="color: #00e676; font-style: inherit;"><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span>
					</div>
					<div class="card-body">
						<form action="InsecCtrl" method="post" enctype="multipart/form-data">

							<div class="form-group">
								<label for="">Insecticide Name</label> <input
									type="text" class="form-control" name="cname"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter Insecticide name" required>

							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Insecticides Range</label> <input
									type="text" name="range" class="form-control"
									id="exampleInputPassword1" placeholder="Enter range">
							</div>
							
							<div class="form-group">
								<label for="exampleInputPassword1">Insecticide Image</label> <input
									type="file" name="image" class="form-control"
									id="exampleInputPassword1" placeholder="Password">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Insecticides Description</label> 
								<textarea rows="3" cols="3" name="desc" class="form-control"></textarea>
							</div>

							<button type="submit" class="btn btn-primary"name="Action" value="Add">Save Insecticides</button>
							&nbsp;&nbsp;&nbsp;
							<button type="reset" class="btn btn-primary">Reset Insecticides</button>
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