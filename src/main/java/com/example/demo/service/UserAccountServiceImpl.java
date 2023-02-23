package com.example.demo.service;

import com.example.demo.dao.UserAccountDao;
import com.example.demo.dao.UserAccountDaoImpl;
import com.example.demo.models.UserAccount;

import java.sql.SQLException;
import java.util.List;

public class UserAccountServiceImpl implements UserAccountService {
	
	private UserAccountDao userAccountDao = new UserAccountDaoImpl();
	@Override
	public boolean addUser(UserAccount userAccount) throws SQLException {
		return userAccountDao.addUser(userAccount);
	}
	
	@Override
	public boolean deleteUser(UserAccount userAccount) throws SQLException {
		return userAccountDao.deleteUser(userAccount);
	}
	
	@Override
	public boolean updateUser(UserAccount userAccount) throws SQLException {
		return userAccountDao.updateUser(userAccount);
	}
	
	@Override
	public List<UserAccount> allUsers(UserAccount userAccount) throws SQLException {
		return userAccountDao.allUsers(userAccount);
	}
	
	@Override
	public UserAccount findUser(String userName) throws SQLException {
		return userAccountDao.findUser(userName);
	}
}
