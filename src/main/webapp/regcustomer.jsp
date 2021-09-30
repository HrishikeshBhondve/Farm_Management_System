<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
body {
  background-image: url(images/Registerbackground.jpg);
  background-repeat: no-repeat;
  background-size: cover;
}
</style>
<title>Insert title here</title>
</head>

<%
String errmsg="";
if(session.getAttribute("ERROR")!=null)
{
 errmsg=(String)session.getAttribute("ERROR");}

%>

<body>
	<main class="d-flex align-items-center primary-background"
		style="height:200vh">
	<div class="container">
		<div class="row">
			<div class="col-md-8 offset-md-1">
				<div class="card">
					<div class="card-header text-center">

						<span class="fa fa-user-plus fa-3x" style="color: gray;"></span> <br>
						<p>Register</p>
						<span style="color: #00e676; font-style: inherit;"><%=(request.getAttribute("errmsg") == null) ? "" : request.getAttribute("errmsg")%></span>
						<span style="color: #00e676; font-style: inherit;"><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span>
					</div>
					<div class="card-body">
						<div class="card-header">Personal Details</div>
						<form action="CustomerCtrl" method="post">
							<div class="form-group">
								<label for="">Name</label> <input type="text"
									class="form-control" name="name" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter Name" required>
<span style="color: red; font-style: inherit;"><strong><%=(request.getAttribute("namevalidation") == null) ? "" : request.getAttribute("namevalidation")%></strong></span>
 
                                    
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Username</label> <input
									type="text" class="form-control" name="uname"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter Username" required>
<span style="color: red; font-style: inherit;"><strong><%=(request.getAttribute("unamevalidation") == null) ? "" : request.getAttribute("unamevalidation")%></strong></span>
  
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Mobile</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="mobile"
									placeholder="Enter Mobile number"    maxlength="10" required >
<!-- pattern="[0-9]{11}" maxlength="10" -->

<span style="color: red; font-style: inherit;"><strong><%=(request.getAttribute("mobvalidation") == null) ? "" : request.getAttribute("mobvalidation")%></strong></span>
 
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" name="pass"
									id="exampleInputPassword1" placeholder="Password">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Confirm Password</label> <input
									type="password" class="form-control" name="cpass"
									id="exampleInputPassword1" placeholder="Password">
<span style="color: red; font-style: inherit;"><strong><%=(request.getAttribute("password") == null) ? "" : request.getAttribute("password")%></strong></span>
 									
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="email"
									placeholder="Enter Email Id" required>

							</div>
							<div class="card-header">Address Details</div>

							<div class="form-group">
								<label for="exampleInputEmail1">City</label> <input type="text"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="city"
									placeholder="Enter City" required>
<span style="color: red; font-style: inherit;"><strong><%=(request.getAttribute("city") == null) ? "" : request.getAttribute("city")%></strong></span>
 									
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">State</label>
								<!-- <input
									type="text" class="form-control" id="exampleInputPassword1"
									placeholder="Enter Month" name="month" required> -->
								<select name="state" class="form-control">
									<option value="Andhra Pradesh">Andhra Pradesh</option>
									<option value="Andaman and Nicobar Islands">Andaman
										and Nicobar Islands</option>
									<option value="Arunachal Pradesh">Arunachal Pradesh</option>
									<option value="Assam">Assam</option>
									<option value="Bihar">Bihar</option>
									<option value="Chandigarh">Chandigarh</option>
									<option value="Chhattisgarh">Chhattisgarh</option>
									<option value="Dadar and Nagar Haveli">Dadar and Nagar
										Haveli</option>
									<option value="Daman and Diu">Daman and Diu</option>
									<option value="Delhi">Delhi</option>
									<option value="Lakshadweep">Lakshadweep</option>
									<option value="Puducherry">Puducherry</option>
									<option value="Goa">Goa</option>
									<option value="Gujarat">Gujarat</option>
									<option value="Haryana">Haryana</option>
									<option value="Himachal Pradesh">Himachal Pradesh</option>
									<option value="Jammu and Kashmir">Jammu and Kashmir</option>
									<option value="Jharkhand">Jharkhand</option>
									<option value="Karnataka">Karnataka</option>
									<option value="Kerala">Kerala</option>
									<option value="Madhya Pradesh">Madhya Pradesh</option>
									<option value="Maharashtra">Maharashtra</option>
									<option value="Manipur">Manipur</option>
									<option value="Meghalaya">Meghalaya</option>
									<option value="Mizoram">Mizoram</option>
									<option value="Nagaland">Nagaland</option>
									<option value="Odisha">Odisha</option>
									<option value="Punjab">Punjab</option>
									<option value="Rajasthan">Rajasthan</option>
									<option value="Sikkim">Sikkim</option>
									<option value="Tamil Nadu">Tamil Nadu</option>
									<option value="Telangana">Telangana</option>
									<option value="Tripura">Tripura</option>
									<option value="Uttar Pradesh">Uttar Pradesh</option>
									<option value="Uttarakhand">Uttarakhand</option>
									<option value="West Bengal">West Bengal</option>
								</select>

							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Full Address</label>
								<textarea rows="3" cols="3" name="address" class="form-control"></textarea>
							</div>

							<button type="submit" class="btn btn-primary" style="">Sign
								up</button>
						<%-- 	<%
							
							if(errmsg!=" ")
							{%>
							<div class="alert alert-danger" role="alert">
								<%=errmsg %>
							</div>
							<%}
							
							%> --%>


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