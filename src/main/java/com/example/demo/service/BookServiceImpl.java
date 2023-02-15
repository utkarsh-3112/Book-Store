package com.example.demo.service;

import com.example.demo.dao.BookDao;
import com.example.demo.dao.BookDaoImpl;
import com.example.demo.models.Book;
import com.example.demo.models.UserAccount;

import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl implements BookService{
	
	private final BookDao bookDao = new BookDaoImpl();
	
	@Override
	public List<Book> getAllBooks(UserAccount userAccount) throws SQLException {
		return bookDao.getAllBooks();
	}
	
	@Override
	public List<Book> getBooksOfUser(UserAccount userAccount) throws SQLException {
		return bookDao.getBooksOfUser(userAccount);
	}
	
	@Override
	public boolean addBook(Book book) throws SQLException {
		return bookDao.addBook(book);
	}
	
	@Override
	public boolean deleteBook(Book book) throws SQLException {
		return bookDao.deleteBook(book);
	}
	
	@Override
	public boolean updateBook(Book book) throws SQLException {
		return bookDao.updateBook(book);
	}
	
	@Override
	public Book getBook(int bookId) throws SQLException {
		return bookDao.getBook(bookId);
	}
	
	@Override
	public boolean issueBook(int bookId, UserAccount userAccount) throws SQLException {
		return bookDao.issueBook(bookId, userAccount);
	}
	
	@Override
	public boolean returnBook(int bookId) throws SQLException {
		return bookDao.returnBook(bookId);
	}
}
