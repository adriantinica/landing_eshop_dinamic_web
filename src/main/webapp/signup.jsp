<%@ page import="java.time.Year"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E-shop | SignUp</title>
<link rel="icon" href="<%= request.getContextPath() %>/icon.png">

</head>
<body align ="center" bgcolor = #ffffcc>

<%-- Check if the form is submitted --%>
<%
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        // Retrieve form data
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("cpassword");

        // Process the form data (you can perform validation, authentication, etc. here)
        // For simplicity, just printing the data to the response
%>
        <p>User firstName: <%= firstname %></p>
        <p>User firstName: <%= lastname %></p>
        <p>Phone Number: <%= phoneNumber %></p>
        <p>Email address: <%= email %></p>
        <p>Password: <%= password %></p>
        <p>Password: <%= cpassword %></p>
<%
    }
%>

      <image width=200 height=200 src="icon.png" alt="calculator.png">
      
      
      <H2>In order to download our products please make an account !!!</H2>
      
      
    <table align="center" bgcolor=#ccccff cellpadding=10 style="border-radius: 10px;">
    <tr>
    	<td>
       		<h2>Create an Account</h2>
    	</td>
    </tr>
    <tr>
    	<td>
	    	<form method="post" action="<%=request.getContextPath()%>/signup-action">
		        <label for="fullName">First Name<span style="color: red;">*</span>:</label>
		        <br>
		        <input type="text" id="username" name="firstname" >
		        <br><br>
		        <label for="fullName">Last Name<span style="color: red;">*</span>:</label>
		        <br>
		        <input type="text" id="username" name="lastname" >
		        <br><br>
		
		        <label for="phoneNumber">Phone<span style="color: red;">*</span>:</label>
		        <br>
		        <input type="text" id="phone" name="phone" ><br><br>
		        
		
		        <label for="email">Email<span style="color: red;">*</span>:</label>
		        <br>
		        <input type="email" id="email" name="email" ><br><br>
	        
	        
		        <label for="password">Set a Password<span style="color: red;">*</span>:</label>
		        <br>
		        <input type="password" id="password" name="password" ><br><br>
		        
		        <label for="cpassword">Confirm the Password<span style="color: red;">*</span>:</label>
		        <br>
		        <input type="password" id="cpassword" name="cpassword" ><br><br>
		        
		        
		
		        <button >Register</button>
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
