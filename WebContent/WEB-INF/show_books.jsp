<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "com.book.Book" %>

<!DOCTYPE html>
<html>
<head>
<%@ include file="parts/header.jsp" %> 
<%@ include file="parts/topnav.jsp" %> 
<style>
	table, td, tr {padding: 2px; border: 1px solid; margin: 0 auto;}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action = "newbook" method = "get">
<table>
	<tr><td>Title </td><td><input type = "text" name = "title"></td></tr>
	<tr><td>ISBN </td><td><input type = "text" name = "isbn"></td></tr>
	<tr><td>Author </td><td><input type = "text" name = "author"></td></tr>
	<tr><td>Price </td><td><input type = "text" name = "price"></td></tr>
	<tr><td>Year </td><td><input type = "text" name = "year"></td></tr>
	<tr><td>Description </td><td><input type = "text" name = "description"></td></tr>
	<tr><td></td><td><input type = "submit"></td></tr>
	
</table>
</form>
<table>
	<tr>
		<th>Id</th>
		<th>Title</th>
		<th>Author</th>
		<th>Isbn</th>
		<th>Price</th>
		<th>Year</th>
		<th>Description</th>
		<th>Actions</th>
		
	</tr>
	
	<c:forEach items="${listBook}" var="book">
		
	<tr>
		<td>${book.id}</td>
		<td>${book.title}</td>
		<td>${book.author}</td>
		<td>${book.isbn}</td>
		<td>${book.price}</td>
		<td>${book.publicYear}</td>
		<td>${book.description}</td>
		<td>
			<a href="/BookDBMS/edit?id=${book.id}">Edit</a>
			<a href="/BookDBMS/delete?id=${book.id}">Delete</a>
		</td>
	</tr>
	</c:forEach>
		<td colspan="8"><center><a href="/BookDBMS/add_book.jsp">New</a></center></td>
</table>
</body>
</html>