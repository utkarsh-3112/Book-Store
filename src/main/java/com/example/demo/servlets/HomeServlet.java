package com.example.demo.servlets;

import com.example.demo.models.Book;
import com.example.demo.service.BookService;
import com.example.demo.service.BookServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = { "/home" })
public class HomeServlet extends HttpServlet {
	
	public HomeServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/homeView.jsp");
		BookService bookService = new BookServiceImpl();
		try {
			List<Book> books = bookService.getAllBooks();
			request.setAttribute("books", books);
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
		dispatcher.forward(request, response);
		//		 response.sendRedirect("views/homeView.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
