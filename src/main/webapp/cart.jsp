<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="com.garage.database.ProductDao" %>
  <%@page import="java.util.List" %>
  <%@page import="com.garage.connection.DbCon" %>
 <%@ page import="garage.*, com.garage.database.*, java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart Page</title>
<%@include file="includes/head.jsp"%>
<style type="text/css">
.table tbody td{
	vartical-align: middle;
}
.btn-incre, .btn-dicre{
	box-shadow: none;
	font-size: 25px;
}
</style>
</head>
<body>
	<%
		if(session.getAttribute("email") == null){// if i use "user" instead of "email" i cannot login . it used to "email"
			response.sendRedirect("login.jsp");
		}
	

	%>
<%@include file="includes/navbar.jsp" %>
	
		<div class="container my-3">
		<div class="d-flex py-3"><h3>Total Price: €452</h3> <a class="mx-3 btn btn-primary" href="cart-check-out">Check Out</a></div>
		<table class="table table=light">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Buy Now</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
			<tr>
			<td>Air filter</td>
			<td>Vehicle's spare parts</td>
			<td>€15</td>
			<td>
				<form action="" method="post" class="form-inline">
					<input type="hidden" name="id"value="1" class="form-input">
					<div class="form-group d-flex justify-content-between">
						<a class="btn btn-sm btn-dicre" href=""><i class="fas fa-minus-square"></i></a>
						<input type="text" name="quantity" class="form-control" value="1" readonly>
						<a class="btn btn-sm btn-incre" href=""><i class="fas fa-plus-square"></i></a>
					</div>
				</form>
			</td>
			<td><a class="btn btn-sm btn-danger" href="">Remove</a></td>
			</tr>
				
			</tbody>
		</table>
	</div>
	
<%@include file="includes/footer.jsp"%>
</body>
</html>