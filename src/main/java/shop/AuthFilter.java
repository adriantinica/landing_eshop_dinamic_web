package shop;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet Filter implementation class AuthFilter
 */
public class AuthFilter extends HttpFilter implements Filter {
       
  
	
	
	private boolean authenticated = false;
	
	

	
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("authenticated")!= null) {
			
			// pass the request along the filter chain
			chain.doFilter(request, response);
			
		}
		else {
			response.sendRedirect((request.getContextPath()+"/signup.jsp"));
		}
	}
		
}

	
	
	
	
	
	
	
	
