package com.example.demo.connection;
import com.example.demo.models.UserAccount;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
	
	public void storeLoginUser(HttpSession session, UserAccount userAccount){
		session.setAttribute("user", userAccount);
	}
	
	public UserAccount getLoginUser(HttpSession session){
		return (UserAccount) session.getAttribute("user");
	}
	
	public void storeUserCookie(HttpServletResponse response, UserAccount userAccount){
		System.out.println("Store user Cookie");
		Cookie cookie = new Cookie("user", userAccount.getUserName());
		cookie.setMaxAge(24*60*60);
		response.addCookie(cookie);
	}
	
	public String getUserNameFromCookie(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
				if("userName".equals(cookie.getName()))
					return cookie.getValue();
			}
		}
		return null;
	}
	
	public void deleteCookie(HttpServletResponse response){
		Cookie cookie = new Cookie("userName", null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
}
