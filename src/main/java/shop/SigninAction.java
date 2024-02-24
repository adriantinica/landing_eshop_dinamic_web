package shop;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;

/**
 * Servlet implementation class SigninAction
 */
public class SigninAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String emailadress = request.getParameter("email");
		String password = request.getParameter("password");
		
		
			
			//Map<String, String[]> params = request.getParameterMap();
			
			
		 
			    
					try {
						Connection conn = (Connection) getServletContext().getAttribute("conn");
						
						Statement smt = conn.createStatement();
						ResultSet resultSet = smt.executeQuery("SELECT * FROM members WHERE email='"+ emailadress+ "' AND password = '"+ password +"'");
						
						if(resultSet.next()) {
							
							HttpSession session = request.getSession();
							session.setAttribute("name", resultSet.getString("first_name"));
							session.setAttribute("name", resultSet.getString("last_name"));
							session.setAttribute("authenticated", true);
							String message = "Welcome to our site !!!";
							response.sendRedirect(request.getContextPath()+"/download?message="+ message);
							
						}else {
							String message ="error, wrong credentials !!!";
							response.sendRedirect(request.getContextPath()+"/signin.jsp?message="+ message);
						}
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				
				
		   
		
			
		}
		
	}


