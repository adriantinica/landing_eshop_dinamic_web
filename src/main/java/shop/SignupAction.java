package shop;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;

public class SignupAction extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String password = request.getParameter("password");
		String passwordRepeat = request.getParameter("cpassword");
		
		
		
		if(password.equals(passwordRepeat)) {
	
			response.getWriter().append( " Registration passed Successfuly !!! " );
			Map<String, String[]> params = request.getParameterMap();
			
			try {
				Class.forName("org.postgresql.Driver");
				String url = "jdbc:postgresql://localhost:5440/landing_db";
				Properties props = new Properties();
				props.setProperty("user", "postgres");
				props.setProperty("password", "laser112");
				props.setProperty("ssl", "false");
				try {
					Connection conn = DriverManager.getConnection(url, props);
					Statement smt = conn.createStatement();
					smt.execute("INSERT INTO members (first_name,last_name,phone,email,password)  VALUES("
					        + "'" + params.get("firstname")[0]
							+ "','" + params.get("lastname")[0]
							+ "','" + params.get("phone")[0]
							+ "','" + params.get("email")[0]
							+ "','" + params.get("password")[0] +"')");
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.err.println("ERROR !!!");
			response.sendRedirect("signup.jsp");
		}
		
	}

}
