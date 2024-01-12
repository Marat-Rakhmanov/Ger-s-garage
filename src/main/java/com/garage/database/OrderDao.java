package com.garage.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import garage.Order;

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
    		query = "insert into orders (p_id, u_email, o_quantity, o_date) values(?,?,?,?)";
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
}
