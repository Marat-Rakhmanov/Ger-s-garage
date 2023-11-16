<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
a:link, a:visited {
  background-color: white;
  color: black;
  border: 2px solid green;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

a:hover, a:active {
  background-color: green;
  color: white;
}
body, html {
  height: 100%;
  margin: 0;
}
.bg {
  /* The image used */
  background-image: url("image/rolls-royce.jpg");

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
	<div class="bg">
		<a href="index.html" target="_self">Home</a>
		<a href="html/Vehicle_parts.html" target="_self">Vehicle parts</a>
		<a href="html/Booking.html" target="_self">Booking</a>
		<a href="welcome.jsp" target="_self">Log out</a>
	</div>
</body>
</html>