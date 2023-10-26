package com.garage.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import garage.User;
import garage.Vehicle;



public class LoginDao {
	
	private String dbUrl = "jdbc:mysql://localhost:3306/customers";
	private String dbUname = "root";
	private String dbPassword = "root1234";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	public static void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public  Connection getConnection() {
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUname, dbPassword );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public boolean insert (User user) {
		loadDriver(dbDriver);
		Connection con = getConnection();
		boolean result = false;
		String sql = "insert into user (userID, email, fname, surname, password, licence, phone, gender, birthday)" + "values(?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, user.getUserID());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getFname());
			ps.setString(4, user.getSurname());
			ps.setString(5, user.getPassword());
			ps.setString(6, user.getLicence());
			ps.setString(7, user.getPhone());
			ps.setString(8, user.getGender());
			ps.setString(9, user.getBirthday());
			ps.executeUpdate();
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	
	public boolean insertVehicle (Vehicle vehicle) {
		loadDriver(dbDriver);
		Connection con = getConnection();
		boolean result = false;
		String sql ="insert into usercars (vehiclePlateID, vehiclePlate, make, model, engineType)" + " values(?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, vehicle.getVehiclePlateID());
			ps.setString(2, vehicle.getVehiclePlate());
			ps.setString(3, vehicle.getMake());
			ps.setString(4, vehicle.getModel());
			ps.setString(5, vehicle.getEngineType());
			ps.executeUpdate();
			result = true;
		}catch(SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

//	public  static boolean emailExists(String email) {
//		loadDriver(dbDriver);
//		Connection con = getConnection();
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		String query = "select email from user" + "where email =?";
//		try {
//			ps = con.prepareStatement(query);
//			ps.setString(1, email);
//			rs = ps.executeQuery();
//			return rs.next();
//			
//		}
//		catch(SQLException e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
//	
//	public static User selectUser (String email) {
//		loadDriver(dbDriver);
//		Connection con = getConnection();
//		PreparedStatement ps = null; 
//		ResultSet rs = null;
//		
//		String query = "select * from user " + "where email=?";
//		try {
//			ps = con.prepareStatement(query);
//			ps.setString(1, email);
//			rs = ps.executeQuery();
//			User user = null;
//			if (rs.next()) {
//			
//				user = new User();
//				user.setFname(rs.getString("fname"));
//				user.setSurname(rs.getString("surname"));
//				user.setPassword(rs.getString("password"));
//				user.setLicence(rs.getString("licnece"));
//				user.setPhone(rs.getString("phone"));
//				user.setGender(rs.getString("gender"));
//				user.setBirthday(rs.getString("birthday"));
//				
//			}
//			return user;
//		}catch(SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//		
//
//	}
	
}
