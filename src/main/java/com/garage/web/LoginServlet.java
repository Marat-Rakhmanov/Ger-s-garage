package com.garage.web;

import jakarta.servlet.RequestDispatcher;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.garage.database.LoginDao;

import garage.User;




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
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root1234");
			
			Statement statement = con.createStatement();
			statement.executeQuery("select password from user where EmailAddress='" + email + "'");
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
						
					url = "/index.jsp";


				}else {
					message = "Incorrect email address or password.<br/>" + "Please try again";
					url = "/login.jsp";

				}
			}
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		//store the user and message in the session
		HttpSession session = request.getSession(); 
		session.setAttribute("email", email);
		request.setAttribute("message", message);
		
		// forward the request and response to the view
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
