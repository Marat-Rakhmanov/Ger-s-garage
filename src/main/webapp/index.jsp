<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

a:hover, a:active, input[type="submit"]:hover, input[type="submit"]:active {
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
.container{
	background-color: white;
	width: 420px;
}
table, th, td {
  border:1px solid black;
}
#main {
  border: 1px dotted black;
  display: flex;
  align-items: center; /* Vertical align the elements to the center */
}

h1 {
  margin: 10px;
}

button {
  margin-left: auto; /* Push this element to the right */
}
a.button, .form.button{
	margin-left:auto;
	
}
</style>
</head>
<body>

	<%
		if(session.getAttribute("email") == null){// if i use "user" instead of "email" i cannot login . it used to "email"
			response.sendRedirect("login.jsp");
		}
	%>


	<div class="bg">
		<a href="index.jsp">Home</a>
		<a href="Parts.jsp" target="_self">Vehicle Parts</a>
		<a href="Booking.jsp" target="_self">Booking</a>
		<a href="LogOut" target="_self">Log Out</a>
<!-- 		<form  action="LogOut" method="get"> -->
<!-- 			<input type="submit" value="Log out"> -->
<!-- 		</form> -->


		<%@ page import="garage.*, com.garage.database.*, java.sql.*" %>
		<%
			
			Connection con;
	        PreparedStatement pst;
	        ResultSet rs;
	        
	        Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost/practice","root","root1234");
	        String email = (String) session.getAttribute("email");
            String query = "select * from usercars where EmailAddress = '" + email + "'";
            Statement st = con.createStatement();
            
			rs = st.executeQuery(query);
			while(rs.next()){ 
				
           
	
		%>
		
		<div class="container">
		<form method="GET" action="">
            
            <table width="400px" border="1">
                <tr>
                    <td colspan="2"><h1>My vehicles:</h1> </td>
                    
                </tr>

                <tr>
                    <td>Vehicle Plate</td>
                    <td><%=rs.getString("vehiclePlate")%></td>
                </tr>
                
                <tr>
                    <td>Make</td>
                    <td><%=rs.getString("make")%></td>
                </tr>
                
                <tr>
                    <td>Model</td>
                    <td><%= rs.getString("model") %></td>
                </tr>
                
                <tr>
                    <td>Engine type</td>
                    <td><%= rs.getString("engineType") %></td>
                </tr>

                
            </table>
 
            <%
            	}
            %>
        </form><br/>
        <a href="addvehicle.jsp">Add vehicle</a>
        <a href="deleteVehicle.jsp">Delete vehicle</a>
        </div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
</body>
</html>