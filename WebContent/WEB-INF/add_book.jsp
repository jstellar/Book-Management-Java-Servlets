<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register a book</title>
</head>
<body>
<a href = "display">Display the book list</a>

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
</body>
</html>