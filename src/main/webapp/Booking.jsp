<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
a:link, a:visited, input[type="submit"]{
  background-color: white;
  color: black;
  border: 2px solid green;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}
.container{
	background-color: white;
	width: 350px;
}

a:hover, a:active, input[type="submit"]:hover, input[type="submit"]:active{
  background-color: green;
  color: white;
}
body, html {
  height: 100%;
  margin: 0;
}

.bg {
  /* The image used */
  background-image: url("image/rolls-royceBlack.jpg");

  /* Full height */
  height: 100%; 

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}
</style>
</head>
<body>
	
		<%
			if(session.getAttribute("email") == null){
			response.sendRedirect("login.jsp");
			}
		%>
		

	<div class="bg">
	<form method="post" action="BookingServlet">
		<div class="container">
			<h1>Booking information</h1>
			<fieldset>
				<legend>Select a vehicel for a booking</legend>
					<p>Select a vehicle using vehicle plate.</p>
                    	<label>Vehicle Plate
                    	<input type="text" name="vehiclePlate" id="vehiclePlateID" required/></label>               	
			</fieldset>
			<fieldset>
				<legend>Message from a user</legend>
				<textarea name="comments" cols="30" rows="5" maxlength="55" required >Leave a short comment what the issue is...</textarea>
			</fieldset>
			<fieldset>
				<legend>Type of service</legend>
					<input type="radio" name="serviceType" value="annualService" required/>Annual Service<br/>
					<input type="radio" name="serviceType" value="majorService"/>Major Service<br/>
					<input type="radio" name="serviceType" value="repairFault"/>Repair/Fault<br/>
					<input type="radio" name="serviceType" value="majorRapair"/>Major Repair<br/><br/>
					<label for="bookingDate">Date</label>
					<input type="date" name="bookingDate" required/>				
			</fieldset>
			<input type="submit" value="Submit"/>
		</div>
	</form>
	<p><a href="viewbookings">View bookings</a></p>
	
	</div>
	
</body>
</html>