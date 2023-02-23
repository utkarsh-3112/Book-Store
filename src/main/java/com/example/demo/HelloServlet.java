package com.example.demo;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

import com.example.demo.models.Book;
import com.example.demo.service.BookService;
import com.example.demo.service.BookServiceImpl;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

public class HelloServlet extends HttpServlet {
	
	private String message;
	
	public void init() {
		message = "Hello World!";
	}
	
	private final BookService bookService = new BookServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Book> list;
		try {
			list = bookService.getAllBooks();
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		for(Book book : list){
			out.println(book);
		}
		out.println("<h1>" + message + "</h1>");
		out.println("</body></html>");
		
	}
	
	public void destroy() {
	}
}
