package com.garage.web;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

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
		String birthday = request.getParameter("birthday");
		
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		String vehiclePlate = request.getParameter("vehiclePlate");
		String engineType = request.getParameter("engineType");
		
		User user = new User(fname, surname, password, licence, email, phone, birthday);
		Vehicle vehicle = new Vehicle(make, model, vehiclePlate, engineType);
		
		LoginDao loginDao = new LoginDao();
		if (loginDao.insert(user)) {

			if(loginDao.insertVehicle(vehicle)) {
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.forward(request, response);
			}else {
				response.getWriter().println("Vehicle details were not entered");
			}
		}else {
			response.getWriter().println("User details were not entered");
		}
	}

}
