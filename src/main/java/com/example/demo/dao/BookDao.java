package com.example.demo.dao;
import com.example.demo.models.Book;
import com.example.demo.models.UserAccount;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
	
	public List<Book> getAllBooks() throws SQLException;
	public List<Book> getBooksOfUser(UserAccount userAccount) throws SQLException;
	public boolean addBook(Book book) throws SQLException;
	public boolean deleteBook(Book book) throws SQLException;
	public boolean updateBook(Book book) throws SQLException;
	public Book getBook(int bookId) throws SQLException;
	public boolean issueBook(int bookId, UserAccount userAccount) throws SQLException;
	public boolean returnBook(int bookId) throws SQLException;
}
