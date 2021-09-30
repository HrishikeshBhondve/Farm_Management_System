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
						<p>Add Crops</p>
						<span style="color: #00e676; font-style: inherit;"><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span>
					</div>
					<div class="card-body">
						<form action="CropCtrl" method="post" enctype="multipart/form-data">

							<div class="form-group">
								<label for="">Crop Name</label> <input
									type="text" class="form-control" name="cname"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter Crop name" required>

							
							
								<!-- <label for="exampleInputPassword1">Crop Month</label> <input
									type="text" name="range" class="form-control"
									id="exampleInputPassword1" placeholder="Enter Month">
							</div> --><br>
							<div class="form-group form-inline"> 
							<label for="exampleInputPassword1">Start Month</label> 
								 <!-- <input
									type="text" class="form-control" id="exampleInputPassword1"
									placeholder="Enter Month" name="month" required> -->
									<select name="startmonth" class="form-control">
									<option value="January">January</option>
									<option value="February">February</option>
									<option value="March">March</option>
									<option value="April">April</option>
									<option value="May">May</option>
									<option value="June">June</option>
									<option value="July">July</option>
									<option value="August">August</option>
									<option value="September">September</option>
									<option value="October">October</option>
									<option value="November">November</option>
									<option value="Decemeber">December</option>
									</select> &nbsp &nbsp &nbsp &nbsp 
									<label for="exampleInputPassword1">End Month</label> 
								 <!-- <input
									type="text" class="form-control" id="exampleInputPassword1"
									placeholder="Enter Month" name="month" required> -->
									<select name="endmonth" class="form-control">
									<option value="January">January</option>
									<option value="February">February</option>
									<option value="March">March</option>
									<option value="April">April</option>
									<option value="May">May</option>
									<option value="June">June</option>
									<option value="July">July</option>
									<option value="August">August</option>
									<option value="September">September</option>
									<option value="October">October</option>
									<option value="November">November</option>
									<option value="Decemeber">December</option>
									</select>
							</div></div>
							
							<div class="form-group">
								<label for="exampleInputPassword1">Crop Image</label> <input
									type="file" name="image" class="form-control"
									id="exampleInputPassword1" placeholder="Password">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Crop Description</label> 
								<textarea rows="3" cols="3" name="desc" class="form-control"></textarea>
							</div>

							<button type="submit" class="btn btn-primary"name="Action" value="Add">Save Crop</button>
							&nbsp;&nbsp;&nbsp;
							<button type="reset" class="btn btn-primary">Reset Crop</button>
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