package com.book;
import com.book.BookDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerBook extends HttpServlet {
	
	public BookDAO bookDAO =  new BookDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		try {
			
			switch (action) {
			
			case "/new":
				newBook(request, response);
				break;
				
			case "/update":
				updateBook(request, response);
				break;
			
			case "/delete":
				deleteBook(request, response);
				break;
				
			case "/edit":
				showEditBook(request, response);
				break;

			default:
				listBook(request, response);
				break;
			}
			
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

	private void newBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String title = request.getParameter("title");
		String isbn = request.getParameter("isbn");
		String author = request.getParameter("author");
		int year = Integer.parseInt(request.getParameter("year"));
		float price = Float.parseFloat(request.getParameter("price"));
		String description = request.getParameter("description");
		Book newBook = new Book(title, isbn, author, year, price, description);
		bookDAO.newBook(newBook);
		response.sendRedirect("list");
	
	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Book book = new Book();
		book.setId(id);
		book.setTitle(request.getParameter("title"));
		book.setAuthor(request.getParameter("author"));
		book.setIsbn(request.getParameter("isbn"));
		book.setPrice(Float.parseFloat(request.getParameter("price")));
		book.setPublicYear(Integer.parseInt(request.getParameter("publicYear")));
		book.setDescription(request.getParameter("description"));
		bookDAO.update(book);
		response.sendRedirect("list");

	}

	private void showEditBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Book book = bookDAO.getBook(id);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/edit_book.jsp");
		request.setAttribute("book", book);
		rd.forward(request, response);
	
	}

	private void listBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		List<Book> listBook = bookDAO.list();
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/show_books.jsp");
		request.setAttribute("listBook",  listBook);
		rd.forward(request, response);
		
		response.sendRedirect("list");
	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		bookDAO.delete(id);
		response.sendRedirect("list");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
