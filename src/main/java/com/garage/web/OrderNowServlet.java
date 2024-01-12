package com.garage.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import garage.Order;
import garage.User;

@WebServlet("/OrderNowServlet")
public class OrderNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        
		try(PrintWriter out = response.getWriter()){
			User email = (User) request.getSession().getAttribute("email");
			if(email != null) {
				
				String productId = request.getParameter("id");
				int productQuantity = Integer.parseInt(request.getParameter("quantity"));
				if(productQuantity <= 0) {
					productQuantity = 1;
					
				}
				
                Order orderModel = new Order();
                orderModel.setId(Integer.parseInt(productId));
                orderModel.setId(User.getUserID()); //lesson 12 email.getUserID() instead of User.getUserID in case if it does not work
                orderModel.setQunatity(productQuantity);
                orderModel.setDate(formatter.format(date));
                
				
			}else {
				response.sendRedirect("login,jsp");
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
