package com.garage.web;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
		String EmailAddress = request.getParameter("emailAddress");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		
		String vehiclePlate = request.getParameter("vehiclePlate");
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		String engineType = request.getParameter("engineType");
		
		User user = new User (fname, surname, password, licence, EmailAddress, phone, gender, birthday);
		
		Vehicle vehicle = new Vehicle(make, model, vehiclePlate, engineType);
		
		String url = "";
		String message = "";
		
		if(fname.length() == 0 || surname.length() == 0 || password.length() == 0 || EmailAddress.length() == 0 || phone.length() == 0 || 
				gender.length() == 0 || birthday.length() == 0 || vehiclePlate.length() == 0 || make.length() == 0 || model.length() == 0 || engineType.length() == 0) {
			
			message ="Please fill out all necessary boxes";
			url = "/create_account.jsp";
		}else {
			
			if(LoginDao.emailExists(user.getEmailAddress())) {
				
				message = "This email address already exist<br/>"
						+ "Please enter another one.";
				url = "/create_account.jsp";
			}else {
				
				LoginDao.insert(user);
				LoginDao.insertVehicle(vehicle);
				url = "/index.html";
			}
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		request.setAttribute("message", message);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
