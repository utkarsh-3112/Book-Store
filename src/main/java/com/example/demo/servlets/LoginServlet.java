package com.example.demo.servlets;

import com.example.demo.connection.ConnectionUtils;
import com.example.demo.models.UserAccount;
import com.example.demo.service.UserAccountService;
import com.example.demo.service.UserAccountServiceImpl;
import com.mysql.cj.Session;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserAccountService userAccountService = new UserAccountServiceImpl();
		ConnectionUtils connectionUtils = new ConnectionUtils();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("rememberMe");
		boolean remember = "Y".equals(rememberMe);
		UserAccount user = null;
		boolean hasError = false;
		String errorString = null;
		if (username == null || password == null || username.length() == 0 || password.length() == 0) {
			hasError = true;
			errorString = "Required Username and Password";
		} else {
			try {
				user = userAccountService.findUser(username);
				if (user == null || !user.getPassword().equals(password)) {
					hasError = true;
					errorString = "Invalid Username or Password";
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				hasError = true;
				errorString = e.getMessage();
			}
		}
		if (hasError) {
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
			dispatcher.forward(request, response);
		} else {
			HttpSession session = request.getSession();
			connectionUtils.storeLoginUser(session, user);
			if (remember)
				connectionUtils.storeUserCookie(response, user);
			else
				connectionUtils.deleteCookie(response);
			response.sendRedirect("./home");
		}
	}
}

