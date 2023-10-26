package com.garage.web;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.garage.database.LoginDao;

import garage.User;
import garage.Vehicle;
//import garage.Vehicle;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fname = request.getParameter("fname");
		String surname= request.getParameter("surname");
		String password = request.getParameter("password");
		String licence = request.getParameter("licence");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		String vehiclePlate = request.getParameter("vehiclePlate");
		String engineType = request.getParameter("engineType");
		
		User user = new User (fname, surname, password, licence, email, phone, gender, birthday);
		
		Vehicle vehicle = new Vehicle(make, model, vehiclePlate, engineType);
		
		LoginDao loginDao = new LoginDao();
		if (loginDao.insert(user)) {
			
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root1234");
				String sql ="insert into usercars (vehiclePlateID, vehiclePlate, userID, make, model, engineType)" + " values(?,?,?,?,?,?)";
				
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setLong(1, vehicle.getVehiclePlateID());
					ps.setString(2, vehicle.getVehiclePlate());
					ps.setLong(3, user.getUserID());
					ps.setString(4, vehicle.getMake());
					ps.setString(5, vehicle.getModel());
					ps.setString(6, vehicle.getEngineType());
					ps.executeUpdate();
					RequestDispatcher rd = request.getRequestDispatcher("index.html");
					rd.forward(request, response);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					response.getWriter().println("Vehicle details were not entered");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else {
			response.getWriter().println("User details were not entered");
		}
	}

}
