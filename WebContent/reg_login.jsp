<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import = "com.user.User"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="WEB-INF/parts/header.jsp" %> 
<%@ include file="WEB-INF/parts/topnav.jsp" %> 
<meta charset="UTF-8">
<title>Register a book</title>
<style>
form {
	margin: 0 auto;
	width: 300px
}

input {
	margin-bottom: 3px;
	padding: 10px;
	width: 100%;
	border: 1px solid #CCC
}

button {
	padding: 10px
}

label {
	cursor: pointer
}

#form-switch {
	display: none
}

#register-form {
	display: none
}

#form-switch:checked ~#register-form {
	display: block
}

#form-switch:checked ~#login-form {
	display: none
}
</style>
<!--  jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Isolated Version of Bootstrap, not needed if your site already uses Bootstrap -->
<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />

</head>
<body>
<div class="bootstrap-iso">
	<input type="checkbox" id='form-switch'>
	<form id='login-form' action="login" method="post">
		<input type="text" placeholder="Username" name="uname" required> 
		<input type="password" placeholder="Password" name="pword" required>
		<button type='submit'>Login</button>
		<label for='form-switch'><span>Register</span></label>
	</form>

	<form id='register-form' action="new" method="post">
		<input type="text" placeholder="First Name" name="fname" required> 
		<input type="text" placeholder="Last Name" name="lname" required>
		<input type="date" placeholder="Date of Birth" name="dob" required> 
		<input type="text" placeholder="Phone Number" name="pnumber" required>  
		<input type="text" placeholder="Username" name="uname" required> 
		<input type="email" placeholder="Email" name="email" required> 
		<input type="password" placeholder="Password" name="pword" required> 
		<input type="password" placeholder="Re Password" required>
		<button type='submit'>Register</button>
		<label for='form-switch'>Sign In</label>
	</form>
	</div>
	
<script src="webjars/jquery/3.0.0/jquery.min.js"></script>	
<script src="webjars/bootstrap/4.4.1/css/bootstrap.min.css"></script>	


</body>
</html>