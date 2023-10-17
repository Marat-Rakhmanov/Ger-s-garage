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
		
		User user = new User(fname, surname, password, licence, email, phone, birthday);
		
		LoginDao loginDao = new LoginDao();
		if (loginDao.insert(user)) {
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request, response);
		}else {
			response.getWriter().println("Data was not entered");
		}
	}

}
