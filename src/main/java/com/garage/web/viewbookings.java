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
import org.apache.commons.text.StringEscapeUtils;



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
			sql = "select usercars.make, usercars.model, usercars.enginetype, bookings.vehiclePlate, \r\n"
					+ "bookings.booking_date, bookings.service_type\r\n"
					+ "from usercars\r\n"
					+ "right join bookings on usercars.vehiclePlate =bookings.vehiclePlate\r\n"
					+ "order by usercars.vehiclePlate;";
			Statement stm = con.createStatement();
			rs = stm.executeQuery(sql);
			
	        out.println("<table cellspacing='0' width='550px' border='1'>");
            out.println("<tr>");
            out.println("<td> Make </td>");
            out.println("<td> Model </td>");
            out.println("<td> EngineType </td>");
            out.println("<td> VehiclePlate </td>");
            out.println("<td> Booking date </td>");
            out.println("<td> Service type </td>");
            out.println("<td> Delete </td>");
            out.println("</tr>");
            
            while(rs.next()) {
            	
                out.println("<tr>");
            	out.println("<td>"  + StringEscapeUtils.escapeHtml4(rs.getString("make")) +  "</td>");
            	out.println("<td>"  + StringEscapeUtils.escapeHtml4(rs.getString("model")) +  "</td>");
            	out.println("<td>"  + StringEscapeUtils.escapeHtml4(rs.getString("engineType")) +  "</td>");
            	out.println("<td>"  + StringEscapeUtils.escapeHtml4(rs.getString("vehiclePlate")) +  "</td>");
            	out.println("<td>"  + StringEscapeUtils.escapeHtml4(rs.getString("booking_date")) +  "</td>");
            	out.println("<td>"  + StringEscapeUtils.escapeHtml4(rs.getString("service_type")) +  "</td>");
            	out.println("<td>"  + "<a href='deleteBookings?vehiclePlate=" 
            	    + StringEscapeUtils.escapeHtml4(rs.getString("vehiclePlate")) + "'> Delete </a></td>");
                
                
            }
            
            out.println("</table>");
            
	      } catch (ClassNotFoundException ex) {
	            Logger.getLogger(viewbookings.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (SQLException ex) {
	           
	             out.println("<font color='red'>  Record Failed   </font>");
	        }
        
	}



}
