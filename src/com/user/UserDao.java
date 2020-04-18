package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.book.ConnectionFactory;

public class UserDao implements UI{
	
	private Connection conn;
	
	public UserDao() throws SQLException {
		conn = ConnectionFactory.getConnection();
	}
	
	public User extractUserFromResultSet(ResultSet rs) throws SQLException {
		
		User user = new User();
		user.setUserId(rs.getInt("userid"));
		user.setFirstName(rs.getString("firstname"));
		user.setLastName(rs.getString("lastname"));
		user.setDob(rs.getDate("dob"));
		user.setPhoneNumber(rs.getString("phonenumber"));
		user.setEmail(rs.getString("email"));
		return user;
	}

	public Set<User> getAllUsers() {
		
		try {
			
			PreparedStatement ps = conn.prepareStatement("select * from users");
			ResultSet rs = ps.executeQuery();
			Set<User> users = new HashSet<User>();
			
			while (rs.next()) {
				User user = extractUserFromResultSet(rs);
				users.add(user);
			}			
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	// Log in
	
	public boolean getUserByUserNameAndPassword(String username, String password) {
		
		Connection conn;
		try {
			conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from users where username =? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				//extractUserFromResultSet(rs);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean insertUser(User user) {
		
		try {
			String sql = "insert into users(firstname, lastname, dob,phonenumber, email)  values(?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setDate(3, new java.sql.Date(user.getDob().getTime()));
			ps.setString(4, user.getPhoneNumber());
			ps.setString(5, user.getEmail());
			int i = ps.executeUpdate();
			
			if (i == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateUser(User user) {
		
		try {
			
			PreparedStatement ps = conn.prepareStatement("update users set firstname=?, lastname=?, dob=?, phonenumber=?, email=? where id="+user.getUserId());
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setDate(3, new java.sql.Date(user.getDob().getTime()));
			ps.setString(4, user.getPhoneNumber());
			ps.setString(5, user.getEmail());
			int i = ps.executeUpdate();
			
			if (i == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteUser(int id) {

		try {
			
			PreparedStatement ps = conn.prepareStatement("delete from users where userid="+id);
			ps.setInt(1, id);
			int i = ps.executeUpdate();

			if (i == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public User getUser(int id) throws SQLException {

		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("select * from users where id="+id);
		
		if (rs.next()) {
			return extractUserFromResultSet(rs);
		}
		return null;
	}

	@Override
	public User getUserByUserNameAndPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		return null;
	}
}
