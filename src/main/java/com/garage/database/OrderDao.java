package com.garage.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import garage.*;

public class OrderDao {

	private Connection con;
	private String query;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public OrderDao (Connection con) {
    	this.con = con;
    }
    
    public boolean insertOrder(Order model) {
    	
    	boolean result = false;
    	
    	try {
    		query = "insert into orders (p_id, EmailAddress, o_quantity, o_date) values(?,?,?,?)";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, model.getId());
            pst.setString(2, model.getEmail());
            pst.setInt(3, model.getQuantity());
            pst.setString(4, model.getDate());
            pst.executeUpdate();
            result = true; //lesson 13
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return result;
    }
    
    public List<Order> userOrders(String email){
    	
    	List<Order> list = new ArrayList<>(); // list of orders
    	
    	try {
    		query = "select * from orders where EmailAddress=? order by orders.o_id desc";
            pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            rs = pst.executeQuery();
    		
            while(rs.next()) {
            	Order order = new Order(); //create a new order    lesson 15
            	ProductDao productDao = new ProductDao(this.con); //we are calling this to get product by id
                int pId = rs.getInt("p_id"); // we're getting this from our query
                
                Product product = productDao.getSingleProduct(pId);
                order.setOrderId(rs.getInt("o_id"));
                order.setId(pId);
                order.setName(product.getName());
                order.setCategory(product.getCategory());
                order.setPrice(product.getPrice()*rs.getInt("o_quantity"));
                order.setQuantity(rs.getInt("o_quantity"));
                order.setDate(rs.getString("o_date"));
                list.add(order);
            	
            }
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
		return list;
    }
    public void cancelOrder(int id) {
    	try {
    		query = "delete from orders where o_id=?";
    		pst = this.con.prepareStatement(query);
    		pst.setInt(1, id);
    		pst.execute();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}
