package shop;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Servlet Filter implementation class GeoFilter
 */
public class GeoFilter extends HttpFilter implements Filter {
       
	private Set<String> allowedIpAddresses;
  
	 @Override
	    public void init(FilterConfig filterConfig) throws ServletException {
		 
	        // Initialize the set of allowed Moldavian IP addresses
	        allowedIpAddresses = new HashSet<>(Arrays.asList("192.163.0.1", "192.163.0.2", "0:0:0:0:0:0:0:1" )); 
	    }
	 
	 
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		String clientIp = request.getRemoteAddr();
		System.out.println(clientIp);
		

        // Check if the IP address is in the set of allowed Moldavian IPs
        if (allowedIpAddresses.contains(clientIp)) {
        	
            chain.doFilter(request, response);
            //System.out.println(clientIp + "i");
        } else {
            // IP is not allowed, restrict the request with a message
            response.getWriter().write("Access denied. Only Moldavian IPs are allowed.");
        }
	}

	

}
