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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 * Servlet implementation class Register
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("emailAddress");
		String password = request.getParameter("password");
		String correctPassword = null;
		String message = "";
		String url = "";
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root1234");
			
			Statement statement = con.createStatement();
			statement.executeQuery("select password from user where emailAddress='" + email + "'");
			ResultSet rs = statement.getResultSet();
			
			if(rs.next()) {
				correctPassword = rs.getString(1);
			}
			statement.close();
			if(email.length() == 0 || password.length() == 0) {
				message ="Please fill out all boxes";
				url = "/login.jsp";
			}else {
				
				if(correctPassword.equals(password)) {
					RequestDispatcher rd = request.getRequestDispatcher("index.html");
					rd.forward(request, response);
				}else {
					message = "Incorrect email address or password.<br/>" + "Please try again";
					url = "/login.jsp";
				}
			}
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
