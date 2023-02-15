package com.example.demo.dao;

import com.example.demo.connection.ConnectionUtils;
import com.example.demo.models.Book;
import com.example.demo.models.UserAccount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao{
	ConnectionUtils connectionUtils = new ConnectionUtils();
	
	@Override
	public List<Book> getAllBooks() throws SQLException {
		List<Book> listBooks = new ArrayList<>();
		String sql = "SELECT * FROM book";
		Connection conn = connectionUtils.getConnection();
		Statement statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()){
			Book book = setBook(resultSet);
			listBooks.add(book);
		}
		connectionUtils.closeConnection(conn);
		return listBooks;
	}
	
	@Override
	public List<Book> getBooksOfUser(UserAccount userAccount) throws SQLException {
		Connection conn = connectionUtils.getConnection();
		Statement statement = conn.createStatement();
		String sql = "SELECT * FROM book WHERE book.user = " + userAccount.getUserName();
		List<Book> userBooks = new ArrayList<>();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()){
			Book book = setBook(resultSet);
			userBooks.add(book);
		}
		statement.close();
		connectionUtils.closeConnection(conn);
		return userBooks;
	}
	
	@Override
	public boolean addBook(Book book) throws SQLException {
		Connection conn = connectionUtils.getConnection();
		String sql = "INSERT INTO book VALUES (?,?,?,?,?,?,?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, book.getBookId());
		statement.setString(2, book.getTitle());
		statement.setInt(3, book.getEdition());
		statement.setString(4, book.getAuthor());
		statement.setString(5, book.getPublication());
		statement.setFloat(6, book.getPrice());
		statement.setString(7, book.getUser());
		boolean result = statement.executeUpdate() > 0;
		statement.close();
		connectionUtils.closeConnection(conn);
		return result;
	}
	
	@Override
	public boolean deleteBook(Book book) throws SQLException {
		Connection conn = connectionUtils.getConnection();
		String sql = "DELETE FROM book WHERE book_id = ?" ;
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, book.getBookId());
		boolean result = statement.executeUpdate() > 0;
		statement.close();
		connectionUtils.closeConnection(conn);
		return result;
	}
	
	@Override
	public boolean updateBook(Book book) throws SQLException {
		Connection conn = connectionUtils.getConnection();
		String sql = "UPDATE book SET title = ?, author = ?, price = ?, edition = ? , user = ?, publication = ? ";
		sql += " WHERE book_id = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, book.getTitle());
		statement.setInt(2, book.getEdition());
		statement.setString(3, book.getAuthor());
		statement.setString(4, book.getPublication());
		statement.setFloat(5, book.getPrice());
		statement.setString(6, book.getUser());
		statement.setInt(7, book.getBookId());
		boolean result = statement.executeUpdate() > 0;
		statement.close();
		connectionUtils.closeConnection(conn);
		return result;
	}
	
	@Override
	public Book getBook(int bookId) throws SQLException {
		Connection conn = connectionUtils.getConnection();
		String sql = "SELECT * FROM book WHERE book_id = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, bookId);
		ResultSet resultSet = statement.executeQuery();
		Book book = null;
		if(resultSet.next()){
			book = setBook(resultSet);
		}
		statement.close();
		connectionUtils.closeConnection(conn);
		return book;
	}
	
	@Override
	public boolean issueBook(int bookId, UserAccount userAccount) throws SQLException {
		Book book = getBook(bookId);
		book.setUser(userAccount.getUserName());
		return updateBook(book);
	}
	
	@Override
	public boolean returnBook(int bookId) throws SQLException {
		Book book = getBook(bookId);
		book.setUser(null);
		return updateBook(book);
	}
	
	private Book setBook(ResultSet resultSet) throws SQLException {
		int bookId = resultSet.getInt("bookId");
		String title = resultSet.getString("title");
		int edition = resultSet.getInt("edition");
		String author = resultSet.getString("author");
		String publication = resultSet.getString("publication");
		float price = resultSet.getFloat("price");
		String user = resultSet.getString("user");
		Book book = new Book(bookId, title, edition, author, publication, price, user);
		return book;
	}
}
