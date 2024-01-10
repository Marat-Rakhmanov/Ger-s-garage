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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/viewbookings")
public class viewbookings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con;
    PreparedStatement pst;
    ResultSet rs;
    int row;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/practice", "root", "root1234");
			String sql;
			sql = "select * from bookings";
			Statement stm = con.createStatement();
			rs = stm.executeQuery(sql);
			
	        out.println("<table cellspacing='0' width='350px' border='1'>");
            out.println("<tr>");
            out.println("<td> EmpID </td>");
            out.println("<td> First name </td>");
            out.println("<td> Last name </td>");
            out.println("<td> Edit </td>");
            out.println("<td> Delete </td>");
            out.println("</tr>");
            
            
            
	      } catch (ClassNotFoundException ex) {
	            Logger.getLogger(viewbookings.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (SQLException ex) {
	           
	             out.println("<font color='red'>  Record Failed   </font>");
	        }
        
	}



}
