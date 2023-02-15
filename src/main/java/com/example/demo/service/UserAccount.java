package com.example.demo.service;

import java.util.List;

public interface UserAccount {
	
	public boolean addUser(UserAccount userAccount);
	public boolean deleteUser(UserAccount userAccount);
	public boolean updateUser(UserAccount userAccount);
	public List<UserAccount> allUsers(UserAccount userAccount);
	public UserAccount findUser(UserAccount userAccount);
}
