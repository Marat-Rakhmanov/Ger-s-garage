package garage.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class Register
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/garage", "root", "root1234");
			PreparedStatement ps = con.prepareStatement("select email from users where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				RequestDispatcher rd = request.getRequestDispatcher("html/index.html");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("create_account.jsp");
				rd.forward(request, response);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
//		if(rDao.insert(member)){
//			RequestDispatcher rd = request.getRequestDispatcher("html/index.html");
//			rd.forward(request, response);
//		}else {
//			RequestDispatcher rd = request.getRequestDispatcher("create_account.jsp");
//			rd.forward(request, response);
//		}
	
	}
}
