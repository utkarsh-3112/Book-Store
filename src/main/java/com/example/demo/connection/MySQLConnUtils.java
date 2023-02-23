package com.example.demo.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class MySQLConnUtils {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/bookstore?useSSL=false&serverTimezone=UTC";
	
	private String jdbcUsername = "myUser";
	
	private String jdbcPassword = "kannu@123";
	
	private Connection jdbcConnection = null;
	
	Connection getConnection() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}
			catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
		return jdbcConnection;
	}
	
}
