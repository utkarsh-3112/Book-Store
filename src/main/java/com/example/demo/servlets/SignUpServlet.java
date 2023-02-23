package com.example.demo.servlets;
import com.example.demo.connection.ConnectionUtils;
import com.example.demo.models.UserAccount;
import com.example.demo.service.UserAccountService;
import com.example.demo.service.UserAccountServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SignUpServlet", value = "/sign_up")
public class SignUpServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
        dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserAccountService userAccountService = new UserAccountServiceImpl();
		ConnectionUtils connectionUtils = new ConnectionUtils();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String gender = request.getParameter("gender");
		String mobileNo = request.getParameter("mobileNo");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		UserAccount user = null;
		boolean hasError = false;
		String errorString = null;
		if(username == null || password == null ||
				username.length() == 0 || password.length() == 0 ||
				firstName == null || lastName == null ||
				gender == null || confirmPassword == null ||
				mobileNo == null || firstName.length() == 0 ||
				lastName.length() == 0){
			hasError = true;
			errorString = "fill all entries";
		} else if(!password.equals(confirmPassword)){
			hasError = true;
			errorString = "password and confirm password nod match";
		}else{
			try {
				user = userAccountService.findUser(username);
				if(user != null){
					hasError = true;
					errorString = "username already used";
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				hasError = true;
				errorString = e.getMessage();
			}
		}
		if(hasError){
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
			dispatcher.forward(request, response);
		}else{
			user = new UserAccount(username,gender,password,mobileNo,firstName,lastName);
			try {
				userAccountService.addUser(user);
			}
			catch (SQLException e) {
				throw new RuntimeException(e);
			}
			response.sendRedirect("./login");
		}
	}
}
