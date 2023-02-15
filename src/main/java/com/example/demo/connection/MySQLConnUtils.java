package com.example.demo.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class MySQLConnUtils {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/bookstore";
	
	private String jdbcUsername = "root";
	
	private String jdbcPassword = "UK@123";
	
	private Connection jdbcConnection;
	
	Connection getConnection() throws SQLException {
		if (jdbcConnection.isClosed()) {
			try {
				Class.forName(jdbcURL);
			}
			catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
		return jdbcConnection;
	}
	
}
