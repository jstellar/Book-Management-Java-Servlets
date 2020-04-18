<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.user.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<c:forEach items="${users}" var="user">
			<tr>
				<th>Name</th>
				<th>Password</th>
				<th>Dob</th>
				<th>PhoneNumber</th>
				<th>Email</th>
			</tr>

			<tr>
				<td>${user.getFirstName()}</td>
				<td>${user.getLastName()}</td>
				<td>${user.getDob()}</td>
				<td>${user.getPhoneNumber()}</td>
				<td>${user.getEmail()}</td>
			</tr>

		</c:forEach>

	</table>
</body>
</html>