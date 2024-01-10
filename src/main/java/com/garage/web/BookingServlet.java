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
import java.util.logging.Level;
import java.util.logging.Logger;

import garage.Booking;
import garage.User;


@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
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
			String vehiclePlate = request.getParameter("vehiclePlate");
			String message = request.getParameter("comments");
			String service_type = request.getParameter("serviceType");
			String booking_date = request.getParameter("bookingDate");
			
			Booking booking = new Booking(vehiclePlate, message, service_type, booking_date);
			
			pst = con.prepareStatement("insert into bookings(EmailAddress, vehiclePlate, message, service_type, booking_date) values(?,?,?,?,?)");
			
			pst.setString(1, User.getEmailAddress());
			pst.setString(2, booking.getVehiclePlate());
			pst.setString(3, booking.getMessage());
			pst.setString(4, booking.getService_type());
			pst.setString(5, booking.getBooking_date());
			row = pst.executeUpdate();
			
            out.println("<button><a href=\"Booking.jsp\">Back</a></button><br/>");
            out.println("<font color='green'>  You have successfully booked the appointment   </font>");
            
	      } catch (ClassNotFoundException ex) {
	            Logger.getLogger(BookingServlet.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (SQLException ex) {
	           
	             out.println("<font color='red'>  Booking Failed   </font>");
	        }
	}

}
