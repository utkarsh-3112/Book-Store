package com.example.demo.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {
	
	public Connection getConnection() throws SQLException {
		return new MySQLConnUtils().getConnection();
	}
	
	public void closeConnection(Connection connection) throws SQLException {
		connection.close();
	}
	
	public void rollback(Connection connection) throws SQLException {
		connection.rollback();
	}
	
}
