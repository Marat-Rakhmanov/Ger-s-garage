<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="garage.*" %>
    <%@ page import="com.garage.database.*" %>
    <%@ page import="com.garage.connection.*" %>
    <%@page import="java.text.DecimalFormat"%>
    
     <%
     DecimalFormat dcf = new DecimalFormat("#.##");
     String email = (String)session.getAttribute("email");
     List<Order> orders = null;
		if(email == null){
			response.sendRedirect("login.jsp");
		}else{
	 		
	 		request.setAttribute("dcf", dcf);
	 		orders = new OrderDao(DbCon.getConnection()).userOrders(email);
		}
		ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
		if(cart_list != null){
			request.setAttribute("cart_list", cart_list);
		}

	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders Page</title>
<%@include file="includes/head.jsp"%>
</head>
<body>
<%@include file="includes/navbar.jsp" %>

	<div class="container">
		<div class="card-header my-3">All Orders</div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Date</th>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
			
			<%
			if(orders != null){
				for(Order o:orders){%>
					<tr>
						<td><%=o.getDate() %></td>
						<td><%=o.getName() %></td>
						<td><%=o.getCategory() %></td>
						<td><%=o.getQuantity() %></td>
						<td><%=dcf.format(o.getPrice()) %></td>
						<td><a class="btn btn-sm btn-danger" href="CancelOrderServlet?id=<%=o.getOrderId()%>">Cancel</a></td>
					</tr>
				<%}
			}
			%>
			
			</tbody>
		</table>
	</div>

<%@include file="includes/footer.jsp"%>
</body>
</html>