package com.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static final String URL = "jdbc:h2:tcp://localhost/~/test";
	//private static final String URL = "jdbc:mysql://localhost:3306/yeyDb?serverTimezone=UTC";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "123";
	
	public static Connection getConnection() throws SQLException {
		
		Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		return conn;
	}

}
