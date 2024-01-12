package com.garage.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.garage.connection.DbCon;
import com.garage.database.OrderDao;

import garage.Cart;
import garage.Order;
import garage.User;

@WebServlet("/OrderNowServlet")
public class OrderNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			String email = (String) request.getSession().getAttribute("email");
			if(email != null) {
				
				String productId = request.getParameter("id");
				int productQuantity = Integer.parseInt(request.getParameter("quantity"));
				if(productQuantity <= 0) {
					productQuantity = 1;
					
				}
				
                Order orderModel = new Order();
                orderModel.setId(Integer.parseInt(productId));
                orderModel.setEmail(email); //lesson 12 email.getUserID() instead of User.getUserID in case if it does not work
                orderModel.setQuantity(productQuantity);
                orderModel.setDate(formatter.format(date));
                
                OrderDao orderDao = new OrderDao(DbCon.getConnection()); //lesson 13
                boolean result = orderDao.insertOrder(orderModel);
                
                if(result) {
                	
                	ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
    				if(cart_list != null){
    					for(Cart c: cart_list) {
    						if(c.getId() ==Integer.parseInt(productId)) {
    							cart_list.remove(cart_list.indexOf(c));
    							break;
    						}
    					}
    				}
    				
                	response.sendRedirect("orders.jsp");
                	
                }else {
                	out.print("Order failed");
                }
				
			}else {
				response.sendRedirect("login,jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
