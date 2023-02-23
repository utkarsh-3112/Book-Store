package com.example.demo.service;

import com.example.demo.models.UserAccount;

import java.sql.SQLException;
import java.util.List;

public interface UserAccountService {
	
	public boolean addUser(UserAccount userAccount) throws SQLException;
	public boolean deleteUser(UserAccount userAccount) throws SQLException;
	public boolean updateUser(UserAccount userAccount) throws SQLException;
	public List<UserAccount> allUsers(UserAccount userAccount) throws SQLException;
	public UserAccount findUser(String userName) throws SQLException;
}
