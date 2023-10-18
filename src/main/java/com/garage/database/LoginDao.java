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
	
	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
		
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
		String sql = "insert into user (fname, surname, password, licence, email, phone, birthday)" + "values(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getFname());
			ps.setString(2, user.getSurname());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getLicence());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getPhone());
			ps.setString(7, user.getBirthday());
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
		String sql ="insert into usercars (make, model, vehiclePlate, engineType)" + "values(?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vehicle.getMake());
			ps.setString(2, vehicle.getModel());
			ps.setString(3, vehicle.getVehiclePlate());
			ps.setString(4, vehicle.getEngineType());
			ps.executeUpdate();
			result = true;
		}catch(SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	
}
