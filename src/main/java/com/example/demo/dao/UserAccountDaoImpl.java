package com.example.demo.dao;

import com.example.demo.connection.ConnectionUtils;
import com.example.demo.models.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserAccountDaoImpl implements UserAccountDao {
	
	ConnectionUtils connectionUtils = new ConnectionUtils();
	
	@Override
	public boolean addUser(UserAccount userAccount) throws SQLException {
		Connection conn = connectionUtils.getConnection();
		String sql = "INSERT INTO user_account VALUES (?,?,?,?,?,?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, userAccount.getUserName());
		statement.setString(2, userAccount.getGender());
		statement.setString(3, userAccount.getPassword());
		statement.setString(4, userAccount.getMobileNo());
		statement.setString(5, userAccount.getFirstName());
		statement.setString(6, userAccount.getLastName());
		boolean result = statement.executeUpdate() > 0;
		statement.close();
		connectionUtils.closeConnection(conn);
		return result;
	}
	
	@Override
	public boolean deleteUser(UserAccount userAccount) throws SQLException {
		Connection conn = connectionUtils.getConnection();
		String sql = "DELETE FROM user_account WHERE user_name = ?" ;
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, userAccount.getUserName());
		boolean result = statement.executeUpdate() > 0;
		statement.close();
		connectionUtils.closeConnection(conn);
		return result;
	}
	
	@Override
	public boolean updateUser(UserAccount userAccount) throws SQLException {
		Connection conn = connectionUtils.getConnection();
		String sql = "UPDATE book SET gender = ?, password = ?, mobile_no = ?, first_name = ? , last_name = ?,";
		sql += " WHERE user_name = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(6, userAccount.getUserName());
		statement.setString(1, userAccount.getGender());
		statement.setString(2, userAccount.getPassword());
		statement.setString(3, userAccount.getMobileNo());
		statement.setString(4, userAccount.getFirstName());
		statement.setString(5, userAccount.getLastName());
		boolean result = statement.executeUpdate() > 0;
		statement.close();
		connectionUtils.closeConnection(conn);
		return result;
	}
	
	@Override
	public List<UserAccount> allUsers(UserAccount userAccount) throws SQLException {
		List<UserAccount> users = new ArrayList<>();
		String sql = "SELECT * FROM user_account";
		Connection conn = connectionUtils.getConnection();
		Statement statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()){
			UserAccount user = setUser(resultSet);
			users.add(user);
		}
		connectionUtils.closeConnection(conn);
		return users;
	}
	
	@Override
	public UserAccount findUser(String userName) throws SQLException {
		Connection conn = connectionUtils.getConnection();
		String sql = "SELECT * FROM user_account WHERE user_name = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, userName);
		ResultSet resultSet = statement.executeQuery();
		UserAccount user = null;
		if(resultSet.next()){
			user = setUser(resultSet);
		}
		statement.close();
		connectionUtils.closeConnection(conn);
		return user;
	}
	
	private UserAccount setUser(ResultSet resultSet) throws SQLException {
		String userName = resultSet.getString("user_name");
		String gender = resultSet.getString("gender");
		String password = resultSet.getString("password");
		String mobileNo = resultSet.getString("mobile_no");
		String firstName = resultSet.getString("first_name");
		String lastName = resultSet.getString("last_name");
		UserAccount user = new UserAccount(userName, gender, password, mobileNo, firstName, lastName);
		return user;
	}
}
