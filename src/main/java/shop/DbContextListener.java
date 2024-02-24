package shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class DbContextListener
 *
 */
public class DbContextListener implements ServletContextListener {

	private static Connection conn ;
	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
	@Override
    public void contextInitialized(ServletContextEvent sce)  { 
		ServletContext context = sce.getServletContext();
	
		//initiate database connection:
         
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (conn == null) {
			
			String url = context.getInitParameter("url");
			Properties props = new Properties();
			props.setProperty("user", context.getInitParameter("user"));
			props.setProperty("password", context.getInitParameter("password"));
			props.setProperty("ssl", context.getInitParameter("ssl"));
			try {
				 conn = DriverManager.getConnection(url, props);
		
			context.setAttribute("conn", conn);
			
			
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			context.setAttribute("conn", conn);
		}	
			
	
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO close the db connection
    	if (conn != null) {
            try {
                conn.close();
                System.out.println("Database connection closed successfully.");
            } catch (SQLException e) {
                System.err.println("Error closing the database connection: " + e.getMessage());
            }
        }
    }
