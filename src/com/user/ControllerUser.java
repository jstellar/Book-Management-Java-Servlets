package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControllerUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao;
	
	public ControllerUser() throws SQLException {
		userDao = new UserDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		try {
			
			switch (action) {
			
			case "/new":
				newUser(request, response);
				break;
				
			case "/login":
				login(request, response);
				break;
			
			case "/logout":
				logout(request, response);
				break;
				
			default:
				listUser(request, response);
				break;
			}
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		request.getRequestDispatcher("index.jsp").include(request, response);
		HttpSession session = request.getSession(false);
		if(session != null ) {
			session.invalidate();
		}		
		pw.print("You are successfully logged out!");
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String username = request.getParameter("uname");
		String password = request.getParameter("pword");
		PrintWriter out = response.getWriter();
		
		if (userDao.getUserByUserNameAndPassword(username, password)) {
			
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(5*60);
			session.setAttribute("username", username);			
			
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/add_book.jsp");
            out.println("Hi "+ username );
            rd.include(request, response);	

			
		} else {
			
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            out.println("<font color=red>Sorry, something went wrong</font>");
            rd.include(request, response);	
		
		}
		
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Set<User> users = userDao.getAllUsers();
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/list_users.jsp");
		request.setAttribute("users", users);
		rd.forward(request, response);
	}


	private void newUser(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		
		User user = new User();
		user.setFirstName(request.getParameter("fname"));
		user.setLastName(request.getParameter("lname"));
		try {
			Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dob"));
			user.setDob(dob);
		} catch (ParseException pex) {
			pex.printStackTrace();
		}
		user.setPhoneNumber(request.getParameter("pn"));
		user.setEmail(request.getParameter("email"));

		
		if (userDao.insertUser(user)) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
