package garage.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import garage.User;

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

	public String validate(User user) {
		
		loadDriver(dbDriver);
		Connection con = getConnection();
		String result = "Data entered successfully";
		
		PreparedStatement ps;
		try {
			
			ps =con.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
			
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getSurname());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getLicence());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getPhone());
			ps.setString(7, user.getBirthday());
			
			ps.executeUpdate();
			
		} catch(SQLException e) {
			
			result = "Data was not entered";
		}

		return result;
		
	}
	


}
