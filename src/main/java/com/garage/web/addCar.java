package com.garage.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import garage.User;
import garage.Vehicle;

@WebServlet("/addPost")
public class addCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection con;
    PreparedStatement ps;
    int row;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/usercars","root","root1234");
    		String vehiclePlate = request.getParameter("vehiclePlate");
    		String make = request.getParameter("make");
    		String model = request.getParameter("model");
    		String engineType = request.getParameter("engineType");
            
			ps = con.prepareStatement("insert into usercars (vehiclePlateID, vehiclePlate, userID, make, model, engineType)" + " values(?,?,?,?,?,?)");
			ps.setLong(1, Vehicle.getVehiclePlateID());
			ps.setString(2, vehiclePlate);
			ps.setLong(3, User.getUserID());
			ps.setString(4, make);
			ps.setString(5, model);
			ps.setString(6, engineType);
			row = ps.executeUpdate();
            
            out.println("<font color='green'>  Record Addedddd   </font>");
 
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addCar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
           
             out.println("<font color='red'>  Record Failed   </font>");
        } 
	}

}
