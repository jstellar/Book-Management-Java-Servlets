<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "com.book.Book"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="parts/header.jsp" %> 
<%@ include file="parts/topnav.jsp" %> 
<style>
	table, td, tr {padding: 2px; border: 1px solid;}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post">
	<table>
		<tr>
			<td>Title</td><td><input name ="title" value = "${book.title}"/></td>
		</tr>
		<tr>	
			<td>Isbn</td><td><input name ="isbn" value = "${book.isbn}"/></td>
		</tr>
		<tr>
			<td>Author</td><td><input name ="author" value = "${book.author}"/></td>
		</tr>
		<tr>
			<td>Public. Year</td><td><input name ="publicYear" value = "${book.publicYear}"/></td>
		</tr>
		<tr>
			<td>Price</td><td><input name ="price" value = "${book.price}"/></td>
		</tr>
		<tr>
			<td>Description</td><td><input name ="description" value = "${book.description}"/></td>
		</tr>
		
		<tr>
			<td></td><td><input type="submit"  /></td>
		</tr>		
	</table>
		<input type="hidden" name ="id" value = "<c:out value = '${book.id}'/>"/>
</form>
</body>
</html>