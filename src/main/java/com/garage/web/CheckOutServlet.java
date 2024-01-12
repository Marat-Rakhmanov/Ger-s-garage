package com.garage.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.garage.connection.DbCon;
import com.garage.database.OrderDao;

import garage.*;

@WebServlet("/CheckOutServlet")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		try(PrintWriter out = response.getWriter()){
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        Date date = new Date();
	        
	        ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list"); // retrive all cart's products
	        String email = (String) request.getSession().getAttribute("email"); //user authentication
	        
	        //check autj and cart list
	        if(cart_list != null && email != null) {
	        	
	        	for(Cart c: cart_list) {
	        		//prepare the order object
	        		Order order = new Order();
	        		order.setId(c.getId());
	        		order.setEmail(email);
	        		order.setQuantity(c.getQuantity());
	        		order.setDate(formatter.format(date));
	        		
	        		//instantiate the dao class
	        		OrderDao oDao = new OrderDao(DbCon.getConnection());
	        		//calling the insert method
	        		boolean result = oDao.insertOrder(order);
	        		if(!result) {
	        			break;
	        		}
	        	}
	        	cart_list.clear();
	        	response.sendRedirect("orders.jsp");
	        	
	        }else {
	        	if(email == null) {
	        		response.sendRedirect("login.jsp");
	        	}
	        	response.sendRedirect("cart.jsp");
	        }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
