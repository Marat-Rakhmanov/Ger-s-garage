<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="garage.*" %>
    
     <%
		if(session.getAttribute("email") == null){
			response.sendRedirect("login.jsp");
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

<%@include file="includes/footer.jsp"%>
</body>
</html>