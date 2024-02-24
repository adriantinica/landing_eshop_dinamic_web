<%@ page import="java.time.Year"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E-shop | SignIn</title>
<link rel="icon" href="<%= request.getContextPath() %>/icon.png">

</head>
<body align ="center" bgcolor = #ffffcc>




<% if (request.getParameter("message") != null) { %>
      <p style='color :red;'><%= request.getParameter("message") %></p>
<% } %>



      <image width=200 height=200 src="/landing-eshop-dinamic-web/src/main/webapp/WEB-INF/ICONS/calculator_icon.png" alt="calculator.png">
      
      
     
      
      
    <table align="center" bgcolor=#ccccff cellpadding=10 style="border-radius: 10px;">
    <tr>
    	<td>
       		<h2>Sign In</h2>
    	</td>
    </tr>
    <tr>
    	<td>
	    	<form method="post" action="<%=request.getContextPath()%>/signin-action">  <%-- path to the servlet --%>
		        
		
		        <label for="email">Email<span style="color: red;">*</span>:</label>
		        <br>
		        <input type="email" id="email" name="email" ><br><br>
	        
	        
		        <label for="password">Password<span style="color: red;">*</span>:</label>
		        <br>
		        <input type="password" id="password" name="password" ><br><br>
		        
		        
		        
		
		        <button >Sign in</button>
		        
		    </form>
		    
		   
		  </td>
	    </tr>
    </table>
    
    <%-- <p>Today's date: <%= (new java.util.Date()).toLocaleString()%></p> --%>
    <p>
       <small>Copyright Pocket Inc. &copy | <%= Year.now() %>  </small>
    </p>
      
</body>
</html>
