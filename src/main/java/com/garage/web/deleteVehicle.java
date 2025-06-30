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
import java.sql.ResultSet;


@WebServlet("/deleteVehicle")
public class deleteVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con;
    PreparedStatement pst;
    ResultSet rs;
    int row;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String vehiclePlate = request.getParameter("vehiclePlate").trim(); 
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost/practice", "root", "root1234");
        	pst = con.prepareStatement("delete from usercars where vehiclePlate =?");
        	pst.setString(1, vehiclePlate);
        	row = pst.executeUpdate();
        	
        	out.println("<font color='green'>  The car was deleted   </font>");
        }catch(Exception e) {
        	out.println("<font color='red'>  Record Failed   </font>");
        }
	}

}
