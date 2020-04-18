package com.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

	public List<Book> list() throws SQLException {
		
		List<Book> proList = new ArrayList<Book>();
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from book");
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			Book book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getFloat(6), rs.getString(7));
			proList.add(book);
		}
		
		return proList;
	}

	public void delete(int id) throws SQLException {
		
		Connection conn = ConnectionFactory.getConnection();
		
		// createStatement method
//		Statement s = conn.createStatement();
//		s.executeUpdate("delete from book where bookid="+id);
		// prepareStatement method
		PreparedStatement ps = conn.prepareStatement("delete from book where bookid=?");
		ps.setInt(1, id);
		ps.executeUpdate();
		

	}

	public Book getBook(int id) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from book where bookid ="+id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return getUserFromResultSet(rs);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	private Book getUserFromResultSet(ResultSet rs) throws SQLException {
		
		Book book = new Book();
		book.setId(rs.getInt(1));
		book.setTitle(rs.getString(2));
		book.setIsbn(rs.getString(3));
		book.setAuthor(rs.getString(4));
		book.setPublicYear(rs.getInt(5));
		book.setPrice(rs.getFloat(6));
		book.setDescription(rs.getString(7));
		
		return book;
	}

	public void update(Book book) throws SQLException {
		
		Connection conn = ConnectionFactory.getConnection();
		String sql = "update book set title=?, isbn=?, author=?,publicyear=?, price=?, description=? where bookid= "+book.getId();
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, book.getTitle());
		ps.setString(2, book.getIsbn());
		ps.setString(3, book.getAuthor());
		ps.setInt(4, book.getPublicYear());
		ps.setFloat(5, book.getPrice());
		ps.setString(6, book.getDescription());
		ps.executeUpdate();
	}

	public void newBook(Book newBook) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "insert into book(title, isbn, author, publicYear, price, description) values (?, ?, ?, ?, ?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, newBook.getTitle());
		ps.setString(2, newBook.getIsbn());
		ps.setString(3, newBook.getAuthor());
		ps.setInt(4, newBook.getPublicYear());
		ps.setFloat(5, newBook.getPrice());
		ps.setString(6, newBook.getDescription());
		ps.executeUpdate();		
	}

}
