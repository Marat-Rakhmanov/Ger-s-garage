package com.garage.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import garage.Vehicle;

@WebServlet("/addVehicle")
public class addVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;
    PreparedStatement pst;
    ResultSet rs;
    int row;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/practice", "root", "root1234");
			
			String make = request.getParameter("make");
			String model = request.getParameter("model");
			String vehiclePlate = request.getParameter("vehiclePlate");
			String engineType = request.getParameter("engineType");
			
			Vehicle vehicle = new Vehicle(make, model, vehiclePlate, engineType);
			HttpSession session = request.getSession();
			String email = (String) session.getAttribute("email");
			
			pst = con.prepareStatement("insert into usercars(vehiclePlate, EmailAddress, make, model, enginetype) values(?,?,?,?,?)");
			
			pst.setString(1, vehicle.getVehiclePlate());
			pst.setString(2, email);
			pst.setString(3, vehicle.getMake());
			pst.setString(4, vehicle.getModel());
			pst.setString(5, vehicle.getEngineType());
			row = pst.executeUpdate();
			
//            out.println("<button><a href=\"addvehicle.jsp\">Back</a></button><br/>");
            out.println("<font color='green'>  You have successfully added the vehicle   </font>");
			
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}

}
